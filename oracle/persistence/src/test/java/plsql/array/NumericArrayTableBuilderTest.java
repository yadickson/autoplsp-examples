package plsql.array;

import java.sql.Connection;
import java.sql.SQLException;

import plsql.util.ArrayUtil;

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
public class NumericArrayTableBuilderTest {

    @InjectMocks
    NumericArrayTableBuilderImpl builder;

    @Mock
    private ArrayUtil arrayUtil;

    @Mock
    private Connection connection;

    @Captor
    private ArgumentCaptor<Object[]> captorObjects;

    @Test
    public void testNumericArrayTableBuilderProcess() throws SQLException {

        NumericArrayTable array = new NumericArrayTable();

        Number object = 0;

        array.add(object);

        Object obj = new Object();

        Mockito.when(arrayUtil.process(Mockito.same(connection), Mockito.eq("NUMERIC_ARRAY"), captorObjects.capture())).thenReturn(obj);

        Object result = builder.process(connection, array);

        Assert.assertNotNull(result);
        Assert.assertSame(obj, result);


        Object[] objParamsResult = captorObjects.getValue();

        Assert.assertNotNull(objParamsResult);
        Assert.assertEquals(1, objParamsResult.length);

        Assert.assertSame(object, objParamsResult[0]);
    }
}
