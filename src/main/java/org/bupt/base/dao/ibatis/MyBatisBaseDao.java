package org.bupt.base.dao.ibatis;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.SqlSessionFactory;
import org.bupt.travel.model.User;
import org.mybatis.spring.SqlSessionTemplate;

public abstract interface  MyBatisBaseDao<T,PK extends Serializable > {

	  public abstract int save(T paramT);

	  public abstract List<T> findByCondition(T paramT);

	  public abstract List<T> findByCondition(T paramT, int paramInt1, int paramInt2);

	  public abstract T findByPK(PK paramPK, Class<T> paramClass);

	  public abstract void update(T paramT);

	  public abstract int updateExp(T paramT);

	  public abstract void delete(PK paramPK, Class<T> paramClass);

	  public abstract int deleteExp(PK paramPK, Class<T> paramClass);

	  public abstract Integer getTotalCount(T paramT);

	  public abstract SqlSessionTemplate getCurSqlSessionTemplate();

	  public abstract SqlSessionFactory getCurSqlSessionFactory();
}
