package com.pack2;

import java.util.Scanner;


public class MainProgram {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String choice;
        // Daoservice daoserviceobj = new DaoServiceImpl(new HashSet<Employee>());
        Daoservice daoserviceobj = new DaoServicedbImpl();

        Services serviceobj = new ServiceImpl(daoserviceobj);


        Employee tempEmployee = new Employee();


        do {
            System.out.println("Please enter your choice below from the following options");
            System.out.println("View all  employees => 1 ");
            System.out.println("Add an employee => 2");
            System.out.println("Delete an employee => 3");
            System.out.println("Search employee=> 4");
            System.out.println("To exit the system = 0 ");

            int tempvar = scanner.nextInt();

            switch (tempvar) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    if (!serviceobj.displayAllEmployee()) {
                        System.out.println("Empty Records...");
                    }
                    break;


                case 2:
                    try {
                        System.out.println("You have chosen to add an employee to the system");
                       /* System.out.println("Please enter the EmpId of the new employee: ");
                        int id = scanner.nextInt();
                        tempEmployee.setEmpId(id);*/

                        System.out.println("Please enter the FirstName of the new employee: ");
                        String fname = scanner.next();
                        tempEmployee.setFname(fname);

                        System.out.println("Please enter the LastName of the new employee: ");
                        String lname = scanner.next();
                        tempEmployee.setLname(lname);

                        System.out.println("Please enter Department name");
                        String department = scanner.next();
                        tempEmployee.setDepartment(department);


                        System.out.println("Please enter your Manager name");
                        String manager = scanner.next();
                        tempEmployee.setManagername(manager);

                        System.out.println("Please enter the Salary of the new employee: ");
                        double salary = scanner.nextDouble();
                        tempEmployee.setSalary(salary);

                        if (serviceobj.addEmployee(tempEmployee)) {
                            System.out.println("Employee added successfully");

                        } else {
                            System.out.println("Employee Record Not add");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;

                case 3:
                    if (serviceobj.displayAllEmployee()) {
                        System.out.println("Please enter the Employee id of the employee you wish to delete");
                        int tempeid = scanner.nextInt();
                        if (serviceobj.deleteEmployee(tempeid))
                            System.out.println("You have deleted : " + tempeid);
                        else
                            System.out.println("The Employee Id you have entered is incorrect");
                    } else {
                        System.out.println("No records found for delete Empty ");
                    }
                    break;


                case 4:
                    System.out.println("Please enter the Employee FirstName for search");
                    String tempname = scanner.next();
                    if (!serviceobj.searchEmployee(tempname)) {
                        System.out.println("Employee record Name Not found");
                    }
                    break;

                default:
                    System.out.println("Invalid input please input correct Number");
            }


            System.out.println("Do u want to be continue press ...Y else press 0 for exit");
            choice = scanner.next();
        } while (choice != "y");


    }

}