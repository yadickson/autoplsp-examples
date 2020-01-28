package plsql.repository;

import java.sql.Connection;

import plsql.domain.SpTestObjectIN;
import plsql.repository.sp.SpTestObjectSP;
import plsql.object.CharObjectObject;
import plsql.object.CharObjectObjectBuilder;
import plsql.object.NumericObjectObject;
import plsql.object.NumericObjectObjectBuilder;
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
public class SpTestObjectDAOTest {

    @InjectMocks
    SpTestObjectDAOImpl repository;

    @Mock
    private Connection connection;

    @Mock
    private ConnectionUtil connectionUtil;

    @Mock
    private CharObjectObjectBuilder charObjectObjectBuilder;

    @Mock
    private NumericObjectObjectBuilder numericObjectObjectBuilder;

    @Mock(name = "SpTestObjectSP")
    private SpTestObjectSP procedure;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testSpTestObjectDAOExecute() throws java.sql.SQLException {

        SpTestObjectIN params = new SpTestObjectIN();

        NumericObjectObject piC1 = new NumericObjectObject();
        CharObjectObject piC2 = new CharObjectObject();
        NumericObjectObject poC3 = new NumericObjectObject();
        CharObjectObject poC4 = new CharObjectObject();

        params.setPiC1(piC1);
        params.setPiC2(piC2);
        params.setPoC3(poC3);
        params.setPoC4(poC4);

        Object[] piC1Builder = new Object[0];
        Object[] piC2Builder = new Object[0];
        Object[] poC3Builder = new Object[0];
        Object[] poC4Builder = new Object[0];

        Mockito.when(connectionUtil.process()).thenReturn(connection);
        Mockito.when(numericObjectObjectBuilder.process(Mockito.same(connection), Mockito.same(piC1))).thenReturn(piC1Builder);
        Mockito.when(charObjectObjectBuilder.process(Mockito.same(connection), Mockito.same(piC2))).thenReturn(piC2Builder);
        Mockito.when(numericObjectObjectBuilder.process(Mockito.same(connection), Mockito.same(poC3))).thenReturn(poC3Builder);
        Mockito.when(charObjectObjectBuilder.process(Mockito.same(connection), Mockito.same(poC4))).thenReturn(poC4Builder);

        repository.execute(params);

        InOrder inOrder = Mockito.inOrder(procedure, connectionUtil);

        inOrder.verify(connectionUtil, Mockito.times(1)).process();
        inOrder.verify(procedure, Mockito.times(1)).execute(captorParameters.capture());
        inOrder.verify(connectionUtil, Mockito.times(1)).release(Mockito.same(connection));

        Mockito.verify(numericObjectObjectBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(piC1));
        Mockito.verify(charObjectObjectBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(piC2));
        Mockito.verify(numericObjectObjectBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(poC3));
        Mockito.verify(charObjectObjectBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(poC4));

        java.util.Map<String, Object> mapParamsResult = captorParameters.getValue();

        Assert.assertNotNull(mapParamsResult);

        Assert.assertSame(piC1Builder, mapParamsResult.get("PI_C1"));
        Assert.assertSame(piC2Builder, mapParamsResult.get("PI_C2"));
        Assert.assertSame(poC3Builder, mapParamsResult.get("PO_C3"));
        Assert.assertSame(poC4Builder, mapParamsResult.get("PO_C4"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestObjectDAOError() throws java.sql.SQLException {
        SpTestObjectIN params = new SpTestObjectIN();

        params.setPiC1(null);
        params.setPiC2(null);
        params.setPoC3(null);
        params.setPoC4(null);

        Mockito.when(connectionUtil.process()).thenReturn(connection);
        Mockito.when(numericObjectObjectBuilder.process(Mockito.same(connection), Mockito.any(NumericObjectObject.class))).thenReturn(null);
        Mockito.when(charObjectObjectBuilder.process(Mockito.same(connection), Mockito.any(CharObjectObject.class))).thenReturn(null);
        Mockito.when(numericObjectObjectBuilder.process(Mockito.same(connection), Mockito.any(NumericObjectObject.class))).thenReturn(null);
        Mockito.when(charObjectObjectBuilder.process(Mockito.same(connection), Mockito.any(CharObjectObject.class))).thenReturn(null);
        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestObjectDAOInputNullParameterError() throws java.sql.SQLException {
        SpTestObjectIN params = null;

        Mockito.when(connectionUtil.process()).thenReturn(connection);

        repository.execute(params);
    }
}
