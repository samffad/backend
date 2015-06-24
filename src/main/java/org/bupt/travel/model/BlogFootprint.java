/*
* BlogFootprint.java 2014-12-15
*/
package org.bupt.travel.model;
import java.util.Date;


public class BlogFootprint{
 
	  // 【in 查询使用】
	 private java.lang.Integer ids;
	 // 【排序  使用】
	 private java.lang.String sortColumns;

 
	 /**
     * 描述:id     
     * 字段: id  INT(10)  
     */	
	private java.lang.Integer id;

 
	 /**
     * 描述:blogRefId     
     * 字段: blog_ref_id  INT(10)  
     */	
	private java.lang.Integer blogRefId;

 
	 /**
     * 描述:seqId     
     * 字段: seq_id  INT(10)  
     */	
	private java.lang.Integer seqId;

 
	 /**
     * 描述:desc     
     * 字段: desc  VARCHAR(300)  
     */	
	private java.lang.String desc;

 
	 /**
     * 描述:locationName     
     * 字段: location_name  VARCHAR(50)  
     */	
	private java.lang.String locationName;

 
	 /**
     * 描述:lon     
     * 字段: lon  DOUBLE(22)  
     */	
	private java.lang.Double lon;

 
	 /**
     * 描述:lat     
     * 字段: lat  DOUBLE(22)  
     */	
	private java.lang.Double lat;

 
	 /**
     * 描述:visitTime     
     * 字段: visit_time  DATETIME(19)  
     */	
	private java.util.Date visitTime;

	//【非数据库字段，查询时使用】
	private java.util.Date visitTimeBegin;
	//【非数据库字段，查询时使用】
	private java.util.Date visitTimeEnd;
 
	 /**
     * 描述:createTime     
     * 字段: create_time  DATETIME(19)  
     */	
	private java.util.Date createTime;

	//【非数据库字段，查询时使用】
	private java.util.Date createTimeBegin;
	//【非数据库字段，查询时使用】
	private java.util.Date createTimeEnd;
 
	 /**
     * 描述:status     
     * 字段: status  INT(10)  
     */	
	private java.lang.Integer status;

 
 
	public BlogFootprint(Integer blogRefId, String desc, String locationName,
			Double lon, Double lat, Date visitTime, Date createTime,
			Integer status) {
		super();
		this.blogRefId = blogRefId;
		this.desc = desc;
		this.locationName = locationName;
		this.lon = lon;
		this.lat = lat;
		this.visitTime = visitTime;
		this.createTime = createTime;
		this.status = status;
	}

	public BlogFootprint(){
	}

	public BlogFootprint(
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
	
    
    
	public void setBlogRefId(java.lang.Integer blogRefId) {
		this.blogRefId = blogRefId;
	}
	
	public java.lang.Integer getBlogRefId() {
		return this.blogRefId;
	}
	
    
    
	public void setSeqId(java.lang.Integer seqId) {
		this.seqId = seqId;
	}
	
	public java.lang.Integer getSeqId() {
		return this.seqId;
	}
	
    
    
	public void setDesc(java.lang.String desc) {
		this.desc = desc;
	}
	
	public java.lang.String getDesc() {
		return this.desc;
	}
	
    
    
	public void setLocationName(java.lang.String locationName) {
		this.locationName = locationName;
	}
	
	public java.lang.String getLocationName() {
		return this.locationName;
	}
	
    
    
	public void setLon(java.lang.Double lon) {
		this.lon = lon;
	}
	
	public java.lang.Double getLon() {
		return this.lon;
	}
	
    
    
	public void setLat(java.lang.Double lat) {
		this.lat = lat;
	}
	
	public java.lang.Double getLat() {
		return this.lat;
	}
	
    
    
	public void setVisitTime(java.util.Date visitTime) {
		this.visitTime = visitTime;
	}
	
	public java.util.Date getVisitTime() {
		return this.visitTime;
	}
	
    public void setVisitTimeBegin(java.util.Date visitTimeBegin) {
		this.visitTimeBegin = visitTimeBegin;
	}
	
	public java.util.Date getVisitTimeBegin() {
		return this.visitTimeBegin;
	}
	
	public void setVisitTimeEnd(java.util.Date visitTimeEnd) {
		this.visitTimeEnd = visitTimeEnd;
	}
	
	public java.util.Date getVisitTimeEnd() {
		return this.visitTimeEnd;
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
    
    
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
    
    
 
}

