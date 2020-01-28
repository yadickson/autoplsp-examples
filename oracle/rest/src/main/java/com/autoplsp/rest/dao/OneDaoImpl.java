package com.autoplsp.rest.dao;

import com.autoplsp.rest.domain.CursorTO;
import com.autoplsp.rest.exception.BusinessException;
import com.autoplsp.rest.util.DataUtil;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import plsql.domain.SpTestCursorOUT;
import plsql.domain.SpTestCursorPoCursorRS;
import plsql.domain.SpTestDeleteIN;
import plsql.domain.SpTestInsertArrayIN;
import plsql.domain.SpTestInsertIN;
import plsql.domain.SpTestInsertObjectIN;
import plsql.domain.SpTestReadIN;
import plsql.domain.SpTestUpdateIN;
import plsql.array.TestArrayTable;
import plsql.object.TestObjectObject;
import plsql.repository.SpTestCursorDAO;
import plsql.repository.SpTestDeleteDAO;
import plsql.repository.SpTestInsertArrayDAO;
import plsql.repository.SpTestInsertDAO;
import plsql.repository.SpTestInsertObjectDAO;
import plsql.repository.SpTestReadDAO;
import plsql.repository.SpTestUpdateDAO;

@Repository
public final class OneDaoImpl implements OneDao {

    static final long serialVersionUID = 1L;

    @Autowired
    private SpTestInsertDAO spTestInsertDAO;

    @Autowired
    private SpTestUpdateDAO spTestUpdateDAO;

    @Autowired
    private SpTestReadDAO spTestReadDAO;

    @Autowired
    private SpTestDeleteDAO spTestDeleteDAO;

    @Autowired
    private SpTestInsertObjectDAO spTestInsertObjectDAO;

    @Autowired
    private SpTestInsertArrayDAO spTestInsertArrayDAO;

    @Autowired
    private SpTestCursorDAO spTestCursorDAO;

    @Override
    public String toDo(final String text) {
        return "Full [" + text + "]";
    }

    @Override
    public void insert(final Long id, final String name) throws BusinessException {

        try {
            SpTestInsertIN params = new SpTestInsertIN(id, name);
            spTestInsertDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error insert", ex);
        }

    }

    @Override
    public void update(final Long id, final String name) throws BusinessException {

        try {
            SpTestUpdateIN params = new SpTestUpdateIN(id, name);
            spTestUpdateDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error update", ex);
        }

    }

    @Override
    public void read(final Long id) throws BusinessException {

        try {
            SpTestReadIN params = new SpTestReadIN(id);
            spTestReadDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error read", ex);
        }

    }

    @Override
    public void delete(final Long id) throws BusinessException {

        try {
            SpTestDeleteIN params = new SpTestDeleteIN(id);
            spTestDeleteDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error delete", ex);
        }

    }

    @Override
    public void addObject(final Long id, final String name) throws BusinessException {

        try {
            TestObjectObject object = new TestObjectObject(id, name);
            SpTestInsertObjectIN params = new SpTestInsertObjectIN(object);
            spTestInsertObjectDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error insert object", ex);
        }

    }

    @Override
    public void addArray(final Long id, final String name) throws BusinessException {

        try {
            TestObjectObject object = new TestObjectObject(id, name);
            TestArrayTable array = new TestArrayTable();
            array.add(object);
            SpTestInsertArrayIN params = new SpTestInsertArrayIN(array);
            spTestInsertArrayDAO.execute(params);

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error insert object", ex);
        }

    }

    @Override
    public java.util.List<CursorTO> getCursor() throws BusinessException {

        try {
            SpTestCursorOUT out = spTestCursorDAO.execute();

            java.util.List<CursorTO> lista = new java.util.ArrayList<CursorTO>();

            for (SpTestCursorPoCursorRS rs : out.getPoCursor()) {

                CursorTO to = new CursorTO();
                new DataUtil().parseObject(rs, to);
                lista.add(to);
            }

            return lista;

        } catch (SQLException ex) {
            throw new BusinessException(0L, "error get string", ex);
        }

    }
}
