
		/**
		*
		
		* @author ying
		* @version 1.0
		* @since 2015年6月20日 上午10:11:08
		*/
	
package org.bupt.travel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bupt.travel.common.BizMsg;
import org.bupt.travel.common.Const;
import org.bupt.travel.dao.BlogDigestDao;
import org.bupt.travel.dao.PhotoinfoDao;
import org.bupt.travel.dao.UserDao;
import org.bupt.travel.model.BlogDigest;
import org.bupt.travel.model.Photoinfo;
import org.bupt.travel.service.UserService;
import org.bupt.travel.vo.BlogDigestItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


		/**
		
 * 描述:
 *
 * @author ying
 * @version 1.0
 * @since 2015年6月20日 上午10:11:08
 */
@Service
public class BlogServiceImpl {
	private static final Logger log = LoggerFactory.getLogger(BlogServiceImpl.class);
	
	@Autowired
	private BlogDigestDao blogDigestDao;
	
	@Autowired
	private PhotoinfoDao photoinfoDao;
	
	public BizMsg<BlogDigestItem> getRecentBlogsAllUser(String offset) {
		BizMsg<BlogDigestItem> msg = new BizMsg<BlogDigestItem>();
		msg.setCode(Const.STATUS_OK);
		int iOffset = 0;
		
		try {
			iOffset = Integer.valueOf(offset);
		} catch (Exception e) {
			log.warn("getRecentBlogsAllUser, wrong offset " + offset);
			iOffset = 0;
		}
		
		try {
			//1. get id and meta list
			List<BlogDigest> list = blogDigestDao.getRecentBlogList(iOffset, null);
			if(list == null) {
				msg.setCode(Const.STATUS_BIZ_ERROR);
				msg.setCode("获取游记列表失败");
				return msg;
			} else if(list.size() == 0) {
				msg.setDataList(new ArrayList<BlogDigestItem>());
				return msg;
			} else {
				//2. get surface map
				List<String> pho 
				
				List<Photoinfo> photos = photoinfoDao.getBlogSurfacePhoto(blogId)
				
				List<BlogDigestItem> resultList = new ArrayList<BlogDigestItem>();
				for (BlogDigest blogDigest : list) {
					
				}
			}
			
		} catch (Exception e) {
			
		}
	}
}


