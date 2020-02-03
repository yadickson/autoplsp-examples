package plsql.repository;

import java.sql.Connection;

import plsql.domain.SpTestInsertObjectIN;
import plsql.domain.SpTestInsertObjectOUT;
import plsql.repository.sp.SpTestInsertObjectSP;
import plsql.object.TestObjectObject;
import plsql.object.TestObjectObjectBuilder;
import plsql.util.OracleCheckResult;
import plsql.util.OracleConnectionUtil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings({"unchecked"})
public class SpTestInsertObjectDAOTest {

    @InjectMocks
    SpTestInsertObjectDAOImpl repository;

    @Mock
    private OracleCheckResult checkResult;

    @Mock
    private Connection connection;

    @Mock
    private OracleConnectionUtil connectionUtil;

    @Mock
    private TestObjectObjectBuilder testObjectObjectBuilder;

    @Mock(name = "SpTestInsertObjectSP")
    private SpTestInsertObjectSP procedure;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testSpTestInsertObjectDAOExecute() throws java.sql.SQLException {

        SpTestInsertObjectIN params = new SpTestInsertObjectIN();

        TestObjectObject piObject = new TestObjectObject();

        params.setPiObject(piObject);

        Object[] piObjectBuilder = new Object[0];

        SpTestInsertObjectOUT out;

        java.util.Map<String, Object> mapResult = new java.util.HashMap<>();

        Number objPoCodRetorno = 2;
        String objPoMsgRetorno = "PO_MSG_RETORNO";

        mapResult.put("PO_COD_RETORNO", objPoCodRetorno);
        mapResult.put("PO_MSG_RETORNO", objPoMsgRetorno);

        Mockito.when(connectionUtil.process()).thenReturn(connection);
        Mockito.when(testObjectObjectBuilder.process(Mockito.same(connection), Mockito.same(piObject))).thenReturn(piObjectBuilder);

        Mockito.when(procedure.execute(captorParameters.capture())).thenReturn(mapResult);

        out = repository.execute(params);

        Assert.assertNotNull(out);

        Assert.assertSame(objPoCodRetorno, out.getPoCodRetorno());
        Assert.assertSame(objPoMsgRetorno, out.getPoMsgRetorno());

        InOrder inOrder = Mockito.inOrder(procedure, checkResult, connectionUtil);

        inOrder.verify(connectionUtil, Mockito.times(1)).process();
        inOrder.verify(procedure, Mockito.times(1)).execute(captorParameters.capture());
        inOrder.verify(connectionUtil, Mockito.times(1)).release(Mockito.same(connection));
        inOrder.verify(checkResult, Mockito.times(1)).check(Mockito.same(mapResult));

        Mockito.verify(testObjectObjectBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(piObject));

        java.util.Map<String, Object> mapParamsResult = captorParameters.getValue();

        Assert.assertNotNull(mapParamsResult);

        Assert.assertSame(piObjectBuilder, mapParamsResult.get("PI_OBJECT"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestInsertObjectDAOError() throws java.sql.SQLException {
        SpTestInsertObjectIN params = new SpTestInsertObjectIN();

        params.setPiObject(null);

        Mockito.when(connectionUtil.process()).thenReturn(connection);
        Mockito.when(testObjectObjectBuilder.process(Mockito.same(connection), Mockito.any(TestObjectObject.class))).thenReturn(null);
        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestInsertObjectDAOInputNullParameterError() throws java.sql.SQLException {
        SpTestInsertObjectIN params = null;

        Mockito.when(connectionUtil.process()).thenReturn(connection);

        repository.execute(params);
    }
}
