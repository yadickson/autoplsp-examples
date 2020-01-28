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
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

/**
 * DAO for stored procedure.
 *
 * SP_TEST_OBJECT
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
public final class SpTestObjectSPImpl
        extends StoredProcedure
        implements SpTestObjectSP {

    /**
     * Full stored procedure name.
     */
    public static final String SPROC_NAME
            = "SP_TEST_OBJECT";

    /**
     * Class constructor from jdbcTemplate.
     *
     * @param jdbcTemplate jdbcTemplate
     */
    public SpTestObjectSPImpl(final JdbcTemplate jdbcTemplate) {

        super(jdbcTemplate.getDataSource(), SPROC_NAME);

        setFunction(false);

        SqlParameter piC1;
        SqlParameter piC2;
        SqlParameter poC3;
        SqlParameter poC4;

        piC1 = new SqlParameter(
                "PI_C1",
                oracle.jdbc.OracleTypes.STRUCT
        );

        piC2 = new SqlParameter(
                "PI_C2",
                oracle.jdbc.OracleTypes.STRUCT
        );

        poC3 = new SqlParameter(
                "PO_C3",
                oracle.jdbc.OracleTypes.STRUCT
        );

        poC4 = new SqlParameter(
                "PO_C4",
                oracle.jdbc.OracleTypes.STRUCT
        );

        declareParameter(piC1);
        declareParameter(piC2);
        declareParameter(poC3);
        declareParameter(poC4);

        compile();
    }
}
