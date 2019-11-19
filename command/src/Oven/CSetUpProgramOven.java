package Oven;

import java.util.Scanner;



public class CSetUpProgramOven implements General.ICommand {
    
    private Oven oven;

    public CSetUpProgramOven(Oven oven){
        this.oven = oven;
    }

    public String getName() {
        return "SetUpProgramOven";
    }

    public void execute(){
        System.out.println("Type in the program you want:");
        System.out.println("current programm: " + oven.getProgram());
        System.out.println("list \n" + oven.display());
        Scanner s = new Scanner(System.in);
        String reply = s.next();
        if (oven.setUpProgram(reply)) {
            System.out.println("Program not available.");
        }
        s.close();
    }
} 