package alex.telegram.bot.telegram;

import alex.telegram.bot.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.util.AbilityExtension;

import java.util.List;

@Component
public class TelegramBot extends AbilityBot {
    public TelegramBot(BotConfig botConfig, List<AbilityExtension> extensions) {
        super(botConfig.getToken(), botConfig.getName());
        addExtensions(extensions);
    }

    @Override
    public long creatorId() {
        return 1L;
    }
}
