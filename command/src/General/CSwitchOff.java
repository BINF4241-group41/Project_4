package General;

public class CSwitchOff implements ICommand {

    IOnOffSwitchable switchable;

    public CSwitchOff(IOnOffSwitchable switchable) {
        this.switchable = switchable;
    }

    public void execute() {
        switchable.switchOff();
    }
}
