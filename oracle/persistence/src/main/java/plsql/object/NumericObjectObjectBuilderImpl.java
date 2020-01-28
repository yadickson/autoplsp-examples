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

import plsql.util.ObjectUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Bean object for datatype NUMERIC_OBJECT.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.26-SNAPSHOT
 */
@Component
public final class NumericObjectObjectBuilderImpl
        implements NumericObjectObjectBuilder {

    /**
     * Object utility.
     */
    @Autowired
    private ObjectUtil objectUtil;

    /**
     * {@inheritDoc}
     */
    @Override
    public Object process(
            final Connection connection,
            final NumericObjectObject object
    ) throws SQLException {

        Object[] objs = new Object[]{
            object.getC1(),
            object.getC2(),
            object.getC3(),
            object.getC4(),
            object.getC5(),
            object.getC6(),
            object.getC7(),
            object.getC9(),
            object.getC10(),
            object.getC11()
        };

        return objectUtil.process(
                connection,
                "NUMERIC_OBJECT",
                objs
        );
    }
}
