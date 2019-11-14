package Microwave;


public class Microwave extends HomeDevice implements ITimerSet, ITimerCheck {


    private float temperature;

    public Microwave(){
        super();
        this.temperature = 0;
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
    }

    public void setTimer(int durationInSeconds) {
        return;
    }

    public int checkTimer() {
        return 0;
    }
}