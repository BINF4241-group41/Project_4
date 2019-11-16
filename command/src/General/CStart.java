package General;

public class CStart {
    private IStartStoppable startStoppable;

    public CStart (IStartStoppable startStoppable) {
        this.startStoppable = startStoppable;
    }

    public void start() {
        this.startStoppable.start();
    }
}
