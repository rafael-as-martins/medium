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
    public String notifyWorkers() {
        //Skype  -> Phone (5) -> Email (3.3) -> 8.3 + 1
        //Phone -> Email (3.3) -> 5 + 3.3
        addTime(notifier.getProcessTime());
        return notifier.notifyWorkers();
    }

    @Override
    public double getProcessTime() {
        return 0.0;
    }

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
