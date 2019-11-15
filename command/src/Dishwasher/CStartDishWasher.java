
package Dishwasher;

public class CStartDishWasher implements General.ICommand {

    private Dishwasher dishwasher;

    public CStartDishWasher(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    public void execute(){
        dishwasher.StartWash();
    }
}