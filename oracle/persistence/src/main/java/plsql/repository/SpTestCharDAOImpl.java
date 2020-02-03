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

import plsql.domain.SpTestCharIN;
import plsql.repository.sp.SpTestCharSP;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * DAO implementation for stored procedure.
 *
 * SP_TEST_CHAR
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@Repository
@SuppressWarnings({"unchecked"})
public final class SpTestCharDAOImpl
        implements SpTestCharDAO {

    /**
     * Stored procedure.
     *
     * SP_TEST_CHAR
     *
     */
    @Resource(name = "SpTestCharSP")
    private SpTestCharSP procedure;

    /**
     * Execute stored procedure.
     *
     * SP_TEST_CHAR
     *
     * @param params input parameters
     * @throws SQLException if error.
     */
    @Override
    public void execute(
            final SpTestCharIN params
    ) throws SQLException {

        Map<String, Object> in = new HashMap<>();

        try {

            in.put("PI_C1", params.getPiC1());
            in.put("PI_C2", params.getPiC2());
            in.put("PI_C3", params.getPiC3());
            in.put("PI_C4", params.getPiC4());
            in.put("PI_C5", params.getPiC5());

            procedure.execute(in);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        }
    }

}
