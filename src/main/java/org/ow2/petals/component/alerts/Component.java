/**
 * Copyright (c) 2006-2012 EBM WebSourcing, 2012-2013 Linagora
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
package org.ow2.petals.component.alerts;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import org.ow2.petals.component.alerts.monitoring.Monitoring;
import org.ow2.petals.component.framework.bc.AbstractBindingComponent;
import org.ow2.petals.probes.api.exceptions.MultipleProbesFactoriesFoundException;
import org.ow2.petals.probes.api.exceptions.NoProbesFactoryFoundException;

import javax.jbi.JBIException;

/**
 * @author Christophe Hamerling - chamerling@linagora.com
 */
public class Component extends AbstractBindingComponent {

    private Monitoring monitoringMbean;

    private Server server;

    @Override
    protected org.ow2.petals.component.framework.monitoring.Monitoring createMonitoringMBean()
            throws MultipleProbesFactoriesFoundException, NoProbesFactoryFoundException {

        this.monitoringMbean = new Monitoring(this.getProbesTimer(),
                this.getResponseTimeProbeSamplePeriod());
        return this.monitoringMbean;
    }

    @Override
    protected void doStart() throws JBIException {

        System.out.println("Starting the JETTY Server");
        server = new Server(8812);
        Context root = new Context(server,"/", Context.SESSIONS);
        root.addServlet(new ServletHolder(new Servlet(this.monitoringMbean)), "/*");
        try {
            server.start();
        } catch (Exception e) {
            throw new JBIException(e);
        }
    }

    @Override
    protected void doShutdown() throws JBIException {
    }

    @Override
    protected void doStop() throws JBIException {
        if (server != null) {
            try {
                server.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
