package Dishwasher;

public class Dishwasher implements General.ITimerCheck, General.IOnOffSwitchable {

    private boolean on = false;

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
