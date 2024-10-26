package DATABASE;

import java.sql.*;
import java.util.Scanner;

public class Employee {
	
    private static final String URL = "jdbc:mysql://localhost:3306/Employees?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "ritankar123@@";
    
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
        	
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Employee Leave Management System");
            System.out.println("The connection with the database has been set up.");
            System.out.println("Please enter your choices below:- ");
            while (true) {
                System.out.println("\n1. Request Leave");
                System.out.println("2. Update Leave Request");
                System.out.println("3. Delete Leave Request");
                System.out.println("4. View All Leave Requests");
                System.out.println("5. Approve/Reject Leave Request");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        requestLeave(conn, scanner);
                        break;
                    case 2:
                        updateLeaveRequest(conn, scanner);
                        break;
                    case 3:
                        deleteLeaveRequest(conn, scanner);
                        break;
                    case 4:
                        viewAllLeaveRequests(conn);
                        break;
                    case 5:
                        approveOrRejectLeave(conn, scanner);
                        break;
                    case 6:
                    	conn.close();
                    	System.out.println("The connection has been closed succesfully!!!!");
                    	System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void requestLeave(Connection conn, Scanner scanner) {
    	  try {
              System.out.print("Enter Employee ID: ");
              int employeeId = scanner.nextInt();
              scanner.nextLine(); 
              System.out.print("Enter Start Date (YYYY-MM-DD): ");
              String startDate = scanner.nextLine();
              System.out.print("Enter End Date (YYYY-MM-DD): ");
              String endDate = scanner.nextLine();
              System.out.print("Enter Reason: ");
              String reason = scanner.nextLine();
              String checkQuery = "SELECT * FROM leave_requests WHERE employee_id = ? AND leave_start_date <= ? AND leave_end_date >= ?";
              try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                  checkStmt.setInt(1, employeeId);
                  checkStmt.setString(2, endDate);
                  checkStmt.setString(3, startDate);
                  ResultSet rs = checkStmt.executeQuery();
                  if (rs.next()) {
                      System.out.println("Leave request overlaps with an existing request.");
                      return;
                  }
              }

              String sql = "INSERT INTO leave_requests (employee_id, leave_start_date, leave_end_date, leave_reason) VALUES (?, ?, ?, ?)";
              try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                  pstmt.setInt(1, employeeId);
                  pstmt.setString(2, startDate);
                  pstmt.setString(3, endDate);
                  pstmt.setString(4, reason);
                  pstmt.executeUpdate();
                  System.out.println("Leave request successfully submitted with status: Pending.");
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
    }
    
    private static void updateLeaveRequest(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter Leave ID: ");
            int leaveId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter New End Date (YYYY-MM-DD): ");
            String newEndDate = scanner.nextLine();
            System.out.print("Enter New Reason: ");
            String newReason = scanner.nextLine();
            String sql = "UPDATE leave_requests SET leave_end_date = ?, leave_reason = ? WHERE leave_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, newEndDate);
                pstmt.setString(2, newReason);
                pstmt.setInt(3, leaveId);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Leave request updated successfully.");
                } else {
                    System.out.println("Leave request not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    private static void deleteLeaveRequest(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter Leave ID: ");
            int leaveId = scanner.nextInt();

            String sql = "DELETE FROM leave_requests WHERE leave_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, leaveId);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Leave request deleted successfully.");
                } else {
                    System.out.println("Leave request not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    

    private static void viewAllLeaveRequests(Connection conn) {
        String sql = "SELECT lr.leave_id, e.emp_name, e.emp_department, lr.leave_start_date, lr.leave_end_date, lr.leave_reason, lr.leave_status " +
                     "FROM leave_requests lr JOIN employees e ON lr.employee_id = e.employee_id";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Leave ID | Employee Name | Department | Start Date | End Date | Reason | Status");
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %s | %s | %s | %s%n",
                                  rs.getInt("leave_id"),
                                  rs.getString("emp_name"),
                                  rs.getString("emp_department"),
                                  rs.getDate("leave_start_date"),
                                  rs.getDate("leave_end_date"),
                                  rs.getString("leave_reason"),
                                  rs.getString("leave_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    private static void approveOrRejectLeave(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter Leave ID: ");
            int leaveId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter New Status (Approved/Rejected): ");
            String newStatus = scanner.nextLine();

            String sql = "UPDATE leave_requests SET leave_status = '" + newStatus + "' WHERE leave_id = " + leaveId;
            try (Statement stmt = conn.createStatement()) {
                int rowsAffected = stmt.executeUpdate(sql);
                if (rowsAffected > 0) {
                    System.out.println("Leave request #" + leaveId + " has been " + newStatus.toLowerCase() + ".");
                } else {
                    System.out.println("Leave request not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    

}
