package com.pack2;

public class Employee {
    private int EmpId;
    private String Fname;
    private String Lname;
    private String Department;
    private String Managername;
    private double Salary;


    public Employee(int eid, String fname, String lname, String department, String managername, Double salary) {
        this.EmpId = eid;
        this.Fname = fname;
        this.Lname = lname;
        this.Department = department;
        this.Managername = managername;
        this.Salary = salary;

    }

    public Employee() {
    }

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int empId) {
        EmpId = empId;
    }


    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getManagername() {
        return Managername;
    }

    public void setManagername(String managername) {
        Managername = managername;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        if (fname == null)
            throw new IllegalArgumentException("Employee FName can't be null");
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        if (lname == null)
            throw new IllegalArgumentException("Employee LName can't be null");
        Lname = lname;
    }

    //when printing employee list method it sets the input to display as below
    public String toString() {
        return
                "EmpID: " + this.EmpId + " " + "FirstName: " + this.Fname + "  " + "LastName: " + this.Lname + "  "

                        + "Department: " + this.Department + "  " + "ManagerName: " + this.Managername + "  "
                        + "Salary: " + this.Salary;
    }

}
