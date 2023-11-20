package alex.telegram.bot.message.publisher;

import alex.telegram.bot.message.model.UserUpdateEvent;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class UserTelegramPublisher {
    private final StreamBridge streamBridge;

    private final static String BINDING_NAME = "userUpdatePublisher";

    public void publishEvent(@NonNull UserUpdateEvent event) {
        log.info("Going to publish event with userId={}", event.getUserId());
        streamBridge.send(BINDING_NAME, event);
        log.info("Event with userId={} has been published", event.getUserId());
    }
}
