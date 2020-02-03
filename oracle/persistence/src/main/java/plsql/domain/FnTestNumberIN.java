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
 * Input parameters for function.
 *
 * FN_TEST_NUMBER
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FnTestNumberIN {

    /**
     * Input parameter PI_C1.
     *
     * FN_TEST_NUMBER
     */
    private Number piC1;

    /**
     * Input parameter PI_C2.
     *
     * FN_TEST_NUMBER
     */
    private Number piC2;

    /**
     * Input parameter PI_C3.
     *
     * FN_TEST_NUMBER
     */
    private Number piC3;

    /**
     * Input parameter PI_C4.
     *
     * FN_TEST_NUMBER
     */
    private Number piC4;

    /**
     * Input parameter PI_C5.
     *
     * FN_TEST_NUMBER
     */
    private Number piC5;

    /**
     * Input parameter PI_C6.
     *
     * FN_TEST_NUMBER
     */
    private Number piC6;

    /**
     * Input parameter PI_C7.
     *
     * FN_TEST_NUMBER
     */
    private Number piC7;

    /**
     * Input parameter PI_C9.
     *
     * FN_TEST_NUMBER
     */
    private Number piC9;

    /**
     * Input parameter PI_C10.
     *
     * FN_TEST_NUMBER
     */
    private Number piC10;

    /**
     * Input parameter PI_C11.
     *
     * FN_TEST_NUMBER
     */
    private Number piC11;

    /**
     * Class constructor FnTestNumberIN.
     *
     * FN_TEST_NUMBER
     *
     * @param pPiC1 set value of PI_C1
     * @param pPiC2 set value of PI_C2
     * @param pPiC3 set value of PI_C3
     * @param pPiC4 set value of PI_C4
     * @param pPiC5 set value of PI_C5
     * @param pPiC6 set value of PI_C6
     * @param pPiC7 set value of PI_C7
     * @param pPiC9 set value of PI_C9
     * @param pPiC10 set value of PI_C10
     * @param pPiC11 set value of PI_C11
     */
    public FnTestNumberIN(
            final Number pPiC1,
            final Number pPiC2,
            final Number pPiC3,
            final Number pPiC4,
            final Number pPiC5,
            final Number pPiC6,
            final Number pPiC7,
            final Number pPiC9,
            final Number pPiC10,
            final Number pPiC11
    ) {
        setPiC1(pPiC1);
        setPiC2(pPiC2);
        setPiC3(pPiC3);
        setPiC4(pPiC4);
        setPiC5(pPiC5);
        setPiC6(pPiC6);
        setPiC7(pPiC7);
        setPiC9(pPiC9);
        setPiC10(pPiC10);
        setPiC11(pPiC11);
    }
}
