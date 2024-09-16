

abstract class Appliance{
    public abstract void turnOn();
}

class Toaster extends Appliance{
    @Override
    public void turnOn(){
        System.out.println("Toaster has been turned on!");
    }
}

class Kettle extends Appliance{
    @Override
    public void turnOn(){
        System.out.println("Kettle has been turned on!");
    }
}

public class override {
    public static void main(String args[]){
        Appliance Toaster = new Toaster();
        Appliance Kettle = new Kettle();
        Toaster.turnOn();
        Kettle.turnOn();
    }
}