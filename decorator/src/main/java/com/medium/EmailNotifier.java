package com.medium;

public class EmailNotifier implements Notifier {

    public static final double PROCESS_TIME = 3.3;

    @Override
    public void notifyWorkers() {
        System.out.println("Sending EMAIL...");
    }

    @Override
    public double getProcessTime() {
        return PROCESS_TIME;
    }

    @Override
    public double getProcessedTime() {
        return PROCESS_TIME;
    }

}
