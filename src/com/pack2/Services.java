package com.pack2;

public interface Services {

    boolean addEmployee(Employee e);

    boolean deleteEmployee(int id);

    boolean displayAllEmployee();

    boolean searchEmployee(String name);
}
