package com.autoplsp.rest.dao;

import com.autoplsp.rest.domain.NumericTO;
import java.sql.SQLException;

import plsql.domain.SpObtenerVehiculoIN;
import plsql.domain.SpObtenerVehiculoOUT;
import plsql.domain.FnReturnStringOUT;
import plsql.domain.FnReturnStringWithParamIN;
import plsql.domain.FnReturnStringWithParamOUT;
import plsql.repository.SpInsertElementDAO;

import plsql.repository.SpObtenerVehiculoDAO;
import plsql.repository.FnReturnStringDAO;
import plsql.repository.FnReturnStringWithParamDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.autoplsp.rest.domain.TablaTO;
import com.autoplsp.rest.exception.BusinessException;
import plsql.domain.FnListarTablaOUT;
import plsql.domain.FnListarTablaReturnValueRS;
import plsql.domain.SpInsertElementIN;
import plsql.domain.SpInsertNumericTypesIN;
import plsql.domain.SpInsertNumericTypesOUT;
import plsql.domain.SpListarTablaOUT;
import plsql.domain.SpListarTablaIN;
import plsql.domain.SpListarTablaReturnValueRS;
import plsql.domain.SpNumericTypesOUT;
import plsql.domain.SpNumericTypesReturnValueRS;
import plsql.domain.SpReadNumericTypesIN;
import plsql.domain.SpReadNumericTypesOUT;
import plsql.repository.FnListarTablaDAO;
import plsql.repository.SpFiltrarVehiculosDAO;
import plsql.repository.SpInsertNumericTypesDAO;
import plsql.repository.SpListarTablaDAO;
import plsql.repository.SpNumericTypesDAO;
import plsql.repository.SpReadNumericTypesDAO;

@Repository
public final class OneDaoImpl implements OneDao {

    static final long serialVersionUID = 1L;

    @Autowired
    private SpInsertElementDAO insertElementDAO;

    @Autowired
    private SpObtenerVehiculoDAO obtenerElementDAO;

    @Autowired
    private FnReturnStringDAO returnStringDAO;

    @Autowired
    private FnReturnStringWithParamDAO returnStringWithParamDAO;

    @Autowired
    private SpFiltrarVehiculosDAO filtrarVehiculosDAO;

    @Autowired
    private FnListarTablaDAO fnListarTablaDAO;

    @Autowired
    private SpListarTablaDAO listarTablaDAO;

    @Autowired
    private SpInsertNumericTypesDAO insertNumericTypesDAO;

    @Autowired
    private SpReadNumericTypesDAO readNumericTypesDAO;

    @Autowired
    private SpNumericTypesDAO numericTypesDAO;

    @Override
    public String toDo(final String text) {
        return "Full [" + text + "]";
    }

    @Override
    public void insert(final String patente, final String marca, final String modelo) throws BusinessException {

        try {
            SpInsertElementIN params = new SpInsertElementIN(patente, marca, modelo);
            insertElementDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error insert", ex);
        }

    }

    @Override
    public void update(final Long id, final String name) throws BusinessException {
        /*
        try {
            SpTestUpdateIN params = new SpTestUpdateIN(id, name);
            spTestUpdateDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error update", ex);
        }
         */
    }

    @Override
    public void read(final Long id) throws BusinessException {

        try {
            SpObtenerVehiculoIN params = new SpObtenerVehiculoIN(id);
            SpObtenerVehiculoOUT out = obtenerElementDAO.execute(params);

            System.out.println("Marca: " + out.getMarca() + " Modelo: " + out.getModelo() + " Patente: " + out.getPatente());

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error read", ex);
        }

    }

    @Override
    public void delete(final Long id) throws BusinessException {
        /*
        try {
            SpTestDeleteIN params = new SpTestDeleteIN(id);
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
            SpTestInsertObjectIN params = new SpTestInsertObjectIN(object);
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
            SpTestInsertArrayIN params = new SpTestInsertArrayIN(array);
            spTestInsertArrayDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error insert object", ex);
        }
         */
    }

    @Override
    public String getString() throws BusinessException {

        try {

            FnReturnStringOUT out = returnStringDAO.execute();
            return out.getReturnValue();

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error get string", ex);
        }

    }

    @Override
    public String getString(final String text) throws BusinessException {

        try {
            FnReturnStringWithParamIN params = new FnReturnStringWithParamIN(text);
            FnReturnStringWithParamOUT out = returnStringWithParamDAO.execute(params);
            return out.getReturnValue();

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error get string", ex);
        }

    }

    @Override
    public java.util.List<TablaTO> getResultTable() throws BusinessException {

        try {

            FnListarTablaOUT out = fnListarTablaDAO.execute();

            java.util.List<TablaTO> lista = new java.util.ArrayList<TablaTO>();

            for (FnListarTablaReturnValueRS rs : out.getReturnValue()) {

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

            SpListarTablaIN params = new SpListarTablaIN(10);
            SpListarTablaOUT out = listarTablaDAO.execute(params);

            java.util.List<TablaTO> lista = new java.util.ArrayList<TablaTO>();

            for (SpListarTablaReturnValueRS rs : out.getReturnValue()) {

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
            SpInsertNumericTypesIN params = new SpInsertNumericTypesIN(
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

            SpInsertNumericTypesOUT out;
            out = insertNumericTypesDAO.execute(params);

            return out.getId().longValue();

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error insert", ex);
        }

    }

    @Override
    public NumericTO readNumericTypes(final Long id) throws BusinessException {

        try {
            SpReadNumericTypesIN params = new SpReadNumericTypesIN(id);

            SpReadNumericTypesOUT out;
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

            SpNumericTypesOUT out = numericTypesDAO.execute();

            java.util.List<NumericTO> lista = new java.util.ArrayList<NumericTO>();

            for (SpNumericTypesReturnValueRS rs : out.getReturnValue()) {

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
