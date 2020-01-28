package plsql.repository;

import plsql.domain.SpTestInsertIN;
import plsql.domain.SpTestInsertOUT;
import plsql.repository.sp.SpTestInsertSP;
import plsql.util.CheckResult;

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
public class SpTestInsertDAOTest {

    @InjectMocks
    SpTestInsertDAOImpl repository;

    @Mock
    private CheckResult checkResult;

    @Mock(name = "SpTestInsertSP")
    private SpTestInsertSP procedure;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testSpTestInsertDAOExecute() throws java.sql.SQLException {

        SpTestInsertIN params = new SpTestInsertIN();

        Number piId = 1;
        String piName = "PI_NAME";

        params.setPiId(piId);
        params.setPiName(piName);

        SpTestInsertOUT out;

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
    public void testExecuteSpTestInsertDAOError() throws java.sql.SQLException {
        SpTestInsertIN params = new SpTestInsertIN();

        params.setPiId(null);
        params.setPiName(null);

        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestInsertDAOInputNullParameterError() throws java.sql.SQLException {
        SpTestInsertIN params = null;
        repository.execute(params);
    }
}
