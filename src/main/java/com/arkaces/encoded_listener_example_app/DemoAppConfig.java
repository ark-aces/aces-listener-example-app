package com.arkaces.encoded_listener_example_app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.arkaces.ApiClient;
import io.arkaces.encoded_listener_client.DefaultApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DemoAppConfig {

    @Bean
    public DefaultApi bitcoinListenerClient(ListenerUrlSettings listenerUrlSettings) {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(listenerUrlSettings.getBitcoinListenerUrl());
        return new DefaultApi(apiClient);
    }

    @Bean
    public DefaultApi arkListenerClient(ListenerUrlSettings listenerUrlSettings) {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(listenerUrlSettings.getArkListenerUrl());
        return new DefaultApi(apiClient);
    }

    @Bean
    public ObjectMapper eventObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper;
    }
}
