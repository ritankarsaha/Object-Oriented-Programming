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
    private static ArrayList <Vehicle> vechicles = new ArrayList<>();

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Add a new Vehcile");
            System.out.println("2. Display all vehicles");
            System.out.println("3. Display vehicle count");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();



            switch(choice){
                case 1:
                addNewVehicle(sc);
                break;
                case 2:
                displayAllVehicles();
                break;
                case 3:
                System.out.println("The total number of vehicles are: "+Vehicle.getVehicleCount());
                break;
                case 4:
                System.out.println("Exiting the program");
                break;
                default:
                System.out.println("Invalid choice");
            }

        }while(choice != 4);
      

        sc.close();



       

    }

    public static void addNewVehicle(Scanner sc){
        System.out.println("Enter the vehicle types:- ");
        System.out.println("1. Car");
        System.out.println("2. Truck");
        System.out.println("Enter your choice:");
        int choice1 = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter vechicle number");
        String vehicleNumber = sc.nextLine();
        System.out.println("Enter vehicle name");
        String vehicleName = sc.nextLine();
        System.err.println("Enter the year of manufacture");
        int YearofManufacture = sc.nextInt();
        Vehicle vehicle = null;
        switch(choice1){
            case 1:
            vehicle = new Car(vehicleNumber, vehicleName, YearofManufacture);
            break;
            case 2:
            vehicle = new Truck(vehicleNumber, vehicleName, YearofManufacture);
            default:
            System.out.println("Wrong choice inputted by the user!");
            break;
        }

        vechicles.add(vehicle);
        System.out.println("The vehicle has been added successfully by the user!! ");

    }

    public static void displayAllVehicles(){
        if (vechicles.isEmpty())
        System.out.println("No vehicle has been added to the list!");
        else{
            for( Vehicle vehicle: vechicles){
                vehicle.displayDetails();
                System.out.println();
                vehicle.calculateMileage();
                System.out.println();
            }
        }
    }
    
    
}


