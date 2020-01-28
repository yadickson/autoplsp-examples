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

import plsql.object.CharObjectObject;
import plsql.object.NumericObjectObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Input parameters for stored procedure.
 *
 * SP_TEST_OBJECT
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpTestObjectIN {

    /**
     * Input parameter PI_C1.
     *
     * SP_TEST_OBJECT
     */
    private NumericObjectObject piC1;

    /**
     * Input parameter PI_C2.
     *
     * SP_TEST_OBJECT
     */
    private CharObjectObject piC2;

    /**
     * Input parameter PO_C3.
     *
     * SP_TEST_OBJECT
     */
    private NumericObjectObject poC3;

    /**
     * Input parameter PO_C4.
     *
     * SP_TEST_OBJECT
     */
    private CharObjectObject poC4;

    /**
     * Class constructor SpTestObjectIN.
     *
     * SP_TEST_OBJECT
     *
     * @param pPiC1 set value of PI_C1
     * @param pPiC2 set value of PI_C2
     * @param pPoC3 set value of PO_C3
     * @param pPoC4 set value of PO_C4
     */
    public SpTestObjectIN(
            final NumericObjectObject pPiC1,
            final CharObjectObject pPiC2,
            final NumericObjectObject pPoC3,
            final CharObjectObject pPoC4
    ) {
        setPiC1(pPiC1);
        setPiC2(pPiC2);
        setPoC3(pPoC3);
        setPoC4(pPoC4);
    }
}
