package kr.withever.humanlibrary.domain.user;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by youngjinkim on 2017. 2. 6..
 */
public class User implements Serializable {

    private Long userId;

    private String loginId;

    private String name;

    private String email;

    private String password;

    private String phoneNo;

    private String mPhoneNo;

    private String birth;

    private String zipCode;

    private String address;

    private String detailAddress;

    private Set<String> roles;

    private Long createTime;

    private Long updateTime;

    public User() {
    }

    public User(Long userId) {
        this.userId = userId;
    }

    public User(String loginId, String name, String email, String password) {
        this.loginId = loginId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createTime = System.currentTimeMillis() / 1000;
        this.updateTime = System.currentTimeMillis() / 1000;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getmPhoneNo() {
        return mPhoneNo;
    }

    public void setmPhoneNo(String mPhoneNo) {
        this.mPhoneNo = mPhoneNo;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
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
