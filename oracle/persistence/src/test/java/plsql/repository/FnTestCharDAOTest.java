package plsql.repository;

import plsql.domain.FnTestCharIN;
import plsql.domain.FnTestCharOUT;
import plsql.repository.sp.FnTestCharSP;

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
public class FnTestCharDAOTest {

    @InjectMocks
    FnTestCharDAOImpl repository;

    @Mock(name = "FnTestCharSP")
    private FnTestCharSP function;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testFnTestCharDAOExecute() throws java.sql.SQLException {

        FnTestCharIN params = new FnTestCharIN();

        String piC1 = "PI_C1";
        String piC2 = "PI_C2";
        String piC3 = "PI_C3";
        String piC4 = "PI_C4";
        String piC5 = "PI_C5";

        params.setPiC1(piC1);
        params.setPiC2(piC2);
        params.setPiC3(piC3);
        params.setPiC4(piC4);
        params.setPiC5(piC5);

        FnTestCharOUT out;

        java.util.Map<String, Object> mapResult = new java.util.HashMap<>();

        Number objReturnValue = 0;

        mapResult.put("return_value", objReturnValue);


        Mockito.when(function.execute(captorParameters.capture())).thenReturn(mapResult);

        out = repository.execute(params);

        Assert.assertNotNull(out);

        Assert.assertSame(objReturnValue, out.getReturnValue());

        InOrder inOrder = Mockito.inOrder(function);

        inOrder.verify(function, Mockito.times(1)).execute(captorParameters.capture());

        java.util.Map<String, Object> mapParamsResult = captorParameters.getValue();

        Assert.assertNotNull(mapParamsResult);

        Assert.assertSame(piC1, mapParamsResult.get("PI_C1"));
        Assert.assertSame(piC2, mapParamsResult.get("PI_C2"));
        Assert.assertSame(piC3, mapParamsResult.get("PI_C3"));
        Assert.assertSame(piC4, mapParamsResult.get("PI_C4"));
        Assert.assertSame(piC5, mapParamsResult.get("PI_C5"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteFnTestCharDAOError() throws java.sql.SQLException {
        FnTestCharIN params = new FnTestCharIN();

        params.setPiC1(null);
        params.setPiC2(null);
        params.setPiC3(null);
        params.setPiC4(null);
        params.setPiC5(null);

        Mockito.when(function.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteFnTestCharDAOInputNullParameterError() throws java.sql.SQLException {
        FnTestCharIN params = null;
        repository.execute(params);
    }
}
