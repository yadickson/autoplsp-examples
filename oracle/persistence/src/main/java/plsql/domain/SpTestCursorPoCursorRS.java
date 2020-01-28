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
package plsql.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * DataSet parameter for stored procedure.
 *
 * SP_TEST_CURSOR
 *
 * PO_CURSOR
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpTestCursorPoCursorRS {

    /**
     * Column C_NUMERIC.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private Number cNumeric;

    /**
     * Column C_INTEGER.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private Number cInteger;

    /**
     * Column C_INT.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private Number cInt;

    /**
     * Column C_SMALLINTEGER.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private Number cSmallinteger;

    /**
     * Column C_DECIMAL.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private Number cDecimal;

    /**
     * Column C_DEC.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private Number cDec;

    /**
     * Column C_FLOAT.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private Number cFloat;

    /**
     * Column C_REAL.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private Number cReal;

    /**
     * Column C_CHAR.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private String cChar;

    /**
     * Column C_CLOB.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private String cClob;

    /**
     * Column C_NCLOB.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private String cNclob;

    /**
     * Column C_BLOB.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     */
    private byte[] cBlob;

    /**
     * Class constructor SpTestCursorPoCursorRS.
     *
     * SP_TEST_CURSOR
     *
     * PO_CURSOR
     *
     * @param cCNumeric set value of C_NUMERIC
     * @param cCInteger set value of C_INTEGER
     * @param cCInt set value of C_INT
     * @param cCSmallinteger set value of C_SMALLINTEGER
     * @param cCDecimal set value of C_DECIMAL
     * @param cCDec set value of C_DEC
     * @param cCFloat set value of C_FLOAT
     * @param cCReal set value of C_REAL
     * @param cCChar set value of C_CHAR
     * @param cCClob set value of C_CLOB
     * @param cCNclob set value of C_NCLOB
     * @param cCBlob set value of C_BLOB
     */
    public SpTestCursorPoCursorRS(
            final Number cCNumeric,
            final Number cCInteger,
            final Number cCInt,
            final Number cCSmallinteger,
            final Number cCDecimal,
            final Number cCDec,
            final Number cCFloat,
            final Number cCReal,
            final String cCChar,
            final String cCClob,
            final String cCNclob,
            final byte[] cCBlob
    ) {
        setCNumeric(cCNumeric);
        setCInteger(cCInteger);
        setCInt(cCInt);
        setCSmallinteger(cCSmallinteger);
        setCDecimal(cCDecimal);
        setCDec(cCDec);
        setCFloat(cCFloat);
        setCReal(cCReal);
        setCChar(cCChar);
        setCClob(cCClob);
        setCNclob(cCNclob);
        setCBlob(cCBlob);
    }
}
