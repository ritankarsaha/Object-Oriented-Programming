package Employee;
import java.sql.*;
import java.util.Scanner;

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}


class Person {
    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}

class Employee extends Person {
    private String department;
    private double salary;
    private static int employeeCount = 0;
    public static final double SALARY_BRACKET = 50000.0;

    public Employee(String id, String name, int age, String department, double salary) {
        super(id, name, age);
        this.department = department;
        this.salary = salary;
        employeeCount++;
    }

    public Employee(String id, String name, int age) {
        this(id, name, age, "General", SALARY_BRACKET);
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    public String displayEmployeeDetails() {
        return getName() + ", Age: " + getAge() + ", Department: " + getDepartment() + ", Salary: " + getSalary();
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }
}

class EMSDatabase {
    private Connection connection;

    public EMSDatabase() throws SQLException {
        try {
        
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS_DB?useSSL=false&serverTimezone=UTC", "root", "ritankar123@@");
        } catch (SQLException e) {
            throw new SQLException("Database connection failed", e);
        }
    }

    public void addEmployee(Employee emp) throws SQLException {
        String query = "INSERT INTO Employees (id, name, age, department, salary) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setInt(3, emp.getAge());
            stmt.setString(4, emp.getDepartment());
            stmt.setDouble(5, emp.getSalary());
            stmt.executeUpdate();
            System.out.println("Employee added: " + emp.displayEmployeeDetails());
        } catch (SQLException e) {
            throw new SQLException("Error adding employee", e);
        }
    }

    public void updateEmployeeSalary(String id, double newSalary) throws SQLException, EmployeeNotFoundException {
        String query = "UPDATE Employees SET salary = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, newSalary);
            stmt.setString(2, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
            }
            System.out.println("Employee's salary updated to " + newSalary);
        } catch (SQLException e) {
            throw new SQLException("Error updating employee salary", e);
        }
    }

    public void fetchEmployeeDetails(String id) throws SQLException, EmployeeNotFoundException {
        String query = "SELECT * FROM Employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");
                System.out.println("Fetched employee: " + name + ", Age: " + age + ", Department: " + department + ", Salary: " + salary);
            } else {
                throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching employee details", e);
        }
    }

    public void deleteEmployee(String id) throws SQLException, EmployeeNotFoundException {
        String query = "DELETE FROM Employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
            }
            System.out.println("Employee deleted: Record for ID " + id + " deleted");
        } catch (SQLException e) {
            throw new SQLException("Error deleting employee", e);
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

public class EmployeeLeaveManagementSystem1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            EMSDatabase db = new EMSDatabase();

            boolean exit = false;

            while (!exit) {
                System.out.println("\nEmployee Management System:");
                System.out.println("1. Add Employee");
                System.out.println("2. Update Employee Salary");
                System.out.println("3. Fetch Employee Details");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  

                switch (choice) {
                    case 1: 
                        System.out.print("Enter Employee ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Employee Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Employee Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();  
                        System.out.print("Enter Employee Department: ");
                        String department = scanner.nextLine();
                        System.out.print("Enter Employee Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine(); 
                        Employee emp = new Employee(id, name, age, department, salary);
                        db.addEmployee(emp);
                        break;

                    case 2: 
                        System.out.print("Enter Employee ID to update salary: ");
                        String updateId = scanner.nextLine();
                        System.out.print("Enter new salary: ");
                        double newSalary = scanner.nextDouble();
                        scanner.nextLine();  
                        db.updateEmployeeSalary(updateId, newSalary);
                        break;

                    case 3: 
                        System.out.print("Enter Employee ID to fetch details: ");
                        String fetchId = scanner.nextLine();
                        db.fetchEmployeeDetails(fetchId);
                        break;

                    case 4: 
                        System.out.print("Enter Employee ID to delete: ");
                        String deleteId = scanner.nextLine();
                        db.deleteEmployee(deleteId);
                        break;

                    case 5:
                        exit = true;
               
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

            db.closeConnection();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
