package kr.withever.humanlibrary.domain.humanbook;

import java.io.Serializable;

import kr.withever.humanlibrary.domain.User;

public class Humanbook implements Serializable{
	private Long hbId; // humanbook primary key
	private String loginId; // login id
	private String hbTitle;
	private String hbMainCareer;
	private String hbStatus;
	private String serviceTime;
	private String upperCategory;
	private String subCategory;
	private Long hbCreateTime;
	private Long hbUpdateTime;
	
	public Humanbook(){
	}
	
	public Humanbook(String userId, Long hbId, String hbTitle){
		this.loginId = userId;
		this.hbId = hbId;
		this.hbTitle = hbTitle;
		this.hbCreateTime = System.currentTimeMillis() / 1000;
		this.hbUpdateTime = System.currentTimeMillis() / 1000;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String userId) {
		this.loginId = userId;
	}

	public Long getHbId() {
		return hbId;
	}

	public void setHbId(Long hbId) {
		this.hbId = hbId;
	}

	public String getHbTitle() {
		return hbTitle;
	}

	public void setHbTitle(String hbTitle) {
		this.hbTitle = hbTitle;
	}

	public String getHbMainCareer() {
		return hbMainCareer;
	}

	public void setHbMainCareer(String hbMainCareer) {
		this.hbMainCareer = hbMainCareer;
	}

	public String getHbStatus() {
		return hbStatus;
	}

	public void setHbStatus(String hbStatus) {
		this.hbStatus = hbStatus;
	}

	public Long getHbCreateTime() {
		return hbCreateTime;
	}

	public void setHbCreateTime(Long hbCreateTime) {
		this.hbCreateTime = hbCreateTime;
	}

	public Long getHbUpdateTime() {
		return hbUpdateTime;
	}

	public void setHbUpdateTime(Long hbUpdateTime) {
		this.hbUpdateTime = hbUpdateTime;
	}

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String hbServiceTime) {
		this.serviceTime = hbServiceTime;
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
	
}
