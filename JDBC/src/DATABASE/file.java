package DATABASE;

import java.io.*;
import java.util.Scanner;

public class file {
    private static final String FILE_NAME = "employee_records.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nEmployee Record Management System:");
            System.out.println("1. Create File");
            System.out.println("2. Get File Information");
            System.out.println("3. Write Employee Details to File");
            System.out.println("4. Read Employee Records from File");
            System.out.println("5. Delete File");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> createFile();
                case 2 -> getFileInfo();
                case 3 -> writeEmployeeDetails();
                case 4 -> readEmployeeRecords();
                case 5 -> deleteFile();
                case 6 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 6);
    }

    private static void createFile() {
        File file = new File(FILE_NAME);
        try {
            if (file.createNewFile()) {
                System.out.println("File " + FILE_NAME + " created successfully!");
            } else {
                System.out.println("File " + FILE_NAME + " already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    private static void getFileInfo() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("Is Readable: " + (file.canRead() ? "Yes" : "No"));
            System.out.println("Is Writable: " + (file.canWrite() ? "Yes" : "No"));
        } else {
            System.out.println("File " + FILE_NAME + " not found.");
        }
    }

    private static void writeEmployeeDetails() {
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        String record = "Employee Name: " + name + ", ID: " + id + ", Department: " + department;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(record);
            writer.newLine();
            System.out.println("Employee details written to " + FILE_NAME + ".");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readEmployeeRecords() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            System.out.println("Employee Records:");
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading from file: " + e.getMessage());
            }
        } else {
            System.out.println("File " + FILE_NAME + " not found.");
        }
    }

    private static void deleteFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File " + FILE_NAME + " deleted successfully!");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File " + FILE_NAME + " not found.");
        }
    }
}

