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

        System.out.println("Please enter the name of the program you want.\n");
        System.out.println("Available programs: " + this.programSelectable.getPrograms());
        Scanner scanner = new Scanner(System.in);

        Program selectedProgram = Program.getNoProgram();

        while (scanner.hasNext()) {
            String programString = scanner.next();
            for (Program program: this.programSelectable.getPrograms()) {
                if (programString.equals(program.getName())) {
                    selectedProgram = program;
                }
            }
        }

        scanner.close();
        this.programSelectable.setProgram(selectedProgram);
    }
}
