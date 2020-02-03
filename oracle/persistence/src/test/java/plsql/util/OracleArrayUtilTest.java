package plsql.util;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleConnection;
import oracle.sql.ARRAY;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OracleArrayUtilTest {

    @InjectMocks
    OracleArrayUtilImpl arrayUtil;

    @Mock
    private OracleConnection oracleConnection;

    @Mock
    private ARRAY array;

    @Mock
    private Connection connection;

    @Test
    public void testProcessArray() throws SQLException {
        Object[] objects = new Object[0];

        Mockito.when(connection.unwrap(Mockito.eq(OracleConnection.class))).thenReturn(oracleConnection);
        Mockito.when(oracleConnection.createARRAY(Mockito.eq("NAME"), Mockito.same(objects))).thenReturn(array);

        Object result = arrayUtil.process(connection, "NAME", objects);

        Assert.assertNotNull(result);
        Assert.assertSame(array, result);
    }

    @Test(expected = SQLException.class)
    public void testProcessArrayError() throws SQLException {
        Object[] objects = new Object[0];

        Mockito.when(connection.unwrap(Mockito.eq(OracleConnection.class))).thenReturn(oracleConnection);
        Mockito.when(oracleConnection.createARRAY(Mockito.eq("NAME"), Mockito.same(objects))).thenThrow(new RuntimeException());

        arrayUtil.process(connection, "NAME", objects);
    }
}
