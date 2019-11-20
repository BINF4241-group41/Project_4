package WashingMachine;

import General.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class WashingMachine extends Device implements General.IOnOffSwitchable, General.IStartStoppable, IProgramSelectable {

    private boolean on;
    private ArrayList<Program> programs;
    private Program currentProgram;
    private int temperature; // enum?
    private Timer timer;
    private Thread timerThread;


    public WashingMachine(String deviceName) {
        this.on = false;
        this.temperature = 0;
        this.name = deviceName;
        this.currentProgram = Program.getNoProgram();
        this.programs = new ArrayList<Program>();
        addPrograms(this.programs);
    }


    public boolean isRunning() {
        return (timer != null && timer.isRunning());
    }

    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }

    public void start() {
        if (this.on && !isRunning() && this.currentProgram != null && this.currentProgram != Program.getNoProgram()) {
            this.timer = new Timer(this.currentProgram.getDuration());
            this.timerThread = new Thread(this.timer);
            this.timerThread.start();
        }
    }

    public void stop() {
        if (this.on && !isRunning()) {
            this.timerThread = null;
            this.timer = null;
            this.currentProgram = Program.getNoProgram();
            this.temperature = 0;
        }
    }

    public void setTemperature(int temperature) {
        if (this.on) {
            this.temperature = temperature;
        }
    }

    public void setProgram(Program program) {
        if (this.on && program != null) {
            this.currentProgram = program;
            this.timer = new Timer(currentProgram.getDuration());
        }
    }

    private void addPrograms(ArrayList<Program> list) {
        list.add(new Program("Double Rinse", 240));
        list.add(new Program("Intense", 120));
        list.add(new Program("Quick", 60));
        list.add(new Program("Spin", 120));
    }

    public ArrayList<Program> getPrograms() {
        return new ArrayList<Program>(this.programs);
    }
}
