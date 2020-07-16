package com.medium;

public class NotifierBaseDecorator implements Notifier {

    private Notifier notifier;

    private double processTime;

    private double processedTime;

    public NotifierBaseDecorator(Notifier notifier, double processTime) {
        this.notifier = notifier;
        this.processedTime = 0;
        this.processTime = processTime;
    }

    @Override
    public void notifyWorkers() {

        // Skype > Phone.notifyWorkers  | addTime (8.3) - processedTime = 8.3 - getProcessedTime = 8.3 + 1 = 9
        // Phone > Email.notifyWorkers  | addTime (3.3) - processedTime = 3.3 - getProcessedTime = 3.3 + 5 = 8.3
        // Email


        notifier.notifyWorkers();
        addTime(notifier.getProcessedTime());
    }

    @Override
    public double getProcessTime() {
        return 0.0;
    }

    @Override
    public double getProcessedTime(){
        return processTime + processedTime;
    }


    public void addTime(double time){
        this.processedTime += time;
    }

    public Notifier getNotifier() {
        return notifier;
    }

}
