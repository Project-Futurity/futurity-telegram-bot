package alex.telegram.bot.telegram;

import alex.telegram.bot.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityWebhookBot;
import org.telegram.abilitybots.api.util.AbilityExtension;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class TelegramBot extends AbilityWebhookBot {
    public TelegramBot(BotConfig botConfig, List<AbilityExtension> extensions) {
        super(botConfig.getToken(), botConfig.getName(), botConfig.getPath());
        addExtensions(extensions);
    }

    @Override
    public long creatorId() {
        return 1L;
    }
}
