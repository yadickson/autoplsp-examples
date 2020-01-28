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
 * Input parameters for stored procedure.
 *
 * SP_TEST_CHAR
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpTestCharIN {

    /**
     * Input parameter PI_C1.
     *
     * SP_TEST_CHAR
     */
    private String piC1;

    /**
     * Input parameter PI_C2.
     *
     * SP_TEST_CHAR
     */
    private String piC2;

    /**
     * Input parameter PI_C3.
     *
     * SP_TEST_CHAR
     */
    private String piC3;

    /**
     * Input parameter PI_C4.
     *
     * SP_TEST_CHAR
     */
    private String piC4;

    /**
     * Input parameter PI_C5.
     *
     * SP_TEST_CHAR
     */
    private String piC5;

    /**
     * Class constructor SpTestCharIN.
     *
     * SP_TEST_CHAR
     *
     * @param pPiC1 set value of PI_C1
     * @param pPiC2 set value of PI_C2
     * @param pPiC3 set value of PI_C3
     * @param pPiC4 set value of PI_C4
     * @param pPiC5 set value of PI_C5
     */
    public SpTestCharIN(
            final String pPiC1,
            final String pPiC2,
            final String pPiC3,
            final String pPiC4,
            final String pPiC5
    ) {
        setPiC1(pPiC1);
        setPiC2(pPiC2);
        setPiC3(pPiC3);
        setPiC4(pPiC4);
        setPiC5(pPiC5);
    }
}
