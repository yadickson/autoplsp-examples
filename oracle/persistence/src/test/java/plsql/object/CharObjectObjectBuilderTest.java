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
public class CharObjectObjectBuilderTest {

    @InjectMocks
    CharObjectObjectBuilderImpl builder;

    @Mock
    private ObjectUtil objectUtil;

    @Mock
    private Connection connection;

    @Captor
    private ArgumentCaptor<Object[]> captorObjects;

    @Test
    public void testCharObjectObjectBuilderProcess() throws SQLException {

        CharObjectObject object = new CharObjectObject();

        String objC1 = "C1";
        String objC2 = "C2";
        String objC3 = "C3";
        String objC4 = "C4";
        String objC5 = "C5";

        object.setC1(objC1);
        object.setC2(objC2);
        object.setC3(objC3);
        object.setC4(objC4);
        object.setC5(objC5);

        Object[] obj = new Object[0];

        Mockito.when(objectUtil.process(Mockito.same(connection), Mockito.eq("CHAR_OBJECT"), captorObjects.capture())).thenReturn(obj);

        Object result = builder.process(connection, object);

        Assert.assertNotNull(result);
        Assert.assertSame(obj, result);

        Object[] objParamsResult = captorObjects.getValue();

        Assert.assertNotNull(objParamsResult);
        Assert.assertEquals(5, objParamsResult.length);
        Assert.assertSame(objC1, objParamsResult[0]);
        Assert.assertSame(objC2, objParamsResult[1]);
        Assert.assertSame(objC3, objParamsResult[2]);
        Assert.assertSame(objC4, objParamsResult[3]);
        Assert.assertSame(objC5, objParamsResult[4]);
    }
}
