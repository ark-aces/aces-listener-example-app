package com.arkaces.encoded_listener_example_app;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "listeners")
public class ListenerSettings {
    private String bitcoinListenerUrl;
    private String arkListenerUrl;
}
