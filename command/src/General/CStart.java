package General;


public class CStart implements ICommand {

    private IStartStoppable startStoppable;

    public CStart (IStartStoppable startStoppable) {
        this.startStoppable = startStoppable;
    }

    public void execute() {
        this.startStoppable.start();
    }
}
