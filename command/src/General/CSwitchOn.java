package General;


public class CSwitchOn implements ICommand {

    IOnOffSwitchable switchable;

    public CSwitchOn(IOnOffSwitchable switchable) {
        this.switchable = switchable;
    }

    public boolean isAvailable() {
        return !this.switchable.isOn();
    }

    public String getName() {
        return "SwitchOn";
    }

    public void execute() {
        switchable.switchOn();
    }
}
