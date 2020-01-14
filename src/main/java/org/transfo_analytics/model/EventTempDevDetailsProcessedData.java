package org.transfo_analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.transfo_analytics.utils.Utilities;

import java.util.List;

@Getter
public class EventTempDevDetailsProcessedData {

    private List<String> labels; //X axis labels
    private List<String> label; //Name of dataset
    private List<List<Long>> data;

    public EventTempDevDetailsProcessedData(EventTempDevDetails eventTempDevDetails) {
        this.label = eventTempDevDetails.getColumns();
        this.data = Utilities.transpose(eventTempDevDetails.getData());
    }
}
