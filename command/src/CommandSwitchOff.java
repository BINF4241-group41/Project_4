public class CommandSwitchOff {

    OnOffSwitchable switchable;

    public CommandSwitchOff(OnOffSwitchable switchable) {
        this.switchable = switchable;
    }

    public void execute() {
        switchable.switchOff();
    }
}
