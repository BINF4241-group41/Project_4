public class InterruptProgramOven implements Command{

    private Oven oven;

    public InterruptProgramOven(Oven oven){
        this.oven=oven;
    }

    public void execute(){
        oven.interruptProgram();
    }
}