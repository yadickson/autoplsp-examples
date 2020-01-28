package plsql.repository;

import java.sql.Connection;

import plsql.array.TestArrayTable;
import plsql.array.TestArrayTableBuilder;
import plsql.domain.SpTestInsertArrayIN;
import plsql.domain.SpTestInsertArrayOUT;
import plsql.repository.sp.SpTestInsertArraySP;
import plsql.util.CheckResult;
import plsql.util.ConnectionUtil;

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
public class SpTestInsertArrayDAOTest {

    @InjectMocks
    SpTestInsertArrayDAOImpl repository;

    @Mock
    private CheckResult checkResult;

    @Mock
    private Connection connection;

    @Mock
    private ConnectionUtil connectionUtil;

    @Mock
    private TestArrayTableBuilder testArrayTableBuilder;

    @Mock(name = "SpTestInsertArraySP")
    private SpTestInsertArraySP procedure;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testSpTestInsertArrayDAOExecute() throws java.sql.SQLException {

        SpTestInsertArrayIN params = new SpTestInsertArrayIN();

        TestArrayTable piArray = new TestArrayTable();

        params.setPiArray(piArray);

        Object[] piArrayBuilder = new Object[0];

        SpTestInsertArrayOUT out;

        java.util.Map<String, Object> mapResult = new java.util.HashMap<>();

        Number objPoCodRetorno = 2;
        String objPoMsgRetorno = "PO_MSG_RETORNO";

        mapResult.put("PO_COD_RETORNO", objPoCodRetorno);
        mapResult.put("PO_MSG_RETORNO", objPoMsgRetorno);

        Mockito.when(connectionUtil.process()).thenReturn(connection);
        Mockito.when(testArrayTableBuilder.process(Mockito.same(connection), Mockito.same(piArray))).thenReturn(piArrayBuilder);

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

        Mockito.verify(testArrayTableBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(piArray));

        java.util.Map<String, Object> mapParamsResult = captorParameters.getValue();

        Assert.assertNotNull(mapParamsResult);

        Assert.assertSame(piArrayBuilder, mapParamsResult.get("PI_ARRAY"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestInsertArrayDAOError() throws java.sql.SQLException {
        SpTestInsertArrayIN params = new SpTestInsertArrayIN();

        params.setPiArray(null);

        Mockito.when(connectionUtil.process()).thenReturn(connection);
        Mockito.when(testArrayTableBuilder.process(Mockito.same(connection), Mockito.any(TestArrayTable.class))).thenReturn(null);
        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestInsertArrayDAOInputNullParameterError() throws java.sql.SQLException {
        SpTestInsertArrayIN params = null;

        Mockito.when(connectionUtil.process()).thenReturn(connection);

        repository.execute(params);
    }
}
