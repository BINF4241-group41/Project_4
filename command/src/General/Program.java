package General;


public class Program{

    private final String name;
    private final int duration;

    public Program(String name, int duration){
        this.name = name;
        this.duration = duration;
    }

    public String getName(){
        return name;
    }

    public int getDuration(){
        return duration;
    }

    public static Program getNoProgram() {
        return new Program("NoProgram", 0);
    }
}