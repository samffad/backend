/*
* BattleTeamRelationDaoImpl.java 2014-12-15
*/
package org.bupt.travel.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bupt.base.dao.ibatis.impl.MyBatisBaseDaoImpl;
import org.bupt.travel.dao.BattleTeamLeaderDao;
import org.bupt.travel.dao.BattleTeamRelationDao;
import org.bupt.travel.exception.BizException;
import org.bupt.travel.exception.MessageCode;
import org.bupt.travel.model.BattleTeamLeader;
import org.bupt.travel.model.BattleTeamRelation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableMap;
/**
 * 
 * @description:	
 * @version   Ver 1.0
 * @author   <a href="mailto:liupeng@lianjia.com">SYSTEM</a>
 * @Date	 
 *
 */
@Repository
public class BattleTeamRelationDaoImpl extends MyBatisBaseDaoImpl<BattleTeamRelation,java.lang.Integer> implements  BattleTeamRelationDao{
	protected final static Logger logger = LoggerFactory.getLogger(BattleTeamRelationDaoImpl.class);
	
	@Override
	public List<BattleTeamRelation> getTeamMemberInfo(String teamLeaderCode) throws BizException {
		Map<String, String> parasMap = ImmutableMap.of("leaderCode", teamLeaderCode);
		
		return sqlSessionTemplate.selectList(BattleTeamRelation.class.getName().concat(".getTeamMemberListByLeadId"), parasMap);
	}
	
	@Override
	public List<BattleTeamRelation> getTeamMemberInfoByMemId(String memberCode) throws BizException {
		Map<String, String> parasMap = ImmutableMap.of("memberCode", memberCode);
		
		return sqlSessionTemplate.selectList(BattleTeamRelation.class.getName().concat(".getTeamMemberInfoByMemId"), parasMap);
	}
	
	@Override
	public void deleteTeamMemberByLeaderCode(String teamLeaderCode, String opId) throws BizException{
		try {
			this.sqlSessionTemplate.update(BattleTeamRelation.class.getName().concat(".deleteTeamMemberByLeaderCode"), 
					ImmutableMap.of("teamLeaderCode", teamLeaderCode, "updatetime", new Date(), "updatercode", opId));
		} catch (Exception e) {
			logger.error(String.format("fail to deleteTeamMemberByLeaderCode, code %s, error %s", teamLeaderCode, e.getLocalizedMessage()));
			throw new BizException(MessageCode.BattleTeamOrmError);
		}
	}
	
	@Override
	public void deleteTeamMemberByMemCode(String memberCode) throws BizException {
		try {
			this.sqlSessionTemplate.update(BattleTeamRelation.class.getName().concat(".delTeamMemberByMemCode"), ImmutableMap.of("memberCode", memberCode));
		} catch (Exception e) {
			logger.error(String.format("fail to delTeamMemberByMemCode, code %s, error %s", memberCode, e.getLocalizedMessage()));
			throw new BizException(MessageCode.BattleTeamOrmError);
		}
	}
	
	
	@Override
	public List<BattleTeamRelation> getOrgMemberInfoByOrgId(String orgId) throws BizException {
		Map<String, String> parasMap = ImmutableMap.of("orgId", orgId);
		
		return sqlSessionTemplate.selectList(BattleTeamRelation.class.getName().concat(".getTeamMemberListByOrgId"), parasMap);
	}
	
	@Override
	public void AddMemberList(List<BattleTeamRelation> relations) throws BizException {
		try {
			sqlSessionTemplate.update(BattleTeamRelation.class.getName().concat(".updateMemBatch"), relations);
		} catch (Exception e) {
			logger.error(String.format("fail to AddMemberList, error %s", e.getLocalizedMessage()));
			throw new BizException(MessageCode.BattleTeamOrmError);
		}
	}
}
