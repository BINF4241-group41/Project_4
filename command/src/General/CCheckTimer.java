package General;

public class CCheckTimer implements ICommand {

    ITimerCheck timerCheckableObject;

    public CCheckTimer(ITimerCheck timerCheckableObject) {
        this.timerCheckableObject = timerCheckableObject;
    }

    public void execute() {
        System.out.println("General.Timer: " + this.timerCheckableObject.checkTimer());
    }
}
