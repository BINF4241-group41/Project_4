package CleaningRobot;


public class CCompleteCleaningCR implements General.ICommand {

    private CleaningRobot cleaningRobot;

    public CCompleteCleaningCR(CleaningRobot cr) {
        this.cleaningRobot = cr;
    }

    public void execute() {
        // if not already cleaning, start default program
        this.cleaningRobot.completeCleaning();
    }
}
