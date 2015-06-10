package org.bupt.travel.service;

import org.bupt.travel.common.BizMsg;
import org.bupt.travel.vo.UserVo;

public interface UserService {

	BizMsg<String> login(String username, String pwd);

	BizMsg<UserVo> register(String username, String pwd, String nickname,
			String gender);

}
