package com.autoplsp.rest.service;

import com.autoplsp.rest.domain.CursorTO;
import java.io.Serializable;

import com.autoplsp.rest.exception.BusinessException;

public interface OneService extends Serializable {

    String toDo(final String text);

    void crud(final Long id, final String name) throws BusinessException;

    void object(final Long id, final String name) throws BusinessException;

    void array(final Long id, final String name) throws BusinessException;

    java.util.List<CursorTO> getCursor() throws BusinessException;

}
