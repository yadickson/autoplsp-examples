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
 * FN_TEST_LOB
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FnTestLobOUT {

    /**
     * Output parameter return_value.
     *
     * FN_TEST_LOB
     */
    private Number returnValue;

    /**
     * Output parameter PO_C4.
     *
     * FN_TEST_LOB
     */
    private String poC4;

    /**
     * Output parameter PO_C5.
     *
     * FN_TEST_LOB
     */
    private String poC5;

    /**
     * Output parameter PO_C6.
     *
     * FN_TEST_LOB
     */
    private byte[] poC6;

    /**
     * Class constructor FnTestLobOUT.
     *
     * FN_TEST_LOB
     *
     * @param pReturnValue set value of return_value
     * @param pPoC4 set value of PO_C4
     * @param pPoC5 set value of PO_C5
     * @param pPoC6 set value of PO_C6
     */
    public FnTestLobOUT(
            final Number pReturnValue,
            final String pPoC4,
            final String pPoC5,
            final byte[] pPoC6
    ) {
        setReturnValue(pReturnValue);
        setPoC4(pPoC4);
        setPoC5(pPoC5);
        setPoC6(pPoC6);
    }
}
