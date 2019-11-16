package Oven;

import java.util.ArrayList;


public class Oven implements General.IOnOffSwitchable, General.ITimerCheck, General.ITimerSet, General.IStartStoppable {

    private boolean on = false;

    private boolean running;
    private float temperature;
    private ArrayList<String> programs;
    private String actualProgram;
    private General.Timer timer=null;
    private static final String DEFAULT_PROGRAM="noProgram";

    public Oven(){
        this.actualProgram = DEFAULT_PROGRAM;
        this.temperature=0;
        this.programs=new ArrayList<String>();
        addProgram(programs);
        this.running=false;    
    }
    //maybe you don't need cause we have the common timer class
    public void setTimer(int time){
        this.timer=new General.Timer(time*1000);
    }

    public void setTemperature(float temperature){
        this.temperature=temperature;
    }

    public void start() {
        if (this.on && (temperature>0) && (!actualProgram.equals(DEFAULT_PROGRAM)) && timer!=null){
            Thread t = new Thread(timer);
            running = true;
            t.start();
        }
    }

    public int checkTimer() {
        if (timer != null) {
            return timer;
        }
        return 0;
        //i don't understand the otherwise part on the paper
    }

    public void stop() {
        if(running) {
            running = false;
            timer = null;
        }
    }

    private void addProgram(ArrayList<String> list) {
        list.add("ventilated");
        list.add("grill");
    }

    public boolean setUpProgram(String program){
        if (programs.contains(program)){
            actualProgram = program;
            return true;
        }
        else {
            return false;
        }
    }

    //add_by_me
    //maybe we can use an interface
    public String display() {

        String output = "";
        output+= (running) ? "oven is running ": "oven isn't running ";
        output += "the temperature is " + temperature;
        output +="  the program is " + actualProgram;
        output += " timer:" + timer;

        return output;
    }

    //--------------
    public String getProgram(){
        String s = "";
        for (String r : programs){
            s += r + "\n";
        }
        return s;
    }

    public String currentProgram(){
        return actualProgram;
    }

    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }
    
}   