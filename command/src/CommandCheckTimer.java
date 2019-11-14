public class CommandCheckTimer implements ICommand {

    ITimerCheck timerCheckableObject;

    public CommandCheckTimer(ITimerCheck timerCheckableObject) {
        this.timerCheckableObject = timerCheckableObject;
    }

    public void execute() {
        System.out.println("Timer: " + this.timerCheckableObject.checkTimer());
    }
}
