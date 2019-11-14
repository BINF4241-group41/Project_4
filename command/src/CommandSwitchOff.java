public class CommandSwitchOff {

    HomeDevice device;

    public CommandSwitchOff(HomeDevice device) {
        this.device = device;
    }

    public void execute() {
        device.switchOff();
    }
}
