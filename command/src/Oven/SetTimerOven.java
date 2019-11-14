import java.util.Scanner;

public class SetTimerOven implements Command{

    private Oven oven;

    public SetTimerOven(Oven oven){
        this.oven=oven;
    }

    public execute(){
        Scanner s = new Scanner(System.in);
        System.out.println("Insert the time for the oven:");
        float num=s.nextFloat();
        oven.setTimer(time);
        s.close();
    }
}