package plsql.repository;

import plsql.domain.SpTestInsertLobIN;
import plsql.domain.SpTestInsertLobOUT;
import plsql.repository.sp.SpTestInsertLobSP;
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
public class SpTestInsertLobDAOTest {

    @InjectMocks
    SpTestInsertLobDAOImpl repository;

    @Mock
    private CheckResult checkResult;

    @Mock(name = "SpTestInsertLobSP")
    private SpTestInsertLobSP procedure;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testSpTestInsertLobDAOExecute() throws java.sql.SQLException {

        SpTestInsertLobIN params = new SpTestInsertLobIN();

        String piClob = "PI_CLOB";
        String piNclob = "PI_NCLOB";
        byte[] piBlob = new byte[0];

        params.setPiClob(piClob);
        params.setPiNclob(piNclob);
        params.setPiBlob(piBlob);

        SpTestInsertLobOUT out;

        java.util.Map<String, Object> mapResult = new java.util.HashMap<>();

        Number objPoCodRetorno = 4;
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

        Assert.assertSame(piClob, mapParamsResult.get("PI_CLOB"));
        Assert.assertSame(piNclob, mapParamsResult.get("PI_NCLOB"));
        Assert.assertSame(piBlob, mapParamsResult.get("PI_BLOB"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestInsertLobDAOError() throws java.sql.SQLException {
        SpTestInsertLobIN params = new SpTestInsertLobIN();

        params.setPiClob(null);
        params.setPiNclob(null);
        params.setPiBlob(null);

        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestInsertLobDAOInputNullParameterError() throws java.sql.SQLException {
        SpTestInsertLobIN params = null;
        repository.execute(params);
    }
}
