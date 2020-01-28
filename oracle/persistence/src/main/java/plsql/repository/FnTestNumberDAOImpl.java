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

import plsql.domain.FnTestNumberIN;
import plsql.domain.FnTestNumberOUT;
import plsql.repository.sp.FnTestNumberSP;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * DAO implementation for function.
 *
 * FN_TEST_NUMBER
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@Repository
@SuppressWarnings({"unchecked"})
public final class FnTestNumberDAOImpl
        implements FnTestNumberDAO {

    /**
     * Function.
     *
     * FN_TEST_NUMBER
     *
     */
    @Resource(name = "FnTestNumberSP")
    private FnTestNumberSP function;

    /**
     * Execute function.
     *
     * FN_TEST_NUMBER
     *
     * @param params input parameters
     * @return output parameters
     * @throws SQLException if error.
     */
    @Override
    public FnTestNumberOUT execute(
            final FnTestNumberIN params
    ) throws SQLException {

        Map<String, Object> in = new HashMap<>();
        Map<String, Object> out;

        try {

            in.put("PI_C1", params.getPiC1());
            in.put("PI_C2", params.getPiC2());
            in.put("PI_C3", params.getPiC3());
            in.put("PI_C4", params.getPiC4());
            in.put("PI_C5", params.getPiC5());
            in.put("PI_C6", params.getPiC6());
            in.put("PI_C7", params.getPiC7());
            in.put("PI_C9", params.getPiC9());
            in.put("PI_C10", params.getPiC10());
            in.put("PI_C11", params.getPiC11());

            out = function.execute(in);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        }

        FnTestNumberOUT result;
        result = new FnTestNumberOUT();

        Number returnValue;

        returnValue = (Number) out.get("return_value");

        result.setReturnValue(returnValue);

        return result;
    }

}
