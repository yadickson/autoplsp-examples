package plsql.repository;

import plsql.domain.SpTestOutOUT;
import plsql.repository.sp.SpTestOutSP;

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
public class SpTestOutDAOTest {

    @InjectMocks
    SpTestOutDAOImpl repository;

    @Mock(name = "SpTestOutSP")
    private SpTestOutSP procedure;

    @Test
    public void testSpTestOutDAOExecute() throws java.sql.SQLException {
        SpTestOutOUT out;

        java.util.Map<String, Object> mapResult = new java.util.HashMap<>();

        String objPoC1 = "PO_C1";
        String objPoC2 = "PO_C2";
        String objPoC3 = "PO_C3";
        String objPoC4 = "PO_C4";
        String objPoC5 = "PO_C5";
        Number objPoC6 = 6;
        Number objPoC7 = 7;
        Number objPoC8 = 8;
        Number objPoC9 = 9;
        Number objPoC10 = 10;
        Number objPoC11 = 11;
        Number objPoC12 = 12;
        Number objPoC13 = 13;
        Number objPoC14 = 14;
        Number objPoC15 = 15;
        Number objCounter = 16;
        String objMessage = "MESSAGE";

        mapResult.put("PO_C1", objPoC1);
        mapResult.put("PO_C2", objPoC2);
        mapResult.put("PO_C3", objPoC3);
        mapResult.put("PO_C4", objPoC4);
        mapResult.put("PO_C5", objPoC5);
        mapResult.put("PO_C6", objPoC6);
        mapResult.put("PO_C7", objPoC7);
        mapResult.put("PO_C8", objPoC8);
        mapResult.put("PO_C9", objPoC9);
        mapResult.put("PO_C10", objPoC10);
        mapResult.put("PO_C11", objPoC11);
        mapResult.put("PO_C12", objPoC12);
        mapResult.put("PO_C13", objPoC13);
        mapResult.put("PO_C14", objPoC14);
        mapResult.put("PO_C15", objPoC15);
        mapResult.put("COUNTER", objCounter);
        mapResult.put("MESSAGE", objMessage);


        Mockito.when(procedure.execute(Mockito.anyMap())).thenReturn(mapResult);

        out = repository.execute();

        Assert.assertNotNull(out);

        Assert.assertSame(objPoC1, out.getPoC1());
        Assert.assertSame(objPoC2, out.getPoC2());
        Assert.assertSame(objPoC3, out.getPoC3());
        Assert.assertSame(objPoC4, out.getPoC4());
        Assert.assertSame(objPoC5, out.getPoC5());
        Assert.assertSame(objPoC6, out.getPoC6());
        Assert.assertSame(objPoC7, out.getPoC7());
        Assert.assertSame(objPoC8, out.getPoC8());
        Assert.assertSame(objPoC9, out.getPoC9());
        Assert.assertSame(objPoC10, out.getPoC10());
        Assert.assertSame(objPoC11, out.getPoC11());
        Assert.assertSame(objPoC12, out.getPoC12());
        Assert.assertSame(objPoC13, out.getPoC13());
        Assert.assertSame(objPoC14, out.getPoC14());
        Assert.assertSame(objPoC15, out.getPoC15());
        Assert.assertSame(objCounter, out.getCounter());
        Assert.assertSame(objMessage, out.getMessage());

        InOrder inOrder = Mockito.inOrder(procedure);

        inOrder.verify(procedure, Mockito.times(1)).execute(Mockito.anyMap());
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestOutDAOError() throws java.sql.SQLException {
        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute();
    }
}
