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
 * DAO for stored procedure.
 *
 * SP_TEST_INSERT_OBJECT
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
public final class SpTestInsertObjectSPImpl
        extends StoredProcedure
        implements SpTestInsertObjectSP {

    /**
     * Full stored procedure name.
     */
    public static final String SPROC_NAME
            = "SP_TEST_INSERT_OBJECT";

    /**
     * Class constructor from jdbcTemplate.
     *
     * @param jdbcTemplate jdbcTemplate
     */
    public SpTestInsertObjectSPImpl(final JdbcTemplate jdbcTemplate) {

        super(jdbcTemplate.getDataSource(), SPROC_NAME);

        setFunction(false);

        SqlParameter piObject;
        SqlOutParameter poCodRetorno;
        SqlOutParameter poMsgRetorno;

        piObject = new SqlParameter(
                "PI_OBJECT",
                oracle.jdbc.OracleTypes.STRUCT
        );

        poCodRetorno = new SqlOutParameter(
                "PO_COD_RETORNO",
                java.sql.Types.NUMERIC
        );

        poMsgRetorno = new SqlOutParameter(
                "PO_MSG_RETORNO",
                java.sql.Types.VARCHAR
        );

        declareParameter(piObject);
        declareParameter(poCodRetorno);
        declareParameter(poMsgRetorno);

        compile();
    }
}
