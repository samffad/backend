/*
* UserDao.java 2014-12-15
*/
package org.bupt.travel.dao;
import org.bupt.travel.model.*;
import org.bupt.base.dao.ibatis.MyBatisBaseDao;

import java.util.Date;
import java.util.List;

/**
 * 
 * @description:	 TODO add description
 * @version  Ver 1.0
 * @author   <a href="mailto:"></a>
 * @Date	
 *
 */
public interface UserDao extends MyBatisBaseDao<User, java.lang.Integer> {

	List<User> getUserInfoByName(String name);



	void insertUser(String name, String nickname, String gender, String passwd,
			String path);}
