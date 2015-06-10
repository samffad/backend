/*
* BattleTeamRelation.java 2014-12-15
*/
package org.bupt.travel.model;
import java.util.Date;


public class BattleTeamRelation{
 
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
     * 描述:组长id     
     * 字段: leader_code  VARCHAR(50)  
     */	
	private java.lang.String leaderCode;

 
	 /**
     * 描述:组长姓名     
     * 字段: leader_name  VARCHAR(20)  
     */	
	private java.lang.String leaderName;

 
	 /**
     * 描述:记录创建时间     
     * 字段: create_time  TIMESTAMP(19)  
     */	
	private java.util.Date createTime;

	//【非数据库字段，查询时使用】
	private java.util.Date createTimeBegin;
	//【非数据库字段，查询时使用】
	private java.util.Date createTimeEnd;
 
	 /**
     * 描述:创建者id     
     * 字段: creator_code  VARCHAR(50)  
     */	
	private java.lang.String creatorCode;

 
	 /**
     * 描述:商圈组id     
     * 字段: org_code  VARCHAR(50)  
     */	
	private java.lang.String orgCode;

 
	 /**
     * 描述:元组状态，0-正常，1-已被删除     
     * 字段: status  TINYINT(3)  
     */	
	private Integer status;

 
	 /**
     * 描述:updateTime     
     * 字段: update_time  DATETIME(19)  
     */	
	private java.util.Date updateTime;

	//【非数据库字段，查询时使用】
	private java.util.Date updateTimeBegin;
	//【非数据库字段，查询时使用】
	private java.util.Date updateTimeEnd;
 
	 /**
     * 描述:updaterCode     
     * 字段: updater_code  VARCHAR(50)  
     */	
	private java.lang.String updaterCode;

 
	 /**
     * 描述:公司城市代码     
     * 字段: office_address  VARCHAR(10)  
     */	
	private java.lang.String officeAddress;

 
	 /**
     * 描述:分公司id     
     * 字段: comp_id  INT(10)  
     */	
	private java.lang.Integer compId;

 
	public BattleTeamRelation(String memberCode, String memberName,
			String leaderCode, String leaderName, String creatorCode,
			String orgCode, Integer status, String officeAddress, Integer compId) {
		super();
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.leaderCode = leaderCode;
		this.leaderName = leaderName;
		this.creatorCode = creatorCode;
		this.orgCode = orgCode;
		this.status = status;
		this.officeAddress = officeAddress;
		this.compId = compId;
	}

	public BattleTeamRelation(){
	}

	public BattleTeamRelation(
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
	
    
    
	public void setLeaderCode(java.lang.String leaderCode) {
		this.leaderCode = leaderCode;
	}
	
	public java.lang.String getLeaderCode() {
		return this.leaderCode;
	}
	
    
    
	public void setLeaderName(java.lang.String leaderName) {
		this.leaderName = leaderName;
	}
	
	public java.lang.String getLeaderName() {
		return this.leaderName;
	}
	
    
    
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
    public void setCreateTimeBegin(java.util.Date createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}
	
	public java.util.Date getCreateTimeBegin() {
		return this.createTimeBegin;
	}
	
	public void setCreateTimeEnd(java.util.Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	
	public java.util.Date getCreateTimeEnd() {
		return this.createTimeEnd;
	}	
    
    
	public void setCreatorCode(java.lang.String creatorCode) {
		this.creatorCode = creatorCode;
	}
	
	public java.lang.String getCreatorCode() {
		return this.creatorCode;
	}
	
    
    
	public void setOrgCode(java.lang.String orgCode) {
		this.orgCode = orgCode;
	}
	
	public java.lang.String getOrgCode() {
		return this.orgCode;
	}
	
    
    
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
    
    
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	
    public void setUpdateTimeBegin(java.util.Date updateTimeBegin) {
		this.updateTimeBegin = updateTimeBegin;
	}
	
	public java.util.Date getUpdateTimeBegin() {
		return this.updateTimeBegin;
	}
	
	public void setUpdateTimeEnd(java.util.Date updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}
	
	public java.util.Date getUpdateTimeEnd() {
		return this.updateTimeEnd;
	}	
    
    
	public void setUpdaterCode(java.lang.String updaterCode) {
		this.updaterCode = updaterCode;
	}
	
	public java.lang.String getUpdaterCode() {
		return this.updaterCode;
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
	
    
    
 
}

