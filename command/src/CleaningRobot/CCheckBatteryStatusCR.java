package CleaningRobot;


public class CCheckBatteryStatusCR implements General.ICommand {

    CleaningRobot cleaningRobot;

    public CCheckBatteryStatusCR(CleaningRobot cr) {
        this.cleaningRobot = cr;
    }

    public void execute() {
        float status = this.cleaningRobot.checkBatteryStatus();
        System.out.println("Battery status: " + status);
    }
}
