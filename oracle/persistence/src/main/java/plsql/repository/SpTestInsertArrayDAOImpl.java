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

import plsql.array.TestArrayTableBuilder;
import plsql.domain.SpTestInsertArrayIN;
import plsql.domain.SpTestInsertArrayOUT;
import plsql.repository.sp.SpTestInsertArraySP;
import plsql.util.OracleCheckResult;
import plsql.util.OracleConnectionUtil;

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
 * SP_TEST_INSERT_ARRAY
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
@Repository
@SuppressWarnings({"unchecked"})
public final class SpTestInsertArrayDAOImpl
        implements SpTestInsertArrayDAO {

    /**
     * TestArrayTable builder utility.
     */
    @Autowired
    private TestArrayTableBuilder testArrayTableBuilder;

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
     * SP_TEST_INSERT_ARRAY
     *
     */
    @Resource(name = "SpTestInsertArraySP")
    private SpTestInsertArraySP procedure;

    /**
     * Execute stored procedure.
     *
     * SP_TEST_INSERT_ARRAY
     *
     * @param params input parameters
     * @return output parameters
     * @throws SQLException if error.
     */
    @Override
    public SpTestInsertArrayOUT execute(
            final SpTestInsertArrayIN params
    ) throws SQLException {

        Map<String, Object> in = new HashMap<>();
        Map<String, Object> out;

        Connection connection = null;

        try {

            connection = connectionUtil.process();

            Object piArray;

            piArray = testArrayTableBuilder.process(
                    connection,
                    params.getPiArray()
            );

            in.put("PI_ARRAY",
                    piArray
            );

            out = procedure.execute(in);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        } finally {
            connectionUtil.release(connection);
        }

        checkResult.check(out);

        SpTestInsertArrayOUT result;
        result = new SpTestInsertArrayOUT();

        Number poCodRetorno;
        String poMsgRetorno;

        poCodRetorno = (Number) out.get("PO_COD_RETORNO");
        poMsgRetorno = (String) out.get("PO_MSG_RETORNO");

        result.setPoCodRetorno(poCodRetorno);
        result.setPoMsgRetorno(poMsgRetorno);

        return result;
    }

}
