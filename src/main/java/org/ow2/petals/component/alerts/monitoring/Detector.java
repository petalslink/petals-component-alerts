/**
 * Copyright (c) 2013, Linagora
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA 
 *
 */
package org.ow2.petals.component.alerts.monitoring;

import org.ow2.petals.component.framework.monitoring.defect.JmxDefectCreator;
import org.ow2.petals.probes.api.sensor.detector.GaugeDefectDetector;

/**
 * @author Christophe Hamerling - chamerling@linagora.com
 */
public class Detector implements GaugeDefectDetector<Long> {

    private final JmxDefectCreator jmxDefectCreator;

    public Detector(JmxDefectCreator jmxDefectCreator) {
        this.jmxDefectCreator = jmxDefectCreator;
    }

    @Override
    public void detect(Long aLong) {
        this.jmxDefectCreator.createAndSend();
    }
}
