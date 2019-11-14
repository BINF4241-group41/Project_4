public abstract class HomeDevice {
    
    protected boolean on;

    public HomeDevice(){
        this.on = false;
    } 

    public void switchOn(){
        on = true;
    }
    public void switchOff(){
        on = false;
    }

}