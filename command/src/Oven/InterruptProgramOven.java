package Oven;


public class InterruptProgramOven implements ICommand {

    private Oven oven;

    public InterruptProgramOven(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.interruptProgram();
    }
}