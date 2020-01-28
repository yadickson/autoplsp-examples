package plsql.repository;

import java.sql.Connection;

import plsql.array.CharArrayObjectTable;
import plsql.array.CharArrayObjectTableBuilder;
import plsql.array.CharArrayTable;
import plsql.array.CharArrayTableBuilder;
import plsql.array.NumericArrayObjectTable;
import plsql.array.NumericArrayObjectTableBuilder;
import plsql.array.NumericArrayTable;
import plsql.array.NumericArrayTableBuilder;
import plsql.domain.SpTestArrayIN;
import plsql.repository.sp.SpTestArraySP;
import plsql.util.ConnectionUtil;

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
public class SpTestArrayDAOTest {

    @InjectMocks
    SpTestArrayDAOImpl repository;

    @Mock
    private Connection connection;

    @Mock
    private ConnectionUtil connectionUtil;

    @Mock
    private CharArrayObjectTableBuilder charArrayObjectTableBuilder;

    @Mock
    private CharArrayTableBuilder charArrayTableBuilder;

    @Mock
    private NumericArrayObjectTableBuilder numericArrayObjectTableBuilder;

    @Mock
    private NumericArrayTableBuilder numericArrayTableBuilder;

    @Mock(name = "SpTestArraySP")
    private SpTestArraySP procedure;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testSpTestArrayDAOExecute() throws java.sql.SQLException {

        SpTestArrayIN params = new SpTestArrayIN();

        NumericArrayTable piC1 = new NumericArrayTable();
        CharArrayTable piC2 = new CharArrayTable();
        NumericArrayTable poC3 = new NumericArrayTable();
        CharArrayTable poC4 = new CharArrayTable();
        NumericArrayObjectTable poC5 = new NumericArrayObjectTable();
        CharArrayObjectTable poC6 = new CharArrayObjectTable();

        params.setPiC1(piC1);
        params.setPiC2(piC2);
        params.setPoC3(poC3);
        params.setPoC4(poC4);
        params.setPoC5(poC5);
        params.setPoC6(poC6);

        Object[] piC1Builder = new Object[0];
        Object[] piC2Builder = new Object[0];
        Object[] poC3Builder = new Object[0];
        Object[] poC4Builder = new Object[0];
        Object[] poC5Builder = new Object[0];
        Object[] poC6Builder = new Object[0];

        Mockito.when(connectionUtil.process()).thenReturn(connection);
        Mockito.when(numericArrayTableBuilder.process(Mockito.same(connection), Mockito.same(piC1))).thenReturn(piC1Builder);
        Mockito.when(charArrayTableBuilder.process(Mockito.same(connection), Mockito.same(piC2))).thenReturn(piC2Builder);
        Mockito.when(numericArrayTableBuilder.process(Mockito.same(connection), Mockito.same(poC3))).thenReturn(poC3Builder);
        Mockito.when(charArrayTableBuilder.process(Mockito.same(connection), Mockito.same(poC4))).thenReturn(poC4Builder);
        Mockito.when(numericArrayObjectTableBuilder.process(Mockito.same(connection), Mockito.same(poC5))).thenReturn(poC5Builder);
        Mockito.when(charArrayObjectTableBuilder.process(Mockito.same(connection), Mockito.same(poC6))).thenReturn(poC6Builder);

        repository.execute(params);

        InOrder inOrder = Mockito.inOrder(procedure, connectionUtil);

        inOrder.verify(connectionUtil, Mockito.times(1)).process();
        inOrder.verify(procedure, Mockito.times(1)).execute(captorParameters.capture());
        inOrder.verify(connectionUtil, Mockito.times(1)).release(Mockito.same(connection));

        Mockito.verify(numericArrayTableBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(piC1));
        Mockito.verify(charArrayTableBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(piC2));
        Mockito.verify(numericArrayTableBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(poC3));
        Mockito.verify(charArrayTableBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(poC4));
        Mockito.verify(numericArrayObjectTableBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(poC5));
        Mockito.verify(charArrayObjectTableBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(poC6));

        java.util.Map<String, Object> mapParamsResult = captorParameters.getValue();

        Assert.assertNotNull(mapParamsResult);

        Assert.assertSame(piC1Builder, mapParamsResult.get("PI_C1"));
        Assert.assertSame(piC2Builder, mapParamsResult.get("PI_C2"));
        Assert.assertSame(poC3Builder, mapParamsResult.get("PO_C3"));
        Assert.assertSame(poC4Builder, mapParamsResult.get("PO_C4"));
        Assert.assertSame(poC5Builder, mapParamsResult.get("PO_C5"));
        Assert.assertSame(poC6Builder, mapParamsResult.get("PO_C6"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestArrayDAOError() throws java.sql.SQLException {
        SpTestArrayIN params = new SpTestArrayIN();

        params.setPiC1(null);
        params.setPiC2(null);
        params.setPoC3(null);
        params.setPoC4(null);
        params.setPoC5(null);
        params.setPoC6(null);

        Mockito.when(connectionUtil.process()).thenReturn(connection);
        Mockito.when(numericArrayTableBuilder.process(Mockito.same(connection), Mockito.any(NumericArrayTable.class))).thenReturn(null);
        Mockito.when(charArrayTableBuilder.process(Mockito.same(connection), Mockito.any(CharArrayTable.class))).thenReturn(null);
        Mockito.when(numericArrayTableBuilder.process(Mockito.same(connection), Mockito.any(NumericArrayTable.class))).thenReturn(null);
        Mockito.when(charArrayTableBuilder.process(Mockito.same(connection), Mockito.any(CharArrayTable.class))).thenReturn(null);
        Mockito.when(numericArrayObjectTableBuilder.process(Mockito.same(connection), Mockito.any(NumericArrayObjectTable.class))).thenReturn(null);
        Mockito.when(charArrayObjectTableBuilder.process(Mockito.same(connection), Mockito.any(CharArrayObjectTable.class))).thenReturn(null);
        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestArrayDAOInputNullParameterError() throws java.sql.SQLException {
        SpTestArrayIN params = null;

        Mockito.when(connectionUtil.process()).thenReturn(connection);

        repository.execute(params);
    }
}
