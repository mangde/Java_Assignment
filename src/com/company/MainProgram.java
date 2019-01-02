package com.company;

import java.util.*;


public class MainProgram {

    static Scanner sd = new Scanner(System.in);

    static ArrayList<Employee> list = new ArrayList<Employee>();

    static {
        list.add(new Employee(1001, "yogesh", "mangde", "sales", "Kadam", 25845.50));
        list.add(new Employee(1002, "Harshad", "patel", "Testing", "Roy", 41585.54));
        list.add(new Employee(1003, "suraj", "kapse", "devOps", "Huddi", 41585.54));

    }


    public static void main(String[] args) {

        String choice;
        // statements and prompts within the console for the user to follow
        do {
            System.out.println("Please enter your choice below from the following options");
            System.out.println("View all  employees => 1 ");
            System.out.println("Delete an employee => 2 ");
            System.out.println("Add an employee => 3");
            System.out.println("Search employee=> 4");
            System.out.println("To exit the system = 0 ");

            int tempvar = sd.nextInt();


            // runs the userChoice method of Otherdetailclass
            userChoice(tempvar);
            System.out.println("Do u want to bre continue..Y/N");
            choice = sd.next();
        } while (choice != "y");
    }


    // method to determine what statement runs according to which choice user makes
    public static void userChoice(int tempvar) {
        int tempeid;

        Employee tempEmployee = new Employee();
        boolean foundEmployee = false;

        // if user enters 1 it prints out the employee list.
        if (tempvar == 1) {
            printEmployeelist();

        }
        //if user enter 2 delete employee record
        else if (tempvar == 2) {
            printEmployeelist();
            System.out.println("");
            System.out.println("Above are a list of all employees.");
            System.out.println("Please enter the Employee id of the employee you wish to delete");
            tempeid = sd.nextInt();

            // while loop to search on EmpId, deletes the employee if correct, error message if not
            if (list.isEmpty() == false) {
                int a = 0;
                while (a < list.size()) {
                    tempEmployee = list.get(a);
                    if (tempEmployee.getEmpId() == tempeid) {
                        foundEmployee = true;
                        break;
                    }
                    a++;
                }
                if (foundEmployee == true) {
                    System.out.println("You have deleted : " + tempEmployee.getEmpId());
                    System.out.println();
                    list.remove(tempEmployee);
                    printEmployeelist();
                } else {
                    System.out.println("The Employee Id you have entered is incorrect");
                }
            }
        }
//if user enter 3 => allows the user to add an employee to the employee list
        else if (tempvar == 3) {
            String fname1;
            String lname2;
            String manager3;
            String department4;
            double salary5;
            int id;

            System.out.println("You have chosen to add an employee to the system");
            System.out.println();

            System.out.println("Please enter the EmpId of the new employee: ");
            id = sd.nextInt();
            tempEmployee.setEmpId(id);

            // tempEmployee.setEmpId(EmpId + 1); // sets Employee id to next in sequence


            System.out.println("Please enter the FirstName of the new employee: ");
            fname1 = sd.next();
            tempEmployee.setFname(fname1);

            System.out.println("Please enter the LastName of the new employee: ");
            lname2 = sd.next();
            tempEmployee.setLname(lname2);

            System.out.println("Please enter Department name");
            department4 = sd.next();
            tempEmployee.setDepartment(department4);


            System.out.println("Please enter your Manager name");
            manager3 = sd.next();
            tempEmployee.setManagername(manager3);

            System.out.println("Please enter the Salary of the new employee: ");
            salary5 = sd.nextDouble();
            tempEmployee.setSalary(salary5);

            list.add(tempEmployee);// creates temp employee and adds to list
            System.out.println("Employee added successfully");
            printEmployeelist();
        } else if (tempvar == 4) {
            System.out.println("Please enter the Employee FirstName for search");
            String tempname = sd.next();

            if (list.isEmpty() == false) {
                int a = 0;
                while (a < list.size()) {
                    tempEmployee = list.get(a);
                    if (tempEmployee.getFname().equals(tempname)) {
                        foundEmployee = true;
                        break;
                    }
                    a++;
                }
            }
            if (foundEmployee == true) {
                System.out.println("Found Employee Details");
                System.out.println("Employee Id :" + tempEmployee.getEmpId());
                System.out.println("Employee FName : " + tempEmployee.getFname());
                System.out.println("Employee LName : " + tempEmployee.getLname());
                System.out.println("Employee ManagerName : " + tempEmployee.getManagername());
                System.out.println("Employee department : " + tempEmployee.getDepartment());
                System.out.println("Employee Salary : " + tempEmployee.getSalary());

            } else {
                System.out.println("Employee record Name Not found");
            }
        } else if (tempvar == 0) // if user enter 0 it allows them to exit the programme

        {
            System.out.println("You have exited the system");
            System.exit(0);
        } else // if any other choice entered they will be met with this message
        {
            System.out.println("You have entered the wrong choice");
        }
    }

    // method to print list using a for loop
    public static void printEmployeelist() {
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }


}