package org.bupt.travel.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.bupt.travel.common.BizMsg;
import org.bupt.travel.common.Const;
import org.bupt.travel.common.FunctionUtility;
import org.bupt.travel.dao.UserDao;
import org.bupt.travel.model.User;
import org.bupt.travel.service.UserService;
import org.bupt.travel.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.sym.Name;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	 
	@Override
	public BizMsg<String> login(String username, String pwd) {
		BizMsg<String> msg = new BizMsg<String>();
		msg.setCode(Const.STATUS_OK);
		
		if(FunctionUtility.checkString(username) == false)
		{
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("请输入正确的用户名");
			return msg;
		}
		if(FunctionUtility.checkString(pwd) == false)
		{
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("请输入正确的密码");
			return msg;
		}
		
		List<User> userList = userDao.getUserInfoByName(username);
		if(userList == null || userList.size() == 0) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("用户名不存在");
			return msg;
		}
		
		User oneUser = userList.get(0);
		if(oneUser.getPassword().equals(pwd)) {
			List<String> pwds = new ArrayList<String>() ;
			pwds.add(String.valueOf(oneUser.getId()));
			msg.setDataList(pwds);
			return msg;
		}
		else {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("密码错误");
			return msg;
		}
		
	}
	
	@Override
	public BizMsg<UserVo> register(String username, String pwd, String nickname, String gender) {
		BizMsg<UserVo> msg = new BizMsg<UserVo>();
		msg.setCode(Const.STATUS_OK);
		
		if(FunctionUtility.checkString(username) == false)
		{
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("请输入正确的用户名");
			return msg;
		}
		if(FunctionUtility.checkString(pwd) == false)
		{
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("请输入正确的密码");
			return msg;
		}
		if(FunctionUtility.checkString(gender) && (gender.equals("0") == false &&gender.equals("1") == false )) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("请输入正确的性别信息");
			return msg;
		}
		
		List<User> userList = userDao.getUserInfoByName(username);
		if(userList == null || userList.size() == 0) {
			User oneUser = null;
			 try {
				 userDao.insertUser(username, nickname, gender, pwd, null);;
				 oneUser = userDao.getUserInfoByName(username).get(0);
			} catch (Exception e) {
				msg.setCode(Const.STATUS_BIZ_ERROR);
				msg.setMsg("系统错误");
				return msg;
			}
			
			UserVo vo = new UserVo(oneUser.getId(), oneUser.getName(), oneUser.getNickname(), oneUser.getGender(), oneUser.getPhotoPath());
			ArrayList<UserVo> vos = new ArrayList<UserVo>();
			vos.add(vo);
			msg.setDataList(vos);
			return msg;
		}
		else {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("用户已存在");
			return msg;
		}
	}
}
