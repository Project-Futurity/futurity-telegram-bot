package alex.telegram.bot.message.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class Notification {
    @NonNull
    Long userId;
    @NonNull
    Long taskId;
    @NonNull
    ZonedDateTime deadline;
    @NonNull
    String part;
}
