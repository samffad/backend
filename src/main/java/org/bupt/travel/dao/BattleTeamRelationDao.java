/*
* BattleTeamRelationDao.java 2014-12-15
*/
package org.bupt.travel.dao;
import java.util.Date;
import java.util.List;

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
public interface BattleTeamRelationDao extends MyBatisBaseDao<BattleTeamRelation, java.lang.Integer> {


	List<BattleTeamRelation> getTeamMemberInfo(String teamLeaderCode)
			throws BizException;

	void deleteTeamMemberByMemCode(String memberCode) throws BizException;

	List<BattleTeamRelation> getOrgMemberInfoByOrgId(String orgId)
			throws BizException;

	void AddMemberList(List<BattleTeamRelation> relations) throws BizException;

	void deleteTeamMemberByLeaderCode(String teamLeaderCode, String opId)
			throws BizException;

	List<BattleTeamRelation> getTeamMemberInfoByMemId(String memberCode)
			throws BizException;
	
}
