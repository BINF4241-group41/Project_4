package Dishwasher;

import java.util.ArrayList;

public class Dishwasher implements General.ITimerCheck, General.IOnOffSwitchable {

    private boolean on;
    private ArrayList<Program> programs;
    private boolean running;
    private General.Timer timer=null;
    private Program runnigProgram=null;

    public Dishwasher(){
        this.runningProgram=new Program("noProgram",0);
        this.programs= new ArrayList<Program>();
        addProgram(programs);
        this.running=false;
        on=false;

    }
    public String getProgram(){
        return runningProgram.getName();
    }

    private void setTimer(float time){
        this.timer= new General.Timer(time*1000);
    }
    public int checkTimer() {
        if (timer!=null) {
           return timer;
        }
        return 0;
    }
    public String display(){
        String output="";
        for (Program pr : programs){
            output=pr.getName()+"\n"+output;
        }
        return output;
    }
    public void StartWash(){
        if(this.on && timer!=null){
            Thread t = new Thread(timer);
            running=true;
            t.start();
        }
    }

    public void switchOn() {
        this.on = true;
    }
    public void stopWash(){
        if(running){
            running=false;
            timer=null;
        }
    }

    public void switchOff() {
        this.on = false;
    }
    private void addProgram(ArrayList<Program> list){
        list.add(new Program("mixed",400));
        list.add(new Program("pans",300));
        list.add(new Program("glasses",200));
        list.add(new Program("plates",100));
    }

    public boolean chooseProgram(String p){
        for(Program pr : programs){

            if(pr.getName().equals(p)){
                runningProgram=pr;
                setTimer(pr.getMin());
                return true;
            }
        }
        return false;
    }
}
