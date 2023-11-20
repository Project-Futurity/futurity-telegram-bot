package alex.telegram.bot.utils;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.telegram.abilitybots.api.objects.MessageContext;

@UtilityClass
public class BotUtils {
    public void sendMessage(@NonNull String message, @NonNull MessageContext context) {
        context.bot().silent().send(message, context.chatId());
    }

    public Long extractStartId(@NonNull MessageContext context) {
        return Long.parseLong(context.firstArg());
    }
}
