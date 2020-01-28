package plsql.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CheckResultTest {

    @InjectMocks
    CheckResultImpl checkResult;

    @Test
    public void testInputNull() throws java.sql.SQLException {
        checkResult.check(null);
    }

    @Test
    public void testInputNotNullFail() throws java.sql.SQLException {
        java.util.Map<String, Object> map = new java.util.HashMap<>();
        checkResult.check(map);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testInputResponseError() throws java.sql.SQLException {
        java.util.Map<String, Object> map = new java.util.HashMap<>();

        map.put("PO_COD_RETORNO", 101);
        map.put("PO_MSG_RETORNO", "ERROR");

        checkResult.check(map);
    }

    @Test
    public void testInputOk() throws java.sql.SQLException {
        java.util.Map<String, Object> map = new java.util.HashMap<>();

        map.put("PO_COD_RETORNO", 0);
        map.put("PO_MSG_RETORNO", "OK");

        checkResult.check(map);
    }

}
