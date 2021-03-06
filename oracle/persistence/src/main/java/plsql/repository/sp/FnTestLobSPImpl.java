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
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

/**
 * DAO for function.
 *
 * FN_TEST_LOB
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
public final class FnTestLobSPImpl
        extends StoredProcedure
        implements FnTestLobSP {

    /**
     * Full function name.
     */
    public static final String SPROC_NAME
            = "FN_TEST_LOB";

    /**
     * Class constructor from jdbcTemplate.
     *
     * @param jdbcTemplate jdbcTemplate
     */
    public FnTestLobSPImpl(final JdbcTemplate jdbcTemplate) {

        super(jdbcTemplate.getDataSource(), SPROC_NAME);

        setFunction(true);

        SqlOutParameter returnValue;
        SqlParameter piC1;
        SqlParameter piC2;
        SqlParameter piC3;
        SqlOutParameter poC4;
        SqlOutParameter poC5;
        SqlOutParameter poC6;

        returnValue = new SqlOutParameter(
                "return_value",
                java.sql.Types.NUMERIC
        );

        piC1 = new SqlParameter(
                "PI_C1",
                java.sql.Types.CLOB
        );

        piC2 = new SqlParameter(
                "PI_C2",
                java.sql.Types.CLOB
        );

        piC3 = new SqlParameter(
                "PI_C3",
                java.sql.Types.BLOB
        );

        poC4 = new SqlOutParameter(
                "PO_C4",
                java.sql.Types.CLOB
        );

        poC5 = new SqlOutParameter(
                "PO_C5",
                java.sql.Types.CLOB
        );

        poC6 = new SqlOutParameter(
                "PO_C6",
                java.sql.Types.BLOB
        );

        declareParameter(returnValue);
        declareParameter(piC1);
        declareParameter(piC2);
        declareParameter(piC3);
        declareParameter(poC4);
        declareParameter(poC5);
        declareParameter(poC6);

        compile();
    }
}
