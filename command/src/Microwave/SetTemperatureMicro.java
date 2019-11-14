package Microwave;


public class SetTemperatureMicro implements ICommand {

    private Microwave microwave;

    public SetTemperatureMicro(Microwave microwave){
        this.microwave=microwave;
    }

    public void execute(){

    }
}