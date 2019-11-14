public class CommandSwitchOn implements ICommand {

    HomeDevice device;

    public CommandSwitchOn(HomeDevice device) {
        this.device = device;
    }

    public void execute() {
        device.switchOn();
    }
}
