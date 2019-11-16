package CleaningRobot;


public class CCompleteCleaning implements General.ICommand {

    private CleaningRobot cleaningRobot;

    public CCompleteCleaning(CleaningRobot cr) {
        this.cleaningRobot = cr;
    }

    public void execute() {
        // if not already cleaning, start default program
        this.cleaningRobot.completeCleaning();
    }
}
