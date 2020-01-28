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

import java.sql.Blob;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import org.springframework.stereotype.Component;

/**
 * Class to process blob element.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@Component
public final class BlobUtilImpl implements BlobUtil {

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

}