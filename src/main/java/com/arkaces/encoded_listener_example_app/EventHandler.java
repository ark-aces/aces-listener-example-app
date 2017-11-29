package com.arkaces.encoded_listener_example_app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventHandler {

    private final ObjectMapper eventObjectMapper;

    @PostMapping("/bitcoin-events")
    public ResponseEntity<Void> handleBitcoinEvent(@RequestBody JsonNode event) {
        log.info("Received event: " + event.get("transactionId"));
        log.info("Event data: " + event.get("data"));

        return ResponseEntity.ok().build();
    }

    @PostMapping("/ark-events")
    public ResponseEntity<Void> handleArkEvent(@RequestBody JsonNode event) {
        log.info("Received event: " + event.get("transactionId"));
        log.info("Event data: " + event.get("data"));

        return ResponseEntity.ok().build();
    }

}
