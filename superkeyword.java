
public class superkeyword {
    public static void main(String args[]){
        Bike bike = new Bike(2000);
        Car car = new Car(200);
        System.out.println("The price of the bike is: "+bike.price);
        System.out.println("The price of the car is:"+car.price);
    }
}


class VehicleData{
    int price;
    VehicleData(int j){
        price = j;
    }
}

class Bike extends VehicleData{
    public Bike(int j){
        super(j);
        
    }
}

class Car extends VehicleData{
    public Car(int j){
        super(j);
    }
}

