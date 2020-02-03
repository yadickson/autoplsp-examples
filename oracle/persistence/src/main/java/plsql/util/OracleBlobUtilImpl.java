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
import java.io.OutputStream;

import java.sql.Blob;
import java.sql.Connection;

import org.apache.commons.io.IOUtils;

import oracle.jdbc.OracleConnection;
import oracle.sql.BLOB;

import org.springframework.stereotype.Component;

/**
 * Class to process blob element.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@Component
@SuppressWarnings({"deprecation"})
public final class OracleBlobUtilImpl
        implements OracleBlobUtil {

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] process(final Object object) {

        if (object == null) {
            return null;
        }

        Blob blob = (Blob) object;
        byte[] result;

        try (InputStream stream = blob.getBinaryStream()) {
            result = IOUtils.toByteArray(stream, blob.length());
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
        final byte[] param
    ) {
        BLOB blob = null;

        try {

            OracleConnection oracleConn;
            oracleConn = connection.unwrap(OracleConnection.class);

            blob = BLOB.createTemporary(
                    oracleConn,
                    false,
                    BLOB.DURATION_SESSION
            );

            try (OutputStream oracleStream = blob.getBinaryOutputStream()) {
                oracleStream.write(param);
            } catch (Exception ex) {
                blob = null;
            }

        } catch (Exception ex) {
            blob = null;
        }

        return blob;
    }

}
