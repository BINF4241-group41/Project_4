package Oven;

import java.util.Scanner;
//import jdk.jfr.internal.cmd.Execute;


public class CSetUpProgramOven implements General.ICommand {
    
    private Oven oven;

    public CSetUpProgramOven(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        System.out.println("type the program you want:");
        System.out.println("current programm: " + oven.getProgram());
        System.out.println("list \n"+oven.getProgram());
        Scanner s = new Scanner(System.in);
        String reply = s.next();
        oven.setUpProgram(reply);
        s.close();
    }
} 