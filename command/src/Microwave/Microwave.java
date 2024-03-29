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
        if (this.on) {
            this.temperature = temperature;
        }
    }

    public void setTimer(int durationInSeconds) {
        if (this.on) {
            this.timer = new General.Timer(durationInSeconds * 1000);
        }
    }

    public int checkTimer() {
        if (this.on && timer != null) {
            return (timer.getRemainingTime() / 1000);
        }
        return 0;
    }

    public void start() {
        if (on && temperature >= 0 && timer != null ) {
            timerThread = new Thread(timer);
            timerThread.start();
        }
    }

    public void stop() {
        if (on && isRunning()) {
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

    public String toString() {
        String status = "Device: Microwave\n";

        if (this.on) {
            if (isRunning()) {
                status += "Device is switched on and running.\n";
            }
            else {
                status += "Device is switched on.\n";
            }
        }
        else {
            status += "Device is switched off.\n";
        }
        if (this.temperature >= 0) {
            status += "Temperature is set to " + this.temperature + ".\n";
        }
        if (this.timer != null) {
            status += "Timer is set to " + this.timer.getTime() + ".\n";
        }

        return status;
    }
}