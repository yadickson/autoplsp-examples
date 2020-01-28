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
 * Output parameters for stored procedure.
 *
 * SP_TEST_INSERT_ARRAY
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpTestInsertArrayOUT {

    /**
     * Output parameter PO_COD_RETORNO.
     *
     * SP_TEST_INSERT_ARRAY
     */
    private Number poCodRetorno;

    /**
     * Output parameter PO_MSG_RETORNO.
     *
     * SP_TEST_INSERT_ARRAY
     */
    private String poMsgRetorno;

    /**
     * Class constructor SpTestInsertArrayOUT.
     *
     * SP_TEST_INSERT_ARRAY
     *
     * @param pPoCodRetorno set value of PO_COD_RETORNO
     * @param pPoMsgRetorno set value of PO_MSG_RETORNO
     */
    public SpTestInsertArrayOUT(
            final Number pPoCodRetorno,
            final String pPoMsgRetorno
    ) {
        setPoCodRetorno(pPoCodRetorno);
        setPoMsgRetorno(pPoMsgRetorno);
    }
}
