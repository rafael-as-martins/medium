package com.medium;

public class SkypeMessageDecorator extends NotifierBaseDecorator implements Notifier {

    public static final double PROCESS_TIME = 1;

    public SkypeMessageDecorator(Notifier notifier) {
        super(notifier, PROCESS_TIME);
    }

    @Override
    public double getProcessTime() {
        return PROCESS_TIME;
    }

    @Override
    public void notifyWorkers() {
        System.out.println("Sending SKYPE MESSAGE...");
        super.notifyWorkers();
    }

}
