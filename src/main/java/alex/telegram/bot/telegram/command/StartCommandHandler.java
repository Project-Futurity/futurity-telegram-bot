package alex.telegram.bot.telegram.command;

import alex.telegram.bot.service.UserStartService;
import alex.telegram.bot.utils.BotUtils;
import alex.telegram.bot.validator.UserStartValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.MessageContext;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.abilitybots.api.util.AbilityExtension;

@Slf4j
@Component
@AllArgsConstructor
public class StartCommandHandler implements AbilityExtension {
    private final UserStartValidator validator;
    private final UserStartService service;

    private static final String COMMAND = "start";
    private static final String SUCCESS_MESSAGE =
            "Thank you for using Futurity Bot, you will be getting notification about deadline";

    public void handle(MessageContext context) {
        log.info("Got start event for user: {}", context.user().getUserName());
        validator.validate(context);
        service.processStart(BotUtils.extractStartId(context), context.chatId());
        log.info("User with futurity id={} and chatId={} has been processed successfully",
                BotUtils.extractStartId(context), context.chatId());

        BotUtils.sendMessage(SUCCESS_MESSAGE, context);
    }

    @SuppressWarnings("unused")
    public Ability startAbility() {
        return Ability.builder()
                .name(COMMAND)
                .info("Description")
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(this::handle)
                .build();
    }
}
