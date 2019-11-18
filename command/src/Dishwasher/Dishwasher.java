package Dishwasher;


import General.Program;

import java.util.ArrayList;


public class Dishwasher extends General.Device implements General.IOnOffSwitchable, General.IStartStoppable, General.ITimerCheck, General.IProgramSelectable {

    private boolean on;
    private ArrayList<Program> programs;
    private boolean running;
    private General.Timer timer = null;
    private Program currentProgram;

    public Dishwasher(String deviceName) {
        this.name = deviceName;
        this.currentProgram = Program.getNoProgram();
        this.programs = new ArrayList<Program>();
        addProgram(programs);
        this.running = false;
        on = false;

    }
    public String getProgram(){
        return currentProgram.getName();
    }

    private void setTimer(int time){
        this.timer= new General.Timer(time*1000);
    }

    public int checkTimer() {
        if (timer != null) {
           return timer.getTime();
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
        if (this.on && timer != null){
            Thread t = new Thread(timer);
            running = true;
            t.start();
        }
    }

    public void stop() {
        if (running) {
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

    private void addProgram(ArrayList<Program> list){
        list.add(new Program("mixed",400));
        list.add(new Program("pans",300));
        list.add(new Program("glasses",200));
        list.add(new Program("plates",100));
    }

    public ArrayList<Program> getPrograms() {
        return new ArrayList<Program>(this.programs);
    }

    @Override
    public void setProgram(Program program) {
        if (program != null) {
            this.currentProgram = program;
        }
    }
}
