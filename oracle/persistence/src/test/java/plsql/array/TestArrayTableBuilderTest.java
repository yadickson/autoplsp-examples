package plsql.array;

import java.sql.Connection;
import java.sql.SQLException;

import plsql.object.TestObjectObject;
import plsql.object.TestObjectObjectBuilder;

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
public class TestArrayTableBuilderTest {

    @InjectMocks
    TestArrayTableBuilderImpl builder;

    @Mock
    private OracleArrayUtil arrayUtil;

    @Mock
    private Connection connection;

    @Mock
    private TestObjectObjectBuilder objectBuilder;

    @Captor
    private ArgumentCaptor<Object[]> captorObjects;

    @Test
    public void testTestArrayTableBuilderProcess() throws SQLException {

        TestArrayTable array = new TestArrayTable();

        TestObjectObject object = new TestObjectObject();

        array.add(object);

        Object obj = new Object();

        Mockito.when(objectBuilder.process(Mockito.same(connection), Mockito.same(object))).thenReturn(object);
        Mockito.when(arrayUtil.process(Mockito.same(connection), Mockito.eq("TEST_ARRAY"), captorObjects.capture())).thenReturn(obj);

        Object result = builder.process(connection, array);

        Assert.assertNotNull(result);
        Assert.assertSame(obj, result);

        Mockito.verify(objectBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(object));

        Object[] objParamsResult = captorObjects.getValue();

        Assert.assertNotNull(objParamsResult);
        Assert.assertEquals(1, objParamsResult.length);

        Assert.assertSame(object, objParamsResult[0]);
    }
}
