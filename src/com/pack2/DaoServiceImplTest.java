package com.pack2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class DaoServiceImplTest {

    @Mock
    Set<Employee> set;

    private Daoservice daoserviceobj;

    Employee employee;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        employee = new Employee(3, "yogesh", "mangde", "dv", "mm", 234.3);


        daoserviceobj = new DaoServiceImpl(set);
    }


    @Test
    public void testAddEmployee() {
        when(set.add(any())).thenReturn(true);

        boolean result = daoserviceobj.addEmployee(employee);
        assertEquals(true, result);
        boolean result1 = daoserviceobj.addEmployee(employee);
        assertEquals(true, result1);


    }

    @Test
    public void testDisplayAllEmployee() {
        Iterator<Employee> e = new Iterator<Employee>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Employee next() {
                return null;
            }
        };

        when(set.iterator()).thenReturn(e);

        boolean result = daoserviceobj.displayAllEmployee();
        assertTrue("this will success if true", result);
    }


    @Test
    public void testSearchEmployee() {
        Iterator<Employee> e = new Iterator<Employee>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Employee next() {
                return null;
            }
        };

        when(set.iterator()).thenReturn(e);

        boolean result = daoserviceobj.searchEmployee("yogesh");
        assertEquals(false, result);

    }

    @Test
    public void testDeleteEmployee() {
        Iterator<Employee> e = new Iterator<Employee>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Employee next() {
                return null;
            }
        };

        when(set.iterator()).thenReturn(e);
        when(set.remove(anyInt())).thenReturn(true);

        Boolean result = daoserviceobj.deleteEmployee(5);
        assertEquals(false, result);

    }
}
