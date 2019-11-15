package Oven;


public class CInterruptProgramOven implements General.ICommand {

    private Oven oven;

    public CInterruptProgramOven(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.interruptProgram();
    }
}