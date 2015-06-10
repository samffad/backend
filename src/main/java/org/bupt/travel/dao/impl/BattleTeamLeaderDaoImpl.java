/*
* BattleTeamLeaderDaoImpl.java 2014-12-15
*/
package org.bupt.travel.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bupt.base.dao.ibatis.impl.MyBatisBaseDaoImpl;
import org.bupt.travel.dao.BattleTeamLeaderDao;
import org.bupt.travel.exception.BizException;
import org.bupt.travel.exception.MessageCode;
import org.bupt.travel.model.BattleTeamLeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableMap;

/**
 * 
 * @description:	作战团队组长信息的操作dao
 * @version   Ver 1.0
 * @author   <a href="mailto:liupeng@lianjia.com">SYSTEM</a>
 * @Date	 
 *
 */
@Repository
public class BattleTeamLeaderDaoImpl extends MyBatisBaseDaoImpl<BattleTeamLeader,java.lang.Integer> implements  BattleTeamLeaderDao{
	protected final static Logger logger = LoggerFactory.getLogger(BattleTeamLeaderDaoImpl.class);
			
	@Override
	public List<BattleTeamLeader> getTeamLeaderListByOrgId(String orgId) {
		Map<String, String> parasMap = ImmutableMap.of("orgId", orgId);
		
		return sqlSessionTemplate.selectList(BattleTeamLeader.class.getName() + ".getTeamLeaderListByOrgId", parasMap);
	}
	
	
	@Override
	public List<BattleTeamLeader> getTeamLeaderByLeaderId(String leaderId) {
		Map<String, String> parasMap = ImmutableMap.of("leaderCode", leaderId);
		
		return sqlSessionTemplate.selectList(BattleTeamLeader.class.getName() + ".getTeamLeaderByLeaderId", parasMap);
	}
	
	@Override
	public void deleteOneTeamByLeaderCode(String teamLeaderCode, String updaterCode) throws BizException{
		try {
			this.sqlSessionTemplate.update(BattleTeamLeader.class.getName().concat(".deleteOneTeamByLeaderCode"), ImmutableMap.of("teamLeaderCode", teamLeaderCode, "updatetime", new Date(),
					"updaterid", updaterCode));
		} catch (Exception e) {
			logger.error(String.format("fail to DeleteOneTeamByLeaderCode, code %s, error %s", teamLeaderCode, e.getLocalizedMessage()));
			throw new BizException(MessageCode.BattleTeamOrmError);
		}
	}
	
	@Override
	public void AddTeamLeader(String leaderCode, String leaderName, String creatorCode, String orgId, String officeAddr, int compId) throws BizException {
		try {
			List<BattleTeamLeader> leaderRecords = sqlSessionTemplate.selectList(BattleTeamLeader.class.getName() + ".getTeamLeaderByLeaderId", ImmutableMap.of("leaderCode", leaderCode));
			if(leaderRecords == null || leaderRecords.size() == 0) {
				BattleTeamLeader leader = new BattleTeamLeader(leaderCode, leaderName, creatorCode, 0, null, "", orgId, officeAddr, compId);
				leader.setCreateTime(new Date());
				super.save(leader);
			}
			else {
				this.sqlSessionTemplate.update(BattleTeamLeader.class.getName().concat(".addLeaderByLeaderCode"), ImmutableMap.of("teamLeaderCode", leaderCode));
			}
		} catch (Exception e) {
			logger.error(String.format("fail to AddTeamLeader, error %s", e.getLocalizedMessage()));
			throw new BizException(MessageCode.BattleTeamOrmError);
		}
	}
}
