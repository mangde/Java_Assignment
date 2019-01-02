package com.pack2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class DaoServicedbImplTest  extends  DaoServicedbImpl{
    @Mock
    PreparedStatement pstmt;

    @Mock
    Statement stmt;

    private Daoservice daoserviceobj;

    Employee employee;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        employee= new Employee(1,"y","l","ac","pk",52.00);
        daoserviceobj = new DaoServicedbImpl();
    }

    @Test
    public void testAddEmployee() {
        try {
            when(pstmt.executeUpdate(any())).then(InvocationOnMock::getArguments);

            boolean result=daoserviceobj.addEmployee(employee);
            assertEquals(true, result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteEmployee() {
        try {
            when(pstmt.executeUpdate(any())).then(InvocationOnMock::getArguments);

            boolean result=daoserviceobj.deleteEmployee(anyInt());
            assertEquals(false, result);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSearchEmployee() {
        try {
            when(pstmt.executeUpdate(any())).then(InvocationOnMock::getArguments);

            boolean result=daoserviceobj.searchEmployee("raj");
            assertEquals(true, result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDisplayAllEmployee() {
        try {
            when(stmt.executeQuery(any())).then(InvocationOnMock::getMock);
            boolean result=daoserviceobj.displayAllEmployee();
            assertTrue(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}