package alex.telegram.bot.validator;

import alex.telegram.bot.exception.InvalidStartException;
import alex.telegram.bot.service.UserStartService;
import alex.telegram.bot.utils.BotUtils;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.objects.MessageContext;

@Component
@AllArgsConstructor
public class UserStartValidator {
    private final UserStartService userStartService;

    private static final String FUTURITY_ID_VALIDATION_MESSAGE = "Please start bot using Futurity";
    private static final String EXISTS_VALIDATION_MESSAGE = "You have already joined to futurity";

    public void validate(@NonNull MessageContext context) {
        checkIfHasFuturityId(context);
        checkIfExists(context);
    }

    private void checkIfHasFuturityId(MessageContext context) {
        if (context.arguments().length == 0) {
            BotUtils.sendMessage(FUTURITY_ID_VALIDATION_MESSAGE, context);
            throw new InvalidStartException(
                    String.format("Start command can't be processed as it does not have futurity id, user: %s", context.user().getUserName())
            );
        }
    }

    private void checkIfExists(MessageContext context) {
        if (userStartService.exists(BotUtils.extractStartId(context))) {
            BotUtils.sendMessage(EXISTS_VALIDATION_MESSAGE, context);
            throw new InvalidStartException(
                    String.format("Start command can't be processed as user already exists id: %s", BotUtils.extractStartId(context))
            );
        }
    }
}
