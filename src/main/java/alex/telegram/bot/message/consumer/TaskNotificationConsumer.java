package alex.telegram.bot.message.consumer;

import alex.telegram.bot.message.model.Notification;
import alex.telegram.bot.service.UserNotificationSender;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@AllArgsConstructor
@Component("notificationConsumer")
public class TaskNotificationConsumer implements Consumer<Notification> {
    private final UserNotificationSender notificationSender;

    @Override
    public void accept(Notification notification) {
        log.info("Got notification update for task={}", notification.getTaskId());
        notificationSender.sendNotification(notification);
    }
}
