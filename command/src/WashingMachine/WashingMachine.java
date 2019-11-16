package WashingMachine;

import General.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class WashingMachine implements General.IOnOffSwitchable, General.IStartStoppable, IProgramSelectable, ITemperatureSettable {

    private boolean on = false;
    private ArrayList<Program> programs;
    private Program currentProgram;
    private int degrees; // enum?
    private boolean running;

    public WashingMachine() {
        this.on = false;
        currentProgram = Program.getNoProgram();
        this.programs = new ArrayList<Program>();
        addProgram(programs);
        this.running = false;
        
    }

    public void switchOn() {
        this.on = true;
    }

    public void switchOff() {
        this.on = false;
    }

    // move to separate thread
    public void start() {
        if (!running) {
            running = true;
            Timer timer = new Timer(this.currentProgram.getDuration());
            timer.run();
            running = false;
        }
    }

    public void stop() {
        if (running) {
            System.out.println("A program is running. Can't turn off.");
        }
        else {
            this.currentProgram = Program.getNoProgram();
            this.degrees = 0;
        }
    }

    public void setTemperature() {
        System.out.println("Please select the degrees (type abort to abort):\n40 C\n60 C\n90 C");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int nextInt = scanner.nextInt();
                if (nextInt == 40 || nextInt == 60 || nextInt == 90) {
                    this.degrees = nextInt;
                    break;
                }
                else {
                    System.out.println("Please select one of the provided values.");
                }
            }
            else if (scanner.next().equals("abort")) {
                break;
            }
        }
        scanner.close();
    }

    public void setProgram(Program program) {
        if (program != null) {
            this.currentProgram = program;
        }
    }

    private void addProgram(ArrayList<Program> list){
        list.add(new Program("Double Rinse", 240));
        list.add(new Program("Intense", 120));
        list.add(new Program("Quick", 60));
        list.add(new Program("Spin", 120));
    }

    public ArrayList<Program> getPrograms() {
        return new ArrayList<Program>(this.programs);
    }
}
