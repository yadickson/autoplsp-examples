package com.autoplsp.rest.dao;

import com.autoplsp.rest.domain.CursorTO;
import java.io.Serializable;

import com.autoplsp.rest.exception.BusinessException;

public interface OneDao extends Serializable {

    String toDo(final String text);

    void insert(final Long id, final String name) throws BusinessException;

    void update(final Long id, final String name) throws BusinessException;

    void read(final Long id) throws BusinessException;

    void delete(final Long id) throws BusinessException;

    void addObject(final Long id, final String name) throws BusinessException;

    void addArray(final Long id, final String name) throws BusinessException;

    java.util.List<CursorTO> getCursor() throws BusinessException;
}
