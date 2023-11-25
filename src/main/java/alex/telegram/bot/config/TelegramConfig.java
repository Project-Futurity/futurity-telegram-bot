package alex.telegram.bot.config;

import alex.telegram.bot.telegram.TelegramBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.Webhook;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultWebhook;

@Configuration
public class TelegramConfig {

    @Bean
    public SetWebhook externalWebHook(@Value("${telegram.futurity.url}") String url) {
        return SetWebhook.builder()
                .url(url)
                .build();
    }

    @Bean
    public Webhook internalWebHook() {
        DefaultWebhook webhook = new DefaultWebhook();
        webhook.setInternalUrl("http://localhost:8088");

        return webhook;
    }

    @Bean
    public TelegramBotsApi api(TelegramBot bot, SetWebhook externalWebHook, Webhook internalWebHook) {
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class, internalWebHook);

            api.registerBot(bot, externalWebHook);
            return api;
        } catch (TelegramApiException e) {
            throw new IllegalStateException("Failed to register bot", e);
        }
    }
}
