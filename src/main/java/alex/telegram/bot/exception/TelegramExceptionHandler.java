package alex.telegram.bot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class TelegramExceptionHandler {
    @ExceptionHandler(InvalidStartException.class)
    public ResponseEntity<String> handleInvalidStartException(InvalidStartException ex) {
        log.info("Handling InvalidStartException");
        return ResponseEntity.ok(ex.getMessage());
    }
}
