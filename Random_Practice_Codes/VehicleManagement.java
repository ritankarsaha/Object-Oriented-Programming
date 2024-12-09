
import java.util.*;

abstract class Vehicle{
    protected String VechicleNumber;
    protected String Model;
    protected int YearOfManufacture;
    protected static int VehicleCount = 0;


    public Vehicle(String VechicleNumber, String Model, int YearOfManufacture){
        this.VechicleNumber = VechicleNumber;
        this.Model = Model;
        this.YearOfManufacture = YearOfManufacture;
        VehicleCount++;
    }

    public abstract double calculateMileage();

    public void displayDetails(){
        System.out.println("Vehicle Number: " + VechicleNumber);
        System.out.println("Model: " + Model);
        System.out.println("Year of Manufacture: " + YearOfManufacture);
    }

    public static int getTotalVehicleCount(){
        return VehicleCount;
    }

}


class Car extends Vehicle{
    public Car(String VechicleNumber, String Model, int YearOfManufacture){
        super(VechicleNumber, Model, YearOfManufacture);
    }
    public Car(String VechicleNumber, String Model){
        super(VechicleNumber, Model, 2020);
    }

    @Override
    public double calculateMileage(){
        return 15.0;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Mileage: " + calculateMileage() + " km/l");
    }
}

class Truck extends Vehicle{
    public Truck(String VechicleNumber, String Model, int YearOfManufacture){
        super(VechicleNumber, Model, YearOfManufacture);
    }
    public Truck(String VechicleNumber, String Model){
        super(VechicleNumber, Model, 2020);
    }

    @Override
    public double calculateMileage(){
        return 10.0;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Mileage: " + calculateMileage() + " km/l");
    }
}

class Motorcycle extends Vehicle{
    public Motorcycle(String VechicleNumber, String Model, int YearOfManufacture){
        super(VechicleNumber, Model, YearOfManufacture);
    }
    public Motorcycle(String VechicleNumber, String Model){
        super(VechicleNumber, Model, 2020);
    }

    @Override
    public double calculateMileage(){
        return 20.0;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Mileage: " + calculateMileage() + " km/l");
    }
}



public class VehicleManagement {

    private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add a new vehicle");
            System.out.println("2. Display all vehicles");
            System.out.println("3. Display total number of vehicles");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addNewVehicle(sc);
                    break;
                case 2:
                    displayAllVehicles();
                    break;
                case 3:
                    System.out.println("Total number of vehicles: " + Vehicle.getTotalVehicleCount());
                    break;
                case 4:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
 } while (choice != 4);

        sc.close();

    }

    public static void addNewVehicle(Scanner sc) {
        System.out.println("\nChoose vehicle type:");
        System.out.println("1. Car");
        System.out.println("2. Truck");
        System.out.println("3. Motorcycle");
        System.out.print("Enter your choice: ");
        int typeChoice = sc.nextInt();

        sc.nextLine(); 
        System.out.print("Enter vehicle number: ");
        String vehicleNumber = sc.nextLine();
        System.out.print("Enter model: ");
        String model = sc.nextLine();
        System.out.print("Enter year of manufacture: ");
        int year = sc.nextInt();

        Vehicle vehicle = null;
        switch (typeChoice) {
            case 1:
                vehicle = new Car(vehicleNumber, model, year);
                break;
            case 2:
                vehicle = new Truck(vehicleNumber, model, year);
                break;
            case 3:
                vehicle = new Motorcycle(vehicleNumber, model, year);
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully!");
    }
    public static void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles added yet.");
        } else {
            for (Vehicle vehicle : vehicles) {
                vehicle.displayDetails();
                System.out.println();
            }xxx
        }
    }
    
}

