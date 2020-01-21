/* Copyright (c) 2020, RTE (http://www.rte-france.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.transfo_analytics.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.transfo_analytics.model.EventTempDeviation;
import org.transfo_analytics.model.EventTempDeviationMessage;

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
    public void sendMessageToKafkaTopic(@RequestBody EventTempDeviationMessage eventTempDeviationMessage){ //TODO Generic message type with metadata and inheritance from data object
        System.out.println("Publish endpoint received: "+eventTempDeviationMessage.toString());

        this.kafkaProducer.sendMessage(eventTempDeviationMessage);

    }

}
