package plsql.repository;

import plsql.domain.FnTestNumberIN;
import plsql.domain.FnTestNumberOUT;
import plsql.repository.sp.FnTestNumberSP;

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
public class FnTestNumberDAOTest {

    @InjectMocks
    FnTestNumberDAOImpl repository;

    @Mock(name = "FnTestNumberSP")
    private FnTestNumberSP function;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testFnTestNumberDAOExecute() throws java.sql.SQLException {

        FnTestNumberIN params = new FnTestNumberIN();

        Number piC1 = 1;
        Number piC2 = 2;
        Number piC3 = 3;
        Number piC4 = 4;
        Number piC5 = 5;
        Number piC6 = 6;
        Number piC7 = 7;
        Number piC9 = 8;
        Number piC10 = 9;
        Number piC11 = 10;

        params.setPiC1(piC1);
        params.setPiC2(piC2);
        params.setPiC3(piC3);
        params.setPiC4(piC4);
        params.setPiC5(piC5);
        params.setPiC6(piC6);
        params.setPiC7(piC7);
        params.setPiC9(piC9);
        params.setPiC10(piC10);
        params.setPiC11(piC11);

        FnTestNumberOUT out;

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
        Assert.assertSame(piC6, mapParamsResult.get("PI_C6"));
        Assert.assertSame(piC7, mapParamsResult.get("PI_C7"));
        Assert.assertSame(piC9, mapParamsResult.get("PI_C9"));
        Assert.assertSame(piC10, mapParamsResult.get("PI_C10"));
        Assert.assertSame(piC11, mapParamsResult.get("PI_C11"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteFnTestNumberDAOError() throws java.sql.SQLException {
        FnTestNumberIN params = new FnTestNumberIN();

        params.setPiC1(null);
        params.setPiC2(null);
        params.setPiC3(null);
        params.setPiC4(null);
        params.setPiC5(null);
        params.setPiC6(null);
        params.setPiC7(null);
        params.setPiC9(null);
        params.setPiC10(null);
        params.setPiC11(null);

        Mockito.when(function.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteFnTestNumberDAOInputNullParameterError() throws java.sql.SQLException {
        FnTestNumberIN params = null;
        repository.execute(params);
    }
}
