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

import plsql.domain.SpTestUpdateIN;
import plsql.domain.SpTestUpdateOUT;
import plsql.repository.sp.SpTestUpdateSP;
import plsql.util.CheckResult;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 * DAO implementation for stored procedure.
 *
 * SP_TEST_UPDATE
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@Repository
@SuppressWarnings({"unchecked"})
public final class SpTestUpdateDAOImpl
        implements SpTestUpdateDAO {

    /**
     * Check result utility.
     */
    @Autowired
    private CheckResult checkResult;

    /**
     * Stored procedure.
     *
     * SP_TEST_UPDATE
     *
     */
    @Resource(name = "SpTestUpdateSP")
    private SpTestUpdateSP procedure;

    /**
     * Execute stored procedure.
     *
     * SP_TEST_UPDATE
     *
     * @param params input parameters
     * @return output parameters
     * @throws SQLException if error.
     */
    @Override
    public SpTestUpdateOUT execute(
            final SpTestUpdateIN params
    ) throws SQLException {

        Map<String, Object> in = new HashMap<>();
        Map<String, Object> out;

        try {

            in.put("PI_ID", params.getPiId());
            in.put("PI_NAME", params.getPiName());

            out = procedure.execute(in);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        }

        checkResult.check(out);

        SpTestUpdateOUT result;
        result = new SpTestUpdateOUT();

        Number poCodRetorno;
        String poMsgRetorno;

        poCodRetorno = (Number) out.get("PO_COD_RETORNO");
        poMsgRetorno = (String) out.get("PO_MSG_RETORNO");

        result.setPoCodRetorno(poCodRetorno);
        result.setPoMsgRetorno(poMsgRetorno);

        return result;
    }

}
