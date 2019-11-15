package General;

public class CSwitchOn implements ICommand {

    IOnOffSwitchable switchable;

    public CSwitchOn(IOnOffSwitchable switchable) {
        this.switchable = switchable;
    }

    public void execute() {
        switchable.switchOn();
    }
}
