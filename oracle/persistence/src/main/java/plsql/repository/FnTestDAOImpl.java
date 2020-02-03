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

import plsql.domain.FnTestOUT;
import plsql.repository.sp.FnTestSP;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * DAO implementation for function.
 *
 * FN_TEST
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@Repository
@SuppressWarnings({"unchecked"})
public final class FnTestDAOImpl
        implements FnTestDAO {

    /**
     * Function.
     *
     * FN_TEST
     *
     */
    @Resource(name = "FnTestSP")
    private FnTestSP function;

    /**
     * Execute function.
     *
     * FN_TEST
     *
     * @return output parameters
     * @throws SQLException if error.
     */
    @Override
    public FnTestOUT execute() throws SQLException {

        Map<String, Object> in = new HashMap<>();
        Map<String, Object> out;

        try {

            out = function.execute(in);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        }

        FnTestOUT result;
        result = new FnTestOUT();

        Number returnValue;

        returnValue = (Number) out.get("return_value");

        result.setReturnValue(returnValue);

        return result;
    }

}
