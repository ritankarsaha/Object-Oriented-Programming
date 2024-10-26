package TravelBooking;

import java.util.*;

public class Travel {

    private static ArrayList<booking> booking = new ArrayList<booking>();
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Book a Flight");
            System.out.println("2. Book a Hotel");
            System.out.println("3. Rent a Car");
            System.out.println("4. Display All Bookings:- ");
            System.out.println("5. Apply Discount");
            System.out.println("6. View Booking Summary");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addNewVehicle(sc);
                    break;
                case 2:
                	addNewVehicle(sc);
                    break;
                case 3:
                	addNewVehicle(sc);
                    break;
                case 4:
                	displayAllBookings();
                	break;
                case 5:
                	ApplyDiscount(sc);
                    break;
                case 6:
                	BookingSummary(sc);
                	break;
                case 7:
                	System.out.println("Exiting the system!! ");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
 } while (choice != 7);

        sc.close();

    }
    public static void ApplyDiscount(Scanner sc) {
    	System.out.println("Enter the registration number of the vehicle");
    	String id = sc.nextLine();
    	double amt =0;
    	for(booking book:booking) {
    		if(book.bookingid.equals(id)) {
    			amt = book.BookingPrice()-(15*100)/book.BookingPrice();
    		}
    	}
    	System.out.println("The discounted price is:"+amt);
    }
    
    public static void BookingSummary(Scanner sc) {
    	System.out.println("Enter the registration number of the vehicle");
    	String id1 = sc.nextLine();
    	for(booking book:booking) {
    		if(book.bookingid.equals(id1)) {
    			book.displayDetails();
    		}
    	}
    }
    public static void addNewVehicle(Scanner sc) {
        System.out.println("\nChoose Renting Type:");
        System.out.println("1. Flight");
        System.out.println("2. Hotel");
        System.out.println("3. Car");
        System.out.print("Enter your choice: ");
        int typeChoice = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Your booking id:-  ");
        String bookingid = sc.nextLine();
        System.out.print("Enter your registration number:- ");
        String reg = sc.nextLine();
        booking book = null;
        switch (typeChoice) {
            case 1:
                book = new Car(bookingid,reg);
                break;
            case 2:
                book = new Flight(bookingid,reg);
                break;
            case 3:
                book = new Hotel(bookingid,reg);
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        booking.add(book);
        System.out.println("Your booking has been added successfully!");
        
    }
    public static void displayAllBookings() {
        if (booking.isEmpty()) {
            System.out.println("No vehicles added yet.");
        } else {
            for (booking vehicle : booking) {
                vehicle.displayDetails();
                System.out.println();
            }
        }
    }
    
    
    
}