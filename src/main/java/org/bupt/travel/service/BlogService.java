
/**
 *

 * @author ying
 * @version 1.0
 * @since 2015年6月22日 上午9:44:06
 */

package org.bupt.travel.service;

import org.bupt.travel.common.BizMsg;
import org.bupt.travel.vo.BlogDigestItem;


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
	* @author liupeng 2015年6月22日 上午10:59:56
	*/
		
	BizMsg<BlogDigestItem> getRecentBlogsByUserId(String offset, String userid);

}
