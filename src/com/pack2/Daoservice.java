package com.pack2;

public interface Daoservice {
    boolean addEmployee(Employee e);

    boolean deleteEmployee(int id);

    boolean searchEmployee(String name);

    boolean displayAllEmployee();
}
