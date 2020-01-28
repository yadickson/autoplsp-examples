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
public class TestObjectObjectBuilderTest {

    @InjectMocks
    TestObjectObjectBuilderImpl builder;

    @Mock
    private ObjectUtil objectUtil;

    @Mock
    private Connection connection;

    @Captor
    private ArgumentCaptor<Object[]> captorObjects;

    @Test
    public void testTestObjectObjectBuilderProcess() throws SQLException {

        TestObjectObject object = new TestObjectObject();

        Number objId = 1;
        String objName = "NAME";

        object.setId(objId);
        object.setName(objName);

        Object[] obj = new Object[0];

        Mockito.when(objectUtil.process(Mockito.same(connection), Mockito.eq("TEST_OBJECT"), captorObjects.capture())).thenReturn(obj);

        Object result = builder.process(connection, object);

        Assert.assertNotNull(result);
        Assert.assertSame(obj, result);

        Object[] objParamsResult = captorObjects.getValue();

        Assert.assertNotNull(objParamsResult);
        Assert.assertEquals(2, objParamsResult.length);
        Assert.assertSame(objId, objParamsResult[0]);
        Assert.assertSame(objName, objParamsResult[1]);
    }
}
