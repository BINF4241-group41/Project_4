public class CommandSwitchOn implements Command {
    OnOffSwitchable switchable;

    public CommandSwitchOn(OnOffSwitchable switchable) {
        this.switchable = switchable;
    }

    public void execute() {
        switchable.switchOn();
    }
}
