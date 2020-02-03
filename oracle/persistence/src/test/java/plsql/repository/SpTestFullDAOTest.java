package plsql.repository;

import java.sql.Connection;

import plsql.array.BlobArrayTable;
import plsql.array.BlobArrayTableBuilder;
import plsql.array.ClobArrayTable;
import plsql.array.ClobArrayTableBuilder;
import plsql.domain.SpTestFullIN;
import plsql.repository.sp.SpTestFullSP;
import plsql.object.TestObjectFullObject;
import plsql.object.TestObjectFullObjectBuilder;
import plsql.util.OracleConnectionUtil;

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
public class SpTestFullDAOTest {

    @InjectMocks
    SpTestFullDAOImpl repository;

    @Mock
    private Connection connection;

    @Mock
    private OracleConnectionUtil connectionUtil;

    @Mock
    private BlobArrayTableBuilder blobArrayTableBuilder;

    @Mock
    private ClobArrayTableBuilder clobArrayTableBuilder;

    @Mock
    private TestObjectFullObjectBuilder testObjectFullObjectBuilder;

    @Mock(name = "SpTestFullSP")
    private SpTestFullSP procedure;

    @Captor
    private ArgumentCaptor<java.util.Map<String, Object>> captorParameters;

    @Test
    public void testSpTestFullDAOExecute() throws java.sql.SQLException {

        SpTestFullIN params = new SpTestFullIN();

        ClobArrayTable piC1 = new ClobArrayTable();
        BlobArrayTable piC2 = new BlobArrayTable();
        TestObjectFullObject poC3 = new TestObjectFullObject();

        params.setPiC1(piC1);
        params.setPiC2(piC2);
        params.setPoC3(poC3);

        Object[] piC1Builder = new Object[0];
        Object[] piC2Builder = new Object[0];
        Object[] poC3Builder = new Object[0];

        Mockito.when(connectionUtil.process()).thenReturn(connection);
        Mockito.when(clobArrayTableBuilder.process(Mockito.same(connection), Mockito.same(piC1))).thenReturn(piC1Builder);
        Mockito.when(blobArrayTableBuilder.process(Mockito.same(connection), Mockito.same(piC2))).thenReturn(piC2Builder);
        Mockito.when(testObjectFullObjectBuilder.process(Mockito.same(connection), Mockito.same(poC3))).thenReturn(poC3Builder);

        repository.execute(params);

        InOrder inOrder = Mockito.inOrder(procedure, connectionUtil);

        inOrder.verify(connectionUtil, Mockito.times(1)).process();
        inOrder.verify(procedure, Mockito.times(1)).execute(captorParameters.capture());
        inOrder.verify(connectionUtil, Mockito.times(1)).release(Mockito.same(connection));

        Mockito.verify(clobArrayTableBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(piC1));
        Mockito.verify(blobArrayTableBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(piC2));
        Mockito.verify(testObjectFullObjectBuilder, Mockito.times(1)).process(Mockito.same(connection), Mockito.same(poC3));

        java.util.Map<String, Object> mapParamsResult = captorParameters.getValue();

        Assert.assertNotNull(mapParamsResult);

        Assert.assertSame(piC1Builder, mapParamsResult.get("PI_C1"));
        Assert.assertSame(piC2Builder, mapParamsResult.get("PI_C2"));
        Assert.assertSame(poC3Builder, mapParamsResult.get("PO_C3"));
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestFullDAOError() throws java.sql.SQLException {
        SpTestFullIN params = new SpTestFullIN();

        params.setPiC1(null);
        params.setPiC2(null);
        params.setPoC3(null);

        Mockito.when(connectionUtil.process()).thenReturn(connection);
        Mockito.when(clobArrayTableBuilder.process(Mockito.same(connection), Mockito.any(ClobArrayTable.class))).thenReturn(null);
        Mockito.when(blobArrayTableBuilder.process(Mockito.same(connection), Mockito.any(BlobArrayTable.class))).thenReturn(null);
        Mockito.when(testObjectFullObjectBuilder.process(Mockito.same(connection), Mockito.any(TestObjectFullObject.class))).thenReturn(null);
        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute(params);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestFullDAOInputNullParameterError() throws java.sql.SQLException {
        SpTestFullIN params = null;

        Mockito.when(connectionUtil.process()).thenReturn(connection);

        repository.execute(params);
    }
}
