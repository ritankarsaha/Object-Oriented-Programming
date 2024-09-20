import java.util.*;
public class VehicleManagementProper {

    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
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
                    System.out.println("Total number of vehicles: " + vehicles.size());
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


    public static void addNewVehicle(Scanner sc){
        System.out.println("Choose Vehicle Type:- ");
        System.out.println("1. Car");
        System.out.println("2. Truck");
        System.out.println("Enter your choices:- ");
        int typeChoice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Vehicle Number:- ");
        String VehicleNumber = sc.nextLine();
        System.err.println("Enter the model no. of the vehicle");
        String Model = sc.nextLine();
        System.out.println("Enter the year of manufacture:- ");
        int year = sc.nextInt();

        Vehicle vehicle = null;
        switch (typeChoice) {
            case 1:
                vehicle = new Car(VehicleNumber,Model,year); 
                break;
            case 2:
                vehicle = new Truck(VehicleNumber, Model, year);
            default:
                System.out.println("Enter  a valid choice!! ");
                break;
        }

        vehicles.add(vehicle);
        System.out.println("Vehicle has been added successfully! ");

    }
    
    public static void displayAllVehicles(){
        if(vehicles.isEmpty())
        {
            System.out.println("No vehicle has been added till now! ");
        }
        else{
            for(Vehicle a:vehicles){
                a.display();
                System.out.println();
            }
        }
    }
}


abstract class Vehicle{
    protected String VehicleNumber;
    protected String Model;
    protected int ManufacturignDate;
    protected static int vehicleCount = 0;

    public Vehicle(String VehicleNumber, String Model, int ManufacturignDate){
        this.VehicleNumber = VehicleNumber;
        this.Model=Model;
        this.ManufacturignDate=ManufacturignDate;
        vehicleCount++;
    }

    public abstract double calculateMileage();

    public void display(){
        System.out.println(this.VehicleNumber);
        System.out.println(this.Model);
        System.out.println(this.ManufacturignDate);
    }
}

class Car extends Vehicle{
    public Car(String VechicleNumber, String Model, int ManufacturignDate){
        super(VechicleNumber, Model, ManufacturignDate);
    }

    // public Car(String VechicleNumber, String Model){
    //     super(VechicleNumber, Model, 2021);
    // }

    @Override
    public double calculateMileage(){
        return 12.6;

    }

    @Override
    public void display(){
        super.display();
        System.out.println(calculateMileage());
        System.out.println("This was for the car");
    }

}

class Truck extends Vehicle{
    public Truck(String VechicleNumber, String Model, int ManufacturignDate){
        super(VechicleNumber, Model, ManufacturignDate);
    }

    // public Truck(String VechicleNumber, String Model){
    //     super(VechicleNumber, Model, 2022);
    // }

    @Override
    public double calculateMileage(){
        return 12.9;

    }

    @Override
    public void display(){
        super.display();
        System.out.println(calculateMileage());
        System.out.println("This was for the truck");
    }

}