public class SwitchOffOven implements Command{

    private Oven oven;

    public SwitchOffOven(Oven oven){
        this.oven=oven;
    }

    public execute(){
        oven.switchOff();
    }

}