package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.entity.NotificationTask;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface NotificationTaskRepository extends JpaRepository<NotificationTask, Long> {

    /**
     * Get all notifications for particular time point
     * @param notificationDateTime To pick the time point use
     * @return list of overlays
     */

    List<NotificationTask> findAllByNotificationDateTime(LocalDateTime notificationDateTime);
}
