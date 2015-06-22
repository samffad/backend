/*
* PhotoinfoDaoImpl.java 2014-12-15
*/
package org.bupt.travel.dao.impl;

import java.util.List;

import org.bupt.base.dao.ibatis.impl.MyBatisBaseDaoImpl;
import org.bupt.travel.dao.PhotoinfoDao;
import org.bupt.travel.model.Photoinfo;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableMap;

/**
 * 
 * @description:	
 * @version   Ver 1.0
 * @author   lin ying
 * @Date	 
 *
 */
@Repository
public class PhotoinfoDaoImpl extends MyBatisBaseDaoImpl<Photoinfo,java.lang.Integer> implements  PhotoinfoDao{
	 
	@Override
	public void delBlogSureface(String bid) {
		this.sqlSessionTemplate.delete(Photoinfo.class.getName().concat(".deleteBybid"), ImmutableMap.of("blog_id", bid));
	}
	
	@Override
	public void delBlogFPPhoto(String fpId) {
		this.sqlSessionTemplate.delete(Photoinfo.class.getName().concat(".deleteByFPid"), ImmutableMap.of("footprint_id", fpId));
	}
	
	@Override
	public List<Photoinfo> getBlogSurfacePhoto(List<String> blogId) {
		return this.sqlSessionTemplate.selectList(Photoinfo.class.getName().concat(".select_blog_photo_batch_list"), blogId);
	}
	
	
}
