/*
* BattleTeamLeaderDao.java 2014-12-15
*/
package org.bupt.travel.dao;
import java.util.List;
import java.util.Date;

import org.bupt.base.dao.ibatis.MyBatisBaseDao;
import org.bupt.travel.exception.BizException;
import org.bupt.travel.model.*;

/**
 * 
 * @description:	 TODO add description
 * @version  Ver 1.0
 * @author   <a href="mailto:liupeng@lianjia.com">SYSTEM</a>
 * @Date	
 *
 */
public interface BattleTeamLeaderDao extends MyBatisBaseDao<BattleTeamLeader, java.lang.Integer> {
	public List<BattleTeamLeader> getTeamLeaderListByOrgId(String orgId);

	void AddTeamLeader(String leaderCode, String leaderName,
			String creatorCode, String orgId, String officeAddr, int compId)
			throws BizException;

	List<BattleTeamLeader> getTeamLeaderByLeaderId(String leaderId);

	void deleteOneTeamByLeaderCode(String teamLeaderCode, String updaterCode)
			throws BizException;
	
}
