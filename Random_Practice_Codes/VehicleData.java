public class VehicleData {
    public static void main(String[] args) {
        Car car = new Car();
        Bike bike = new Bike();
        car.move(10);
        bike.move(10);
    }
}

class Vehicle {
    public void move(int km){
        System.out.println("Vehicle Moved "+km+" kms.");
    }
}


class Bike extends Vehicle {

    @Override
    public void move(int km){
        System.out.println("Bike Moved "+km+" kms.");
    }
}

class Car extends  Vehicle {

    @Override
    public void move(int km){
        System.out.println("Car Moved "+km+" kms.");
    }
}