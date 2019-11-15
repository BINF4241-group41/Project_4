package Microwave;


public class Microwave implements General.IOnOffSwitchable, General.ITimerSet, General.ITimerCheck {

    private boolean on;
    private float temperature;

    public Microwave(){
        this.on = false;
        this.temperature = 0;
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
    }

    public void setTimer(int durationInSeconds) {
        return;
    }

    public int checkTimer() {
        return 0;
    }

    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }
}