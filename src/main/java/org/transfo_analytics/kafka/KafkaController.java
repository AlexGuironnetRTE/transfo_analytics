package org.transfo_analytics.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.transfo_analytics.model.EventTempDeviation;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    //Based on https://dzone.com/articles/magic-of-kafka-with-spring-boot
    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody EventTempDeviation eventTempDeviation){ //TODO Generic message type with metadata and inheritance from data object
        System.out.println("Publish endpoint received: "+eventTempDeviation.toString());
        this.kafkaProducer.sendMessage(eventTempDeviation);

    }

}
