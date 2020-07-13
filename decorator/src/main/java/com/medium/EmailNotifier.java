package com.medium;

public class EmailNotifier implements Notifier {

    public static final double PROCESS_TIME = 3.3;

    @Override
    public String notifyWorkers() {
        return "Sending EMAIL...";
    }

    @Override
    public double getProcessTime() {
        return PROCESS_TIME;
    }

}
