package alex.telegram.bot.service;

import alex.telegram.bot.client.TaskClient;
import alex.telegram.bot.message.model.Notification;
import alex.telegram.bot.model.Task;
import alex.telegram.bot.model.User;
import alex.telegram.bot.config.FuturityUrlConfig;
import alex.telegram.bot.repository.UserRepository;
import alex.telegram.bot.telegram.TelegramBot;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserNotificationSender {
    private final UserRepository repository;
    private final TelegramBot bot;
    private final TaskClient taskClient;
    private final FuturityUrlConfig properties;

    private static final String MESSAGE =
            "Hello! There %s left to complete the task '%s'. Hurry up! Here is a [link](%s) to the board";

    public void sendNotification(@NonNull Notification notification) {
        User user = getUser(notification);
        bot.silent().sendMd(buildMessage(notification), user.getChatId());
    }

    private String buildMessage(Notification notification) {
        Task info = taskClient.getTaskInfo(notification.getTaskId(), notification.getUserId());

        return MESSAGE.formatted(notification.getPart(), info.getName(), properties.getUrl());
    }

    private User getUser(Notification notification) {
        return repository.findByFuturityUserId(notification.getUserId())
                .orElseThrow(() ->
                        new IllegalStateException(String.format("Failed to find user with id=%s", notification.getUserId()))
                );
    }
}
