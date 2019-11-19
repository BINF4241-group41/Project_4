package Oven;


import General.Program;

import java.util.ArrayList;


public class Oven extends General.Device implements General.IOnOffSwitchable, General.IStartStoppable, General.ITimerCheck, General.ITimerSet {

    private boolean on = false;

    private boolean isRunning() {
        return (this.timer != null && this.timer.isRunning());
    };

    private float temperature = 0;
    private ArrayList<Program> programs = new ArrayList<Program>();
    private Program currentProgram = Program.getNoProgram();
    private General.Timer timer = null;
    private Thread myThread = null; // thread for timer


    public Oven(String deviceName) {
        this.name = deviceName;
        addPrograms(programs);
    }

    public void setTimer(int time) {
        this.timer = new General.Timer(time*1000);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void start() {
        if (this.on && (temperature > 0) && (currentProgram != Program.getNoProgram()) && timer != null) {
            this.myThread = new Thread(timer);
            this.myThread.start();
        }
    }

    public int checkTimer() {
        if (timer != null) {
            return timer.getTime();
        }
        return 0;
    }

    public void stop() {
        if (this.myThread != null && this.timer.isRunning()) {
            this.myThread = null;
        }

        this.timer = null;
        this.temperature = 0;
        this.currentProgram = Program.getNoProgram();
    }

    private void addPrograms(ArrayList<Program> list) {
        list.add(new Program("Ventilated"));
        list.add(new Program("Grill"));
    }

    public boolean setUpProgram(String program) {
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

        if (!this.on) {
            return "Oven isn't running.";
        }

        String output = "";
        output += "The temperature is " + temperature + ", ";
        output += "the program is " + currentProgram.getName() + ", ";
        output += "total timer duration: " + timer.getTime() + ".";

        return output;
    }


    public ArrayList<Program> getPrograms() {
        return new ArrayList<Program>(this.programs);
    }

    public Program getCurrentProgram(){
        return currentProgram;
    }

    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }

    public boolean isOn() {
        return on;
    }
}