package CleaningRobot;


import General.Timer;

public class CleaningRobot extends General.Device implements General.ITimerSet, General.IStartStoppable {

    private final int MAX_BATTERY_CAPACITY = 2000;
    private float batteryCharge = MAX_BATTERY_CAPACITY;
    private float batteryChargeSpeed = 200; // capacity charged/second
    private float batteryDischargeSpeed = 200; // capacity discharged/second
    private boolean inChargingStation = true;
    private int cleaningDuration = 0; // time it takes to clean in ms
    private General.Timer timer; // time remaining to finish cleaning
    private Thread thread; // runs clean/run Runnables

    private int timeSpentCleaning = 0; // timer gets reset after each charging -> needs memory


    private Runnable chargeBattery = () -> {
        this.inChargingStation = true;

        try {
            while (this.batteryCharge < MAX_BATTERY_CAPACITY) {
                Thread.sleep(100);
                if (batteryCharge < (MAX_BATTERY_CAPACITY - batteryChargeSpeed/10)) {
                    this.batteryCharge += batteryChargeSpeed/10;
                }
                else {
                    Thread.sleep(Math.round((MAX_BATTERY_CAPACITY - batteryCharge) / batteryChargeSpeed));
                    this.batteryCharge = MAX_BATTERY_CAPACITY;
                }
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
                // timer gets stopped at beginning, reinitialized with remaining time after cleaning restart
                else {
                    Thread.sleep(Math.round(batteryCharge/batteryDischargeSpeed));
                    this.timeSpentCleaning += (this.timer.getTime() - this.timer.getRemainingTime());
                    timerThread = null;
                    this.timer = null;
                    this.batteryCharge = 0;
                    chargeBattery.run();
                    this.inChargingStation = false;
                    this.timer = new Timer(this.cleaningDuration - this.timeSpentCleaning);
                    timerThread = new Thread(this.timer);
                    timerThread.start();
                }
            }
            // finished cleaning
            this.inChargingStation = true;
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    };


    public CleaningRobot(String deviceName) {
        this.name = deviceName;
    }

    public void setTimer(int durationInSeconds) {
        this.timer = new General.Timer(durationInSeconds*1000);
        this.cleaningDuration = durationInSeconds*1000;
    }

    public float checkBatteryStatus() {
        return this.batteryCharge / this.MAX_BATTERY_CAPACITY;
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
        this.timeSpentCleaning = 0;
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
        if (cleaningDuration == 0 || this.thread == null) {
            return 0;
        }
        else {
            int cleaningTime = this.timeSpentCleaning;
            if (this.timer != null) {
                cleaningTime += (this.timer.getTime() - this.timer.getRemainingTime());
            }
            return ((float)cleaningTime / (float)this.cleaningDuration);
        }
    }
}
