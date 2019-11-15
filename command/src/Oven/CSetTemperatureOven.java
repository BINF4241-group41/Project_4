package Oven;

import java.util.Scanner;


public class CSetTemperatureOven implements General.ICommand {

    private Oven oven;

    public CSetTemperatureOven(Oven oven){
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