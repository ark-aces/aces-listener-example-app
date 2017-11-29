package com.arkaces.encoded_listener_example_app;

import io.arkaces.ApiException;
import io.arkaces.encoded_listener_client.DefaultApi;
import io.swagger.client.model.SubscriptionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class DemoAppInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final DefaultApi bitcoinListenerClient;
    private final DefaultApi arkListenerClient;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        try {
            SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
            subscriptionRequest.setCallbackUrl("http://localhost:8080/bitcoin-events");
            subscriptionRequest.setMinConfirmations(1);

            bitcoinListenerClient.subscriptionsPost(subscriptionRequest);
        } catch (ApiException e) {
            log.warn("Failed to subscribe with bitcoin listener");
        }

        try {
            SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
            subscriptionRequest.setCallbackUrl("http://localhost:8080/ark-events");
            subscriptionRequest.setMinConfirmations(1);

            arkListenerClient.subscriptionsPost(subscriptionRequest);
        } catch (ApiException e) {
            log.warn("Failed to subscribe with ark listener");
        }
    }
}