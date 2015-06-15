package org.bupt.travel.service;

import org.bupt.travel.common.BizMsg;
import org.bupt.travel.model.User;
import org.bupt.travel.vo.UserVo;

public interface UserService {

	BizMsg<UserVo> login(String username, String pwd);

	BizMsg<UserVo> register(String username, String pwd, String nickname,
			String gender);

	BizMsg<String> updateUserAvatarInfo(String uid, String filename);

	BizMsg<UserVo> getuserInfo(String userId);

}
