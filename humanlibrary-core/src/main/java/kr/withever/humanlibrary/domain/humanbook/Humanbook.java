package kr.withever.humanlibrary.domain.humanbook;

import kr.withever.humanlibrary.domain.common.humanbook.HumanbookState;
import kr.withever.humanlibrary.domain.common.humanbook.HumanbookTime;

import java.io.Serializable;
import java.util.Set;

public class Humanbook implements Serializable{

	private static final long serialVersionUID = -5705360965002860670L;

	private Long id;
	/** 휴먼북 등록한 사용자 ID **/
	private String userId;
	private String title;
	private String mainCareer;
	private Set<String> serviceDay;
	private String serviceTime;
	private Category parentCategory;
	private Category subCategory;
	private HumanbookState state;
	private String imageUrl;
	private String description;
	private Long createTime;
	private Long updateTime;
	
	public Humanbook(){
	}

	public Humanbook(Long id) {
		this.id = id;
	}

	public Humanbook(String userId, Long id, String title){
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.createTime = System.currentTimeMillis() / 1000;
		this.updateTime = System.currentTimeMillis() / 1000;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Set<String> getServiceDay() {
		return serviceDay;
	}

	public void setServiceDay(Set<String> serviceDay) {
		this.serviceDay = serviceDay;
	}

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category upperCategory) {
		this.parentCategory = upperCategory;
	}

	public Category getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Category subCategory) {
		this.subCategory = subCategory;
	}

	public HumanbookState getState() {
		return state;
	}

	public void setState(HumanbookState state) {
		this.state = state;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
}
