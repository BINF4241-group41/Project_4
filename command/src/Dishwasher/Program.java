package Dishwasher;

public class Program{
    private String name;
    private float min;

    public Program(String name, float min){
        this.name=name;
        this.min=min;
    }

    public String getName(){
        return name;
    }
    public float getMin(){
        return min;
    }
}