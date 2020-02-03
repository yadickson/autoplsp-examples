package plsql.array;

import java.sql.Connection;
import java.sql.SQLException;

import plsql.util.OracleArrayUtil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings({"rawtypes", "unchecked"})
public class CharArrayTableBuilderTest {

    @InjectMocks
    CharArrayTableBuilderImpl builder;

    @Mock
    private OracleArrayUtil arrayUtil;

    @Mock
    private Connection connection;

    @Captor
    private ArgumentCaptor<Object[]> captorObjects;

    @Test
    public void testCharArrayTableBuilderProcess() throws SQLException {

        CharArrayTable array = new CharArrayTable();

        String object = "String";

        array.add(object);

        Object obj = new Object();

        Mockito.when(arrayUtil.process(Mockito.same(connection), Mockito.eq("CHAR_ARRAY"), captorObjects.capture())).thenReturn(obj);

        Object result = builder.process(connection, array);

        Assert.assertNotNull(result);
        Assert.assertSame(obj, result);


        Object[] objParamsResult = captorObjects.getValue();

        Assert.assertNotNull(objParamsResult);
        Assert.assertEquals(1, objParamsResult.length);

        Assert.assertSame(object, objParamsResult[0]);
    }
}
