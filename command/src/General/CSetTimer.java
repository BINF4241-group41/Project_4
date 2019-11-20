package General;

import java.util.Scanner;


public class CSetTimer implements ICommand {

    ITimerSet canSetTimerObject;

    public CSetTimer(ITimerSet canSetTimerObject) {
        this.canSetTimerObject = canSetTimerObject;
    }

    public String getName() {
        return "SetTimer";
    }

    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.println("Set the timer interval:");
        int time = s.nextInt();
        this.canSetTimerObject.setTimer(time);
    }
}
