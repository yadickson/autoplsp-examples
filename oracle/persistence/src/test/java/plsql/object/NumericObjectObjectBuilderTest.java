package plsql.object;

import java.sql.Connection;
import java.sql.SQLException;

import plsql.util.ObjectUtil;

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
public class NumericObjectObjectBuilderTest {

    @InjectMocks
    NumericObjectObjectBuilderImpl builder;

    @Mock
    private ObjectUtil objectUtil;

    @Mock
    private Connection connection;

    @Captor
    private ArgumentCaptor<Object[]> captorObjects;

    @Test
    public void testNumericObjectObjectBuilderProcess() throws SQLException {

        NumericObjectObject object = new NumericObjectObject();

        Number objC1 = 1;
        Number objC2 = 2;
        Number objC3 = 3;
        Number objC4 = 4;
        Number objC5 = 5;
        Number objC6 = 6;
        Number objC7 = 7;
        Number objC9 = 8;
        Number objC10 = 9;
        Number objC11 = 10;

        object.setC1(objC1);
        object.setC2(objC2);
        object.setC3(objC3);
        object.setC4(objC4);
        object.setC5(objC5);
        object.setC6(objC6);
        object.setC7(objC7);
        object.setC9(objC9);
        object.setC10(objC10);
        object.setC11(objC11);

        Object[] obj = new Object[0];

        Mockito.when(objectUtil.process(Mockito.same(connection), Mockito.eq("NUMERIC_OBJECT"), captorObjects.capture())).thenReturn(obj);

        Object result = builder.process(connection, object);

        Assert.assertNotNull(result);
        Assert.assertSame(obj, result);

        Object[] objParamsResult = captorObjects.getValue();

        Assert.assertNotNull(objParamsResult);
        Assert.assertEquals(10, objParamsResult.length);
        Assert.assertSame(objC1, objParamsResult[0]);
        Assert.assertSame(objC2, objParamsResult[1]);
        Assert.assertSame(objC3, objParamsResult[2]);
        Assert.assertSame(objC4, objParamsResult[3]);
        Assert.assertSame(objC5, objParamsResult[4]);
        Assert.assertSame(objC6, objParamsResult[5]);
        Assert.assertSame(objC7, objParamsResult[6]);
        Assert.assertSame(objC9, objParamsResult[7]);
        Assert.assertSame(objC10, objParamsResult[8]);
        Assert.assertSame(objC11, objParamsResult[9]);
    }
}
