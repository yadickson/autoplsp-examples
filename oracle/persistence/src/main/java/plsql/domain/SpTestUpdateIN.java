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
 * SP_TEST_UPDATE
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpTestUpdateIN {

    /**
     * Input parameter PI_ID.
     *
     * SP_TEST_UPDATE
     */
    private Number piId;

    /**
     * Input parameter PI_NAME.
     *
     * SP_TEST_UPDATE
     */
    private String piName;

    /**
     * Class constructor SpTestUpdateIN.
     *
     * SP_TEST_UPDATE
     *
     * @param pPiId set value of PI_ID
     * @param pPiName set value of PI_NAME
     */
    public SpTestUpdateIN(
            final Number pPiId,
            final String pPiName
    ) {
        setPiId(pPiId);
        setPiName(pPiName);
    }
}
