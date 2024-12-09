
abstract class Appliance {
    public abstract void turnOn();
}


class WashingMachine extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Washing Machine is now ON. Starting the wash cycle.");
    }
}

class Refrigerator extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Refrigerator is now ON. Cooling system is activated.");
    }
}


public class Wash {
    public static void main(String[] args) {
 
        Appliance washingMachine = new WashingMachine();
        Appliance refrigerator = new Refrigerator();
        washingMachine.turnOn();
        refrigerator.turnOn();
    }
}