/*
 * Copyright (C) 2019 Yadickson Soto
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package plsql.repository.mapper;

import plsql.cursor.SpTestCursorPoCursorRS;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Resultset mapper for stored procedure.
 *
 * SP_TEST_CURSOR
 *
 * PO_CURSOR
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
public final class SpTestCursorPoCursorRSRowMapper
        implements RowMapper<SpTestCursorPoCursorRS> {

    /**
     * Column position.
     */
    private static final int C_NUMERIC = 1;

    /**
     * Column position.
     */
    private static final int C_INTEGER = 2;

    /**
     * Column position.
     */
    private static final int C_INT = 3;

    /**
     * Column position.
     */
    private static final int C_SMALLINTEGER = 4;

    /**
     * Column position.
     */
    private static final int C_DECIMAL = 5;

    /**
     * Column position.
     */
    private static final int C_DEC = 6;

    /**
     * Column position.
     */
    private static final int C_FLOAT = 7;

    /**
     * Column position.
     */
    private static final int C_REAL = 8;

    /**
     * Column position.
     */
    private static final int C_CHAR = 9;

    /**
     * Column position.
     */
    private static final int C_CLOB = 10;

    /**
     * Column position.
     */
    private static final int C_NCLOB = 11;

    /**
     * Column position.
     */
    private static final int C_BLOB = 12;

    /**
     * Resultset mapper.
     *
     * @param resultSet resultset.
     * @param i row number.
     * @throws SQLException if error.
     * @return object
     */
    @Override
    public SpTestCursorPoCursorRS mapRow(
            final ResultSet resultSet,
            final int i
    ) throws SQLException {

        SpTestCursorPoCursorRS row;
        row = new SpTestCursorPoCursorRS();

        fillStep1(resultSet, row);
        fillStep2(resultSet, row);

        return row;
    }

    /**
     * Fill row values for step 1.
     *
     * @param resultSet resultset.
     * @param row row to fill.
     * @throws SQLException if error.
     */
    private void fillStep1(
        final ResultSet resultSet,
        final SpTestCursorPoCursorRS row
    ) throws SQLException {

        Number cNumeric;
        Number cInteger;
        Number cInt;
        Number cSmallinteger;
        Number cDecimal;
        Number cDec;
        Number cFloat;
        Number cReal;
        String cChar;
        String cClob;

        cNumeric = (Number) resultSet.getObject(C_NUMERIC);
        cInteger = (Number) resultSet.getObject(C_INTEGER);
        cInt = (Number) resultSet.getObject(C_INT);
        cSmallinteger = (Number) resultSet.getObject(C_SMALLINTEGER);
        cDecimal = (Number) resultSet.getObject(C_DECIMAL);
        cDec = (Number) resultSet.getObject(C_DEC);
        cFloat = (Number) resultSet.getObject(C_FLOAT);
        cReal = (Number) resultSet.getObject(C_REAL);
        cChar = resultSet.getString(C_CHAR);
        cClob = resultSet.getString(C_CLOB);

        row.setCNumeric(cNumeric);
        row.setCInteger(cInteger);
        row.setCInt(cInt);
        row.setCSmallinteger(cSmallinteger);
        row.setCDecimal(cDecimal);
        row.setCDec(cDec);
        row.setCFloat(cFloat);
        row.setCReal(cReal);
        row.setCChar(cChar);
        row.setCClob(cClob);
    }

    /**
     * Fill row values for step 2.
     *
     * @param resultSet resultset.
     * @param row row to fill.
     * @throws SQLException if error.
     */
    private void fillStep2(
        final ResultSet resultSet,
        final SpTestCursorPoCursorRS row
    ) throws SQLException {

        String cNclob;
        byte[] cBlob;

        cNclob = resultSet.getString(C_NCLOB);
        cBlob = resultSet.getBytes(C_BLOB);

        row.setCNclob(cNclob);
        row.setCBlob(cBlob);
    }
}
