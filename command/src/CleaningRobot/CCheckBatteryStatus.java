package CleaningRobot;


public class CCheckBatteryStatus implements General.ICommand {

    CleaningRobot cleaningRobot;

    public CCheckBatteryStatus(CleaningRobot cr) {
        this.cleaningRobot = cr;
    }

    public void execute() {
        float status = this.cleaningRobot.checkBatteryStatus();
        System.out.println("Battery status: " + status);
    }
}
