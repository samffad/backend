
		/**
		*
		
		* @author ying
		* @version 1.0
		* @since 2015年6月20日 上午10:11:08
		*/
	
package org.bupt.travel.service.impl;

import org.bupt.travel.dao.BlogDigestDao;
import org.bupt.travel.dao.UserDao;
import org.bupt.travel.service.UserService;
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
	
	
}


