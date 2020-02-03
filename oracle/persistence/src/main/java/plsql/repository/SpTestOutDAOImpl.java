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

import plsql.domain.SpTestOutOUT;
import plsql.repository.sp.SpTestOutSP;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * DAO implementation for stored procedure.
 *
 * SP_TEST_OUT
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@Repository
@SuppressWarnings({"unchecked"})
public final class SpTestOutDAOImpl
        implements SpTestOutDAO {

    /**
     * Stored procedure.
     *
     * SP_TEST_OUT
     *
     */
    @Resource(name = "SpTestOutSP")
    private SpTestOutSP procedure;

    /**
     * Execute stored procedure.
     *
     * SP_TEST_OUT
     *
     * @return output parameters
     * @throws SQLException if error.
     */
    @Override
    public SpTestOutOUT execute() throws SQLException {

        Map<String, Object> in = new HashMap<>();
        Map<String, Object> out;

        try {

            out = procedure.execute(in);

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        }

        SpTestOutOUT result;
        result = new SpTestOutOUT();

        String poC1;
        String poC2;
        String poC3;
        String poC4;
        String poC5;
        Number poC6;
        Number poC7;
        Number poC8;
        Number poC9;
        Number poC10;
        Number poC11;
        Number poC12;
        Number poC13;
        Number poC14;
        Number poC15;
        Number counter;
        String message;

        poC1 = (String) out.get("PO_C1");
        poC2 = (String) out.get("PO_C2");
        poC3 = (String) out.get("PO_C3");
        poC4 = (String) out.get("PO_C4");
        poC5 = (String) out.get("PO_C5");
        poC6 = (Number) out.get("PO_C6");
        poC7 = (Number) out.get("PO_C7");
        poC8 = (Number) out.get("PO_C8");
        poC9 = (Number) out.get("PO_C9");
        poC10 = (Number) out.get("PO_C10");
        poC11 = (Number) out.get("PO_C11");
        poC12 = (Number) out.get("PO_C12");
        poC13 = (Number) out.get("PO_C13");
        poC14 = (Number) out.get("PO_C14");
        poC15 = (Number) out.get("PO_C15");
        counter = (Number) out.get("COUNTER");
        message = (String) out.get("MESSAGE");

        result.setPoC1(poC1);
        result.setPoC2(poC2);
        result.setPoC3(poC3);
        result.setPoC4(poC4);
        result.setPoC5(poC5);
        result.setPoC6(poC6);
        result.setPoC7(poC7);
        result.setPoC8(poC8);
        result.setPoC9(poC9);
        result.setPoC10(poC10);
        result.setPoC11(poC11);
        result.setPoC12(poC12);
        result.setPoC13(poC13);
        result.setPoC14(poC14);
        result.setPoC15(poC15);
        result.setCounter(counter);
        result.setMessage(message);

        return result;
    }

}
