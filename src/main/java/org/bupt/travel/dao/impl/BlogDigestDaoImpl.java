package org.bupt.travel.dao.impl;

import java.util.List;
import org.bupt.base.dao.ibatis.impl.MyBatisBaseDaoImpl;
import org.bupt.travel.dao.BlogDigestDao;
import org.bupt.travel.model.BlogDigest;
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
public class BlogDigestDaoImpl extends MyBatisBaseDaoImpl<BlogDigest,java.lang.Integer> implements  BlogDigestDao{
	 
	@Override
	public List<BlogDigest> getBlogFPDetail(int blog_id) {
		return this.sqlSessionTemplate.selectList(BlogDigest.class.getName().concat(".queryByBlogId"), ImmutableMap.of("blog_id", blog_id));
	}
}
