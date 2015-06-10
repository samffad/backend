/*
* BattleTeamRelationLogDaoImpl.java 2014-12-15
*/
package org.bupt.travel.dao.impl;

import java.util.Date;
import java.util.List;

import org.bupt.base.dao.ibatis.impl.MyBatisBaseDaoImpl;
import org.bupt.travel.dao.BattleTeamLeaderDao;
import org.bupt.travel.dao.BattleTeamRelationLogDao;
import org.bupt.travel.model.BattleTeamRelationLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
/**
 * 
 * @description:	
 * @version   Ver 1.0
 * @author   <a href="mailto:liupeng@lianjia.com">SYSTEM</a>
 * @Date	 
 *
 */
@Repository
public class BattleTeamRelationLogDaoImpl extends MyBatisBaseDaoImpl<BattleTeamRelationLog,java.lang.Integer> implements  BattleTeamRelationLogDao{
	protected final static Logger logger = LoggerFactory.getLogger(BattleTeamRelationLogDaoImpl.class);

	@Override
	public void AddOperationLog(String memberCode, String memberName, String originLeaderCode, 
			String newLeaderCode, String orgId, String opId, String reason, String officeAddr, int compId) {
		try {
			BattleTeamRelationLog log = new BattleTeamRelationLog(memberCode, memberName, originLeaderCode, newLeaderCode, orgId, opId, reason, officeAddr, compId);
			log.setOpTime(new Date());
			super.save(log);
		} catch (Exception e) {
			logger.error(String.format("fail to AddOperationLog in battleteam, error :%s", e.getMessage()));
		}
		
	}

	@Override
	public void AddOperationLogBatch(List<BattleTeamRelationLog> list) {
		try {
			sqlSessionTemplate.insert(BattleTeamRelationLog.class.getName().concat(".insertBatch"), list);
		} catch (Exception e) {
			logger.error(String.format("fail to AddOperationLog in battleteam, error :%s", e.getMessage()));
			for(BattleTeamRelationLog log : list) {
				logger.error(log.toString());
			}
		}
	}
}
