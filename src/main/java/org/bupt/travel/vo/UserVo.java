package org.bupt.travel.vo;

import java.io.Serializable;

public class UserVo implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8614756057286821686L;

	private java.lang.Integer uid;

	private java.lang.String name;

	private java.lang.String nickname;

	private java.lang.String gender;

	private java.lang.String photoPath;

	public UserVo(Integer id, String name, String nickname, String gender,
			String photoPath) {
		super();
		this.uid = id;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.photoPath = photoPath;
	}

	

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getNickname() {
		return nickname;
	}

	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}

	public java.lang.String getGender() {
		return gender;
	}

	public void setGender(java.lang.String gender) {
		this.gender = gender;
	}

	public java.lang.String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(java.lang.String photoPath) {
		this.photoPath = photoPath;
	}
	
	
}
