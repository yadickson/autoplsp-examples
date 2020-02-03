package plsql.repository;

import plsql.domain.FnTestLobIN;
import plsql.domain.FnTestLobOUT;
import plsql.repository.sp.FnTestLobSP;
import plsql.util.OracleBlobUtil;
import plsql.util.OracleClobUtil;

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
public class FnTestLobDAOTest {

    @InjectMocks
    FnTestLobDAOImpl repository;

    @Mock
    private OracleBlobUtil blobUtil;

    @Mock
    private OracleClobUtil clobUtil;

    @Mock(name = "FnTestLobSP")
    private FnTestLobSP function;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testFnTestLobDAOExecute() throws java.sql.SQLException {

        FnTestLobIN params = new FnTestLobIN();

        String piC1 = "PI_C1";
        String piC2 = "PI_C2";
        byte[] piC3 = new byte[0];

        params.setPiC1(piC1);
        params.setPiC2(piC2);
        params.setPiC3(piC3);

        FnTestLobOUT out;

        java.util.Map<String, Object> mapResult = new java.util.HashMap<>();

        Number objReturnValue = 0;
        java.sql.Clob objPoC4 = Mockito.mock(java.sql.Clob.class);
        java.sql.Clob objPoC5 = Mockito.mock(java.sql.Clob.class);
        java.sql.Blob objPoC6 = Mockito.mock(java.sql.Blob.class);

        mapResult.put("return_value", objReturnValue);
        mapResult.put("PO_C4", objPoC4);
        mapResult.put("PO_C5", objPoC5);
        mapResult.put("PO_C6", objPoC6);


        Mockito.when(clobUtil.process(Mockito.same(objPoC4))).thenReturn("PO_C4");
        Mockito.when(clobUtil.process(Mockito.same(objPoC5))).thenReturn("PO_C5");
        Mockito.when(blobUtil.process(Mockito.same(objPoC6))).thenReturn(new byte[0]);
        Mockito.when(function.execute(captorParameters.capture())).thenReturn(mapResult);

        out = repository.execute(params);

        Assert.assertNotNull(out);

        Assert.assertSame(objReturnValue, out.getReturnValue());
        Assert.assertEquals("PO_C4", out.getPoC4());
        Assert.assertEquals("PO_C5", out.getPoC5());
        Assert.assertNotNull(out.getPoC6());

        InOrder inOrder = Mockito.inOrder(function);

        inOrder.verify(function, Mockito.times(1)).execute(captorParameters.capture());

        java.util.Map<String, Object> mapParamsResult = captorParameters.getValue();

        Assert.assertNotNull(mapParamsResult);

        Assert.assertSame(piC1, mapParamsResult.get("PI_C1"));
        Assert.assertSame(piC2, mapParamsResult.get("PI_C2"));
        Assert.assertSame(piC3, mapParamsResult.get("PI_C3"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteFnTestLobDAOError() throws java.sql.SQLException {
        FnTestLobIN params = new FnTestLobIN();

        params.setPiC1(null);
        params.setPiC2(null);
        params.setPiC3(null);

        Mockito.when(function.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteFnTestLobDAOInputNullParameterError() throws java.sql.SQLException {
        FnTestLobIN params = null;
        repository.execute(params);
    }
}
