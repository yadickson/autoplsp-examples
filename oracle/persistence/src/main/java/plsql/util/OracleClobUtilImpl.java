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

import java.io.InputStream;
import java.io.Writer;

import java.sql.Connection;
import java.sql.Clob;

import org.apache.commons.io.IOUtils;

import oracle.jdbc.OracleConnection;
import oracle.sql.CLOB;

import org.springframework.stereotype.Component;

/**
 * Class to process clob element.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@Component
@SuppressWarnings({"deprecation"})
public final class OracleClobUtilImpl
        implements OracleClobUtil {

    /**
     * {@inheritDoc}
     */
    @Override
    public String process(final Object object) {

        if (object == null) {
            return null;
        }

        Clob clob = (Clob) object;
        String result;

        try (InputStream stream = clob.getAsciiStream()) {
            result = IOUtils.toString(stream, "UTF-8");
        } catch (Exception ex) {
            result = null;
        }

        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Object process(
        final Connection connection,
        final String param
    ) {

        CLOB clob = null;

        try {

            OracleConnection oConn = connection.unwrap(OracleConnection.class);

            clob = CLOB.createTemporary(
                    oConn,
                    false,
                    CLOB.DURATION_SESSION
            );

            try (Writer writer = clob.getCharacterOutputStream()) {
                writer.write(param.toCharArray());
            } catch (Exception ex) {
                clob = null;
            }

        } catch (Exception ex) {
            clob = null;
        }

        return clob;
    }
}
