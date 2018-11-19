package com.autoplsp.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autoplsp.rest.dao.OneDao;
import com.autoplsp.rest.domain.NumericTO;
import com.autoplsp.rest.domain.TablaTO;
import com.autoplsp.rest.exception.BusinessException;
import java.util.List;

@Service
public final class OneServiceImpl implements OneService {

    static final long serialVersionUID = 1L;

    @Autowired
    private OneDao oneDao;

    @Override
    public String toDo(final String text) {
        return oneDao.toDo(text);
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public void crud(final Long id, final String name) throws BusinessException {
        oneDao.insert("xxyyzz", "ford", "abc1");
        oneDao.insert("xxyyzz", "ford", "abc2");
        oneDao.insert("xxyyzz", "ford", "abc3");
        oneDao.insert("xxyyzz", "ford", "abc4");
        oneDao.insert("xxyyzz", "ford", "abc5");
        oneDao.update(id, name);
        oneDao.read(id);
        oneDao.delete(2L);
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public void object(final Long id, final String name) throws BusinessException {
        oneDao.addObject(id, name);
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public void array(final Long id, final String name) throws BusinessException {
        oneDao.addArray(id, name);
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public String getString() throws BusinessException {
        return oneDao.getString();
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public String getString(final String text) throws BusinessException {
        return oneDao.getString(text);
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public java.util.List<TablaTO> getResultTable() throws BusinessException {
        return oneDao.getResultTable();
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public java.util.List<TablaTO> getResultSet() throws BusinessException {
        return oneDao.getResultSet();
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public Long insertNumericTypes() throws BusinessException {
        return oneDao.insertNumericTypes();
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public NumericTO readNumericTypes(Long id) throws BusinessException {
        return oneDao.readNumericTypes(id);
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public List<NumericTO> getNumericResultSet() throws BusinessException {
        return oneDao.getNumericResultSet();
    }
}
