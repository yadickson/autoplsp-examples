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
package plsql.repository.sp;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

/**
 * DAO for stored procedure.
 *
 * SP_TEST_OUT
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
public final class SpTestOutSPImpl
        extends StoredProcedure
        implements SpTestOutSP {

    /**
     * Full stored procedure name.
     */
    public static final String SPROC_NAME
            = "SP_TEST_OUT";

    /**
     * Class constructor from jdbcTemplate.
     *
     * @param jdbcTemplate jdbcTemplate
     */
    public SpTestOutSPImpl(final JdbcTemplate jdbcTemplate) {

        super(jdbcTemplate.getDataSource(), SPROC_NAME);

        setFunction(false);

        fillStep1();
        fillStep2();

        compile();
    }

    /**
     * Fill parameters declaration for step 1.
     */
    private void fillStep1() {

        SqlOutParameter poC1;
        SqlOutParameter poC2;
        SqlOutParameter poC3;
        SqlOutParameter poC4;
        SqlOutParameter poC5;
        SqlOutParameter poC6;
        SqlOutParameter poC7;
        SqlOutParameter poC8;
        SqlOutParameter poC9;
        SqlOutParameter poC10;

        poC1 = new SqlOutParameter(
                "PO_C1",
                java.sql.Types.VARCHAR
        );

        poC2 = new SqlOutParameter(
                "PO_C2",
                java.sql.Types.VARCHAR
        );

        poC3 = new SqlOutParameter(
                "PO_C3",
                java.sql.Types.VARCHAR
        );

        poC4 = new SqlOutParameter(
                "PO_C4",
                java.sql.Types.VARCHAR
        );

        poC5 = new SqlOutParameter(
                "PO_C5",
                java.sql.Types.VARCHAR
        );

        poC6 = new SqlOutParameter(
                "PO_C6",
                java.sql.Types.NUMERIC
        );

        poC7 = new SqlOutParameter(
                "PO_C7",
                java.sql.Types.NUMERIC
        );

        poC8 = new SqlOutParameter(
                "PO_C8",
                java.sql.Types.NUMERIC
        );

        poC9 = new SqlOutParameter(
                "PO_C9",
                java.sql.Types.NUMERIC
        );

        poC10 = new SqlOutParameter(
                "PO_C10",
                java.sql.Types.NUMERIC
        );

        declareParameter(poC1);
        declareParameter(poC2);
        declareParameter(poC3);
        declareParameter(poC4);
        declareParameter(poC5);
        declareParameter(poC6);
        declareParameter(poC7);
        declareParameter(poC8);
        declareParameter(poC9);
        declareParameter(poC10);
    }

    /**
     * Fill parameters declaration for step 2.
     */
    private void fillStep2() {

        SqlOutParameter poC11;
        SqlOutParameter poC12;
        SqlOutParameter poC13;
        SqlOutParameter poC14;
        SqlOutParameter poC15;
        SqlOutParameter counter;
        SqlOutParameter message;

        poC11 = new SqlOutParameter(
                "PO_C11",
                java.sql.Types.NUMERIC
        );

        poC12 = new SqlOutParameter(
                "PO_C12",
                java.sql.Types.NUMERIC
        );

        poC13 = new SqlOutParameter(
                "PO_C13",
                java.sql.Types.NUMERIC
        );

        poC14 = new SqlOutParameter(
                "PO_C14",
                java.sql.Types.NUMERIC
        );

        poC15 = new SqlOutParameter(
                "PO_C15",
                java.sql.Types.NUMERIC
        );

        counter = new SqlOutParameter(
                "COUNTER",
                java.sql.Types.NUMERIC
        );

        message = new SqlOutParameter(
                "MESSAGE",
                java.sql.Types.VARCHAR
        );

        declareParameter(poC11);
        declareParameter(poC12);
        declareParameter(poC13);
        declareParameter(poC14);
        declareParameter(poC15);
        declareParameter(counter);
        declareParameter(message);
    }
}
