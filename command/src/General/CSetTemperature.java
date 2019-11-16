package General;


public class CSetTemperature implements ICommand {

    ITemperatureSettable temperatureSettable;

    public CSetTemperature(ITemperatureSettable temperatureSettable) {
        this.temperatureSettable = temperatureSettable;
    }

    public void execute() {
        this.temperatureSettable.setTemperature();
    }
}
