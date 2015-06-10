package org.bupt.travel.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.bupt.travel.common.Const;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 类名称：ExceptionHandler 类描述：异常处理器 创建人：shanyb@lianjia.com 创建时间：2014-12-16
 * 下午5:08:15
 * 
 * @version
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

	private static Logger log = Logger.getLogger(ExceptionHandler.class);

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {

		ModelAndView mav = new ModelAndView();
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("code", Const.STATUS_BIZ_ERROR);// 业务错误
		if (e instanceof BizException) {
			BizException x = (BizException) e;
			log.error("BIZ　ERROR MSG " + x.getMessage());
			attributes.put("msg", x.getMessage());
		} else if (e instanceof ProxyException) {
			ProxyException x = (ProxyException) e;
			log.error("PROXY ERROR MSG " + x.getMessage());
			attributes.put("msg", x.getMessage());
		} else {
			log.error(
					"ERROR CODE:" + Const.STATUS_BIZ_ERROR + ":"
							+ e.getMessage(), e);
			attributes.put("msg", e.getMessage());
		}
		view.setAttributesMap(attributes);
		mav.setView(view);
		return mav;
	}
}
