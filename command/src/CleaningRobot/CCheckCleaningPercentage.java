package CleaningRobot;


public class CCheckCleaningPercentage implements General.ICommand {

    private CleaningRobot cleaningRobot;

    public CCheckCleaningPercentage(CleaningRobot cr) {
        this.cleaningRobot = cr;
    }

    public void execute() {
        float progress = this.cleaningRobot.getCleaningProgress();
        System.out.println("Cleaning progress: " + progress*100 + "%");
    }
}
