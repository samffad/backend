/*
* BlogDigestDao.java 2014-12-15
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
public interface BlogDigestDao extends MyBatisBaseDao<BlogDigest, java.lang.Integer> {

	
	/**
	* 描述:
	* @param blog_id
	* @return
	* @author ying 2015年6月20日 上午10:09:44
	*/
		
	List<BlogDigest> getBlogFPDetail(int blog_id);}
