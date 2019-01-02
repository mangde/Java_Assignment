package com.pack2;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class DaoServicedbImpl implements Daoservice {

    private Connection conn = null;
    boolean flag = false;


    public DaoServicedbImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //here employee_yo is database name, root is a username and password
            conn = getConnection("jdbc:mysql://localhost:3306/employee_yo", "root", "root");
            System.out.println("connection establish");
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

    }


    @Override
    public boolean addEmployee(Employee employee) {
        int managerid = getManagerID(employee);
        int deptid = getDepartmentId(employee);

        try {
            String sql = "INSERT INTO employee_details (first_Name,last_Name,department_id,manager_id,Salary) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, employee.getFname());
            statement.setString(2, employee.getLname());
            statement.setInt(3, deptid);
            statement.setInt(4, managerid);

            statement.setDouble(5, employee.getSalary());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Employee was inserted successfully!");
                flag = true;
            }

        } catch (SQLException e1) {
            System.out.println(e1);
        }

        return flag;

    }


    @Override
    public boolean deleteEmployee(int id) {

        String sql = "DELETE FROM employee_details WHERE employee_id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A employee was deleted successfully!");
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean searchEmployee(String name) {

        try {
            String sql = "SELECT * FROM employee_details WHERE first_name='" + name + "'";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result!=null) {
                System.out.println("Record found");
                System.out.println("id FName LName Dept_ID Manager_Id Salary ");
                while (result.next()) {
                    System.out.println(result.getInt(1) + "   " + result.getString(2) + "  \t " +
                            result.getString(3) + "  \t" + result.getInt(4) + " \t" +
                            result.getInt(5) + "  \t" + result.getDouble(6));
                    flag = true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public boolean displayAllEmployee() {
        int count = 0;

        try {
            Statement statement = conn.createStatement();

            String sql = "SELECT * FROM employee_details";

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("employee_id");
                String fname = result.getString("first_name");
                String lname = result.getString("last_name");
                String deptid = result.getString(4);
                String manager = result.getString(5);
                double salary = result.getDouble("Salary");
                System.out.println(salary);
                String output = "Employee #%d: %s - %s - %s - %s - %s";
                System.out.println(String.format(output, ++count, id, fname, lname, deptid, manager, salary));
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public int getDepartmentId(Employee employee) {
        int deptid = 0;
        String deptname = employee.getDepartment();
        Statement statement = null;
        ResultSet rs = null;


        try {
            String sqldept = "SELECT department_id FROM department_details WHERE department_name='" + deptname + "'";

            statement = conn.createStatement();
            rs = statement.executeQuery(sqldept);
            if (rs.next()) {
                deptid = rs.getInt(1);
            } else {
                try {

                    String query1 = "INSERT INTO department_details(department_name) VALUES(?)";
                    PreparedStatement pstmt = conn.prepareStatement(query1);
                    pstmt.setString(1, employee.getDepartment());
                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        rs = statement.executeQuery(sqldept);
                        if (rs.next()) deptid = rs.getInt(1);
                        System.out.println("A new department was inserted successfully!");
                    }

                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return deptid;
    }

    public int getManagerID(Employee employee) {
        int mid = 0;
        String sqlmgr = null;
        Statement stmt = null;
        ResultSet mgrid = null;
        String mangername = employee.getManagername();

        try {
            sqlmgr = "SELECT manager_id FROM manager_details WHERE manager_name='" + mangername + "'";
            stmt = conn.createStatement();
            mgrid = stmt.executeQuery(sqlmgr);
            if (mgrid.next()) {
                mid = mgrid.getInt(1);
            } else {
                try {
                    String query2 = "INSERT INTO manager_details(manager_name) VALUES(?)";
                    PreparedStatement pstmt2 = conn.prepareStatement(query2);
                    pstmt2.setString(1, employee.getManagername());
                    int rowsInserted = pstmt2.executeUpdate();
                    if (rowsInserted > 0) {
                        mgrid = stmt.executeQuery(sqlmgr);
                        if (mgrid.next()) {
                            mid = mgrid.getInt(1);
                        }
                        System.out.println("A new manager was inserted successfully!");
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return mid;
    }
}