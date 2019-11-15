package Dishwasher;


public class CStopDishWasher implements General.ICommand {

    private Dishwasher dishwasher;

    public CStopDishWasher(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.stopWash();
    }
}