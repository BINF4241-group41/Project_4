package General;


import java.util.Scanner;

public class CSetTemperature implements ICommand {

    ITemperatureSettable temperatureSettable;

    public CSetTemperature(ITemperatureSettable temperatureSettable) {
        this.temperatureSettable = temperatureSettable;
    }

    public String getName() {
        return "SetTemperature";
    }

    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the temperature (must be non-negative): ");
        int temp = s.nextInt();
        if (temp >= 0) {
            this.temperatureSettable.setTemperature(temp);
        }
    }
}
