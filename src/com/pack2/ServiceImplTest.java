
package com.pack2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ServiceImplTest {

    Employee employee;

    Services serviceobj;

    @Mock
    private Daoservice daoserviceobj;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        employee = new Employee(3, "yogesh", "jadhav", "dv", "mm", 234.3);
        serviceobj = new ServiceImpl(daoserviceobj);
    }

    @Test
    public void testAddEmployee() {
        when(daoserviceobj.addEmployee(any())).thenReturn(true);

        boolean result = serviceobj.addEmployee(employee);
        assertEquals(true, result);


    }

    @Test
    public void testDeleteEmployee() {

        when(daoserviceobj.deleteEmployee(anyInt())).thenReturn(true);

        Boolean result = serviceobj.deleteEmployee(anyInt());
        assertEquals(true, result);


    }


    @Test
    public void testDisplayAllEmployee() {
        when(daoserviceobj.displayAllEmployee()).thenReturn(true);
        Boolean result = serviceobj.displayAllEmployee();
        assertEquals(true, result);


    }


    @Test
    public void testSearchEmployee() {
        when(daoserviceobj.searchEmployee(anyString())).thenReturn(true);

        Boolean result = serviceobj.searchEmployee(anyString());
        assertEquals(true, result);
    }
}
