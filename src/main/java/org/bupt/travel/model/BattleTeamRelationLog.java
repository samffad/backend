/*
* BattleTeamRelationLog.java 2014-12-15
*/
package org.bupt.travel.model;
import java.util.Date;


public class BattleTeamRelationLog{
 
	  // 【in 查询使用】
	 private java.lang.Integer ids;
	 // 【排序  使用】
	 private java.lang.String sortColumns;

 
	 /**
     * 描述:自增主键id     
     * 字段: id  INT UNSIGNED(10)  
     */	
	private java.lang.Integer id;

 
	 /**
     * 描述:组员经纪人id     
     * 字段: member_code  VARCHAR(50)  
     */	
	private java.lang.String memberCode;

 
	 /**
     * 描述:组员姓名     
     * 字段: member_name  VARCHAR(20)  
     */	
	private java.lang.String memberName;

 
	 /**
     * 描述:老的组长id     
     * 字段: origin_leader_code  VARCHAR(50)  
     */	
	private java.lang.String originLeaderCode;

 
	 /**
     * 描述:新的组长id     
     * 字段: new_leader_code  VARCHAR(50)  
     */	
	private java.lang.String newLeaderCode;

 
	 /**
     * 描述:商圈组id     
     * 字段: org_code  VARCHAR(50)  
     */	
	private java.lang.String orgCode;

 
	 /**
     * 描述:变更操作时间     
     * 字段: op_time  TIMESTAMP(19)  
     */	
	private java.util.Date opTime;

	//【非数据库字段，查询时使用】
	private java.util.Date opTimeBegin;
	//【非数据库字段，查询时使用】
	private java.util.Date opTimeEnd;
 
	 /**
     * 描述:变更操作执行者id     
     * 字段: oper_code  VARCHAR(50)  
     */	
	private java.lang.String operCode;

 
	 /**
     * 描述:备注变更原因     
     * 字段: reason  VARCHAR(200)  
     */	
	private java.lang.String reason;

 
	 /**
     * 描述:城市id     
     * 字段: office_address  VARCHAR(10)  
     */	
	private java.lang.String officeAddress;

 
	 /**
     * 描述:分公司id     
     * 字段: comp_id  INT(10)  
     */	
	private java.lang.Integer compId;

	
 
	public BattleTeamRelationLog(String memberCode, String memberName,
			String originLeaderCode, String newLeaderCode, String orgCode,
			String operCode, String reason, String officeAddress, Integer compId) {
		super();
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.originLeaderCode = originLeaderCode;
		this.newLeaderCode = newLeaderCode;
		this.orgCode = orgCode;
		this.operCode = operCode;
		this.reason = reason;
		this.officeAddress = officeAddress;
		this.compId = compId;
	}

	public BattleTeamRelationLog(){
	}

	public BattleTeamRelationLog(
		java.lang.Integer id
	){
		this.id = id;
	}

	public java.lang.Integer getIds() {
	    return ids;
	}
	
	public void setIds(java.lang.Integer ids) {
	    this.ids = ids;
	}
	
	public java.lang.String getSortColumns() {
	    return sortColumns;
	}
	
	public void setSortColumns(java.lang.String sortColumns) {
	    this.sortColumns = sortColumns;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	
    
    
	public void setMemberCode(java.lang.String memberCode) {
		this.memberCode = memberCode;
	}
	
	public java.lang.String getMemberCode() {
		return this.memberCode;
	}
	
    
    
	public void setMemberName(java.lang.String memberName) {
		this.memberName = memberName;
	}
	
	public java.lang.String getMemberName() {
		return this.memberName;
	}
	
    
    
	public void setOriginLeaderCode(java.lang.String originLeaderCode) {
		this.originLeaderCode = originLeaderCode;
	}
	
	public java.lang.String getOriginLeaderCode() {
		return this.originLeaderCode;
	}
	
    
    
	public void setNewLeaderCode(java.lang.String newLeaderCode) {
		this.newLeaderCode = newLeaderCode;
	}
	
	public java.lang.String getNewLeaderCode() {
		return this.newLeaderCode;
	}
	
    
    
	public void setOrgCode(java.lang.String orgCode) {
		this.orgCode = orgCode;
	}
	
	public java.lang.String getOrgCode() {
		return this.orgCode;
	}
	
    
    
	public void setOpTime(java.util.Date opTime) {
		this.opTime = opTime;
	}
	
	public java.util.Date getOpTime() {
		return this.opTime;
	}
	
    public void setOpTimeBegin(java.util.Date opTimeBegin) {
		this.opTimeBegin = opTimeBegin;
	}
	
	public java.util.Date getOpTimeBegin() {
		return this.opTimeBegin;
	}
	
	public void setOpTimeEnd(java.util.Date opTimeEnd) {
		this.opTimeEnd = opTimeEnd;
	}
	
	public java.util.Date getOpTimeEnd() {
		return this.opTimeEnd;
	}	
    
    
	public void setOperCode(java.lang.String operCode) {
		this.operCode = operCode;
	}
	
	public java.lang.String getOperCode() {
		return this.operCode;
	}
	
    
    
	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}
	
	public java.lang.String getReason() {
		return this.reason;
	}
	
    
    
	public void setOfficeAddress(java.lang.String officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	public java.lang.String getOfficeAddress() {
		return this.officeAddress;
	}
	
    
    
	public void setCompId(java.lang.Integer compId) {
		this.compId = compId;
	}
	
	public java.lang.Integer getCompId() {
		return this.compId;
	}

	@Override
	public String toString() {
		return "BattleTeamRelationLog [id=" + id + ", memberCode=" + memberCode
				+ ", memberName=" + memberName + ", originLeaderCode="
				+ originLeaderCode + ", newLeaderCode=" + newLeaderCode
				+ ", orgCode=" + orgCode + ", opTime=" + opTime + ", operCode="
				+ operCode + ", reason=" + reason + ", officeAddress="
				+ officeAddress + ", compId=" + compId + "]";
	}
	
    
    
 
}

