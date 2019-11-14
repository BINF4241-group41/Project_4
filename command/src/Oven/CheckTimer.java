public class CheckTimer implements Command{

    private Oven oven;

    public CheckTimer(Oven oven){
        this.oven=oven;
    }

    public void execute(){
        System.out.println("Timer: "+oven.checkTimer());
    }

}