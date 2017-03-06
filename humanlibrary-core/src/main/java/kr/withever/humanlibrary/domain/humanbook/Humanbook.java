package kr.withever.humanlibrary.domain.humanbook;

import java.io.Serializable;
import java.util.Set;

public class Humanbook implements Serializable{
	private Long id; // humanbook primary key
	private String userId; // login id
	private String title;
	private String mainCareer;
	private Set<String> serviceDay;
	private String serviceTime;
	private String upperCategory;
	private String subCategory;
	private Long createTime;
	private Long updateTime;
	private String status;
	
	public Humanbook(){
	}
	
	public Humanbook(String userId, Long id, String title){
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.createTime = System.currentTimeMillis() / 1000;
		this.updateTime = System.currentTimeMillis() / 1000;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMainCareer() {
		return mainCareer;
	}

	public void setMainCareer(String mainCareer) {
		this.mainCareer = mainCareer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getUpperCategory() {
		return upperCategory;
	}

	public void setUpperCategory(String upperCategory) {
		this.upperCategory = upperCategory;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Set<String> getServiceDay() {
		return serviceDay;
	}

	public void setServiceDay(Set<String> serviceDay) {
		this.serviceDay = serviceDay;
	}

}
