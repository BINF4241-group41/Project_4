import General.*;

import CleaningRobot.*;
import Dishwasher.*;
import Microwave.*;
import Oven.*;
import WashingMachine.*;

import java.util.ArrayList;


public class Smartphone {

    private CleaningRobot cleaningRobot;
    private Dishwasher dishwasher;
    private Microwave microwave;
    private Oven oven;
    private WashingMachine washingMachine;

    private ICommand[] cleaningRobotCommands;
    private ICommand[] dishwasherCommands;
    private ICommand[] microwaveCommands;
    private ICommand[] ovenCommands;
    private ICommand[] washingMachineCommands;


    public Smartphone() {

        this.cleaningRobot = new CleaningRobot("CleaningRobot");
        this.dishwasher = new Dishwasher("Dishwasher");
        this.microwave = new Microwave("Microwave");
        this.oven = new Oven("Oven");
        this.washingMachine = new WashingMachine("WashingMachine");

        this.cleaningRobotCommands = new ICommand[] {
                new CStart(this.cleaningRobot),
                new CStop(this.cleaningRobot),
                new CSetTimer(this.cleaningRobot),
                new CCheckBatteryStatusCR(this.cleaningRobot),
                new CCheckCleaningPercentageCR(this.cleaningRobot),
                new CCompleteCleaningCR(this.cleaningRobot)
        };

        this.dishwasherCommands = new ICommand[] {
                new CSwitchOn(this.dishwasher),
                new CSwitchOff(this.dishwasher),
                new CStart(this.dishwasher),
                new CStop(this.dishwasher),
                new CCheckTimer(this.dishwasher),
                new CSelectProgram(this.dishwasher)
        };

        this.microwaveCommands = new ICommand[] {
                new CSwitchOn(this.microwave),
                new CSwitchOff(this.microwave),
                new CStart(this.microwave),
                new CStop(this.microwave),
                new CSetTimer(this.microwave),
                new CSetTemperatureMicrowave(this.microwave)
        };

        this.ovenCommands = new ICommand[] {
                new CSwitchOn(this.oven),
                new CSwitchOff(this.oven),
                new CStart(this.oven),
                new CStop(this.oven),
                new CSetTimer(this.oven),
                new CSetTemperatureOven(this.oven),
                new CSetUpProgramOven(this.oven);
        };

        this.washingMachineCommands = new ICommand[] {
                new CSwitchOn(this.washingMachine),
                new CSwitchOff(this.washingMachine),
                new CStart(this.washingMachine),
                new CStop(this.washingMachine),
                new CSelectProgram(this.washingMachine),
                new CSetTemperature(this.washingMachine)
        };
    }
    
    public String[] getDevices() {
        return new String[] {
            this.cleaningRobot.getName(),
                this.dishwasher.getName(),
                this.microwave.getName(),
                this.oven.getName(),
                this.washingMachine.getName()
        };
    }
}
