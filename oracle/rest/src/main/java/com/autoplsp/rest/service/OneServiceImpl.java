package com.autoplsp.rest.service;

import com.autoplsp.rest.dao.OneDao;
import com.autoplsp.rest.domain.CursorTO;
import com.autoplsp.rest.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public final class OneServiceImpl implements OneService {

    static final long serialVersionUID = 1L;

    @Autowired
    private OneDao oneDao;

    @Override
    public String toDo(final String text) {
        return oneDao.toDo(text);
    }

    @Transactional (rollbackFor = BusinessException.class)
    @Override
    public void crud(final Long id, final String name) throws BusinessException {
      oneDao.insert(1L, "uno");
      oneDao.insert(2L, "dos");
      oneDao.insert(3L, "tres");
      oneDao.insert(4L, "cuatro");
      oneDao.insert(5L, "cinco");
      oneDao.update(id, name);
      oneDao.read(id);
      oneDao.delete(2L);
    }
    
    @Transactional (rollbackFor = BusinessException.class)
    @Override
    public void object(final Long id, final String name) throws BusinessException {
        oneDao.addObject(id, name);
    }

    @Transactional (rollbackFor = BusinessException.class)
    @Override
    public void array(final Long id, final String name) throws BusinessException {
        oneDao.addArray(id, name);
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public java.util.List<CursorTO> getCursor() throws BusinessException {
        return oneDao.getCursor();
    }

}
