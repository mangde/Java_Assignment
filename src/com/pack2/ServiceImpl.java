package com.pack2;


public class ServiceImpl implements Services {

    private Daoservice daoserviceobj;


    public ServiceImpl(Daoservice ds) {

        this.daoserviceobj  = ds;
    }

    @Override
    public boolean addEmployee(Employee tempEmployee) {

        if (daoserviceobj.addEmployee(tempEmployee)) return true;

        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        if (daoserviceobj.deleteEmployee(id)) return true;

        return false;

    }

    @Override
    public boolean displayAllEmployee() {
        if (daoserviceobj.displayAllEmployee()) return true;

        return false;
    }

    @Override
    public boolean searchEmployee(String tempname) {

        if (daoserviceobj.searchEmployee(tempname)) return true;

        return false;


    }
}
