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
package plsql.repository;

import plsql.domain.SpTestDeleteIN;
import plsql.domain.SpTestDeleteOUT;
import plsql.repository.sp.SpTestDeleteSP;
import plsql.util.OracleCheckResult;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 * DAO implementation for stored procedure.
 *
 * SP_TEST_DELETE
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@Repository
@SuppressWarnings({"unchecked"})
public final class SpTestDeleteDAOImpl
        implements SpTestDeleteDAO {

    /**
     * Check result utility.
     */
    @Autowired
    private OracleCheckResult checkResult;

    /**
     * Stored procedure.
     *
     * SP_TEST_DELETE
     *
     */
    @Resource(name = "SpTestDeleteSP")
    private SpTestDeleteSP procedure;

    /**
     * Execute stored procedure.
     *
     * SP_TEST_DELETE
     *
     * @param params input parameters
     * @return output parameters
     * @throws SQLException if error.
     */
    @Override
    public SpTestDeleteOUT execute(
            final SpTestDeleteIN params
    ) throws SQLException {

        Map<String, Object> in = new HashMap<>();
        Map<String, Object> out;

        try {

            in.put("PI_ID",
                    params.getPiId()
            );

            out = procedure.execute(in);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        }

        checkResult.check(out);

        SpTestDeleteOUT result;
        result = new SpTestDeleteOUT();

        Number poCodRetorno;
        String poMsgRetorno;

        poCodRetorno = (Number) out.get("PO_COD_RETORNO");
        poMsgRetorno = (String) out.get("PO_MSG_RETORNO");

        result.setPoCodRetorno(poCodRetorno);
        result.setPoMsgRetorno(poMsgRetorno);

        return result;
    }

}
