package com.medium.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ConsumerController {

    private static final Logger logger =
            LoggerFactory.getLogger(ConsumerController.class);

    @KafkaListener(
            topics = "custom-topic",
            clientIdPrefix = "json",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(ConsumerRecord<String, CachedEntity> record,
                        @Payload CachedEntity payload) {
            logger.info("Received Payload: {} | Record: {}", payload, record);
    }
}
