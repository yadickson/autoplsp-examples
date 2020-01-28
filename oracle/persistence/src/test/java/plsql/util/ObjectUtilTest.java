package plsql.util;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleConnection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ObjectUtilTest {

    @InjectMocks
    ObjectUtilImpl objectUtil;

    @Mock
    private OracleConnection oracleConnection;

    @Mock
    private Connection connection;

    @Test(expected = SQLException.class)
    public void testProcessObjectError() throws SQLException {
        Object[] objects = new Object[0];

        Mockito.when(connection.unwrap(Mockito.eq(OracleConnection.class))).thenReturn(oracleConnection);

        objectUtil.process(connection, "NAME", objects);
    }
}
