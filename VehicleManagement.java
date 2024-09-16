import java.util.*;

abstract class Vehicle{
    protected String VehicleNumber;
    protected String VehicleName;
    protected int YearofManufacture;
    protected static int VehicleCount =0;


    public Vehicle(String VehicleNumber, String VehicleName, int YearofManufacture){
        this.VehicleNumber = VehicleNumber;
        this.VehicleName = VehicleName;
        this.YearofManufacture = YearofManufacture;
        VehicleCount++;
    }

    public abstract double calculateMileage();

    public void displayDetails(){
        System.out.println("Vehicle Number: "+VehicleNumber);
        System.out.println("Vehicle Name: "+VehicleName);
        System.out.println("Vehicle Year of Manufacture: "+YearofManufacture);

    }

    public static int getVehicleCount(){
        return VehicleCount;
    }
}


class Car extends Vehicle{
    public Car(String VehicleNumber, String VehicleName, int YearofManufacture){
        super(VehicleNumber, VehicleName, YearofManufacture);
    }
    public Car(String VehicleNumber, String VehicleName){
        super(VehicleNumber,VehicleName, 2021);
    }

    @Override
    public double calculateMileage(){
        return 21.0;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("The calculated mileage is:"+calculateMileage());
    }
}

class Truck extends Vehicle{
    public Truck(String VehicleNumber, String VehicleName, int YearofManufacture){
        super(VehicleNumber, VehicleName, YearofManufacture);
    }
    public Truck(String VehicleNumber, String VehicleName){
        super(VehicleNumber,VehicleName, 2022);
    }

    @Override
    public double calculateMileage(){
        return 80.0;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("The calcualted mileage is: -"+ calculateMileage());
    }
}








public class VehicleManagement {
    
}


