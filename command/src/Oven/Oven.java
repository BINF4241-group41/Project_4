package Oven;


import General.Program;

import java.util.ArrayList;


public class Oven extends General.Device implements General.IOnOffSwitchable, General.IStartStoppable, General.ITimerCheck, General.ITimerSet, General.IProgramSelectable, General.ITemperatureSettable {

    private boolean on = false;

    private int temperature = 0;
    private ArrayList<Program> programs = new ArrayList<Program>();
    private Program currentProgram = Program.getNoProgram();
    private General.Timer timer = null;
    private Thread timerThread = null;


    public Oven(String deviceName) {
        this.name = deviceName;
        addPrograms(programs);
    }

    public boolean isRunning() {
        return (this.timer != null && this.timer.isRunning());
    }

    public void setTimer(int time) {
        this.timer = new General.Timer(time*1000);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void start() {
        if (this.on && (temperature > 0) && (currentProgram != Program.getNoProgram()) && timer != null) {
            this.timerThread = new Thread(timer);
            this.timerThread.start();
        }
    }

    public int checkTimer() {
        if (timer != null) {
            return timer.getTime();
        }
        return 0;
    }

    public void stop() {
        if (this.timerThread != null && this.timer.isRunning()) {
            this.timerThread = null;
        }

        this.timer = null;
        this.temperature = 0;
        this.currentProgram = Program.getNoProgram();
    }

    private void addPrograms(ArrayList<Program> list) {
        list.add(new Program("Ventilated"));
        list.add(new Program("Grill"));
    }

    public void setProgram(Program program) {
        if (program != null) {
            this.currentProgram = program;
        }
    }


    /*
    public String display() {

        String output;

        if (!this.on) {
            output = "Oven isn't on.";
        }

        else if (isRunning()) {
            output = "Currently running the following program:\n";
            output += "The program is " + currentProgram.getName() + ", ";
            output += "temperature: " + temperature + ", ";
            output += "total timer duration: " + timer.getTime() + ".";
        }

        else if (Finished running) {
            output += "The temperature is " + temperature + ", ";
            output += "the program is " + currentProgram.getName() + ", ";
            output += "total timer duration: " + timer.getTime() + ".";
        }

        else {
            // reset
        }

        return output;
    }
     */


    public ArrayList<Program> getPrograms() {
        return new ArrayList<Program>(this.programs);
    }

    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }
}