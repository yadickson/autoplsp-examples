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
 * SP_TEST_READ
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpTestReadOUT {

    /**
     * Output parameter PO_NAME.
     *
     * SP_TEST_READ
     */
    private String poName;

    /**
     * Output parameter PO_COD_RETORNO.
     *
     * SP_TEST_READ
     */
    private Number poCodRetorno;

    /**
     * Output parameter PO_MSG_RETORNO.
     *
     * SP_TEST_READ
     */
    private String poMsgRetorno;

    /**
     * Class constructor SpTestReadOUT.
     *
     * SP_TEST_READ
     *
     * @param pPoName set value of PO_NAME
     * @param pPoCodRetorno set value of PO_COD_RETORNO
     * @param pPoMsgRetorno set value of PO_MSG_RETORNO
     */
    public SpTestReadOUT(
            final String pPoName,
            final Number pPoCodRetorno,
            final String pPoMsgRetorno
    ) {
        setPoName(pPoName);
        setPoCodRetorno(pPoCodRetorno);
        setPoMsgRetorno(pPoMsgRetorno);
    }
}
