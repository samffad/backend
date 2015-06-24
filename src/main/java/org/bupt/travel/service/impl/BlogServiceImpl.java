
		/**
		*
		
		* @author ying
		* @version 1.0
		* @since 2015年6月20日 上午10:11:08
		*/
	
package org.bupt.travel.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.bupt.travel.common.BizMsg;
import org.bupt.travel.common.Const;
import org.bupt.travel.common.FunctionUtility;
import org.bupt.travel.dao.BlogDigestDao;
import org.bupt.travel.dao.BlogFootprintDao;
import org.bupt.travel.dao.PhotoinfoDao;
import org.bupt.travel.dao.UserDao;
import org.bupt.travel.model.BlogDigest;
import org.bupt.travel.model.BlogFootprint;
import org.bupt.travel.model.Photoinfo;
import org.bupt.travel.service.BlogService;
import org.bupt.travel.service.UserService;
import org.bupt.travel.vo.BlogDigestItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


		/**
		
 * 描述:
 *
 * @author ying
 * @version 1.0
 * @since 2015年6月20日 上午10:11:08
 */
@Service
public class BlogServiceImpl implements BlogService{
	private static final Logger log = LoggerFactory.getLogger(BlogServiceImpl.class);
	
	@Autowired
	private BlogDigestDao blogDigestDao;
	
	@Autowired
	private BlogFootprintDao footprintDao;
	
	@Autowired
	private PhotoinfoDao photoinfoDao;
	
	@Override
	public BizMsg<String> addNewBlogFootPrint(String userId, String bId, String desc, String location, String lon, String lat, String visitTime, MultipartFile photo) {
		BizMsg<String> msg = new BizMsg<>();
		msg.setCode(Const.STATUS_OK);
		
		if(FunctionUtility.checkString(bId) == false) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("参数错误");
		}
		
		try {
			double dLon = Double.valueOf(lon);
			double dLat = Double.valueOf(lat);
			Date nowDate = new Date();
			Date dVisitTime = new Date(Long.valueOf(visitTime));
			BlogFootprint footprint = new BlogFootprint(Integer.valueOf(bId), desc, location, dLon, dLat, dVisitTime, nowDate, 0);
			
			footprintDao.save(footprint);
			
			if(photo != null) {
				String fileName = bId.concat(String.valueOf(nowDate.getTime())).concat(photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".")));
				String photoPath = Const.blogPhotoPersistPath.concat(fileName);
				
				photo.transferTo(new File(photoPath));
				
				Photoinfo photoinfo = new Photoinfo(fileName, fileName, new Date(), 0, Integer.valueOf(userId), Integer.valueOf(bId), footprint.getId(), 0);
				photoinfoDao.save(photoinfo);
			}
			
		} catch (Exception e) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("操作失败，请稍后重试");
		}
		
		return msg;
	}
	
	@Override
	public BizMsg<String> addNewBlogSummary(String title, String visitTime, String location, String duration, String userid, String username, String desc, MultipartFile surface) {
		BizMsg<String> msg = new BizMsg<>();
		msg.setCode(Const.STATUS_OK);
		
		if(FunctionUtility.checkString(userid) == false || FunctionUtility.checkString(title) == false) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("请传入正确参数");
			return msg;
		}
		
		try {
			int iUserId = Integer.valueOf(userid);
			int iDuration = 0;
			if(duration != null) {
				iDuration = Integer.valueOf(duration);
			}
			
			BlogDigest blogDigest = new BlogDigest(title, visitTime == null ? new Date() : new Date(Long.valueOf(visitTime)), 
					location, iDuration, iUserId, username, desc, new Date(), 0);
			
			blogDigestDao.save(blogDigest);
			
			if(surface != null) {
				String fileName = userid.concat(visitTime).concat(surface.getOriginalFilename().substring(surface.getOriginalFilename().lastIndexOf(".")));
				String photoPath = Const.blogPhotoPersistPath.concat(fileName);
				
				surface.transferTo(new File(photoPath));
				
				Photoinfo photoinfo = new Photoinfo(fileName, fileName, new Date(), 0, iUserId, blogDigest.getId(), null, 1);
				photoinfoDao.save(photoinfo);
			}
			
			List<String> dataList = new ArrayList<>();
			dataList.add(String.valueOf(blogDigest.getId()));
			msg.setDataList(dataList);
		} catch (Exception e) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("系统错误");
			
		}
		
		return msg; 
	}
	
	@Override
	public BizMsg<BlogDigestItem> getRecentBlogsByUserId(String offset, String userid) {
		BizMsg<BlogDigestItem> msg = new BizMsg<BlogDigestItem>();
		msg.setCode(Const.STATUS_OK);
		
		if(FunctionUtility.checkString(userid) == false) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("请传入正确的用户信息");
			return msg;
		}
		int iOffset = 0;
		
		try {
			iOffset = Integer.valueOf(offset);
		} catch (Exception e) {
			log.warn("getRecentBlogsAllUser, wrong offset " + offset);
			iOffset = 0;
		}
		
		try {
			//1. get id and meta list
			List<BlogDigest> list = blogDigestDao.getRecentBlogList(iOffset, userid);
			
			List<BlogDigestItem> blogListResult = this.getBlogListInfoByBids(list, msg);
				
			msg.setDataList(blogListResult);
		} catch (Exception e) {
			log.error(e.getMessage());
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("系统错误，请稍后重试");
		}
		return msg;
		
	}
	
	@Override
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
			
			List<BlogDigestItem> blogListResult = this.getBlogListInfoByBids(list, msg);
				
			msg.setDataList(blogListResult);
		} catch (Exception e) {
			log.error(e.getMessage());
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("系统错误，请稍后重试");
		}
		return msg;
	}
	
	private List<BlogDigestItem> getBlogListInfoByBids(List<BlogDigest> list, BizMsg<BlogDigestItem> msg) {
		if(list == null) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setCode("获取游记列表失败");
			return null;
		} else if(list.size() == 0) {
			msg.setDataList(new ArrayList<BlogDigestItem>());
			return null;
		} else {
			//2. get surface map
			List<String> blogIds = new ArrayList<>();
			for(BlogDigest digest : list) {
				blogIds.add(String.valueOf(digest.getId()));
			}
			
			List<Photoinfo> photos = photoinfoDao.getBlogSurfacePhoto(blogIds);
			HashMap<Integer, Photoinfo> photoMap = new HashMap<>();
			if(photos != null) {
				for (Photoinfo photoinfo : photos) {
					photoMap.put(photoinfo.getBlogId(), photoinfo);
				}
			}
			
			//3. combine blog info and surface photo info
			List<BlogDigestItem> resultList = new ArrayList<BlogDigestItem>();
			for (BlogDigest blogDigest : list) {
				BlogDigestItem item = new BlogDigestItem(blogDigest.getId(), blogDigest.getTitle(), blogDigest.getVisitTime() == null ? blogDigest.getCreateTime() : blogDigest.getVisitTime(), 
						blogDigest.getDuration(), blogDigest.getAuthorName(), blogDigest.getLocation(), null);
				
				if(photoMap.containsKey(blogDigest.getId()))
					item.setSurfaceUrl(Const.blogPhotoPath.concat(photoMap.get(blogDigest.getId()).getPhotoPath()));
				
				resultList.add(item);
			}
			
			return resultList;
		}
	}
		
		
}


