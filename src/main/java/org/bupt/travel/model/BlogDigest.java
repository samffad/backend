/*
* BlogDigest.java 2014-12-15
*/
package org.bupt.travel.model;
import java.util.Date;


public class BlogDigest{
 
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
     * 描述:title     
     * 字段: title  VARCHAR(20)  
     */	
	private java.lang.String title;

 
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
     * 描述:location     
     * 字段: location  VARCHAR(50)  
     */	
	private java.lang.String location;

 
	 /**
     * 描述:duration     
     * 字段: duration  INT(10)  
     */	
	private java.lang.Integer duration;

 
	 /**
     * 描述:authorId     
     * 字段: author_id  INT(10)  
     */	
	private java.lang.Integer authorId;

 
	 /**
     * 描述:authorName     
     * 字段: author_name  VARCHAR(20)  
     */	
	private java.lang.String authorName;

 
	 /**
     * 描述:description     
     * 字段: description  VARCHAR(200)  
     */	
	private java.lang.String description;

 
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
	
	private BlogFootprint bFootprint;
	
	
	
 
 
	public BlogDigest(String title, Date visitTime, String location,
			Integer duration, Integer authorId, String authorName,
			String description, Date createTime, Integer status) {
		super();
		this.title = title;
		this.visitTime = visitTime;
		this.location = location;
		this.duration = duration;
		this.authorId = authorId;
		this.authorName = authorName;
		this.description = description;
		this.createTime = createTime;
		this.status = status;
	}

	public BlogFootprint getbFootprint() {
		return bFootprint;
	}

	public void setbFootprint(BlogFootprint bFootprint) {
		this.bFootprint = bFootprint;
	}

	public BlogDigest(){
	}

	public BlogDigest(
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
	
    
    
	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	
	public java.lang.String getTitle() {
		return this.title;
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
    
    
	public void setLocation(java.lang.String location) {
		this.location = location;
	}
	
	public java.lang.String getLocation() {
		return this.location;
	}
	
    
    
	public void setDuration(java.lang.Integer duration) {
		this.duration = duration;
	}
	
	public java.lang.Integer getDuration() {
		return this.duration;
	}
	
    
    
	public void setAuthorId(java.lang.Integer authorId) {
		this.authorId = authorId;
	}
	
	public java.lang.Integer getAuthorId() {
		return this.authorId;
	}
	
    
    
	public void setAuthorName(java.lang.String authorName) {
		this.authorName = authorName;
	}
	
	public java.lang.String getAuthorName() {
		return this.authorName;
	}
	
    
    
	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	
	public java.lang.String getDescription() {
		return this.description;
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

