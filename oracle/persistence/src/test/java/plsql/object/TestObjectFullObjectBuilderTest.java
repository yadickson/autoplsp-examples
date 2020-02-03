package plsql.object;

import java.sql.Connection;
import java.sql.SQLException;

import plsql.util.OracleBlobUtil;
import plsql.util.OracleClobUtil;
import plsql.util.OracleDateUtil;
import plsql.util.OracleObjectUtil;

import java.util.Date;

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
public class TestObjectFullObjectBuilderTest {

    @InjectMocks
    TestObjectFullObjectBuilderImpl builder;

    @Mock
    private OracleBlobUtil blobUtil;

    @Mock
    private OracleClobUtil clobUtil;

    @Mock
    private OracleDateUtil dateUtil;

    @Mock
    private OracleObjectUtil objectUtil;

    @Mock
    private Connection connection;

    @Captor
    private ArgumentCaptor<Object[]> captorObjects;

    @Test
    public void testTestObjectFullObjectBuilderProcess() throws SQLException {

        TestObjectFullObject object = new TestObjectFullObject();

        Number objId = 1;
        String objName = "NAME";
        String objStrClob = "STR_CLOB";
        byte[] objByteBlob = new byte[0];
        Date objFecha = new Date(5);

        object.setId(objId);
        object.setName(objName);
        object.setStrClob(objStrClob);
        object.setByteBlob(objByteBlob);
        object.setFecha(objFecha);

        Object[] obj = new Object[0];

        Mockito.when(clobUtil.process(Mockito.same(connection), Mockito.same(objStrClob))).thenReturn(objStrClob);
        Mockito.when(blobUtil.process(Mockito.same(connection), Mockito.same(objByteBlob))).thenReturn(objByteBlob);
        Mockito.when(dateUtil.process(Mockito.eq(objFecha))).thenReturn(objFecha);
        Mockito.when(objectUtil.process(Mockito.same(connection), Mockito.eq("TEST_OBJECT_FULL"), captorObjects.capture())).thenReturn(obj);

        Object result = builder.process(connection, object);

        Assert.assertNotNull(result);
        Assert.assertSame(obj, result);

        Object[] objParamsResult = captorObjects.getValue();

        Assert.assertNotNull(objParamsResult);
        Assert.assertEquals(5, objParamsResult.length);
        Assert.assertSame(objId, objParamsResult[0]);
        Assert.assertSame(objName, objParamsResult[1]);
        Assert.assertSame(objStrClob, objParamsResult[2]);
        Assert.assertSame(objByteBlob, objParamsResult[3]);
        Assert.assertEquals(objFecha, objParamsResult[4]);

        Mockito.verify(clobUtil, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(objStrClob));
        Mockito.verify(blobUtil, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(objByteBlob));
        Mockito.verify(dateUtil, Mockito.times(1)).process(Mockito.eq(objFecha));
    }
}
