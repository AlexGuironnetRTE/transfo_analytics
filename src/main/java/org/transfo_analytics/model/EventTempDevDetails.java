/* Copyright (c) 2020, RTE (http://www.rte-france.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

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
