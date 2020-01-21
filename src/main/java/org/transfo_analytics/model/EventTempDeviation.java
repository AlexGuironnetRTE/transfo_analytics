/* Copyright (c) 2020, RTE (http://www.rte-france.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.transfo_analytics.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EventTempDeviation {

    private long time;
    private String transformer_name;
    private String flag; //TODO Maybe switch to enum ?

    private EventTempDevDetails details;

    public long getTime() {
        return time;
    }

    public String getTransformer_name() {
        return transformer_name;
    }

    public String getFlag() {
        return flag;
    }

    public EventTempDevDetails getDetails() {
        return details;
    }

    //TODO Find a way to make Jackson serialization recognize Lombok generated getters
    //https://www.baeldung.com/jackson-jsonmappingexception


}
