package alex.telegram.bot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class Task {
    private String name;
    private ZonedDateTime deadline;
    private Long projectId;
}
