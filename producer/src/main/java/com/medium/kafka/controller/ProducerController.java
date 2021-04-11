package com.medium.kafka.controller;

import com.medium.kafka.ProducerApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private static final Logger logger =
            LoggerFactory.getLogger(ProducerController.class);

    private final KafkaTemplate<String, Object> template;
    private final ProducerApplicationProperties producerApplicationProperties;

    @GetMapping("/produce")
    public String produce(){
        String topicName = producerApplicationProperties.getTopic();
        int messages = producerApplicationProperties.getMessages();

        IntStream.range(0, messages)
                .forEach(index -> this.template.send(topicName, String.valueOf(index),
                        new CachedEntity(index))
                );
        logger.info("All messages sent");
        return "Messages added!";
    }
}
