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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Bean object for datatype NUMERIC_OBJECT.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class NumericObjectObject {

    /**
     * Field parameter c1.
     */
    private Number c1 = null;

    /**
     * Field parameter c2.
     */
    private Number c2 = null;

    /**
     * Field parameter c3.
     */
    private Number c3 = null;

    /**
     * Field parameter c4.
     */
    private Number c4 = null;

    /**
     * Field parameter c5.
     */
    private Number c5 = null;

    /**
     * Field parameter c6.
     */
    private Number c6 = null;

    /**
     * Field parameter c7.
     */
    private Number c7 = null;

    /**
     * Field parameter c9.
     */
    private Number c9 = null;

    /**
     * Field parameter c10.
     */
    private Number c10 = null;

    /**
     * Field parameter c11.
     */
    private Number c11 = null;

    /**
     * Class Constructor NumericObjectObject.
     *
     * @param pC1 set value of c1
     * @param pC2 set value of c2
     * @param pC3 set value of c3
     * @param pC4 set value of c4
     * @param pC5 set value of c5
     * @param pC6 set value of c6
     * @param pC7 set value of c7
     * @param pC9 set value of c9
     * @param pC10 set value of c10
     * @param pC11 set value of c11
     */
    public NumericObjectObject(
            final Number pC1,
            final Number pC2,
            final Number pC3,
            final Number pC4,
            final Number pC5,
            final Number pC6,
            final Number pC7,
            final Number pC9,
            final Number pC10,
            final Number pC11
    ) {
        setC1(pC1);
        setC2(pC2);
        setC3(pC3);
        setC4(pC4);
        setC5(pC5);
        setC6(pC6);
        setC7(pC7);
        setC9(pC9);
        setC10(pC10);
        setC11(pC11);
    }
}
