package org.bupt.travel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.bupt.travel.common.BizMsg;
import org.bupt.travel.common.Const;
import org.bupt.travel.service.BattleTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/battleteam")
public class BattleTeamController {
	
	@Autowired
	private BattleTeamService battleTeamService;
	
	private Logger logger = Logger.getLogger(BattleTeamController.class);
	
	/*@RequestMapping("/overview")
	@ResponseBody
	public Object getBattleTeamOverview() {
		
		long orgId = suser.getOrgSelected().getOrgId();
		String officeAddress = suser.getOrgSelected().getOfficeAddress();
		
		List<BattleTeamGroupVO> groupVOs = battleTeamService.getTeamGroupView(String.valueOf(orgId));
		this.getUserLevel(groupVOs, officeAddress);
		//get all brokers of this store, no split page
		Page<User> allBrokers = userService.getAllBrokersOfStore(orgId, 1, 1000);
		BizMsg<BattleTeamGroupVO> msg = new BizMsg<BattleTeamGroupVO>();
		if(groupVOs != null) {
			msg.setCode(Const.STATUS_OK);
			msg.setDataList(groupVOs);
		}
		else {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("查询失败，请稍后再试");
		}
		
		return msg;
	}
	
	@RequestMapping(value = "/delteam", method = RequestMethod.POST)
	@ResponseBody
	public Object delBattleTeamLeaderByCode(HttpServletRequest request) {
		String leaderCode = request.getParameter("leadercode");
		SessionUser suser = SessionUserContext.getCurrentSessionUser();
		
		long orgId = suser.getOrgSelected().getOrgId();
		String officeAddress = suser.getOrgSelected().getOfficeAddress();
		
		
		BizMsg<String> msg =  battleTeamService.delOneTeamByLeaderId(leaderCode, String.valueOf(orgId), suser.getUserCode(), officeAddress);

		return msg;
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	@ResponseBody
	public Object getBattleTeamMemberByCode(HttpServletRequest request) {
		String leaderCode = request.getParameter("leadercode");
		
		List<BattleTeamGroupVO> result =  battleTeamService.getTeamMemberList(leaderCode);
		String officeAddress = SessionUserContext.getCurrentSessionUser().getOrgSelected().getOfficeAddress();
		this.getUserLevel(result, officeAddress);
		
		BizMsg<BattleTeamGroupVO> msg = new BizMsg<BattleTeamGroupVO>();
		if(result != null) {
			msg.setCode(Const.STATUS_OK);
			msg.setDataList(result);
		}
		else {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("查询失败，请稍后再试");
		}
		
		return msg;
	}
	
	@RequestMapping(value = "/delmember", method = RequestMethod.POST)
	@ResponseBody
	public Object delBattleTeamMemberByCode(HttpServletRequest request) {
		String membercode = request.getParameter("membercode");
		SessionUser suser = SessionUserContext.getCurrentSessionUser();
		
		long orgId = suser.getOrgSelected().getOrgId();
		String officeAddress = suser.getOrgSelected().getOfficeAddress();
		
		BizMsg<String> msg = battleTeamService.delOneTeamByLeaderId(membercode, String.valueOf(orgId), suser.getUserCode(), officeAddress);
		
		return msg;
	}
	
	@RequestMapping(value = "/addleader", method = RequestMethod.POST)
	@ResponseBody
	public Object addBattleTeamLeaderByCode(HttpServletRequest request) {
		String leaderCode = request.getParameter("leadercode");
		String leaderName = request.getParameter("leadername");
		
		SessionUser suser = SessionUserContext.getCurrentSessionUser();
		
		long orgId = suser.getOrgSelected().getOrgId();
		String officeAddress = suser.getOrgSelected().getOfficeAddress();
		
		BizMsg<String> msg = battleTeamService.AddNewTeamLeader(leaderCode, leaderName, suser.getUserCode(), String.valueOf(orgId), officeAddress, suser.getUserCode());
		
		return msg;
	}
	
	@RequestMapping(value = "/addmember", method = RequestMethod.POST)
	@ResponseBody
	public Object addBattleTeamMemberByCode(HttpServletRequest request, @RequestBody List<BattleTeamMemberVO> members) {
		String leaderCode = request.getParameter("leadercode");
		String leaderName = request.getParameter("leadername");
		
		SessionUser suser = SessionUserContext.getCurrentSessionUser();
		
		long orgId = suser.getOrgSelected().getOrgId();
		String officeAddress = suser.getOrgSelected().getOfficeAddress();
		
		battleTeamService.AddMembersInBatch(leaderCode, leaderName, members, suser.getUserCode(), String.valueOf(orgId), officeAddress);	
		BizMsg<String> msg = battleTeamService.AddNewTeamLeader(leaderCode, leaderName, suser.getUserCode(), String.valueOf(orgId), officeAddress, suser.getUserCode());
		
		return msg;
	}
	
	@RequestMapping("/leadercandidate")
	@ResponseBody
	public Object getBattleTeamLeaderCandidate() {
		SessionUser suser = SessionUserContext.getCurrentSessionUser();
		
		long orgId = suser.getOrgSelected().getOrgId();
		String officeAddress = suser.getOrgSelected().getOfficeAddress();
		
		BizMsg<BattleTeamGroupVO> msg = new BizMsg<BattleTeamGroupVO>();
		
		Page<User> userPage = userService.getAllBrokersOfStore(orgId, 1, 1000);
		List<String> userCodeList = this.getTeamMemberList(userPage);
		
		if(userCodeList == null || userCodeList.size() == 0) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("获取经纪人信息失败");
			return msg;
		}
		
		Map<String, UserLevelScoreBean> userLevelMap = userLevelService.getUserLevelByUserCodeList(userCodeList, officeAddress);
		List<BattleTeamGroupVO> candidates = battleTeamService.getValidTeamLeaderList(userLevelMap, String.valueOf(orgId), userPage);
		
		if(candidates != null) {
			msg.setCode(Const.STATUS_OK);
			msg.setDataList(candidates);
		}
		else {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("获取组长候选人列表失败，请稍后再试");
		}
		
		
		return msg;
	}
	
	@RequestMapping("/membercandidate")
	@ResponseBody
	public Object getBattleTeamMemberCandidate() {
		SessionUser suser = SessionUserContext.getCurrentSessionUser();
		
		long orgId = suser.getOrgSelected().getOrgId();
		String officeAddress = suser.getOrgSelected().getOfficeAddress();
		
		BizMsg<BattleTeamGroupVO> msg = new BizMsg<BattleTeamGroupVO>();
		
		Page<User> userPage = userService.getAllBrokersOfStore(orgId, 1, 1000);
		List<String> userCodeList = this.getTeamMemberList(userPage);
		
		if(userCodeList == null || userCodeList.size() == 0) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("获取经纪人信息失败");
			return msg;
		}
		
		Map<String, UserLevelScoreBean> userLevelMap = userLevelService.getUserLevelByUserCodeList(userCodeList, officeAddress);
		List<BattleTeamGroupVO> candidates = battleTeamService.getValidTeamMemberList(userLevelMap, String.valueOf(orgId), userPage);
		
		if(candidates != null) {
			msg.setCode(Const.STATUS_OK);
			msg.setDataList(candidates);
		}
		else {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("获取组长候选人列表失败，请稍后再试");
		}
		
		
		return msg;
	}
	
	private List<String> getTeamMemberList(Page<User> allBrokers) {
		if(allBrokers == null) {
			return null;
		}
		
		List<User> users = allBrokers.getContent();
		if(users != null && users.size() > 0) {
			List<String> userCodeList = new ArrayList<String>();
			
			for(User oneUser : users) {
				userCodeList.add(oneUser.getUserCode());
			}
			
			return userCodeList;
		}
		else {
			return null;
		}
	}
	
	private void getUserLevel(List<BattleTeamGroupVO> resultList, String officeAddr) {
		if(resultList == null || resultList.size() == 0)
			return ;
		
		List<String> userCodeList = new ArrayList<>(resultList.size());
		for (int i = 0; i < resultList.size(); i++) {
			userCodeList.add(resultList.get(i).getLeaderCode());
		}
		
		Map<String, UserLevelScoreBean> levelMap = userLevelService
				.getUserLevelByUserCodeList(userCodeList, officeAddr);

		if (levelMap == null || levelMap.size() == 0)
			return;

		for (BattleTeamGroupVO ur : resultList) {
			UserLevelScoreBean uBean = levelMap.get(ur.getLeaderCode());
			if (uBean != null) {
				ur.setLeaderLevel(uBean.getReadableLevel());
			}
		}
	}*/
}
