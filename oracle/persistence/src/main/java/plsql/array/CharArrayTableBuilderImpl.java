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
package plsql.array;

import java.sql.Connection;
import java.sql.SQLException;

import plsql.util.ArrayUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Builder class to make array for datatype CHAR_ARRAY.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@Component
public final class CharArrayTableBuilderImpl
        implements CharArrayTableBuilder {

    /**
     * Array utility.
     */
    @Autowired
    private ArrayUtil arrayUtil;

    /**
     * {@inheritDoc}
     */
    @Override
    public Object process(
            final Connection connection,
            final CharArrayTable array
    ) throws SQLException {

        Object[] input = new Object[array.size()];

        int i = 0;

        for (String obj : array) {
            input[i++] = obj;
        }

        return arrayUtil.process(
                connection,
                "CHAR_ARRAY",
                input
        );
    }
}