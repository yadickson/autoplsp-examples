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
package plsql.util;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * Check result from store procedure or function.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
@Component
public final class OracleCheckResultImpl
        implements OracleCheckResult {

    /**
     * Success constant value.
     */
    private static final String ORACLE_SUCCESS_CODE = "0";

    /**
     * Code to check.
     */
    private static final String ORACLE_CODE = "PO_COD_RETORNO";

    /**
     * Message to check.
     */
    private static final String ORACLE_MESSAGE = "PO_MSG_RETORNO";

    /**
     * {@inheritDoc}
     */
    @Override
    public void check(final Map<String, Object> map) throws SQLException {

        if (map == null) {
            return;
        }

        Number oracleCode = (Number) map.get(ORACLE_CODE);

        if (oracleCode == null) {
            return;
        }

        if (!ORACLE_SUCCESS_CODE.equals(oracleCode.toString())) {
            String description = (String) map.get(ORACLE_MESSAGE);
            throw new SQLException(description, oracleCode.toString());
        }
    }

}
