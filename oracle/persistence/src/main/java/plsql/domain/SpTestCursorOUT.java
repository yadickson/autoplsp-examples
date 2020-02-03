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

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Output parameters for stored procedure.
 *
 * SP_TEST_CURSOR
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpTestCursorOUT {

    /**
     * Output parameter PO_CURSOR.
     *
     * SP_TEST_CURSOR
     */
    private List<SpTestCursorPoCursorRS> poCursor;

    /**
     * Output parameter PO_COD_RETORNO.
     *
     * SP_TEST_CURSOR
     */
    private Number poCodRetorno;

    /**
     * Output parameter PO_MSG_RETORNO.
     *
     * SP_TEST_CURSOR
     */
    private String poMsgRetorno;

    /**
     * Class constructor SpTestCursorOUT.
     *
     * SP_TEST_CURSOR
     *
     * @param pPoCursor set value of PO_CURSOR
     * @param pPoCodRetorno set value of PO_COD_RETORNO
     * @param pPoMsgRetorno set value of PO_MSG_RETORNO
     */
    public SpTestCursorOUT(
            final List<SpTestCursorPoCursorRS> pPoCursor,
            final Number pPoCodRetorno,
            final String pPoMsgRetorno
    ) {
        setPoCursor(pPoCursor);
        setPoCodRetorno(pPoCodRetorno);
        setPoMsgRetorno(pPoMsgRetorno);
    }
}
