package WashingMachine;

import java.util.ArrayList;
import General.Timer;
import sun.java2d.loops.DrawGlyphListAA.General;

public class WashingMachine implements General.IOnOffSwitchable {

    private boolean on = false;
    private ArrayList<String> programs;
    private boolean running;
    private General.Timer timer=null;
    private String runningProgram;
    private Thread t;

    public WashingMachine(){
        this.runningProgram= "noProgram";
        this.programs= new ArrayList<String>();
        addProgram(programs);
        this.running=false;
        on=false;
        
    }
    public String getProgram(){
        return runningProgram;
    }
    public void switchOn() {
        this.on = true;
    }
    private void setTimer(float time){
        this.timer= new Timer(time*1000);
    }

    public boolean turnOff(){ 

        if(!t.isAlive()){
            //what is turn off??
            //difference between turn off and switch off?
            return true;
        }
        return false;
    }

    public void switchOff() {
        this.on = false;
    }
    private void addProgram(ArrayList<String> list){
        list.add("Double Rinse");
        list.add("Intense");
        list.add("Quick");
        list.add("Spin");
    }
}
