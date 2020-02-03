package plsql.repository;

import plsql.domain.SpTestDeleteIN;
import plsql.domain.SpTestDeleteOUT;
import plsql.repository.sp.SpTestDeleteSP;
import plsql.util.OracleCheckResult;

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
public class SpTestDeleteDAOTest {

    @InjectMocks
    SpTestDeleteDAOImpl repository;

    @Mock
    private OracleCheckResult checkResult;

    @Mock(name = "SpTestDeleteSP")
    private SpTestDeleteSP procedure;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testSpTestDeleteDAOExecute() throws java.sql.SQLException {

        SpTestDeleteIN params = new SpTestDeleteIN();

        Number piId = 1;

        params.setPiId(piId);

        SpTestDeleteOUT out;

        java.util.Map<String, Object> mapResult = new java.util.HashMap<>();

        Number objPoCodRetorno = 2;
        String objPoMsgRetorno = "PO_MSG_RETORNO";

        mapResult.put("PO_COD_RETORNO", objPoCodRetorno);
        mapResult.put("PO_MSG_RETORNO", objPoMsgRetorno);


        Mockito.when(procedure.execute(captorParameters.capture())).thenReturn(mapResult);

        out = repository.execute(params);

        Assert.assertNotNull(out);

        Assert.assertSame(objPoCodRetorno, out.getPoCodRetorno());
        Assert.assertSame(objPoMsgRetorno, out.getPoMsgRetorno());

        InOrder inOrder = Mockito.inOrder(procedure, checkResult);

        inOrder.verify(procedure, Mockito.times(1)).execute(captorParameters.capture());
        inOrder.verify(checkResult, Mockito.times(1)).check(Mockito.same(mapResult));

        java.util.Map<String, Object> mapParamsResult = captorParameters.getValue();

        Assert.assertNotNull(mapParamsResult);

        Assert.assertSame(piId, mapParamsResult.get("PI_ID"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestDeleteDAOError() throws java.sql.SQLException {
        SpTestDeleteIN params = new SpTestDeleteIN();

        params.setPiId(null);

        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestDeleteDAOInputNullParameterError() throws java.sql.SQLException {
        SpTestDeleteIN params = null;
        repository.execute(params);
    }
}
