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
package plsql.object;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface to build object for datatype NUMERIC_OBJECT.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
public interface NumericObjectObjectBuilder {

    /**
     * Getter data object type.
     *
     * @param connection database connection.
     * @param object object to process.
     * @return object processed.
     * @throws SQLException if error
     */
    Object process(
            Connection connection,
            NumericObjectObject object
    ) throws SQLException;
}
