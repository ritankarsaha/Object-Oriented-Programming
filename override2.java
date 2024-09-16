public class override2 {

    public static void main(String args[]){
    Truck truck = new Truck();
    Bus bus = new Bus();
    truck.move(10);
    bus.move(20);

    
}
}
class Vehicle{
    public void move(int km){
        System.out.println("Vehicle has moved "+km+" km");
    }
}

class Truck extends Vehicle{
    public void move(int km){
        System.out.println("Truck has moved "+km+" km");
    }
}
class Bus extends Vehicle{
    public void move(int km){
        System.out.println("Bus has moved "+km+" km");
    }
}