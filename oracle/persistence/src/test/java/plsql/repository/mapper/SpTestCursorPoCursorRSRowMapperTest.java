package plsql.repository.mapper;

import plsql.domain.SpTestCursorPoCursorRS;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings({"rawtypes", "unchecked"})
public class SpTestCursorPoCursorRSRowMapperTest {

    @Mock
    private java.sql.ResultSet resultSet;

    @Test
    public void testSpTestCursorPoCursorRSRowMapper() throws java.sql.SQLException {
        SpTestCursorPoCursorRSRowMapper mapper = new SpTestCursorPoCursorRSRowMapper();

        Number cNumeric = 1;
        Number cInteger = 2;
        Number cInt = 3;
        Number cSmallinteger = 4;
        Number cDecimal = 5;
        Number cDec = 6;
        Number cFloat = 7;
        Number cReal = 8;
        String cChar = "C_CHAR";
        String cClob = "C_CLOB";
        String cNclob = "C_NCLOB";
        byte[] cBlob = new byte[0];

        Mockito.when(resultSet.getObject(Mockito.eq(1))).thenReturn(cNumeric);
        Mockito.when(resultSet.getObject(Mockito.eq(2))).thenReturn(cInteger);
        Mockito.when(resultSet.getObject(Mockito.eq(3))).thenReturn(cInt);
        Mockito.when(resultSet.getObject(Mockito.eq(4))).thenReturn(cSmallinteger);
        Mockito.when(resultSet.getObject(Mockito.eq(5))).thenReturn(cDecimal);
        Mockito.when(resultSet.getObject(Mockito.eq(6))).thenReturn(cDec);
        Mockito.when(resultSet.getObject(Mockito.eq(7))).thenReturn(cFloat);
        Mockito.when(resultSet.getObject(Mockito.eq(8))).thenReturn(cReal);
        Mockito.when(resultSet.getString(Mockito.eq(9))).thenReturn(cChar);
        Mockito.when(resultSet.getString(Mockito.eq(10))).thenReturn(cClob);
        Mockito.when(resultSet.getString(Mockito.eq(11))).thenReturn(cNclob);
        Mockito.when(resultSet.getBytes(Mockito.eq(12))).thenReturn(cBlob);

        SpTestCursorPoCursorRS result = mapper.mapRow(resultSet, 0);

        Assert.assertNotNull(result);
        Assert.assertSame(cNumeric, result.getCNumeric());
        Assert.assertSame(cInteger, result.getCInteger());
        Assert.assertSame(cInt, result.getCInt());
        Assert.assertSame(cSmallinteger, result.getCSmallinteger());
        Assert.assertSame(cDecimal, result.getCDecimal());
        Assert.assertSame(cDec, result.getCDec());
        Assert.assertSame(cFloat, result.getCFloat());
        Assert.assertSame(cReal, result.getCReal());
        Assert.assertSame(cChar, result.getCChar());
        Assert.assertSame(cClob, result.getCClob());
        Assert.assertSame(cNclob, result.getCNclob());
        Assert.assertSame(cBlob, result.getCBlob());
    }
}
