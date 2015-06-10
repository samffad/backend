/*
* UserDaoImpl.java 2014-12-15
*/
package org.bupt.travel.dao.impl;

import java.util.Date;

import org.bupt.base.dao.ibatis.impl.MyBatisBaseDaoImpl;
import org.bupt.travel.dao.UserDao;
import org.bupt.travel.model.User;
import org.springframework.stereotype.Repository;

/**
 * 
 * @description:	
 * @version   Ver 1.0
 * @Date	 
 *
 */
@Repository
public class UserDaoImpl extends MyBatisBaseDaoImpl<User,java.lang.Integer> implements  UserDao{
	 

}
