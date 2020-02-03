package plsql.repository.sp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SpTestFullSPTest {

    @Mock
    private javax.sql.DataSource dataSource;

    @Mock
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    @Test
    public void testSpTestFullSPDataSource() throws java.sql.SQLException {

        Mockito.when(jdbcTemplate.getDataSource()).thenReturn(dataSource);

        SpTestFullSPImpl sp = new SpTestFullSPImpl(jdbcTemplate);

        Assert.assertSame(dataSource, sp.getJdbcTemplate().getDataSource());

        Assert.assertEquals("{call SP_TEST_FULL(?, ?, ?)}", sp.getCallString());
    }
}
