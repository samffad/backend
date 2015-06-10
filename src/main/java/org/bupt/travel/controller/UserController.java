package org.bupt.travel.controller;

import javax.servlet.http.HttpServletRequest;

import org.bupt.travel.common.BizMsg;
import org.bupt.travel.common.Const;
import org.bupt.travel.service.UserService;
import org.bupt.travel.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object userRegister(HttpServletRequest request) {
		String UName = request.getParameter("UName");
		String nickname = request.getParameter("nickname");
		String gender = request.getParameter("gender");
		String pwd = request.getParameter("pwd");
		
		BizMsg<UserVo> msg = new BizMsg<UserVo>();
		try {
			msg = userService.register(UName, pwd, nickname, gender);
		} catch (Exception e) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("系统错误，请稍后重试");
		}
		
		return msg;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object userLogin(HttpServletRequest request) {
		String UName = request.getParameter("UName");
		String pwd = request.getParameter("pwd");
		
		BizMsg<String> msg = new BizMsg<String>();
		try {
			msg = userService.login(UName, pwd);
		} catch (Exception e) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("系统错误，请稍后重试");
		}
		
		return msg;
	}
}
