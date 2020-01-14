package org.transfo_analytics.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.lfenergy.operatorfabric.cards.model.Card;
import org.lfenergy.operatorfabric.cards.model.CardCreationReport;
import org.transfo_analytics.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.transfo_analytics.operatorfabric.CardPublisher;

@Service
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    CardPublisher cardPublisher;

    @Autowired
    ObjectMapper mapper;

    //TODO Why not use the application properties?
    @KafkaListener(topics = "dummy-event-temperature-deviation")
    public void consume(EventTempDeviationMessage eventTempDeviationMessage){

        logger.info(String.format("$$ -> Consumed Message -> %s", eventTempDeviationMessage));

        //Transform message into data that is more easy to use to create

        //Convert details string to object
        EventTempDevDetails eventTempDevDetails = new EventTempDevDetails();
        try {
            eventTempDevDetails = mapper.readValue(eventTempDeviationMessage.getDetails(), EventTempDevDetails.class);
        } catch (JsonProcessingException e) {
            logger.error("Couldn't read EventTempDevDetails from string: "+eventTempDeviationMessage.getDetails());
            e.printStackTrace();
        }

        EventTempCardData eventTempCardData = new EventTempCardData(eventTempDeviationMessage,new EventTempDevDetailsProcessedData(eventTempDevDetails));

        Card card = cardPublisher.createEventTempDevCard(eventTempCardData);

        logger.info("Created card: "+card.toString());

        CardCreationReport report = cardPublisher.publishCard(card);

        logger.info("Card publication report: "+report.toString());

    }

}
