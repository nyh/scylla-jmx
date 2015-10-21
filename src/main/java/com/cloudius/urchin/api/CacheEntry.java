/*
 * Copyright (C) 2015 ScyllaDB
 */

/*
 * This file is part of Scylla.
 *
 * Scylla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Scylla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Scylla.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.cloudius.urchin.api;

import com.cloudius.urchin.utils.EstimatedHistogram;

public class CacheEntry {
    long time;
    Object value;

    CacheEntry(Object res) {
        time = System.currentTimeMillis();
        this.value = res;
    }

    public boolean valid(long duration) {
        return (System.currentTimeMillis() - time) < duration;
    }

    public String stringValue() {
        return (String) value;
    }

    public EstimatedHistogram getEstimatedHistogram() {
        return (EstimatedHistogram)value;
    }
}
