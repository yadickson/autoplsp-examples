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

import plsql.domain.FnTestCharIN;
import plsql.domain.FnTestCharOUT;
import plsql.repository.sp.FnTestCharSP;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * DAO implementation for function.
 *
 * FN_TEST_CHAR
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
@Repository
@SuppressWarnings({"unchecked"})
public final class FnTestCharDAOImpl
        implements FnTestCharDAO {

    /**
     * Function.
     *
     * FN_TEST_CHAR
     *
     */
    @Resource(name = "FnTestCharSP")
    private FnTestCharSP function;

    /**
     * Execute function.
     *
     * FN_TEST_CHAR
     *
     * @param params input parameters
     * @return output parameters
     * @throws SQLException if error.
     */
    @Override
    public FnTestCharOUT execute(
            final FnTestCharIN params
    ) throws SQLException {

        Map<String, Object> in = new HashMap<>();
        Map<String, Object> out;

        try {

            in.put("PI_C1",
                    params.getPiC1()
            );
            in.put("PI_C2",
                    params.getPiC2()
            );
            in.put("PI_C3",
                    params.getPiC3()
            );
            in.put("PI_C4",
                    params.getPiC4()
            );
            in.put("PI_C5",
                    params.getPiC5()
            );

            out = function.execute(in);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        }

        FnTestCharOUT result;
        result = new FnTestCharOUT();

        Number returnValue;

        returnValue = (Number) out.get("return_value");

        result.setReturnValue(returnValue);

        return result;
    }

}
