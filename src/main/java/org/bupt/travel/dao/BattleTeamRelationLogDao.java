/*
* BattleTeamRelationLogDao.java 2014-12-15
*/
package org.bupt.travel.dao;
import java.util.Date;
import java.util.List;

import org.bupt.base.dao.ibatis.MyBatisBaseDao;
import org.bupt.travel.model.*;

/**
 * 
 * @description:	 TODO add description
 * @version  Ver 1.0
 * @author   <a href="mailto:liupeng@lianjia.com">SYSTEM</a>
 * @Date	
 *
 */
public interface BattleTeamRelationLogDao extends MyBatisBaseDao<BattleTeamRelationLog, java.lang.Integer> {

	void AddOperationLog(String memberCode, String memberName,
			String originLeaderCode, String newLeaderCode, String orgId,
			String opId, String reason, String officeAddr, int compId);

	void AddOperationLogBatch(List<BattleTeamRelationLog> list);}
