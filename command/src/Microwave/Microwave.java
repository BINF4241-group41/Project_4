package Microwave;


public class Microwave extends General.Device implements General.IOnOffSwitchable, General.IStartStoppable, General.ITimerSet, General.ITimerCheck {

    private boolean on;
    private float temperature;
    private General.Timer timer = null;
    private boolean running;

    public Microwave(String deviceName) {
        this.name = deviceName;
        this.on = false;
        this.temperature = 0;
        this.running = false;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setTimer(int durationInSeconds) {
        this.timer = new General.Timer(durationInSeconds*1000);
    }

    public void start() {
        if (on && temperature > 0 && timer != null ){
            Thread t = new Thread(timer);
            running = true;
            t.start();
        }
    }

    public int checkTimer() {
        if (running && timer != null) {
            return timer.getTime();
        }
        return 0;
    }

    public void stop() {
        if (running) {
            running = false;
            timer = null;
        }
    }

    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }

    public boolean isOn() {
        return on;
    }
}