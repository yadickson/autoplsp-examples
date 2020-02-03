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

import java.sql.Connection;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

import org.springframework.stereotype.Component;

/**
 * Class to process connection transaction.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.27-SNAPSHOT
 */
@Component
public final class OracleConnectionUtilImpl implements
        OracleConnectionUtil {

    /**
     * JDBC template to use.
     */
    @Resource(name = "oracleJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public Connection process() {

        Connection oracleConn;

        try {

            oracleConn = DataSourceUtils.getConnection(
                    jdbcTemplate.getDataSource()
            );

        } catch (Exception ex) {
            oracleConn = null;
        }

        return oracleConn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean release(final Connection connection) {

        boolean oracleResult;

        try {

            DataSourceUtils.releaseConnection(
                    connection,
                    jdbcTemplate.getDataSource()
            );

            oracleResult = true;

        } catch (Exception ex) {
            oracleResult = false;
        }

        return oracleResult;
    }

}
