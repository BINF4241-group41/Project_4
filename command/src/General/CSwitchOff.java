package General;


public class CSwitchOff implements ICommand {

    IOnOffSwitchable switchable;

    public CSwitchOff(IOnOffSwitchable switchable) {
        this.switchable = switchable;
    }

    public boolean isAvailable() {
        return this.switchable.isOn();
    }

    public String getName() {
        return "SwitchOff";
    }

    public void execute() {
        switchable.switchOff();
    }
}
