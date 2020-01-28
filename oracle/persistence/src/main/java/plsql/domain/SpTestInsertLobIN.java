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
 * SP_TEST_INSERT_LOB
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpTestInsertLobIN {

    /**
     * Input parameter PI_CLOB.
     *
     * SP_TEST_INSERT_LOB
     */
    private String piClob;

    /**
     * Input parameter PI_NCLOB.
     *
     * SP_TEST_INSERT_LOB
     */
    private String piNclob;

    /**
     * Input parameter PI_BLOB.
     *
     * SP_TEST_INSERT_LOB
     */
    private byte[] piBlob;

    /**
     * Class constructor SpTestInsertLobIN.
     *
     * SP_TEST_INSERT_LOB
     *
     * @param pPiClob set value of PI_CLOB
     * @param pPiNclob set value of PI_NCLOB
     * @param pPiBlob set value of PI_BLOB
     */
    public SpTestInsertLobIN(
            final String pPiClob,
            final String pPiNclob,
            final byte[] pPiBlob
    ) {
        setPiClob(pPiClob);
        setPiNclob(pPiNclob);
        setPiBlob(pPiBlob);
    }
}
