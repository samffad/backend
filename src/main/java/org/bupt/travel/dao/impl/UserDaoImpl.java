/*
* UserDaoImpl.java 2014-12-15
*/
package org.bupt.travel.dao.impl;

import java.util.List;
import java.util.Map;

import org.bupt.base.dao.ibatis.impl.MyBatisBaseDaoImpl;
import org.bupt.travel.common.FunctionUtility;
import org.bupt.travel.dao.UserDao;
import org.bupt.travel.model.User;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableMap;

/**
 * 
 * @description:	
 * @version   Ver 1.0
 * @Date	 
 *
 */
@Repository
public class UserDaoImpl extends MyBatisBaseDaoImpl<User,java.lang.Integer> implements  UserDao{
	 
	@Override
	public List<User> getUserInfoByName(String name) {
		Map<String, String> parasMap = ImmutableMap.of("name", name);
		return sqlSessionTemplate.selectList(User.class.getName() + ".getuserinfo", parasMap);
	}
	
	/*
	 * #{id} ,
        	#{name} ,
        	#{nickname} ,
        	#{gender} ,
        	#{password} ,
        	#{photoPath} 
	 */
	@Override
	public void insertUser(String name, String nickname, String gender, String passwd, String path) {
		try {
			Map<String, ? extends Object> parasMap = ImmutableMap.of("name", name, "nickname", nickname == null ? "" : nickname, "gender", gender == null ? "3" : gender, "password", passwd,  "photoPath", path == null ? "" : path);
			sqlSessionTemplate.insert(User.class.getName().concat(".insert"), parasMap);
		} catch (Exception e) {
			throw e;
		}
		
	}

}
