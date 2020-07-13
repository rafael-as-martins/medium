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
    public String notifyWorkers() {
        System.out.println(super.notifyWorkers());
        System.out.println("Sending PHONE MESSAGE...");
        return "Sending PHONE MESSAGE...";
    }

}
