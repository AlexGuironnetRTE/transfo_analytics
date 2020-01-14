package org.transfo_analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//TODO Fix issue with lombok

public class EventTempCardData {

    private EventTempDeviationMessage eventTempDeviationMessage;
    private EventTempDevDetailsProcessedData eventTempDevDetailsProcessedData;

    public EventTempCardData(EventTempDeviationMessage eventTempDeviationMessage, EventTempDevDetailsProcessedData eventTempDevDetailsProcessedData) {
        this.eventTempDeviationMessage = eventTempDeviationMessage;
        this.eventTempDevDetailsProcessedData = eventTempDevDetailsProcessedData;
    }

    public EventTempDeviationMessage getEventTempDeviationMessage() {
        return eventTempDeviationMessage;
    }

    public void setEventTempDeviation(EventTempDeviationMessage eventTempDeviationMessage) {
        this.eventTempDeviationMessage = eventTempDeviationMessage;
    }

    public EventTempDevDetailsProcessedData getEventTempDevDetailsProcessedData() {
        return eventTempDevDetailsProcessedData;
    }

    public void setEventTempDevDetailsProcessedData(EventTempDevDetailsProcessedData eventTempDevDetailsProcessedData) {
        this.eventTempDevDetailsProcessedData = eventTempDevDetailsProcessedData;
    }
}
