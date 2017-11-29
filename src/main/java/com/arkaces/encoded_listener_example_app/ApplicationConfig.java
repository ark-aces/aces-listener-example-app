package com.arkaces.encoded_listener_example_app;

import io.arkaces.ApiClient;
import io.arkaces.encoded_listener_client.DefaultApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ApplicationConfig {

    @Bean
    public DefaultApi bitcoinListenerClient(ListenerSettings listenerSettings) {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(listenerSettings.getBitcoinListenerUrl());
        return new DefaultApi(apiClient);
    }

    @Bean
    public DefaultApi arkListenerClient(ListenerSettings listenerSettings) {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(listenerSettings.getArkListenerUrl());
        return new DefaultApi(apiClient);
    }

}
