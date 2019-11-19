package General;


public interface ICommand {

    // name of command
    public String getName();

    // execute the encapsulated command
    public void execute();
}
