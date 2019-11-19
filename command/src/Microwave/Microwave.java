package Microwave;


public class Microwave extends General.Device implements General.IOnOffSwitchable, General.IStartStoppable, General.ITimerSet, General.ITimerCheck, General.ITemperatureSettable {

    private boolean on;
    private int temperature = -1;
    private General.Timer timer = null;
    private Thread timerThread = null;

    public Microwave(String deviceName) {
        this.name = deviceName;
        this.on = false;
        this.temperature = 0;
    }

    public boolean isRunning() {
        return timer != null && timer.isRunning();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setTimer(int durationInSeconds) {
        this.timer = new General.Timer(durationInSeconds*1000);
    }

    public void start() {
        if (on && temperature >= 0 && timer != null ) {
            timerThread = new Thread(timer);
            timerThread.start();
        }
    }

    public int checkTimer() {
        if (on && timer != null && isRunning()) {
            return timer.getTime();
        }
        return 0;
    }

    public void stop() {
        if (isRunning()) {
            timerThread = null;
            timer = null;
            temperature = -1;
        }
    }

    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }
}