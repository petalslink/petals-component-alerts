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

import org.ow2.petals.probes.api.exceptions.*;

import javax.management.MBeanNotificationInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

/**
 * @author Christophe Hamerling - chamerling@linagora.com
 */
public class Monitoring extends org.ow2.petals.component.framework.monitoring.Monitoring implements MonitoringMBean {

    private final Sensor sensor;

    private final Detector detector;

    private DefectCreator defectCreator;

    /**
     *
     * @param responseTimeProbesTimer
     * @param samplePeriod
     * @throws MultipleProbesFactoriesFoundException
     * @throws NoProbesFactoryFoundException
     */
    public Monitoring(Timer responseTimeProbesTimer, long samplePeriod) throws MultipleProbesFactoriesFoundException, NoProbesFactoryFoundException {
        super(responseTimeProbesTimer, samplePeriod);

        this.defectCreator = new DefectCreator(this);
        this.sensor = new Sensor();
        this.detector = new Detector(this.defectCreator);
    }

    @Override
    public void doInit() throws ProbeInitializedException, ProbeStartedException, ProbeInitializationException {
    }

    @Override
    protected void doStart() throws ProbeNotInitializedException, ProbeStartedException, ProbeStartupException {
    }

    @Override
    public void doShutdown() throws ProbeShutdownException, ProbeStartedException, ProbeNotInitializedException {
    }

    @Override
    public void doStop() throws ProbeNotInitializedException, ProbeNotStartedException, ProbeStopException {
    }

    @Override
    public List<MBeanNotificationInfo> addNotificationInfo() {
        return Arrays.asList(new MBeanNotificationInfo[]{
                this.defectCreator.getNotificationInfo()});
    }

    public Sensor getSensor() {
        return sensor;
    }

    public Detector getDetector() {
        return detector;
    }

    public DefectCreator getDefectCreator() {
        return defectCreator;
    }
}
