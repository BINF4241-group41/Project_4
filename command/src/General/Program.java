package General;


public class Program {

    private String name;
    private int duration = 0;
    private int temperature = 0;


    // constructor for no set duration
    public Program(String name) {
        this.name = name;
    }

    public Program(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public Program(String name, int duration, int temperature) {
        this.name = name;
        this.duration = duration;
        this.temperature = temperature;
    }


    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getTemperature() {
        return temperature;
    }

    public static Program getNoProgram() {
        return new Program("NoProgram");
    }
}