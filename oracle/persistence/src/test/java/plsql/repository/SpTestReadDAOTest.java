package plsql.repository;

import plsql.domain.SpTestReadIN;
import plsql.domain.SpTestReadOUT;
import plsql.repository.sp.SpTestReadSP;
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
public class SpTestReadDAOTest {

    @InjectMocks
    SpTestReadDAOImpl repository;

    @Mock
    private CheckResult checkResult;

    @Mock(name = "SpTestReadSP")
    private SpTestReadSP procedure;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testSpTestReadDAOExecute() throws java.sql.SQLException {

        SpTestReadIN params = new SpTestReadIN();

        Number piId = 1;

        params.setPiId(piId);

        SpTestReadOUT out;

        java.util.Map<String, Object> mapResult = new java.util.HashMap<>();

        String objPoName = "PO_NAME";
        Number objPoCodRetorno = 3;
        String objPoMsgRetorno = "PO_MSG_RETORNO";

        mapResult.put("PO_NAME", objPoName);
        mapResult.put("PO_COD_RETORNO", objPoCodRetorno);
        mapResult.put("PO_MSG_RETORNO", objPoMsgRetorno);


        Mockito.when(procedure.execute(captorParameters.capture())).thenReturn(mapResult);

        out = repository.execute(params);

        Assert.assertNotNull(out);

        Assert.assertSame(objPoName, out.getPoName());
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
    public void testExecuteSpTestReadDAOError() throws java.sql.SQLException {
        SpTestReadIN params = new SpTestReadIN();

        params.setPiId(null);

        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestReadDAOInputNullParameterError() throws java.sql.SQLException {
        SpTestReadIN params = null;
        repository.execute(params);
    }
}
