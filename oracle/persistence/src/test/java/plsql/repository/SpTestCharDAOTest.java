package plsql.repository;

import plsql.domain.SpTestCharIN;
import plsql.repository.sp.SpTestCharSP;

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
public class SpTestCharDAOTest {

    @InjectMocks
    SpTestCharDAOImpl repository;

    @Mock(name = "SpTestCharSP")
    private SpTestCharSP procedure;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testSpTestCharDAOExecute() throws java.sql.SQLException {

        SpTestCharIN params = new SpTestCharIN();

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


        repository.execute(params);

        InOrder inOrder = Mockito.inOrder(procedure);

        inOrder.verify(procedure, Mockito.times(1)).execute(captorParameters.capture());

        java.util.Map<String, Object> mapParamsResult = captorParameters.getValue();

        Assert.assertNotNull(mapParamsResult);

        Assert.assertSame(piC1, mapParamsResult.get("PI_C1"));
        Assert.assertSame(piC2, mapParamsResult.get("PI_C2"));
        Assert.assertSame(piC3, mapParamsResult.get("PI_C3"));
        Assert.assertSame(piC4, mapParamsResult.get("PI_C4"));
        Assert.assertSame(piC5, mapParamsResult.get("PI_C5"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestCharDAOError() throws java.sql.SQLException {
        SpTestCharIN params = new SpTestCharIN();

        params.setPiC1(null);
        params.setPiC2(null);
        params.setPiC3(null);
        params.setPiC4(null);
        params.setPiC5(null);

        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestCharDAOInputNullParameterError() throws java.sql.SQLException {
        SpTestCharIN params = null;
        repository.execute(params);
    }
}
