package General;

import java.util.Scanner;


public class CSelectProgram implements General.ICommand {

    private IProgramSelectable programSelectable;

    public CSelectProgram(IProgramSelectable programSelectable) {
        this.programSelectable = programSelectable;
    }

    public String getName() {
        return "SelectProgram";
    }

    public void execute() {

        System.out.println("Please enter the name of the program you want (enter exit to exit).\n");
        System.out.println("Available programs: ");
        for (Program program : this.programSelectable.getPrograms()) {
            System.out.println("- " + program.getName());
        }

        Scanner scanner = new Scanner(System.in);

        Program selectedProgram = Program.getNoProgram();

        while (scanner.hasNext()) {
            String programString = scanner.next();
            for (Program program: this.programSelectable.getPrograms()) {
                if (program.getName().equals(programString)) {
                    selectedProgram = program;
                    this.programSelectable.setProgram(selectedProgram);
                    return;
                }
            }
            if (programString.equals("exit")) {
                return;
            }
            System.out.println("Program not found.");
        }
    }
}
