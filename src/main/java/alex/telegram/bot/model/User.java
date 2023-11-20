package alex.telegram.bot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "telegram_user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long futurityUserId;

    @Column(nullable = false)
    private Long chatId;

    public User(Long futurityUserId, Long chatId) {
        this.futurityUserId = futurityUserId;
        this.chatId = chatId;
    }
}
