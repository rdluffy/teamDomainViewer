package org.kaizoku.events.event;

import org.kaizoku.cryptography.digest.Digest;

/**
 * Created with IntelliJ IDEA.
 * User: A168594
 * Date: 06/01/13
 * Time: 18:49
 * To change this template use File | Settings | File Templates.
 */
public abstract class Event {
    public String getId() {
        String toHash = this.getClass().getCanonicalName();
        return Digest.hash_by_SHA256_to_base64(toHash);
    }
    public String toJSON(){
        return "JSONSTYLE";
    }
}
