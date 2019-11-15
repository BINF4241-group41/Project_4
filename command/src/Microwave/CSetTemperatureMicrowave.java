package Microwave;


public class CSetTemperatureMicrowave implements General.ICommand {

    private Microwave microwave;

    public CSetTemperatureMicrowave(Microwave microwave){
        this.microwave=microwave;
    }

    public void execute(){

    }
}