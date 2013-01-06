package org.kaizoku.events;

import org.kaizoku.commons.Logger;
import org.kaizoku.events.event.Event;
import org.kaizoku.events.event.CreateDomainEvent;
import org.kaizoku.events.event.CreateUserEvent;
import org.kaizoku.events.handler.CreateDomainHandler;
import org.kaizoku.events.handler.CreateUserHandler;
import org.kaizoku.events.handler.EventHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: A168594
 * Date: 06/01/13
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
public class EventDispatcher {
    Map<String,EventHandler> mapEventHandler = new HashMap<String, EventHandler>();
    static Logger log = Logger.getLogger(EventDispatcher.class);




    public void registerHandler(EventHandler e)
    {
        mapEventHandler.put(e.getEventID(),e);
    }

    public void handleEvent(Event event){
        EventHandler handler = mapEventHandler.get(event.getId());
        if(handler == null){
            log.trace("NO HANDLER FOUND");
        }else{
            if(handler.handle(event)){
                log.trace("Save the event");
            }
        }


    }

    public void main(String args[]) {
     EventDispatcher d= new EventDispatcher();
     d.registerHandler(new CreateDomainHandler());
     d.registerHandler(new CreateUserHandler());

        {
            log.trace("Add a new domain");
            Event evt = new CreateDomainEvent();
            d.handleEvent(evt);
        }

        {
            log.trace("Add a new User");
            Event evt = new CreateUserEvent();
            d.handleEvent(evt);
        }



    }

}
