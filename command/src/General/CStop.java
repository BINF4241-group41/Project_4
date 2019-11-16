package General;

public class CStop {
    private IStartStoppable startStoppable;

    public CStop (IStartStoppable startStoppable) {
        this.startStoppable = startStoppable;
    }

    public void stop() {
        this.startStoppable.stop();
    }

}
