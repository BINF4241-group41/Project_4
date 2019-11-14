public class SetTemperatureOven implements Command{

    private Oven oven;

    public SetTemperatureOven(Oven oven){
        this.oven=oven;
    }

    public void execute(){
        Scanner s = new Scanner(System.in);
        System.out.println("Insert the temperature for the oven:");
        float num=s.nextFloat();
        oven.setTemperature(time);
        s.close();
    }
}