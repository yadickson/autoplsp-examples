package plsql.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OracleClobUtilTest {

    @InjectMocks
    OracleClobUtilImpl clobUtil;

    @Test
    public void testInputNull() {
        Assert.assertNull(clobUtil.process(null));
    }
/*
    @Test
    public void testInputNotNullFail() {
        java.util.Map<String, Object> map = new java.util.HashMap<>();
        clobUtil.process(map);
    }

    @Test(expected = java.sql.SQLException.class)
    public void testInputResponseError() {
        java.util.Map<String, Object> map = new java.util.HashMap<>();

        map.put("PO_COD_RETORNO", 101);
        map.put("PO_MSG_RETORNO", "ERROR");

        clobUtil.process(map);
    }

    @Test
    public void testInputOk() {
        java.util.Map<String, Object> map = new java.util.HashMap<>();

        map.put("PO_COD_RETORNO", 0);
        map.put("PO_MSG_RETORNO", "OK");

        clobUtil.process(map);
    }
*/
}
