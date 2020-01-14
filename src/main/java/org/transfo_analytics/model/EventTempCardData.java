package org.transfo_analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//TODO Fix issue with lombok

public class EventTempCardData {

    private EventTempDeviation eventTempDeviation;
    private EventTempDevDetailsProcessedData eventTempDevDetailsProcessedData;

    public EventTempCardData(EventTempDeviation eventTempDeviation, EventTempDevDetailsProcessedData eventTempDevDetailsProcessedData) {
        this.eventTempDeviation = eventTempDeviation;
        this.eventTempDevDetailsProcessedData = eventTempDevDetailsProcessedData;
    }

    public EventTempDeviation getEventTempDeviation() {
        return eventTempDeviation;
    }

    public void setEventTempDeviation(EventTempDeviation eventTempDeviation) {
        this.eventTempDeviation = eventTempDeviation;
    }

    public EventTempDevDetailsProcessedData getEventTempDevDetailsProcessedData() {
        return eventTempDevDetailsProcessedData;
    }

    public void setEventTempDevDetailsProcessedData(EventTempDevDetailsProcessedData eventTempDevDetailsProcessedData) {
        this.eventTempDevDetailsProcessedData = eventTempDevDetailsProcessedData;
    }
}
