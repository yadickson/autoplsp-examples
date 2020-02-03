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

import plsql.domain.SpTestObjectIN;
import plsql.repository.sp.SpTestObjectSP;
import plsql.util.OracleConnectionUtil;
import plsql.object.CharObjectObjectBuilder;
import plsql.object.NumericObjectObjectBuilder;

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
 * SP_TEST_OBJECT
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
@Repository
@SuppressWarnings({"unchecked"})
public final class SpTestObjectDAOImpl
        implements SpTestObjectDAO {

    /**
     * CharObjectObject builder utility.
     */
    @Autowired
    private CharObjectObjectBuilder charObjectObjectBuilder;

    /**
     * NumericObjectObject builder utility.
     */
    @Autowired
    private NumericObjectObjectBuilder numericObjectObjectBuilder;

    /**
     * The connection util.
     */
    @Autowired
    private OracleConnectionUtil connectionUtil;

    /**
     * Stored procedure.
     *
     * SP_TEST_OBJECT
     *
     */
    @Resource(name = "SpTestObjectSP")
    private SpTestObjectSP procedure;

    /**
     * Execute stored procedure.
     *
     * SP_TEST_OBJECT
     *
     * @param params input parameters
     * @throws SQLException if error.
     */
    @Override
    public void execute(
            final SpTestObjectIN params
    ) throws SQLException {

        Map<String, Object> in = new HashMap<>();

        Connection connection = null;

        try {

            connection = connectionUtil.process();

            Object piC1;
            Object piC2;
            Object poC3;
            Object poC4;

            piC1 = numericObjectObjectBuilder.process(
                    connection,
                    params.getPiC1()
            );

            piC2 = charObjectObjectBuilder.process(
                    connection,
                    params.getPiC2()
            );

            poC3 = numericObjectObjectBuilder.process(
                    connection,
                    params.getPoC3()
            );

            poC4 = charObjectObjectBuilder.process(
                    connection,
                    params.getPoC4()
            );

            in.put("PI_C1",
                    piC1
            );
            in.put("PI_C2",
                    piC2
            );
            in.put("PO_C3",
                    poC3
            );
            in.put("PO_C4",
                    poC4
            );

            procedure.execute(in);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        } finally {
            connectionUtil.release(connection);
        }
    }

}
