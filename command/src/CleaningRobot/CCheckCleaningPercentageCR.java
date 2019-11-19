package CleaningRobot;


public class CCheckCleaningPercentageCR implements General.ICommand {

    private CleaningRobot cleaningRobot;

    public CCheckCleaningPercentageCR(CleaningRobot cr) {
        this.cleaningRobot = cr;
    }

    public String getName() {
        return "CheckCleaningPercentageCR";
    }

    public void execute() {
        float progress = this.cleaningRobot.getCleaningProgress();
        System.out.println("Cleaning progress: " + progress*100 + "%");
    }
}
