package Oven;


public class StartCooking implements ICommand {

    private Oven.Oven oven;

    public StartCooking(Oven.Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.startCooking();
    }
}