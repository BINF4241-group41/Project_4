package CleaningRobot;


public class CleaningRobot implements General.ITimerSet, General.IStartStoppable {

    private final int MAX_BATTERY_CAPACITY = 2000;
    private float batteryCharge = MAX_BATTERY_CAPACITY;
    private float batteryChargeSpeed = 100; // capacity charged/second
    private float batteryDischargeSpeed = 20; // capacity discharged/second
    private boolean inChargingStation = true;
    private int cleaningDuration = 0; // time it takes to clean
    private General.Timer timer; // time remaining to finish cleaning
    private Thread thread;


    private Runnable chargeBattery = () -> {
        this.inChargingStation = true;

        try {
            while (this.batteryCharge < MAX_BATTERY_CAPACITY) {
                Thread.sleep(100);
                if (batteryCharge < MAX_BATTERY_CAPACITY - batteryChargeSpeed/10) {
                    this.batteryCharge += batteryChargeSpeed/10;
                }
                Thread.sleep(Math.round((MAX_BATTERY_CAPACITY - batteryCharge)/batteryChargeSpeed));
                this.batteryCharge = MAX_BATTERY_CAPACITY;
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    private Runnable clean = () -> {
        try {
            Thread timerThread = new Thread(this.timer);
            timerThread.start();

            // still stuff to clean
            while (this.timer.getTime() > 0) {
                // clean for 0.1s, then update
                if (this.batteryCharge > this.batteryDischargeSpeed/10) {
                    Thread.sleep(100);
                    this.batteryCharge -= this.batteryDischargeSpeed/10;
                }
                // go back to charging station, recharge, restart cleaning
                else {
                    Thread.sleep(Math.round(batteryCharge/batteryDischargeSpeed));
                    this.timer.wait();
                    this.batteryCharge = 0;
                    chargeBattery.run();
                    this.inChargingStation = false;
                    timer.notifyAll();
                }
            }
            // finished cleaning
            timerThread = null;
            this.inChargingStation = true;
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public void setTimer(int durationInSeconds) {
        this.timer = new General.Timer(durationInSeconds*1000);
        this.cleaningDuration = durationInSeconds;
    }

    public float checkBatteryStatus() {
        return this.batteryCharge;
    }

    // start vacuum cleaner
    public void start() {
        if (this.inChargingStation && this.batteryCharge == this.MAX_BATTERY_CAPACITY && this.timer != null && !this.timer.isRunning()) {
            this.thread = new Thread(clean);
            this.thread.start();
        }
    }

    // end cleaning, reset state
    public void stop() {
        this.thread = null;
        this.timer = null;
        this.cleaningDuration = 0;
        this.inChargingStation = true;
        this.thread = new Thread(chargeBattery);
        this.thread.start();
    }

    // if not already cleaning, start default program
    public void completeCleaning() {
        // cleaning in progress
        if (this.thread != null) {
            return;
        }

        setTimer(240); // default time
        this.inChargingStation = true;

        this.thread = new Thread(() -> {
            chargeBattery.run();
            clean.run();
        });
        this.thread.start();
    }

    public float getCleaningProgress() {
        if (cleaningDuration == 0 || this.timer == null) {
            return 1;
        }
        else {
            return (this.cleaningDuration - this.timer.getTime()) / this.cleaningDuration;
        }
    }
}
