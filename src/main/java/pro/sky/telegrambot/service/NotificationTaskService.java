package pro.sky.telegrambot.service;

import pro.sky.telegrambot.entity.NotificationTask;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service for notification processing
 */
public interface NotificationTaskService {

    /**
     * Save the notification
     * @param task notification
     */
    void save(NotificationTask task);

    /**
     * Delete the notification
     * @param task notification
     */
    void delete(NotificationTask task);

    /**
     * Get all notifications for particular time point
     * @param notificationDateTime To pick the time point use
     * @return list of overlays
     */

    List<NotificationTask> findAllByNotificationDateTime(LocalDateTime notificationDateTime);
}
