/* Copyright (c) 2020, RTE (http://www.rte-france.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

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
