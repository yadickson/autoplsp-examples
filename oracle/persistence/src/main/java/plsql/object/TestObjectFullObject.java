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

import plsql.util.OracleSafeDate;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Bean object for datatype TEST_OBJECT_FULL.
 *
 * @author Maven Auto PLSQL/SP Generator Plugin
 * @version 1.7.29-SNAPSHOT
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class TestObjectFullObject {

    /**
     * Field parameter id.
     */
    private Number id = null;

    /**
     * Field parameter name.
     */
    private String name = null;

    /**
     * Field parameter strClob.
     */
    private String strClob = null;

    /**
     * Field parameter byteBlob.
     */
    private byte[] byteBlob = null;

    /**
     * Field parameter fecha.
     */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Date fecha = null;

    /**
     * Class Constructor TestObjectFullObject.
     *
     * @param pId set value of id
     * @param pName set value of name
     * @param pStrClob set value of strClob
     * @param pByteBlob set value of byteBlob
     * @param pFecha set value of fecha
     */
    public TestObjectFullObject(
            final Number pId,
            final String pName,
            final String pStrClob,
            final byte[] pByteBlob,
            final Date pFecha
    ) {
        setId(pId);
        setName(pName);
        setStrClob(pStrClob);
        setByteBlob(pByteBlob);
        setFecha(pFecha);
    }

    /**
     * Getter for fecha.
     *
     * @return fecha
     */
    public Date getFecha() {
        return OracleSafeDate.process(fecha);
    }

    /**
     * Setter for fecha.
     *
     * @param pFecha fecha to set
     */
    public void setFecha(final Date pFecha) {
        this.fecha = OracleSafeDate.process(pFecha);
    }
}
