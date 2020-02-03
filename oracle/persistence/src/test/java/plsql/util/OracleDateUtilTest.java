package plsql.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OracleDateUtilTest {

    @InjectMocks
    OracleDateUtilImpl dateUtil;

    @Test
    public void testInputNull() {
        Assert.assertNull(dateUtil.process(null));
    }

    @Test
    public void testInputNotNull() {
        java.util.Date date = new java.util.Date();
        Object result = dateUtil.process(date);
        Assert.assertNotNull(result);
    }
}
