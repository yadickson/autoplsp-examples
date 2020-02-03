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

import java.util.Date;

/**
 * Utility to process date class.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
public final class OracleSafeDate {

    /**
     * Class constructor.
     */
    protected OracleSafeDate() {

    }

    /**
     * Process date.
     *
     * @param oracleInput input date to process.
     * @return date.
     */
    public static Date process(final Date oracleInput) {

        if (oracleInput == null) {
            return null;
        }

        return (Date) oracleInput.clone();
    }

}
