import java.util.Scanner;

import jdk.jfr.internal.cmd.Execute;

public class SetUpProgramOven implements Command{
    
    private Oven oven;

    public SetUpProgramOven(Oven oven){
        this.oven=oven;
    }

    public void execute(){
        System.out.println("type the program you want:");
        System.out.println("current programm: "+oven.currentProgram);
        System.out.println("list \n"+oven.showProgram());
        Scanner s = new Scanner(System.in);
        String reply = s.next();
        oven.setUpProgram(reply);
        s.close();
    }
} 