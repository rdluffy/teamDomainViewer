package org.kaizoku.commons;


import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: A168594
 * Date: 06/01/13
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
public class Logger {
    public static Logger getLogger(Class<?> clz) {
        return new Logger(clz.getCanonicalName());
    }

    String class_asking_logger_canonical_name;

    private Logger(String class_asking_logger_canonical_name) {
        this.class_asking_logger_canonical_name = class_asking_logger_canonical_name;
    }

    public void trace(Object message) {
        String toTrace = new Date().toString() + "|"+class_asking_logger_canonical_name +"| "+message.toString();
        trace_under_stdout(toTrace);
    }

    private void trace_under_stdout(String toTrace) {
        System.out.print(toTrace);
    }


    public void main(String args[]) {
            getLogger(Logger.class).trace("io");
    }
}
