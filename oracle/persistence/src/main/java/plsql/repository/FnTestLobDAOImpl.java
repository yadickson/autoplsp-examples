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

import plsql.domain.FnTestLobIN;
import plsql.domain.FnTestLobOUT;
import plsql.repository.sp.FnTestLobSP;
import plsql.util.BlobUtil;
import plsql.util.ClobUtil;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 * DAO implementation for function.
 *
 * FN_TEST_LOB
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@Repository
@SuppressWarnings({"unchecked"})
public final class FnTestLobDAOImpl
        implements FnTestLobDAO {

    /**
     * Blob utility.
     */
    @Autowired
    private BlobUtil blobUtil;

    /**
     * Clob utility.
     */
    @Autowired
    private ClobUtil clobUtil;

    /**
     * Function.
     *
     * FN_TEST_LOB
     *
     */
    @Resource(name = "FnTestLobSP")
    private FnTestLobSP function;

    /**
     * Execute function.
     *
     * FN_TEST_LOB
     *
     * @param params input parameters
     * @return output parameters
     * @throws SQLException if error.
     */
    @Override
    public FnTestLobOUT execute(
            final FnTestLobIN params
    ) throws SQLException {

        Map<String, Object> in = new HashMap<>();
        Map<String, Object> out;

        try {

            in.put("PI_C1", params.getPiC1());
            in.put("PI_C2", params.getPiC2());
            in.put("PI_C3", params.getPiC3());

            out = function.execute(in);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        }

        FnTestLobOUT result;
        result = new FnTestLobOUT();

        Number returnValue;
        String poC4;
        String poC5;
        byte[] poC6;

        returnValue = (Number) out.get("return_value");
        poC4 = clobUtil.process(out.get("PO_C4"));
        poC5 = clobUtil.process(out.get("PO_C5"));
        poC6 = blobUtil.process(out.get("PO_C6"));

        result.setReturnValue(returnValue);
        result.setPoC4(poC4);
        result.setPoC5(poC5);
        result.setPoC6(poC6);

        return result;
    }

}
