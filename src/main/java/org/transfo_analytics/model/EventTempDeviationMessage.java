package org.transfo_analytics.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//TODO Replace this nightmare with a custom SerDe

@NoArgsConstructor
@AllArgsConstructor
public class EventTempDeviationMessage {

    private long time;
    private String transformer_name;
    private String flag; //TODO Maybe switch to enum ?
    private String details;

    public long getTime() {
        return time;
    }

    public String getTransformer_name() {
        return transformer_name;
    }

    public String getFlag() {
        return flag;
    }

    public String getDetails() {
        return details;
    }

    //TODO Find a way to make Jackson serialization recognize Lombok generated getters
    //https://www.baeldung.com/jackson-jsonmappingexception


}
