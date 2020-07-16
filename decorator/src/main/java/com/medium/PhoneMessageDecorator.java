package com.medium;

public class PhoneMessageDecorator extends NotifierBaseDecorator implements Notifier {

    public static final double PROCESS_TIME = 5;

    public PhoneMessageDecorator(Notifier notifier) {
        super(notifier, PROCESS_TIME);
    }

    @Override
    public double getProcessTime() {
        return PROCESS_TIME;
    }

    @Override
    public void notifyWorkers() {
        System.out.println("Sending PHONE MESSAGE...");
        super.notifyWorkers();
    }

}
