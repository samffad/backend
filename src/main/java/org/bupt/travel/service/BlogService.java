
/**
 *

 * @author ying
 * @version 1.0
 * @since 2015年6月22日 上午9:44:06
 */

package org.bupt.travel.service;

import org.bupt.travel.common.BizMsg;
import org.bupt.travel.vo.BlogDigestItem;
import org.springframework.web.multipart.MultipartFile;


/**

 * 描述:
 *
 * @author ying
 * @version 1.0
 * @since 2015年6月22日 上午9:44:06
 */

public interface BlogService {


	/**
	 * 描述:
	 * @param offset
	 * @return
	 * @author ying lin 2015年6月22日 上午9:44:42
	 */

	BizMsg<BlogDigestItem> getRecentBlogsAllUser(String offset);

	
	/**
	* 描述:
	* @param offset
	* @param userid
	* @return
	* @author ying 2015年6月22日 上午10:59:56
	*/
		
	BizMsg<BlogDigestItem> getRecentBlogsByUserId(String offset, String userid);


	
	/**
	* 描述:
	* @param title
	* @param visitTime
	* @param location
	* @param duration
	* @param userid
	* @param username
	* @param desc
	* @param surface
	* @return
	* @author ying 2015年6月23日 下午10:31:45
	*/
		
	BizMsg<String> addNewBlogSummary(String title, String visitTime,
			String location, String duration, String userid, String username,
			String desc, MultipartFile surface);

	
	/**
	* 描述:
	* @param userId
	* @param bId
	* @param desc
	* @param location
	* @param lon
	* @param lat
	* @param visitTime
	* @param photo
	* @return
	* @author ying 2015年6月24日 下午9:55:28
	*/
		
	BizMsg<String> addNewBlogFootPrint(String userId, String bId, String desc,
			String location, String lon, String lat, String visitTime,
			MultipartFile photo);

}
