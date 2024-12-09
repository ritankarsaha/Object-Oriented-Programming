import java.sql.*;

// Custom exception for employee not found
class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

// Base class: Person
class Person {
    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}

// Derived class: Employee
class Employee extends Person {
    private String department;
    private double salary;
    private static int employeeCount = 0;
    public static final double SALARY_BRACKET = 50000.0;

    // Constructor with department and salary
    public Employee(String id, String name, int age, String department, double salary) {
        super(id, name, age);
        this.department = department;
        this.salary = salary;
        employeeCount++;
    }

    // Constructor without department (overloading)
    public Employee(String id, String name, int age) {
        this(id, name, age, "General", SALARY_BRACKET);
    }

    // Getters and Setters
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    // Overriding display method
    public String displayEmployeeDetails() {
        return getName() + ", Age: " + getAge() + ", Department: " + getDepartment() + ", Salary: " + getSalary();
    }

    // Static method to track employee count
    public static int getEmployeeCount() {
        return employeeCount;
    }
}

// EMS Database Operations
class EMSDatabase {
    private Connection connection;

    public EMSDatabase() throws SQLException {
        try {
            // MySQL JDBC connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS_DB?useSSL=false&serverTimezone=UTC", "root", "ritankar123@@");
        } catch (SQLException e) {
            throw new SQLException("Database connection failed", e);
        }
    }

    // Add new employee
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

    // Update employee salary
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

    // Fetch employee details
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

    // Delete employee
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

    // Close the connection
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

// Main class for testing the EMS
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        try {
            EMSDatabase db = new EMSDatabase();

            // Add employee
            Employee emp = new Employee("001", "Alice", 30, "HR", 60000);
            db.addEmployee(emp);

            // Update employee salary
            db.updateEmployeeSalary("001", 65000);

            // Fetch employee details
            db.fetchEmployeeDetails("001");

            // Delete employee record
            db.deleteEmployee("001");

            // Close the database connection
            db.closeConnection();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
