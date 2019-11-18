package Microwave;


import java.util.Scanner;


public class CSetTemperatureMicrowave implements General.ICommand {

    private Microwave microwave;

    public CSetTemperatureMicrowave(Microwave microwave){
        this.microwave = microwave;
    }

    public void execute(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the temperature for the microwave: ");
        float num = s.nextFloat();
        microwave.setTemperature(num);
        s.close();
    }
}