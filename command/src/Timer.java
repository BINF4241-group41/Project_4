public class Timer implements Runnable{

    private boolean running;
    private int time;

    public Timer(int time){
        this.time=time;
        this.running=false;
    }

    public boolean isRunning(){
        return running;
    }

    @Override
    public void run(){
        try{
            running=true;
            Thread.sleep(time);
            running=false;
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}