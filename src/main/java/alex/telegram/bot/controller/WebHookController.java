package alex.telegram.bot.controller;

import alex.telegram.bot.telegram.TelegramBot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@AllArgsConstructor
@RequestMapping("/")
@Slf4j
public class WebHookController {
    private final TelegramBot telegramBot;

    @PostMapping("/callback/${telegram.bot.path}")
    @ResponseStatus(HttpStatus.OK)
    public void onUpdate(@RequestBody Update update) {
        log.info("Received web hook");
        telegramBot.onWebhookUpdateReceived(update);
    }
}
