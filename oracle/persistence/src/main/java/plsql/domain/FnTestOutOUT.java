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
 * Output parameters for function.
 *
 * FN_TEST_OUT
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FnTestOutOUT {

    /**
     * Output parameter return_value.
     *
     * FN_TEST_OUT
     */
    private Number returnValue;

    /**
     * Output parameter PO_C1.
     *
     * FN_TEST_OUT
     */
    private String poC1;

    /**
     * Output parameter PO_C2.
     *
     * FN_TEST_OUT
     */
    private String poC2;

    /**
     * Output parameter PO_C3.
     *
     * FN_TEST_OUT
     */
    private String poC3;

    /**
     * Output parameter PO_C4.
     *
     * FN_TEST_OUT
     */
    private String poC4;

    /**
     * Output parameter PO_C5.
     *
     * FN_TEST_OUT
     */
    private String poC5;

    /**
     * Output parameter PO_C6.
     *
     * FN_TEST_OUT
     */
    private Number poC6;

    /**
     * Output parameter PO_C7.
     *
     * FN_TEST_OUT
     */
    private Number poC7;

    /**
     * Output parameter PO_C8.
     *
     * FN_TEST_OUT
     */
    private Number poC8;

    /**
     * Output parameter PO_C9.
     *
     * FN_TEST_OUT
     */
    private Number poC9;

    /**
     * Output parameter PO_C10.
     *
     * FN_TEST_OUT
     */
    private Number poC10;

    /**
     * Output parameter PO_C11.
     *
     * FN_TEST_OUT
     */
    private Number poC11;

    /**
     * Output parameter PO_C12.
     *
     * FN_TEST_OUT
     */
    private Number poC12;

    /**
     * Output parameter PO_C13.
     *
     * FN_TEST_OUT
     */
    private Number poC13;

    /**
     * Output parameter PO_C14.
     *
     * FN_TEST_OUT
     */
    private Number poC14;

    /**
     * Output parameter PO_C15.
     *
     * FN_TEST_OUT
     */
    private Number poC15;

    /**
     * Output parameter COUNTER.
     *
     * FN_TEST_OUT
     */
    private Number counter;

    /**
     * Output parameter MESSAGE.
     *
     * FN_TEST_OUT
     */
    private String message;

    /**
     * Class constructor FnTestOutOUT.
     *
     * FN_TEST_OUT
     *
     * @param pReturnValue set value of return_value
     * @param pPoC1 set value of PO_C1
     * @param pPoC2 set value of PO_C2
     * @param pPoC3 set value of PO_C3
     * @param pPoC4 set value of PO_C4
     * @param pPoC5 set value of PO_C5
     * @param pPoC6 set value of PO_C6
     * @param pPoC7 set value of PO_C7
     * @param pPoC8 set value of PO_C8
     * @param pPoC9 set value of PO_C9
     * @param pPoC10 set value of PO_C10
     * @param pPoC11 set value of PO_C11
     * @param pPoC12 set value of PO_C12
     * @param pPoC13 set value of PO_C13
     * @param pPoC14 set value of PO_C14
     * @param pPoC15 set value of PO_C15
     * @param pCounter set value of COUNTER
     * @param pMessage set value of MESSAGE
     */
    public FnTestOutOUT(
            final Number pReturnValue,
            final String pPoC1,
            final String pPoC2,
            final String pPoC3,
            final String pPoC4,
            final String pPoC5,
            final Number pPoC6,
            final Number pPoC7,
            final Number pPoC8,
            final Number pPoC9,
            final Number pPoC10,
            final Number pPoC11,
            final Number pPoC12,
            final Number pPoC13,
            final Number pPoC14,
            final Number pPoC15,
            final Number pCounter,
            final String pMessage
    ) {
        setReturnValue(pReturnValue);
        setPoC1(pPoC1);
        setPoC2(pPoC2);
        setPoC3(pPoC3);
        setPoC4(pPoC4);
        setPoC5(pPoC5);
        setPoC6(pPoC6);
        setPoC7(pPoC7);
        setPoC8(pPoC8);
        setPoC9(pPoC9);
        setPoC10(pPoC10);
        setPoC11(pPoC11);
        setPoC12(pPoC12);
        setPoC13(pPoC13);
        setPoC14(pPoC14);
        setPoC15(pPoC15);
        setCounter(pCounter);
        setMessage(pMessage);
    }
}
