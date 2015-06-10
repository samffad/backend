package org.bupt.base.dao.ibatis.impl;


import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.bupt.base.dao.ibatis.MyBatisBaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component("myBatisBaseDao")
public class MyBatisBaseDaoImpl<T, PK extends Serializable>
    implements MyBatisBaseDao<T, PK> {
    private static Logger logger = Logger.getLogger(MyBatisBaseDaoImpl.class);
    public String INSERT = ".insert";
    public String UPDATE = ".update";
    public String DELETE = ".delete";
    public String GETBYID = ".getById";
    public String COUNT = ".findPage_count";
    public String PAGESELECT = ".findPage";
    @Autowired
    @Qualifier("frameworkSqlSessionFactory")
    protected SqlSessionFactory sqlSessionFactory;
    @Autowired
    @Qualifier("frameworkSqlSessionTemplate")
    protected SqlSessionTemplate sqlSessionTemplate;
    private Object target;
    private Method invokingMethod;

    public int save(T object) {
        if (object == null) {
            throw new IllegalArgumentException(" object can't null!");
        }
        return this.sqlSessionTemplate.insert(object.getClass().getName() + this.INSERT, object);
    }

    public List<T> findByCondition(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException(" condition can't null!");
        }
        return this.sqlSessionTemplate.selectList(obj.getClass().getName() + this.PAGESELECT, obj);
    }

    public List<T> findByCondition(T obj, int offset, int limit) {
        if (obj == null) {
            throw new IllegalArgumentException(" condition can't null!");
        }
        RowBounds rb = new RowBounds(offset, limit);
        return this.sqlSessionTemplate.selectList(obj.getClass().getName() + this.PAGESELECT, obj, rb);
    }

    public T findByPK(PK pk, Class<T> cls) {
        if (pk == null) {
            throw new IllegalArgumentException(" pk can't null!");
        }
        return (T) this.sqlSessionTemplate.selectOne(cls.getName() + this.GETBYID, pk);
    }

    public void delete(PK pk, Class<T> cls) {
        if (pk == null) {
            throw new IllegalArgumentException(" pk can't null!");
        }
        this.sqlSessionTemplate.delete(cls.getName() + this.DELETE, pk);
    }

    public Integer getTotalCount(T object) {
        if (object == null) {
            throw new IllegalArgumentException(" condition can't null!");
        }
        Object obj = this.sqlSessionTemplate.selectOne(object.getClass().getName() + this.COUNT, object);
        if (obj != null) {
            return Integer.valueOf(Integer.parseInt(obj.toString()));
        }
        return Integer.valueOf(0);
    }

    private String getStatment(String statement) {
        if (StringUtils.isEmpty(statement)) {
            return getStatement();
        }
        return statement;
    }

    public String getStatement() {
        if ((this.target == null) || (this.invokingMethod == null))
            return null;
        Class c = this.target.getClass();
        Method[] methods = c.getMethods();
        String namespace = this.target.getClass().getName();
        StringBuffer bufId = new StringBuffer(this.invokingMethod.getName());
        for (Method m : methods) {
            if ((m.getName().equals(this.invokingMethod.getName())) &&
                (!m.equals(this.invokingMethod))) {
                Class[] s = m.getParameterTypes();
                if ((s != null) && (s.length > 0)) {
                    for (Class z : s) {
                        bufId.append("_").append(z.getSimpleName());
                    }
                }
            }
        }
        return namespace + "." + bufId.toString();
    }

    public Object getTarget() {
        return this.target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getInvokingMethod() {
        return this.invokingMethod;
    }

    public void setInvokingMethod(Method invokingMethod) {
        this.invokingMethod = invokingMethod;
    }

    public SqlSessionTemplate getCurSqlSessionTemplate() {
        return this.sqlSessionTemplate;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public SqlSessionFactory getCurSqlSessionFactory() {
        return this.sqlSessionFactory;
    }

    private void setAutoCommit(Connection con, boolean autoCommit) {
        try {
            if (con != null)
                con.setAutoCommit(autoCommit);
        } catch (Exception localException) {
            logger.info("连接设置自动提交失败！");
        }
    }

    public int updateExp(T paramT) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int deleteExp(PK paramPK, Class<T> paramClass) {
        // TODO Auto-generated method stub
        return 0;
    }

	@Override
	public void update(T paramT) {
		// TODO Auto-generated method stub
		
	}

}