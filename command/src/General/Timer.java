package General;

public class Timer implements Runnable{

    private boolean running;
    private int totalTime;
    private int remainingTime;

    public Timer(int time) {
        this.running = false;
        this.totalTime = time;
        this.remainingTime = time;
    }

    public boolean isRunning(){
        return running;
    }

    public int getTime() {
        return totalTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    @Override
    public void run() {
        try {
            running = true;
            // update remaining time every 100ms
            while (remainingTime >= 100) {
                Thread.sleep(100);
                this.remainingTime -= 100;
            }
            Thread.sleep(remainingTime);
            this.remainingTime = 0;
            running = false;
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}