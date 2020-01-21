/* Copyright (c) 2020, RTE (http://www.rte-france.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.transfo_analytics.model;

import org.transfo_analytics.utils.Utilities;

import java.util.List;

public class EventTempDevDetailsProcessedData {

    private List<Long> labels; //X axis labels
    private List<String> label; //Name of dataset
    private List<List<Long>> data;

    public EventTempDevDetailsProcessedData(EventTempDevDetails eventTempDevDetails) {
        this.label = eventTempDevDetails.getColumns();
        this.data = Utilities.transpose(eventTempDevDetails.getData());
        this.labels = eventTempDevDetails.getIndex();
    }

    public List<Long> getLabels() {
        return labels;
    }

    public List<String> getLabel() {
        return label;
    }

    public List<List<Long>> getData() {
        return data;
    }
}
