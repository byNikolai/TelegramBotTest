package pro.sky.telegrambot.scheduler;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.service.NotificationTaskService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class NotificationTaskScheduler {
    private final Logger logger = LoggerFactory.getLogger(NotificationTaskScheduler.class);

    private final NotificationTaskService notificationTaskService;
    private final TelegramBot telegramBot;
@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void sendNotification() {
    LocalDateTime notificationSearchDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    logger.info("Task scheduler started, {}", notificationSearchDateTime);

    notificationTaskService.findAllByNotificationDateTime(notificationSearchDateTime).forEach(notification -> {
        telegramBot.execute(new SendMessage(notification.getChatId(), notification.getMessage()));
        notificationTaskService.delete(notification);
    });
    }
}
