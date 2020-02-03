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
package plsql.domain;

import plsql.object.TestObjectObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Input parameters for stored procedure.
 *
 * SP_TEST_INSERT_OBJECT
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SpTestInsertObjectIN {

    /**
     * Input parameter PI_OBJECT.
     *
     * SP_TEST_INSERT_OBJECT
     */
    private TestObjectObject piObject;

    /**
     * Class constructor SpTestInsertObjectIN.
     *
     * SP_TEST_INSERT_OBJECT
     *
     * @param pPiObject set value of PI_OBJECT
     */
    public SpTestInsertObjectIN(
            final TestObjectObject pPiObject
    ) {
        setPiObject(pPiObject);
    }
}
