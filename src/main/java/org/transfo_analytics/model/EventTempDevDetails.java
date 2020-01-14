package org.transfo_analytics.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class EventTempDevDetails {

    private List<String> columns; //TODO @Singular?
    private List<Long> index;
    private List<List<Long>> data;

    public List<String> getColumns() {
        return columns;
    }

    public List<Long> getIndex() {
        return index;
    }

    public List<List<Long>> getData() {
        return data;
    }
}
