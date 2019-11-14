public class StartCooking implements Command{

    private Oven oven;

    public StartCooking(Oven oven){
        this.oven=oven;
    }

    public void execute(){
        oven.startCooking();
    }
}