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

import plsql.util.OracleObjectUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Bean object for datatype NUMERIC_OBJECT.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@Component
public final class NumericObjectObjectBuilderImpl
        implements NumericObjectObjectBuilder {

    /**
     * Object utility.
     */
    @Autowired
    private OracleObjectUtil objectUtil;

    /**
     * {@inheritDoc}
     */
    @Override
    public Object process(
            final Connection connection,
            final NumericObjectObject object
    ) throws SQLException {

        Object c1;
        Object c2;
        Object c3;
        Object c4;
        Object c5;
        Object c6;
        Object c7;
        Object c9;
        Object c10;
        Object c11;

        c1 = object.getC1();
        c2 = object.getC2();
        c3 = object.getC3();
        c4 = object.getC4();
        c5 = object.getC5();
        c6 = object.getC6();
        c7 = object.getC7();
        c9 = object.getC9();
        c10 = object.getC10();
        c11 = object.getC11();

        Object[] objs = new Object[]{
            c1,
            c2,
            c3,
            c4,
            c5,
            c6,
            c7,
            c9,
            c10,
            c11
        };

        return objectUtil.process(
                connection,
                "NUMERIC_OBJECT",
                objs
        );
    }
}
