import java.sql.*;
import java.util.Scanner;

public class EmployeeManagementSystem {
    static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    static final String USER = "root"; 
    static final String PASSWORD = "kirandhole@8855"; 

    static Connection conn;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            while (true) {
                System.out.println("\nEmployee Management System");
                System.out.println("1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Search Employee by ID");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        updateEmployee();
                        break;
                    case 4:
                        deleteEmployee();
                        break;
                    case 5:
                        searchEmployee();
                        break;
                    case 6:
                        conn.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addEmployee() throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter department: ");
        String dept = scanner.next();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        String sql = "INSERT INTO employee (name, age, department, salary) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, dept);
        ps.setDouble(4, salary);
        ps.executeUpdate();
        System.out.println("Employee added successfully.");
    }

    static void viewEmployees() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

        System.out.printf("%-5s %-20s %-5s %-15s %-10s%n", "ID", "Name", "Age", "Department", "Salary");
        while (rs.next()) {
            System.out.printf("%-5d %-20s %-5d %-15s %-10.2f%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("department"),
                    rs.getDouble("salary"));
        }
    }

    static void updateEmployee() throws SQLException {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();

        String query = "SELECT * FROM employee WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.print("Enter new name (" + rs.getString("name") + "): ");
            String name = scanner.next();
            System.out.print("Enter new age (" + rs.getInt("age") + "): ");
            int age = scanner.nextInt();
            System.out.print("Enter new department (" + rs.getString("department") + "): ");
            String dept = scanner.next();
            System.out.print("Enter new salary (" + rs.getDouble("salary") + "): ");
            double salary = scanner.nextDouble();

            String updateSQL = "UPDATE employee SET name = ?, age = ?, department = ?, salary = ? WHERE id = ?";
            PreparedStatement updatePS = conn.prepareStatement(updateSQL);
            updatePS.setString(1, name);
            updatePS.setInt(2, age);
            updatePS.setString(3, dept);
            updatePS.setDouble(4, salary);
            updatePS.setInt(5, id);
            updatePS.executeUpdate();
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    static void deleteEmployee() throws SQLException {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM employee WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int affectedRows = ps.executeUpdate();
        if (affectedRows > 0)
            System.out.println("Employee deleted successfully.");
        else
            System.out.println("Employee not found.");
    }

    static void searchEmployee() throws SQLException {
        System.out.print("Enter employee ID to search: ");
        int id = scanner.nextInt();

        String sql = "SELECT * FROM employee WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Employee Details:");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Department: " + rs.getString("department"));
            System.out.println("Salary: " + rs.getDouble("salary"));
        } else {
            System.out.println("Employee not found.");
        }
    }
}