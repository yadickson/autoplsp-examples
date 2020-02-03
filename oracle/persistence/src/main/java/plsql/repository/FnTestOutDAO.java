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
package plsql.repository;

import plsql.domain.FnTestOutOUT;

import java.sql.SQLException;

/**
 * DAO interface for function.
 *
 * FN_TEST_OUT
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
public interface FnTestOutDAO {

    /**
     * Execute stored procedure.
     *
     * @return output parameters
     * @throws SQLException if error
     */
    FnTestOutOUT execute() throws SQLException;
}
