/*
* PhotoinfoDao.java 2014-12-15
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
public interface PhotoinfoDao extends MyBatisBaseDao<Photoinfo, java.lang.Integer> {

	void delBlogSureface(String bid);

	void delBlogFPPhoto(String fpId);

	List<Photoinfo> getBlogSurfacePhoto(List<String> blogId);}
