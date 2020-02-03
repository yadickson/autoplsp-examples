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

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleConnection;
import oracle.sql.StructDescriptor;
import oracle.sql.STRUCT;

import org.springframework.stereotype.Component;

/**
 * Class to process object element.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
@Component
@SuppressWarnings({"deprecation"})
public final class OracleObjectUtilImpl
        implements OracleObjectUtil {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object process(
            final Connection connection,
            final String name,
            final Object[] objects
    ) throws SQLException {

        try {

            OracleConnection oracleConn;
            oracleConn = connection.unwrap(OracleConnection.class);

            StructDescriptor descriptor;
            descriptor = StructDescriptor.createDescriptor(
                    name,
                    oracleConn
            );

            return new STRUCT(
                    descriptor,
                    oracleConn,
                    objects
            );

        } catch (Exception ex) {
            throw new SQLException(ex.getMessage(), "0", ex);
        }
    }
}
