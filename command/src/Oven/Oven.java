package Oven;

import java.util.ArrayList;


public class Oven extends command.HomeDevice implements ITimerCheck, command.ITimerSet {

    
    private boolean running;
    private float temperature;
    private ArrayList<String> programs;
    private String actualProgram;
    private command.Timer timer=null;
    private static final String DEFAULT_PROGRAM="noProgram";

    public Oven(){
        super();
        this.actualProgram=defaultProgram;
        this.temperature=0;
        this.programs=new ArrayList<String>();
        addProgram(progrms);
        this.running=false;    
    }

    public void setTimer(int time){
        this.timer=new command.Timer(time*1000);
    }
    public void setTemperature(float temperature){
        this.temperature=temperature;
    }

    public void startCooking(){
        if(this.on && (temperature>0) && (!actualProgram.equals(DEFAULT_PROGRAM)) && timer!=null){
            Thread t = new Thread(timer);
            t.start();
        }
    }
    public int checkTimer(){
        if(running && timer!=null)return timer;
        //i don't understand the otherwise part on the paper
    }
    public void interruptProgram(){
        if(running){
            running=false;
            timer=null;
        }
    }
    private void addProgram(ArrayList<String> list){
        list.add("ventilated");
        list.add("grill");
    }

    public boolean setUpProgram(String program){
        if (programs.contains(program)){
            actualProgram=program;
            return true;
        }else{
            return false;
        }
    } 
    //add_by_me
    //maybe we can use an interface
    public String display(){

        String output="";
        output+= (running) ? "oven is running ": "oven isn't running ";
        output+="the temperature is "+temperature;
        output+=" the program is "+actualProgram;
        output+=" timer:"+timer;

        return output;
    }
    //--------------
    public String showProgram(){
        String s="";
        for (String r : programs){
            s=s+r+"\n";
        }
        return s;
    }

    public String currentProgram(){
        return actualProgram;
    }
    
}   