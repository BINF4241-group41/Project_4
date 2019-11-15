package WashingMachine;

public class WashingMachine implements General.IOnOffSwitchable {

    private boolean on = false;


    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }
}
