package General;


public interface ICommand {

    // can be executed for the device in current state
    public boolean isAvailable();

    // name of command
    public String getName();

    // execute the encapsulated command
    public void execute();
}
