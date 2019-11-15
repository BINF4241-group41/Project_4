package Oven;


public class CStartCookingOven implements General.ICommand {

    private Oven oven;

    public CStartCookingOven(Oven oven){
        this.oven = oven;
    }

    public void execute(){
        oven.startCooking();
    }
}