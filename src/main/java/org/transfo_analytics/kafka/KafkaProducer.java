/* Copyright (c) 2020, RTE (http://www.rte-france.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.transfo_analytics.kafka;

import org.transfo_analytics.model.EventTempDeviation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.transfo_analytics.model.EventTempDeviationMessage;

@Service
public class KafkaProducer {

    //TODO Replace with Slf4j and annotation
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private static final String TOPIC = "event-temperature-deviation";

    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate;

    public void sendMessage(EventTempDeviationMessage eventTempDeviationMessage){

        logger.info(String.format("$$ -> Producing message --> %s",eventTempDeviationMessage));
        this.kafkaTemplate.send(TOPIC,eventTempDeviationMessage);
        //To be able to send an object rather than a string, the following property needs to be set:
        // spring.kafka.value-serializer: org.springframework.kafka.support.serializer.JsonSerializer


    }

}
