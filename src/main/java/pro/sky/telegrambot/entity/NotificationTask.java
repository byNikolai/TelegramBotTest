package pro.sky.telegrambot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class NotificationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long chatId;
    private String message;
    private LocalDateTime notificationDateTime;

    public NotificationTask(long chatId, String message, LocalDateTime notificationDateTime) {
        this.chatId = chatId;
        this.message = message;
        this.notificationDateTime = notificationDateTime;
    }
}
