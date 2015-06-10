/*
* User.java 2014-12-15
*/
package org.bupt.travel.model;
import java.util.Date;


public class User{
 
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
     * 描述:name     
     * 字段: name  VARCHAR(20)  
     */	
	private java.lang.String name;

 
	 /**
     * 描述:nickname     
     * 字段: nickname  VARCHAR(20)  
     */	
	private java.lang.String nickname;

 
	 /**
     * 描述:gender     
     * 字段: gender  INT(10)  
     */	
	private java.lang.Integer gender;

 
	 /**
     * 描述:password     
     * 字段: password  VARCHAR(20)  
     */	
	private java.lang.String password;

 
	 /**
     * 描述:photoPath     
     * 字段: photo_path  VARCHAR(255)  
     */	
	private java.lang.String photoPath;

	
 
	public User(String name) {
		super();
		this.name = name;
	}
	
	

	public User(String name, String nickname, Integer gender, String password,
			String photoPath) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.password = password;
		this.photoPath = photoPath;
	}



	public User(){
	}

	public User(
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
	
    
    
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
    
    
	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}
	
	public java.lang.String getNickname() {
		return this.nickname;
	}
	
    
    
	public void setGender(java.lang.Integer gender) {
		this.gender = gender;
	}
	
	public java.lang.Integer getGender() {
		return this.gender;
	}
	
    
    
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	
    
    
	public void setPhotoPath(java.lang.String photoPath) {
		this.photoPath = photoPath;
	}
	
	public java.lang.String getPhotoPath() {
		return this.photoPath;
	}
	
    
    
 
}

