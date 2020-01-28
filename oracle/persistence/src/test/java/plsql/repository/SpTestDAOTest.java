package plsql.repository;

import plsql.repository.sp.SpTestSP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings({"unchecked"})
public class SpTestDAOTest {

    @InjectMocks
    SpTestDAOImpl repository;

    @Mock(name = "SpTestSP")
    private SpTestSP procedure;

    @Test
    public void testSpTestDAOExecute() throws java.sql.SQLException {
        repository.execute();

        InOrder inOrder = Mockito.inOrder(procedure);

        inOrder.verify(procedure, Mockito.times(1)).execute(Mockito.anyMap());
    }

    @Test(expected = java.sql.SQLException.class)
    public void testExecuteSpTestDAOError() throws java.sql.SQLException {
        Mockito.when(procedure.execute(Mockito.anyMap())).thenThrow(new RuntimeException());

        repository.execute();
    }
}
