package com.autoplsp.rest.service;

import java.io.Serializable;

import com.autoplsp.rest.domain.TablaTO;
import com.autoplsp.rest.exception.BusinessException;

public interface OneService extends Serializable {

    String toDo(final String text);

    void crud(final Long id, final String name) throws BusinessException;

    void object(final Long id, final String name) throws BusinessException;

    void array(final Long id, final String name) throws BusinessException;

    String getString() throws BusinessException;

    String getString(final String text) throws BusinessException;

    java.util.List<TablaTO> getResultTable() throws BusinessException;

    java.util.List<TablaTO> getResultSet() throws BusinessException;
}
