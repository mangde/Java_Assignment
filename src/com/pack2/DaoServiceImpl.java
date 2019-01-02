package com.pack2;

import java.util.Iterator;
import java.util.Set;


public class DaoServiceImpl implements Daoservice {

    private Set<Employee> set;

    public DaoServiceImpl(Set<Employee> set) {
        this.set = set;

    }

    @Override
    public boolean displayAllEmployee() {
        if (set.isEmpty()) {
            return false;
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Employee element = (Employee) iterator.next();
            System.out.println(element);

        }
        return true;

    }


    @Override
    public boolean addEmployee(Employee e) {
        boolean r = set.add(e);
        return r;

    }

    @Override
    public boolean deleteEmployee(int id) {

        for (Employee tempEmployee : set) {
            if (id == tempEmployee.getEmpId()) {
                set.remove(tempEmployee);
                return true;
            }
        }


        return false;

    }


    @Override
    public boolean searchEmployee(String name) {
        if (!set.isEmpty()) {
            for (Employee tempEmployee : set) {
                if (name.equalsIgnoreCase(tempEmployee.getFname())) {
                    return true;

                }
            }
        }
        return false;

    }
}
