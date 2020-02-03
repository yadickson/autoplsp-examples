package plsql.repository;

import plsql.domain.SpTestUpdateIN;
import plsql.domain.SpTestUpdateOUT;
import plsql.repository.sp.SpTestUpdateSP;
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
public class SpTestUpdateDAOTest {

    @InjectMocks
    SpTestUpdateDAOImpl repository;

    @Mock
    private OracleCheckResult checkResult;

    @Mock(name = "SpTestUpdateSP")
    private SpTestUpdateSP procedure;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testSpTestUpdateDAOExecute() throws java.sql.SQLException {

        SpTestUpdateIN params = new SpTestUpdateIN();

        Number piId = 1;
        String piName = "PI_NAME";

        params.setPiId(piId);
        params.setPiName(piName);

        SpTestUpdateOUT out;

        java.util.Map<String, Object> mapResult = new java.util.HashMap<>();

        Number objPoCodRetorno = 3;
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
        Assert.assertSame(piName, mapParamsResult.get("PI_NAME"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestUpdateDAOError() throws java.sql.SQLException {
        SpTestUpdateIN params = new SpTestUpdateIN();

        params.setPiId(null);
        params.setPiName(null);

        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestUpdateDAOInputNullParameterError() throws java.sql.SQLException {
        SpTestUpdateIN params = null;
        repository.execute(params);
    }
}
