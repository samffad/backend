/*
* Photoinfo.java 2014-12-15
*/
package org.bupt.travel.model;
import java.util.Date;


public class Photoinfo{
 
	  // 【in 查询使用】
	 private java.lang.Integer ids;
	 // 【排序  使用】
	 private java.lang.String sortColumns;

 
	 /**
     * 描述:id     
     * 字段: id  INT UNSIGNED(10)  
     */	
	private java.lang.Integer id;

 
	 /**
     * 描述:photoName     
     * 字段: photo_name  VARCHAR(50)  
     */	
	private java.lang.String photoName;

 
	 /**
     * 描述:photoPath     
     * 字段: photo_path  VARCHAR(200)  
     */	
	private java.lang.String photoPath;

 
	 /**
     * 描述:photoRevisePath     
     * 字段: photo_revise_path  VARCHAR(200)  
     */	
	private java.lang.String photoRevisePath;

 
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
     * 描述:0-ok 1-deleted     
     * 字段: status  INT(10)  
     */	
	private java.lang.Integer status;

 
	 /**
     * 描述:userId     
     * 字段: user_id  INT(10)  
     */	
	private java.lang.Integer userId;

 
	 /**
     * 描述:blogId     
     * 字段: blog_id  INT(10)  
     */	
	private java.lang.Integer blogId;

 
	 /**
     * 描述:footprintId     
     * 字段: footprint_id  INT(10)  
     */	
	private java.lang.Integer footprintId;

 
	 /**
     * 描述:0-blog picture 1-blog surface 2-user avatar     
     * 字段: type  INT(10)  
     */	
	private java.lang.Integer type;

 
 
	public Photoinfo(){
	}

	public Photoinfo(
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
	
    
    
	public void setPhotoName(java.lang.String photoName) {
		this.photoName = photoName;
	}
	
	public java.lang.String getPhotoName() {
		return this.photoName;
	}
	
    
    
	public void setPhotoPath(java.lang.String photoPath) {
		this.photoPath = photoPath;
	}
	
	public java.lang.String getPhotoPath() {
		return this.photoPath;
	}
	
    
    
	public void setPhotoRevisePath(java.lang.String photoRevisePath) {
		this.photoRevisePath = photoRevisePath;
	}
	
	public java.lang.String getPhotoRevisePath() {
		return this.photoRevisePath;
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
	
    
    
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
    
    
	public void setBlogId(java.lang.Integer blogId) {
		this.blogId = blogId;
	}
	
	public java.lang.Integer getBlogId() {
		return this.blogId;
	}
	
    
    
	public void setFootprintId(java.lang.Integer footprintId) {
		this.footprintId = footprintId;
	}
	
	public java.lang.Integer getFootprintId() {
		return this.footprintId;
	}
	
    
    
	public void setType(java.lang.Integer type) {
		this.type = type;
	}
	
	public java.lang.Integer getType() {
		return this.type;
	}
	
    
    
 
}

