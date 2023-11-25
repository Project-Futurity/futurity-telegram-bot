package alex.telegram.bot.controller;

import alex.telegram.bot.telegram.TelegramBot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@AllArgsConstructor
@RequestMapping("/")
@Slf4j
public class WebHookController {
    private final TelegramBot telegramBot;

    @PostMapping("/callback/${telegram.bot.path}")
    public BotApiMethod<?> onUpdate(@RequestBody Update update) {
        log.info("Received web hook");
        return telegramBot.onWebhookUpdateReceived(update);
    }
}
