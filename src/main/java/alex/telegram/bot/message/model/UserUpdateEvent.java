package alex.telegram.bot.message.model;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class UserUpdateEvent {
    @NonNull Long userId;
}
