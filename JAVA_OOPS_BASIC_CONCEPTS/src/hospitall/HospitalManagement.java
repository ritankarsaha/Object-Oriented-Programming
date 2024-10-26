package hospitall;
import java.util.*;
 class HospitalManagement {
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Patient> patients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Register Doctors");
            System.out.println("2. Book Appointment");
            System.out.println("3. Book Appointment");
            System.out.println("4. Update Doctor Availability");
            System.out.println("5. View All Doctors");
            System.out.println("6. Add Patients");
            System.out.println("7. View All Patients");
            System.out.println("8. View Appointment Details");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                	bookAppointment();
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                	viewDoctors();
                    break;
                case 6:
                	addPatient();
                    break;
                case 7:
                	viewPatients();
                case 8:
                	viewAppointmentDetails();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addDoctor() {
        System.out.print("Enter doctor's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter doctor's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter doctor's specialization: ");
        String specialization = scanner.nextLine();
        System.out.println("Enter his consultation fees");
        int consultationfees = scanner.nextInt();
        Doctor doctor = new Doctor(name, age, specialization, consultationfees);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }
    


    private static void addPatient() {
        System.out.print("Enter patient's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient's age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter patient's illness: ");
        String illness = scanner.nextLine();
        System.out.println("Enter visiting fees:- ");
        int visitfees = scanner.nextInt();
        Patient patient = new Patient(name, age, illness,visitfees);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }
    
    private static void bookAppointment() {
    	String doc = scanner.nextLine();
    	String pat = scanner.nextLine();
    	int c=0;
    	for(Doctor doc1:doctors) {
    		if(doc1.getName().equals(doc))
    			c++;
    	}
    	for(Patient pat1:patients) {
    		if(pat1.getName().equals(pat))
    			c++;
    	}
    	if(c>1) {
    		String appointment = scanner.nextLine();
    		System.out.println("Appointment book at " + appointment);
    	}
    }
    
    

    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            System.out.println("\nList of Doctors:");
            for (Doctor doctor : doctors) {
                doctor.displayInfo();
            }
        }
    }
    
    private static void viewAppointmentDetails() {
    	String name = scanner.nextLine();
    	for(Patient patient:patients) {
    		if(patient.getName().equals(name)) {
    			patient.displayInfo();
    		}
    	}
    }

   

    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            System.out.println("\nList of Patients:");
            for (Patient patient : patients) {
                patient.displayInfo();
            }
        }
    }
}