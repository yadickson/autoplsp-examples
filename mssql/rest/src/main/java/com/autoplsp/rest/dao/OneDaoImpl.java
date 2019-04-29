package com.autoplsp.rest.dao;

import com.autoplsp.rest.domain.NumericTO;
import java.sql.SQLException;

import plsql.domain.DboSpObtenerVehiculoIN;
import plsql.domain.DboSpObtenerVehiculoOUT;
import plsql.domain.DboFnReturnStringOUT;
import plsql.domain.DboFnReturnStringWithParamIN;
import plsql.domain.DboFnReturnStringWithParamOUT;
import plsql.repository.DboSpInsertElementDAO;

import plsql.repository.DboSpObtenerVehiculoDAO;
import plsql.repository.DboFnReturnStringDAO;
import plsql.repository.DboFnReturnStringWithParamDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.autoplsp.rest.domain.TablaTO;
import com.autoplsp.rest.exception.BusinessException;
import plsql.domain.DboFnListarTablaOUT;
import plsql.domain.DboFnListarTablaReturnValueRS;
import plsql.domain.DboSpInsertElementIN;
import plsql.domain.DboSpInsertNumericTypesIN;
import plsql.domain.DboSpInsertNumericTypesOUT;
import plsql.domain.DboSpListarTablaOUT;
import plsql.domain.DboSpListarTablaIN;
import plsql.domain.DboSpListarTablaReturnValueRS;
import plsql.domain.DboSpNumericTypesOUT;
import plsql.domain.DboSpNumericTypesReturnValueRS;
import plsql.domain.DboSpReadNumericTypesIN;
import plsql.domain.DboSpReadNumericTypesOUT;
import plsql.repository.DboFnListarTablaDAO;
import plsql.repository.DboSpFiltrarVehiculosDAO;
import plsql.repository.DboSpInsertNumericTypesDAO;
import plsql.repository.DboSpListarTablaDAO;
import plsql.repository.DboSpNumericTypesDAO;
import plsql.repository.DboSpReadNumericTypesDAO;

@Repository
public final class OneDaoImpl implements OneDao {

    static final long serialVersionUID = 1L;

    @Autowired
    private DboSpInsertElementDAO insertElementDAO;

    @Autowired
    private DboSpObtenerVehiculoDAO obtenerElementDAO;

    @Autowired
    private DboFnReturnStringDAO returnStringDAO;

    @Autowired
    private DboFnReturnStringWithParamDAO returnStringWithParamDAO;

    @Autowired
    private DboSpFiltrarVehiculosDAO filtrarVehiculosDAO;

    @Autowired
    private DboFnListarTablaDAO fnListarTablaDAO;

    @Autowired
    private DboSpListarTablaDAO listarTablaDAO;

    @Autowired
    private DboSpInsertNumericTypesDAO insertNumericTypesDAO;

    @Autowired
    private DboSpReadNumericTypesDAO readNumericTypesDAO;

    @Autowired
    private DboSpNumericTypesDAO numericTypesDAO;

    @Override
    public String toDo(final String text) {
        return "Full [" + text + "]";
    }

    @Override
    public void insert(final String patente, final String marca, final String modelo) throws BusinessException {

        try {
            DboSpInsertElementIN params = new DboSpInsertElementIN(patente, marca, modelo);
            insertElementDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error insert", ex);
        }

    }

    @Override
    public void update(final Long id, final String name) throws BusinessException {
        /*
        try {
            DboSpTestUpdateIN params = new DboSpTestUpdateIN(id, name);
            spTestUpdateDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error update", ex);
        }
         */
    }

    @Override
    public void read(final Long id) throws BusinessException {

        try {
            DboSpObtenerVehiculoIN params = new DboSpObtenerVehiculoIN(id);
            DboSpObtenerVehiculoOUT out = obtenerElementDAO.execute(params);

            System.out.println("Marca: " + out.getMarca() + " Modelo: " + out.getModelo() + " Patente: " + out.getPatente());

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error read", ex);
        }

    }

    @Override
    public void delete(final Long id) throws BusinessException {
        /*
        try {
            DboSpTestDeleteIN params = new DboSpTestDeleteIN(id);
            spTestDeleteDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error delete", ex);
        }
         */
    }

    @Override
    public void addObject(final Long id, final String name) throws BusinessException {
        /*
        try {
            TestObjectObject object = new TestObjectObject(id, name);
            DboSpTestInsertObjectIN params = new DboSpTestInsertObjectIN(object);
            spTestInsertObjectDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error insert object", ex);
        }
         */
    }

    @Override
    public void addArray(final Long id, final String name) throws BusinessException {
        /*
        try {
            TestObjectObject object = new TestObjectObject(id, name);
            TestArrayTable array = new TestArrayTable();
            array.add(object);
            DboSpTestInsertArrayIN params = new DboSpTestInsertArrayIN(array);
            spTestInsertArrayDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error insert object", ex);
        }
         */
    }

    @Override
    public String getString() throws BusinessException {

        try {

            DboFnReturnStringOUT out = returnStringDAO.execute();
            return out.getReturnValue();

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error get string", ex);
        }

    }

    @Override
    public String getString(final String text) throws BusinessException {

        try {
            DboFnReturnStringWithParamIN params = new DboFnReturnStringWithParamIN(text);
            DboFnReturnStringWithParamOUT out = returnStringWithParamDAO.execute(params);
            return out.getReturnValue();

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error get string", ex);
        }

    }

    @Override
    public java.util.List<TablaTO> getResultTable() throws BusinessException {

        try {

            DboFnListarTablaOUT out = fnListarTablaDAO.execute();

            java.util.List<TablaTO> lista = new java.util.ArrayList<TablaTO>();

            for (DboFnListarTablaReturnValueRS rs : out.getReturnValue()) {

                TablaTO to = new TablaTO();
                to.setId(rs.getId().intValue());
                to.setMarca(rs.getMarca());
                to.setModelo(rs.getModelo());
                to.setPatente(rs.getPatente());
                lista.add(to);
            }

            return lista;

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error get string", ex);
        }

    }

    @Override
    public java.util.List<TablaTO> getResultSet() throws BusinessException {

        try {

            DboSpListarTablaIN params = new DboSpListarTablaIN(10);
            DboSpListarTablaOUT out = listarTablaDAO.execute(params);

            java.util.List<TablaTO> lista = new java.util.ArrayList<TablaTO>();

            for (DboSpListarTablaReturnValueRS rs : out.getReturnValue()) {

                TablaTO to = new TablaTO();
                to.setId(rs.getId().intValue());
                to.setMarca(rs.getMarca());
                to.setModelo(rs.getModelo());
                to.setPatente(rs.getPatente());
                lista.add(to);
            }

            return lista;

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error get resultset", ex);
        }

    }

    @Override
    public Long insertNumericTypes() throws BusinessException {

        try {
            DboSpInsertNumericTypesIN params = new DboSpInsertNumericTypesIN(
                    1,
                    20L,
                    3,
                    4,
                    5,
                    6,
                    7.5F,
                    8.5D,
                    true,
                    10,
                    11);

            DboSpInsertNumericTypesOUT out;
            out = insertNumericTypesDAO.execute(params);

            return out.getId().longValue();

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error insert", ex);
        }

    }

    @Override
    public NumericTO readNumericTypes(final Long id) throws BusinessException {

        try {
            DboSpReadNumericTypesIN params = new DboSpReadNumericTypesIN(id);

            DboSpReadNumericTypesOUT out;
            out = readNumericTypesDAO.execute(params);

            NumericTO numeric = new NumericTO();

            numeric.setId(id);
            numeric.setCInt(out.getCint().intValue());
            numeric.setCBigInt(out.getCbigInt().longValue());

            return numeric;

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error insert", ex);
        }

    }

    @Override
    public java.util.List<NumericTO> getNumericResultSet() throws BusinessException {

        try {

            DboSpNumericTypesOUT out = numericTypesDAO.execute();

            java.util.List<NumericTO> lista = new java.util.ArrayList<NumericTO>();

            for (DboSpNumericTypesReturnValueRS rs : out.getReturnValue()) {

                NumericTO to = new NumericTO();

                to.setCInt(rs.getCint().intValue());
                to.setCBigInt(rs.getCbigInt().longValue());
                lista.add(to);
            }

            return lista;

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error get resultset", ex);
        }

    }

}
