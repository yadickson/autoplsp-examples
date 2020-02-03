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
 * Bean object for datatype CHAR_OBJECT.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class CharObjectObject {

    /**
     * Field parameter c1.
     */
    private String c1 = null;

    /**
     * Field parameter c2.
     */
    private String c2 = null;

    /**
     * Field parameter c3.
     */
    private String c3 = null;

    /**
     * Field parameter c4.
     */
    private String c4 = null;

    /**
     * Field parameter c5.
     */
    private String c5 = null;

    /**
     * Class Constructor CharObjectObject.
     *
     * @param pC1 set value of c1
     * @param pC2 set value of c2
     * @param pC3 set value of c3
     * @param pC4 set value of c4
     * @param pC5 set value of c5
     */
    public CharObjectObject(
            final String pC1,
            final String pC2,
            final String pC3,
            final String pC4,
            final String pC5
    ) {
        setC1(pC1);
        setC2(pC2);
        setC3(pC3);
        setC4(pC4);
        setC5(pC5);
    }
}
