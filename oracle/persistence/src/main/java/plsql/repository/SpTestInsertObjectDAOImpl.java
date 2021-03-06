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

import plsql.domain.SpTestInsertObjectIN;
import plsql.domain.SpTestInsertObjectOUT;
import plsql.repository.sp.SpTestInsertObjectSP;
import plsql.util.OracleCheckResult;
import plsql.util.OracleConnectionUtil;
import plsql.object.TestObjectObjectBuilder;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 * DAO implementation for stored procedure.
 *
 * SP_TEST_INSERT_OBJECT
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
@Repository
@SuppressWarnings({"unchecked"})
public final class SpTestInsertObjectDAOImpl
        implements SpTestInsertObjectDAO {

    /**
     * TestObjectObject builder utility.
     */
    @Autowired
    private TestObjectObjectBuilder testObjectObjectBuilder;

    /**
     * Check result utility.
     */
    @Autowired
    private OracleCheckResult checkResult;

    /**
     * The connection util.
     */
    @Autowired
    private OracleConnectionUtil connectionUtil;

    /**
     * Stored procedure.
     *
     * SP_TEST_INSERT_OBJECT
     *
     */
    @Resource(name = "SpTestInsertObjectSP")
    private SpTestInsertObjectSP procedure;

    /**
     * Execute stored procedure.
     *
     * SP_TEST_INSERT_OBJECT
     *
     * @param params input parameters
     * @return output parameters
     * @throws SQLException if error.
     */
    @Override
    public SpTestInsertObjectOUT execute(
            final SpTestInsertObjectIN params
    ) throws SQLException {

        Map<String, Object> in = new HashMap<>();
        Map<String, Object> out;

        Connection connection = null;

        try {

            connection = connectionUtil.process();

            Object piObject;

            piObject = testObjectObjectBuilder.process(
                    connection,
                    params.getPiObject()
            );

            in.put("PI_OBJECT",
                    piObject
            );

            out = procedure.execute(in);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        } finally {
            connectionUtil.release(connection);
        }

        checkResult.check(out);

        SpTestInsertObjectOUT result;
        result = new SpTestInsertObjectOUT();

        Number poCodRetorno;
        String poMsgRetorno;

        poCodRetorno = (Number) out.get("PO_COD_RETORNO");
        poMsgRetorno = (String) out.get("PO_MSG_RETORNO");

        result.setPoCodRetorno(poCodRetorno);
        result.setPoMsgRetorno(poMsgRetorno);

        return result;
    }

}
