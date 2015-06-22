
		/**
		*
		
		* @author ying
		* @version 1.0
		* @since 2015年6月20日 上午10:18:58
		*/
	
package org.bupt.travel.vo;


		/**
		
 * 描述:
 *
 * @author ying
 * @version 1.0
 * @since 2015年6月20日 上午10:18:58
 */

public class BlogDigestItem {
	private int blogId;
	private String title;
	private String visitTime;
	private String duration;
	private String authorName;
	private String locationName;
	private String city;
	private String surfaceUrl;
	
	public BlogDigestItem(int blogId, String title, String visitTime,
			String duration, String authorName, String locationName,
			String city, String surfaceUrl) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.visitTime = visitTime;
		this.duration = duration;
		this.authorName = authorName;
		this.locationName = locationName;
		this.city = city;
		this.surfaceUrl = surfaceUrl;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSurfaceUrl() {
		return surfaceUrl;
	}
	public void setSurfaceUrl(String surfaceUrl) {
		this.surfaceUrl = surfaceUrl;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
}
