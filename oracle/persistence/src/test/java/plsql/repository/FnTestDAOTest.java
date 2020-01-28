package plsql.repository;

import plsql.domain.FnTestOUT;
import plsql.repository.sp.FnTestSP;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings({"unchecked"})
public class FnTestDAOTest {

    @InjectMocks
    FnTestDAOImpl repository;

    @Mock(name = "FnTestSP")
    private FnTestSP function;

    @Test
    public void testFnTestDAOExecute() throws java.sql.SQLException {
        FnTestOUT out;

        java.util.Map<String, Object> mapResult = new java.util.HashMap<>();

        Number objReturnValue = 0;

        mapResult.put("return_value", objReturnValue);


        Mockito.when(function.execute(Mockito.anyMap())).thenReturn(mapResult);

        out = repository.execute();

        Assert.assertNotNull(out);

        Assert.assertSame(objReturnValue, out.getReturnValue());

        InOrder inOrder = Mockito.inOrder(function);

        inOrder.verify(function, Mockito.times(1)).execute(Mockito.anyMap());
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteFnTestDAOError() throws java.sql.SQLException {
        Mockito.when(function.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute();
    }
}
