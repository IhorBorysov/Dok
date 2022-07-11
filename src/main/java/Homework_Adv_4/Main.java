package Homework_Adv_4;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger Log = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {
        Log.error("ERROR MESSAGE");
        Log.debug("Debug message");
        Log.warn("Warn Log");
        Log.info("Info message");
    }
}
