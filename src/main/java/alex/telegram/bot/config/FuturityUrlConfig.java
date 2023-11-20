package alex.telegram.bot.config;

import lombok.Data;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("telegram.futurity")
public class FuturityUrlConfig {
    private String url;

    private static final String URL_FORMAT = "%s/%s";

    public String buildUrl(@NonNull Long id) {
        return URL_FORMAT.formatted(url, id);
    }
}
