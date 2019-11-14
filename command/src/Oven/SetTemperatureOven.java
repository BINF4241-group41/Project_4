package Oven;

import java.util.Scanner;


public class SetTemperatureOven implements ICommand {

    private Oven oven;

    public SetTemperatureOven(Oven oven){
        this.oven = oven;
    }

    public void execute() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the temperature for the oven:");
        float num = s.nextFloat();
        oven.setTemperature(num);
        s.close();
    }
}