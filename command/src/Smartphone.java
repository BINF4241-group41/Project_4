import General.*;

import CleaningRobot.*;
import Dishwasher.*;
import Microwave.*;
import Oven.*;
import WashingMachine.*;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;


public class Smartphone {

    private Hashtable<String, Device> devices = new Hashtable<>();
    private Hashtable<String, ICommand[]> commands = new Hashtable<>();


    public Smartphone() {

        CleaningRobot cleaningRobot = new CleaningRobot("CleaningRobot");
        Dishwasher dishwasher = new Dishwasher("Dishwasher");
        Microwave microwave = new Microwave("Microwave");
        Oven oven = new Oven("Oven");
        WashingMachine washingMachine = new WashingMachine("WashingMachine");

        this.devices.put(cleaningRobot.getName(), cleaningRobot);
        this.devices.put(dishwasher.getName(), dishwasher);
        this.devices.put(microwave.getName(), microwave);
        this.devices.put(oven.getName(), oven);
        this.devices.put(washingMachine.getName(), washingMachine);

        this.commands.put(cleaningRobot.getName(), new ICommand[] {
                new CStart(cleaningRobot),
                new CStop(cleaningRobot),
                new CSetTimer(cleaningRobot),
                new CCheckBatteryStatusCR(cleaningRobot),
                new CCheckCleaningPercentageCR(cleaningRobot),
                new CCompleteCleaningCR(cleaningRobot)
        });

        this.commands.put(dishwasher.getName(), new ICommand[] {
                new CSwitchOn(dishwasher),
                new CSwitchOff(dishwasher),
                new CStart(dishwasher),
                new CStop(dishwasher),
                new CCheckTimer(dishwasher),
                new CSelectProgram(dishwasher)
        });

        this.commands.put(microwave.getName(), new ICommand[] {
                new CSwitchOn(microwave),
                new CSwitchOff(microwave),
                new CStart(microwave),
                new CStop(microwave),
                new CSetTimer(microwave),
                new CCheckTimer(microwave),
                new CSetTemperature(microwave)
        });

        this.commands.put(oven.getName(), new ICommand[] {
                new CSwitchOn(oven),
                new CSwitchOff(oven),
                new CStart(oven),
                new CStop(oven),
                new CSetTimer(oven),
                new CCheckTimer(oven),
                new CSetTemperature(oven),
                new CSelectProgram(oven)
        });

        this.commands.put(washingMachine.getName(), new ICommand[] {
                new CSwitchOn(washingMachine),
                new CSwitchOff(washingMachine),
                new CStart(washingMachine),
                new CStop(washingMachine),
                new CSelectProgram(washingMachine),
                new CSelectTemperatureWM(washingMachine)
        });
    }


    public void startCLI() {

        String input = "";
        Scanner inputScanner = new Scanner(System.in);

        while (true) {

            String devicesString = "Available devices (choose the device by typing in its name): \n";

            Enumeration deviceNames = this.devices.keys();
            while (deviceNames.hasMoreElements()) {
                devicesString += " - " + deviceNames.nextElement() + "\n";
            }

            System.out.println(devicesString);
            System.out.println("Type exit to exit the program.");

            input = inputScanner.next();

            if (input.equals("exit")) {
                return;
            }

            deviceNames = this.devices.keys();
            while (deviceNames.hasMoreElements()) {
                String deviceName = deviceNames.nextElement().toString();
                if (deviceName.equals(input)) {
                    deviceCLI(deviceName);
                    continue;
                }
            }
            System.out.println("Device not found.");
        }
    }


    private void deviceCLI(String deviceKey) {

        String input = "";
        Scanner inputScanner = new Scanner(System.in);

        if (!this.devices.containsKey(deviceKey) || !this.commands.containsKey(deviceKey)) {
            return;
        }

        Device currentDevice = devices.get(deviceKey);
        ICommand[] currentCommands = this.commands.get(deviceKey);


        while (true) {

            System.out.println(currentDevice.toString());

            String commandsString = "Functions available for device " + currentDevice.getName() + ":\n";

            for (ICommand command : currentCommands) {
                commandsString += " - " + command.getName() + "\n";
            }

            System.out.println(commandsString);
            System.out.println("Type exit to go back to the overview.");

            input = inputScanner.next();

            if (input.equals("exit")) {
                return;
            }

            for (ICommand nextCommand : currentCommands) {
                if (nextCommand.getName().equals(input)) {
                    nextCommand.execute();
                    System.out.println("Executed function " + nextCommand.getName());
                    continue;
                }
            }
        }
    }
}
