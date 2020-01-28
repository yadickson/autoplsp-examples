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

import plsql.array.CharArrayObjectTable;
import plsql.array.CharArrayTable;
import plsql.array.NumericArrayObjectTable;
import plsql.array.NumericArrayTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Input parameters for stored procedure.
 *
 * SP_TEST_ARRAY
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpTestArrayIN {

    /**
     * Input parameter PI_C1.
     *
     * SP_TEST_ARRAY
     */
    private NumericArrayTable piC1;

    /**
     * Input parameter PI_C2.
     *
     * SP_TEST_ARRAY
     */
    private CharArrayTable piC2;

    /**
     * Input parameter PO_C3.
     *
     * SP_TEST_ARRAY
     */
    private NumericArrayTable poC3;

    /**
     * Input parameter PO_C4.
     *
     * SP_TEST_ARRAY
     */
    private CharArrayTable poC4;

    /**
     * Input parameter PO_C5.
     *
     * SP_TEST_ARRAY
     */
    private NumericArrayObjectTable poC5;

    /**
     * Input parameter PO_C6.
     *
     * SP_TEST_ARRAY
     */
    private CharArrayObjectTable poC6;

    /**
     * Class constructor SpTestArrayIN.
     *
     * SP_TEST_ARRAY
     *
     * @param pPiC1 set value of PI_C1
     * @param pPiC2 set value of PI_C2
     * @param pPoC3 set value of PO_C3
     * @param pPoC4 set value of PO_C4
     * @param pPoC5 set value of PO_C5
     * @param pPoC6 set value of PO_C6
     */
    public SpTestArrayIN(
            final NumericArrayTable pPiC1,
            final CharArrayTable pPiC2,
            final NumericArrayTable pPoC3,
            final CharArrayTable pPoC4,
            final NumericArrayObjectTable pPoC5,
            final CharArrayObjectTable pPoC6
    ) {
        setPiC1(pPiC1);
        setPiC2(pPiC2);
        setPoC3(pPoC3);
        setPoC4(pPoC4);
        setPoC5(pPoC5);
        setPoC6(pPoC6);
    }
}
