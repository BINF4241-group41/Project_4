package Dishwasher;

import java.util.Scanner;

import Dishwasher.Dishwasher;


public class CSetProgramDishWasher implements General.ICommand {
    
    private Dishwasher dishwasher;

    public CSetProgramDishWasher(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        System.out.println("type the program you want:");
        System.out.println("current programm: " + dishwasher.getProgram());
        System.out.println("list \n"+dishwasher.display());
        Scanner s = new Scanner(System.in);
        String reply = s.next();
        if(dishwasher.chooseProgram(reply)) System.out.println("Program no available");
        s.close();
    }
} 