package Microwave;

public class Microwave implements General.IOnOffSwitchable, General.ITimerSet, General.ITimerCheck, General.IStartStoppable {

    private boolean on;
    private float temperature;
    private General.Timer timer = null;
    private boolean running;

    public Microwave(){
        this.on = false;
        this.temperature = 0;
        this.running = false;
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
    }

    public void setTimer(int durationInSeconds) {
        this.timer = new General.Timer(durationInSeconds*1000);
    }

    public void start(){
        if(on && temperature > 0 && timer != null ){
            Thread t = new Thread(timer);
            running=true;
            t.start();
        }
    }

    public int checkTimer() {
        if (running && timer != null) {
            return timer;
        }
        return 0;
    }

    public void stop() {
        if(running) {
            running = false;
            timer = null;
        }
    }
    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }
}