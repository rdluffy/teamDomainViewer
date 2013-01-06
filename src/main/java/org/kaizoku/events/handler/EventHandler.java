package org.kaizoku.events.handler;

import org.kaizoku.events.event.Event;

/**
 * Created with IntelliJ IDEA.
 * User: A168594
 * Date: 06/01/13
 * Time: 19:17
 * To change this template use File | Settings | File Templates.
 */
public interface EventHandler {

    /**
     *
     * @param evt
     * @return true if we have to save the event
     */
    public boolean handle(Event evt);
    public String getEventID();
}
