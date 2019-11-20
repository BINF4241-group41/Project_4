package Oven;


import General.Program;

import java.util.ArrayList;


public class Oven extends General.Device implements General.IOnOffSwitchable, General.IStartStoppable, General.ITimerCheck, General.ITimerSet, General.IProgramSelectable, General.ITemperatureSettable {

    private boolean on = false;

    private int temperature = -1; // needs to be non-negative 0
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
        if (this.on) {
            this.timer = new General.Timer(time * 1000);
        }
    }

    public void setTemperature(int temperature) {
        if (this.on && temperature >= 0) {
            this.temperature = temperature;
        }
    }

    public void start() {
        if (this.on && (temperature >= 0) && (currentProgram != Program.getNoProgram()) && timer != null) {
            this.timerThread = new Thread(timer);
            this.timerThread.start();
        }
    }

    public int checkTimer() {
        if (this.on && timer != null) {
            return (timer.getRemainingTime() / 1000);
        }
        return 0;
    }

    public void stop() {
        if (this.on && isRunning()) {
            this.timerThread = null;
            this.timer = null;
            this.temperature = 0;
            this.currentProgram = Program.getNoProgram();
        }
    }

    private void addPrograms(ArrayList<Program> list) {
        list.add(new Program("Ventilated"));
        list.add(new Program("Grill"));
    }

    public void setProgram(Program program) {
        if (this.on && program != null) {
            this.currentProgram = program;
        }
    }

    public ArrayList<Program> getPrograms() {
        return new ArrayList<Program>(this.programs);
    }

    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }

    public String toString() {
        String status = "Device: Oven\n";

        if (this.on) {
            if (isRunning()) {
                status += "Device is switched on and running.\n";
            }
            else {
                status += "Device is switched on.\n";
            }
        }
        else {
            status += "Device is switched off.\n";
        }
        if (this.temperature >= 0) {
            status += "Temperature is set to " + this.temperature + ".\n";
        }
        if (this.timer != null) {
            status += "Timer is set to " + this.timer.getTime() + ".\n";
        }
        if (this.currentProgram != null && this.currentProgram != Program.getNoProgram()) {
            status += "Program is set to " + this.currentProgram.getName() + ".\n";
        }

        return status;
    }
}