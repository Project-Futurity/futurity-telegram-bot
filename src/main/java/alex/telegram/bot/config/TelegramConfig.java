package alex.telegram.bot.config;

import alex.telegram.bot.telegram.TelegramBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TelegramConfig {
    @Bean
    public TelegramBotsApi api(TelegramBot bot) {
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(bot);

            return api;
        } catch (TelegramApiException e) {
            throw new IllegalStateException("Failed to register bot", e);
        }
    }
}
