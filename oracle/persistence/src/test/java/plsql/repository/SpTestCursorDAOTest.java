package plsql.repository;

import plsql.domain.SpTestCursorPoCursorRS;
import plsql.domain.SpTestCursorOUT;
import plsql.repository.sp.SpTestCursorSP;
import plsql.util.CheckResult;

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
public class SpTestCursorDAOTest {

    @InjectMocks
    SpTestCursorDAOImpl repository;

    @Mock
    private CheckResult checkResult;

    @Mock(name = "SpTestCursorSP")
    private SpTestCursorSP procedure;

    @Test
    public void testSpTestCursorDAOExecute() throws java.sql.SQLException {
        SpTestCursorOUT out;

        java.util.Map<String, Object> mapResult = new java.util.HashMap<>();

        java.util.List<SpTestCursorPoCursorRS> objPoCursor = new java.util.ArrayList<>();
        Number objPoCodRetorno = 2;
        String objPoMsgRetorno = "PO_MSG_RETORNO";

        mapResult.put("PO_CURSOR", objPoCursor);
        mapResult.put("PO_COD_RETORNO", objPoCodRetorno);
        mapResult.put("PO_MSG_RETORNO", objPoMsgRetorno);


        Mockito.when(procedure.execute(Mockito.anyMap())).thenReturn(mapResult);

        out = repository.execute();

        Assert.assertNotNull(out);

        Assert.assertSame(objPoCursor, out.getPoCursor());
        Assert.assertSame(objPoCodRetorno, out.getPoCodRetorno());
        Assert.assertSame(objPoMsgRetorno, out.getPoMsgRetorno());

        InOrder inOrder = Mockito.inOrder(procedure, checkResult);

        inOrder.verify(procedure, Mockito.times(1)).execute(Mockito.anyMap());
        inOrder.verify(checkResult, Mockito.times(1)).check(Mockito.same(mapResult));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestCursorDAOError() throws java.sql.SQLException {
        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute();
    }
}
