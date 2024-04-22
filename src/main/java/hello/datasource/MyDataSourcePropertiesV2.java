package hello.datasource;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV2 {
    private final String url;
    private final String username;
    private final String password;
    private final Etc etc;

    public MyDataSourcePropertiesV2(final String url, final String username, final String password, @DefaultValue final Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {
        private final int maxConnection;
        private final Duration timeout;
        private final List<String> options;

        public Etc(final int maxConnection, final Duration timeout, @DefaultValue("DEFAULT") final List<String> options) {
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }
}
