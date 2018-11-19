package com.autoplsp.rest.dao;

import java.io.Serializable;

import com.autoplsp.rest.domain.NumericTO;
import com.autoplsp.rest.domain.TablaTO;
import com.autoplsp.rest.exception.BusinessException;

public interface OneDao extends Serializable {

    String toDo(final String text);

    void insert(final String patente, final String marca, final String modelo) throws BusinessException;

    void update(final Long id, final String name) throws BusinessException;

    void read(final Long id) throws BusinessException;

    void delete(final Long id) throws BusinessException;

    void addObject(final Long id, final String name) throws BusinessException;

    void addArray(final Long id, final String name) throws BusinessException;

    String getString() throws BusinessException;

    String getString(final String text) throws BusinessException;

    java.util.List<TablaTO> getResultTable() throws BusinessException;

    java.util.List<TablaTO> getResultSet() throws BusinessException;

    Long insertNumericTypes() throws BusinessException;

    NumericTO readNumericTypes(final Long id) throws BusinessException;

    java.util.List<NumericTO> getNumericResultSet() throws BusinessException;
    
}
