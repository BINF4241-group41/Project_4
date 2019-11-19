package General;

public class CCheckTimer implements ICommand {

    ITimerCheck timerCheckableObject;

    public CCheckTimer(ITimerCheck timerCheckableObject) {
        this.timerCheckableObject = timerCheckableObject;
    }

    public String getName() {
        return "CheckTimer";
    }

    public void execute() {
        System.out.println("Total timer duration: " + this.timerCheckableObject.checkTimer());
    }
}
