package General;


public class CStop implements ICommand {

    private IStartStoppable startStoppable;

    public CStop (IStartStoppable startStoppable) {
        this.startStoppable = startStoppable;
    }

    public String getName() {
        return "Stop";
    }

    public void execute() {
        this.startStoppable.stop();
    }
}
