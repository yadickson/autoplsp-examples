package plsql.repository.sp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SpTestObjectSPTest {

    @Mock
    private javax.sql.DataSource dataSource;

    @Mock
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    @Test
    public void testSpTestObjectSPDataSource() throws java.sql.SQLException {

        Mockito.when(jdbcTemplate.getDataSource()).thenReturn(dataSource);

        SpTestObjectSPImpl sp = new SpTestObjectSPImpl(jdbcTemplate);

        Assert.assertSame(dataSource, sp.getJdbcTemplate().getDataSource());

        Assert.assertEquals("{call SP_TEST_OBJECT(?, ?, ?, ?)}", sp.getCallString());
    }
}
