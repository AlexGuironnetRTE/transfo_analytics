package org.transfo_analytics.kafka;

import org.lfenergy.operatorfabric.cards.model.Card;
import org.lfenergy.operatorfabric.cards.model.CardCreationReport;
import org.transfo_analytics.model.EventTempCardData;
import org.transfo_analytics.model.EventTempDevDetailsProcessedData;
import org.transfo_analytics.model.EventTempDeviation;
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

    //TODO Why not use the application properties?
    @KafkaListener(topics = "dummy-event-temperature-deviation")
    public void consume(EventTempDeviation eventTempDeviation){

        logger.info(String.format("$$ -> Consumed Message -> %s", eventTempDeviation));

        EventTempCardData eventTempCardData = new EventTempCardData(eventTempDeviation,new EventTempDevDetailsProcessedData(eventTempDeviation.getDetails()));

        Card card = cardPublisher.createEventTempDevCard(eventTempCardData);

        logger.info("Created card: "+card.toString());

        CardCreationReport report = cardPublisher.publishCard(card);

        logger.info("Card publication report: "+report.toString());

    }

}
