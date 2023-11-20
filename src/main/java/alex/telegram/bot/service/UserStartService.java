package alex.telegram.bot.service;

import alex.telegram.bot.message.model.UserUpdateEvent;
import alex.telegram.bot.message.publisher.UserTelegramPublisher;
import alex.telegram.bot.model.User;
import alex.telegram.bot.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserStartService {
    private final UserRepository userRepository;
    private final UserTelegramPublisher userUpdatePublisher;

    public boolean exists(@NonNull Long futurityId) {
        return userRepository.existsByFuturityUserId(futurityId);
    }

    public void processStart(@NonNull Long futurityId, @NonNull Long chatId) {
        User user = new User(futurityId, chatId);
        userRepository.save(user);
        publish(futurityId);
    }

    private void publish(Long futurityId) {
        userUpdatePublisher.publishEvent(UserUpdateEvent.of(futurityId));
    }
}
