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
package org.ow2.petals.component.alerts;

import org.ow2.petals.component.framework.api.message.Exchange;
import org.ow2.petals.component.framework.listener.AbstractJBIListener;
import org.ow2.petals.component.framework.process.async.AsyncContext;

/**
 * @author Christophe Hamerling - chamerling@linagora.com
 */
public class NopListener extends AbstractJBIListener {

    @Override
    public boolean onAsyncJBIMessage(Exchange asyncExchange, AsyncContext asyncContext) {
        return true;
    }

    @Override
    public boolean onExpiredAsyncJBIMessage(Exchange originalExchange, AsyncContext asyncContext) {
        return true;
    }

    @Override
    public boolean onJBIMessage(Exchange exchange) {
        return true;
    }
}
