package plsql.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OracleSafeDateTest {

    @Test
    public void testCreate() {
        Assert.assertNotNull(new OracleSafeDate());
    }

    @Test
    public void testInputNull() {
        Assert.assertNull(OracleSafeDate.process(null));
    }

    @Test
    public void testInputNotNull() {
        java.util.Date date = new java.util.Date();
        java.util.Date result = OracleSafeDate.process(date);
        Assert.assertNotNull(result);
        Assert.assertNotSame(date, result);
        Assert.assertEquals(date, result);
    }
}
