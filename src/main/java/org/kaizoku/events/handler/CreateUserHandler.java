package org.kaizoku.events.handler;

import org.kaizoku.commons.Logger;
import org.kaizoku.events.event.Event;

/**
 * Created with IntelliJ IDEA.
 * User: A168594
 * Date: 06/01/13
 * Time: 19:50
 * To change this template use File | Settings | File Templates.
 */
public class CreateUserHandler implements  EventHandler {
    static Logger log = Logger.getLogger(CreateUserHandler.class);

    @Override
    public boolean handle(Event evt) {
        log.trace("Create new user, save the event");
        return true;

    }

    @Override
    public String getEventID() {
        return new CreateUserHandler().getEventID();
    }
}
