public class SwitchOnOven implements Command{
    
    private Oven oven;

    public SwitchOnOven(Oven oven){
        this.oven=oven;
    }
    public void execute(){
        oven.switchOn();
    }
}