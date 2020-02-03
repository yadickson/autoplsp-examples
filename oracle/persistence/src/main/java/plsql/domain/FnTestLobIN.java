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
 * FN_TEST_LOB
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class FnTestLobIN {

    /**
     * Input parameter PI_C1.
     *
     * FN_TEST_LOB
     */
    private String piC1;

    /**
     * Input parameter PI_C2.
     *
     * FN_TEST_LOB
     */
    private String piC2;

    /**
     * Input parameter PI_C3.
     *
     * FN_TEST_LOB
     */
    private byte[] piC3;

    /**
     * Class constructor FnTestLobIN.
     *
     * FN_TEST_LOB
     *
     * @param pPiC1 set value of PI_C1
     * @param pPiC2 set value of PI_C2
     * @param pPiC3 set value of PI_C3
     */
    public FnTestLobIN(
            final String pPiC1,
            final String pPiC2,
            final byte[] pPiC3
    ) {
        setPiC1(pPiC1);
        setPiC2(pPiC2);
        setPiC3(pPiC3);
    }
}
