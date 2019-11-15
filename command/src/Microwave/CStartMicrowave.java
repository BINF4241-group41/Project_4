package Microwave;


public class CStartMicrowave implements General.ICommand {

    private Microwave microwave;

    public CStartMicrowave(Microwave microwave){
        this.microwave=microwave;
    }

    public void execute(){
        microwave.start();
    }
}