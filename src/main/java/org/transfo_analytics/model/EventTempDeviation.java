package org.transfo_analytics.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EventTempDeviation {

    private long time;
    private String transformer_name;
    private String flag; //TODO Maybe switch to enum ?

    public long getTime() {
        return time;
    }

    public String getTransformer_name() {
        return transformer_name;
    }

    public String getFlag() {
        return flag;
    }

    //TODO Find a way to make Jackson serialization recognize Lombok generated getters
    //https://www.baeldung.com/jackson-jsonmappingexception


}
