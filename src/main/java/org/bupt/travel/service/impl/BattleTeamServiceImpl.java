package org.bupt.travel.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.bupt.travel.common.BizMsg;
import org.bupt.travel.common.Const;
import org.bupt.travel.dao.BattleTeamLeaderDao;
import org.bupt.travel.dao.BattleTeamRelationDao;
import org.bupt.travel.dao.BattleTeamRelationLogDao;
import org.bupt.travel.model.BattleTeamLeader;
import org.bupt.travel.model.BattleTeamRelation;
import org.bupt.travel.model.BattleTeamRelationLog;
import org.bupt.travel.service.BattleTeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleTeamServiceImpl implements BattleTeamService{
	private static final Logger log = LoggerFactory.getLogger(BattleTeamServiceImpl.class);
	/*
	@Autowired
	private BattleTeamLeaderDao battleTeamLeaderDao;
	
	@Autowired
	private BattleTeamRelationDao btRelationDao;
	
	@Autowired
	private	BattleTeamRelationLogDao btRelationLog;
	
	@Autowired
	private UserLevelService userLevelService;
	
	@Autowired
	CompConfigDao compConfigDao;
	
	@Autowired
	private UserInfoProxy userInfoProxy;
	
	@Override
	public List<BattleTeamGroupVO> getTeamGroupView(String orgId) {
		if(orgId == null || orgId.isEmpty())
			return null;
		
		List<BattleTeamGroupVO> btGroup = new ArrayList<BattleTeamGroupVO>();
		try {
			List<BattleTeamLeader> leaders = battleTeamLeaderDao.getTeamLeaderListByOrgId(orgId);
			
			if(leaders != null && leaders.size() > 0) {
				List<String> userCodeList = new ArrayList<String>(leaders.size());
				
				//get people level
				for (BattleTeamLeader battleTeamLeader : leaders) {
					userCodeList.add(battleTeamLeader.getLeaderCode());
				}
				Map<String, UserLevelScoreBean> levelMap = userLevelService
						.getUserLevelByUserCodeList(userCodeList, officeAddress);
				
				for (BattleTeamLeader battleTeamLeader : leaders) {
					BattleTeamGroupVO oneLeader = new BattleTeamGroupVO(battleTeamLeader.getLeaderCode(), battleTeamLeader.getLeaderName(), null, battleTeamLeader.getCreateTime());
					btGroup.add(oneLeader);
				}
			}
		} catch (Exception e) {
			log.error(String.format("unexpected error in GetTeamGroupView, error:%s. Orgid:%s", e.getMessage(), orgId));
			return null;
		}
		
		return btGroup;
	}
	
	@Override
	public BizMsg<String> delOneTeamByLeaderId(String teamLeaderCode, String orgId, String opId, String officeAddr) {
		BizMsg<String> msg = new BizMsg<String>();
		msg.setCode(Const.STATUS_OK);
		
		if(teamLeaderCode == null || teamLeaderCode.isEmpty()) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("要删除的组长ID不能为空");
		}
		
		try {
			battleTeamLeaderDao.deleteOneTeamByLeaderCode(teamLeaderCode, opId);
			btRelationDao.deleteTeamMemberByLeaderCode(teamLeaderCode, opId);
		} catch (Exception e) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("删除操作出现错误，请重试或者联系管理员");
		}
		
		try {
			Integer comp_id = null;
			List<Integer> compIdList = compConfigDao.getCompIdByOfficeAddr(
					officeAddr, DateUtil.getYearMonthInt(new Date()));
			
			if (compIdList != null && compIdList.size() > 0) {
				comp_id = compIdList.get(0);
			}
			btRelationLog.AddOperationLog(null, null, teamLeaderCode, null, orgId, opId, Const.BT_REASON_DEL_TEAM, officeAddr, comp_id);
		} catch (Exception e) {
			log.warn("fail to log delOneTeamLeader");
		}
		
		return msg;
	}
	
	@Override
	public List<BattleTeamGroupVO> getTeamMemberList(String teamLeaderCode) {
		if(teamLeaderCode == null || teamLeaderCode.isEmpty()) {
			return null;
		}
		
		List<BattleTeamGroupVO> result = new ArrayList<BattleTeamGroupVO>();
		try {
			List<BattleTeamRelation> members = btRelationDao.getTeamMemberInfo(teamLeaderCode);
			
			if(members != null && members.size() > 0) {
				for (BattleTeamRelation battleTeamRelation : members) {
					BattleTeamGroupVO oneMem = new BattleTeamGroupVO(battleTeamRelation.getMemberCode(), battleTeamRelation.getMemberName(), null, battleTeamRelation.getCreateTime());
					result.add(oneMem);
				}
			}
		} catch (Exception e) {
			return null;
		}
		
		return result;
	}
	
	@Override
	public BizMsg<String> delTeamMemberByMemCode(String memberCode, String teamLeaderCode, String orgId, String opId, String officeAddr) {
		BizMsg<String> msg = new BizMsg<String>();
		msg.setCode(Const.STATUS_OK);
		
		if(memberCode == null || memberCode.isEmpty()) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("请传入正确的组员信息");
		}
		
		try {
			btRelationDao.deleteTeamMemberByMemCode(memberCode);
		} catch (Exception e) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("查询失败，请稍后重试");
		}
		
		try {
			Integer comp_id = null;
			List<Integer> compIdList = compConfigDao.getCompIdByOfficeAddr(
					officeAddr, DateUtil.getYearMonthInt(new Date()));
			
			if (compIdList != null && compIdList.size() > 0) {
				comp_id = compIdList.get(0);
			}
			
			btRelationLog.AddOperationLog(memberCode, null, teamLeaderCode, null, orgId, opId, Const.BT_REASON_ADD_LEADER, officeAddr, comp_id);
		} catch (Exception e) {
			log.warn("fail to log delOneTeamLeader");
		}
		
		return msg;
	}
	
	@Override
	public List<BattleTeamGroupVO> getValidTeamLeaderList(Map<String, UserLevelScoreBean> userLevelInfo, String orgId, Page<User> allBrokers) {
		if(userLevelInfo == null || userLevelInfo.size() == 0 || orgId == null || orgId.isEmpty())
			return null;
		
		List<BattleTeamGroupVO> leaderCandidateList = new ArrayList<BattleTeamGroupVO>();
		List<BattleTeamLeader> leaders = battleTeamLeaderDao.getTeamLeaderListByOrgId(orgId);
		HashSet<String> existingLeaderCode = new HashSet<String>();

		for(BattleTeamLeader item : leaders) {
			if(existingLeaderCode.contains(item.getLeaderCode()) == false) {
				existingLeaderCode.add(item.getLeaderCode());
			}
		}
		
		List<BattleTeamRelation> members = btRelationDao.getOrgMemberInfoByOrgId(orgId);
		
		if(members != null && members.size() > 0) {
			for(BattleTeamRelation item : members) {
				if(existingLeaderCode.contains(item.getMemberCode()) == false) {
					existingLeaderCode.add(item.getMemberCode());
				}
			}
		}
		
		
		List<User> managers = this.getOrgManagers(orgId);
		if(managers != null) {
			for (User user : managers) {
				existingLeaderCode.add(user.getUserCode());
			}
		}
		
		List<User> allMembersList = allBrokers.getContent();
		for (User user : allMembersList) {
			UserLevelScoreBean levelInfo = userLevelInfo.get(user.getUserCode());
			if(levelInfo != null) {
				if(levelInfo.getReadableLevel().startsWith("M")) {
					if(existingLeaderCode.contains(user.getUserCode()) == false) {
						leaderCandidateList.add(new BattleTeamGroupVO(user.getUserCode(), user.getDescription(), levelInfo.getReadableLevel(), null));
					}
				}
			}
			else {
				log.warn(String.format("user has no level info, code %s", user.getUserCode()));
			}
		}
		
		return leaderCandidateList;
	}
	
	private List<User> getOrgManagers(String orgId) {
		if(orgId == null || orgId.isEmpty())
			return null;
		
		try {
			List<User> managers = userInfoProxy.getStoreMgrByStoreId(Long.valueOf(orgId));
			return managers;
		} catch (Exception e) {
			log.warn("getOrgManagers, fail to get managers by orgid ".concat(orgId));
			return null;
		}
	}
	
	@Override
	public List<BattleTeamGroupVO> getValidTeamMemberList(Map<String, UserLevelScoreBean> userLevelInfo, String orgId, Page<User> allBrokers) {
		if(userLevelInfo == null || userLevelInfo.size() == 0 || orgId == null || orgId.isEmpty())
			return null;
		
		List<BattleTeamGroupVO> memberCandidateList = new ArrayList<BattleTeamGroupVO>();
		List<BattleTeamRelation> members = btRelationDao.getOrgMemberInfoByOrgId(orgId);
		
		//used to store existing leader, existing member and managers
		HashSet<String> existingMemberCode = new HashSet<String>();
		for(BattleTeamRelation item : members) {
			if(existingMemberCode.contains(item.getMemberCode()) == false) {
				existingMemberCode.add(item.getMemberCode());
			}
		}
		
		List<BattleTeamLeader> existingLeaders = battleTeamLeaderDao.getTeamLeaderListByOrgId(orgId);
		for (BattleTeamLeader battleTeamLeader : existingLeaders) {
			existingMemberCode.add(battleTeamLeader.getLeaderCode());
		}
		
		List<User> managers = this.getOrgManagers(orgId);
		if(managers != null) {
			for (User user : managers) {
				existingMemberCode.add(user.getUserCode());
			}
		}
		
		List<User> allMembersList = allBrokers.getContent();
		for (User user : allMembersList) {
			UserLevelScoreBean levelInfo = userLevelInfo.get(user.getUserCode());
			if(levelInfo != null) {
				if(existingMemberCode.contains(user.getUserCode()) == false) {
					memberCandidateList.add(new BattleTeamGroupVO(user.getUserCode(), user.getDescription(), levelInfo.getReadableLevel(), null));
				}
			}
			else {
				log.warn(String.format("user has no level info, code %s", user.getUserCode()));
			}
		}
		
		return memberCandidateList;
	}
	
	@Override
	public BizMsg<String> AddNewTeamLeader(String leaderCode, String leaderName, String creatorCode, String orgId, String officeAddr, String opId) {
		BizMsg<String> msg = new BizMsg<>();
		msg.setCode(Const.STATUS_OK);
		
		if(leaderCode == null || leaderCode.isEmpty()) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("请传入组长ID");
			return msg;
		}
		
		Integer comp_id = null;
		try {
			List<Integer> compIdList = compConfigDao.getCompIdByOfficeAddr(
					officeAddr, DateUtil.getYearMonthInt(new Date()));
			
			if (compIdList != null && compIdList.size() > 0) {
				comp_id = compIdList.get(0);
			}
			
			battleTeamLeaderDao.AddTeamLeader(leaderCode, leaderName, creatorCode, orgId, officeAddr, comp_id);
		} catch (Exception e) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("操作失败，请稍后重试");
		}
		
		try {
			btRelationLog.AddOperationLog(null, null, null, leaderCode, orgId, opId, Const.BT_REASON_ADD_LEADER, officeAddr, comp_id);
		} catch (Exception e) {
			log.warn("fail to log delOneTeamLeader");
		}
		
		return msg;
	}
	
	@Override
	public BizMsg<String> AddMembersInBatch(String leaderCode, String leaderName, List<BattleTeamMemberVO> newMembers, String creatorId, String orgId, String officeAddr) {
		BizMsg<String> msg = new BizMsg<>();
		msg.setCode(Const.STATUS_OK);
		
		if(leaderCode == null || leaderCode.isEmpty() || newMembers == null || newMembers.size() == 0) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("请传入正确数据");
			return msg;
		}
		
		if(newMembers.size() > Const.BT_MAX_NUMBER) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("组员人数超过上限，最多添加".concat(String.valueOf(Const.BT_MAX_NUMBER)).concat("个人"));
			return msg;
		}
		
		Integer comp_id = null;
		try {
			List<BattleTeamRelation> validRelations = btRelationDao.getTeamMemberInfo(leaderCode);
			if(validRelations.size() + newMembers.size() > Const.BT_MAX_NUMBER) {
				msg.setCode(Const.STATUS_BIZ_ERROR);
				msg.setMsg("组员人数超过上限，最多添加".concat(String.valueOf(Const.BT_MAX_NUMBER)).concat("个人。组内已有").concat(String.valueOf(validRelations.size()).concat("个人。")));
				return msg;
			}
			
			List<Integer> compIdList = compConfigDao.getCompIdByOfficeAddr(
					officeAddr, DateUtil.getYearMonthInt(new Date()));
			
			if (compIdList != null && compIdList.size() > 0) {
				comp_id = compIdList.get(0);
			}
			
			List<BattleTeamRelation> relations = new ArrayList<>();
			for(BattleTeamMemberVO mem : newMembers)  {
				BattleTeamRelation relation = new BattleTeamRelation(mem.getId(), mem.getName(), leaderCode, leaderName, creatorId, orgId, 0, officeAddr, comp_id);
				relations.add(relation);
			}
			btRelationDao.AddMemberList(relations);
			
			try {
				btRelationLog.AddOperationLog(null, null, null, leaderCode, orgId, creatorId, Const.BT_REASON_ADD_LEADER, officeAddr, comp_id);
			} catch (Exception e) {
				log.warn("fail to log delOneTeamLeader");
			}
		} catch (Exception e) {
			msg.setCode(Const.STATUS_BIZ_ERROR);
			msg.setMsg("操作失败，请稍后重试");
		}

		return msg;
	}*/
}
