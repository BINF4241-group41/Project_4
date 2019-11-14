import java.util.Scanner;


public class CommandSetTimer implements ICommand {

    ITimerSet canSetTimerObject;

    public CommandSetTimer(ITimerSet canSetTimerObject) {
        this.canSetTimerObject = canSetTimerObject;
    }

    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.println("Set the timer interval:");
        int time = s.nextInt();
        this.canSetTimerObject.setTimer(time);
        s.close();
    }
}
