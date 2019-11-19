package WashingMachine;


import java.util.Scanner;

public class CSelectTemperatureWM implements General.ICommand {

    WashingMachine washingMachine;

    public CSelectTemperatureWM(WashingMachine wm) {
        this.washingMachine = wm;
    }

    public String getName() {
        return "SelectTemperatureWM";
    }

    public void execute() {
        System.out.println("Please select the degrees (type in abort to abort): 40, 60, 90");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int nextInt = scanner.nextInt();
                if (nextInt == 40 || nextInt == 60 || nextInt == 90) {
                    washingMachine.setTemperature(nextInt);
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
}
