package Dishwasher;


import General.Program;

import java.util.ArrayList;


public class Dishwasher extends General.Device implements General.IOnOffSwitchable, General.IStartStoppable, General.ITimerCheck, General.IProgramSelectable {

    private boolean on;
    private ArrayList<Program> programs;
    private Program currentProgram;
    private General.Timer timer;
    private Thread timerThread;

    public Dishwasher(String deviceName) {
        this.on = false;
        this.timer = null;
        this.timerThread = null;
        this.name = deviceName;
        this.currentProgram = Program.getNoProgram();
        this.programs = new ArrayList<Program>();
        addPrograms(programs);
    }

    public boolean isRunning() {
        return timer != null && timer.isRunning();
    }

    public int checkTimer() {
        if (this.on && timer != null) {
            return (timer.getRemainingTime() / 1000);
        }
        return 0;
    }

    public String display() {
        String output = "";
        for (Program pr : programs){
            output = pr.getName() + "\n" + output;
        }
        return output;
    }

    public void start() {
        if (this.on && timer != null && this.currentProgram != Program.getNoProgram()) {
            timerThread = new Thread(timer);
            timerThread.start();
        }
    }

    public void stop() {
        if (this.on && isRunning()) {
            timerThread = null;
            timer = null;
            this.currentProgram = Program.getNoProgram();
        }
    }

    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }

    private void addPrograms(ArrayList<Program> list) {
        list.add(new Program("Mixed",400));
        list.add(new Program("Pans",300));
        list.add(new Program("Glasses",200));
        list.add(new Program("Plates",100));
    }

    public ArrayList<Program> getPrograms() {
        return new ArrayList<Program>(this.programs);
    }

    // check if program available?
    public void setProgram(Program program) {
        if (this.on && program != null) {
            this.currentProgram = program;
            this.timer = new General.Timer(program.getDuration() * 1000);
        }
    }

    public String toString() {
        String status = "Device: Dishwasher\n";

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
        if (this.currentProgram != null && this.currentProgram != Program.getNoProgram()) {
            status += "Program: " + this.currentProgram.getName() + " with duration " + this.currentProgram.getDuration();
        }

        return status;
    }
}
