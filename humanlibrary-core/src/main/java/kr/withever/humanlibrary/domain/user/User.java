package kr.withever.humanlibrary.domain.user;

import kr.withever.humanlibrary.domain.common.user.Gender;
import kr.withever.humanlibrary.domain.common.user.RoleType;
import kr.withever.humanlibrary.util.AESEncryptionUtil;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by youngjinkim on 2017. 2. 6..
 */
public class User implements Serializable {

    private static final long serialVersionUID = -5021384076538644565L;

    private Long userId;

    private String loginId;

    private String name;

    private String email;

    private String password;

    private String gender;

    private String phoneNo;

    private String mPhoneNo;

    private String birth;

    private String zipCode;

    private String address;

    private String imageUrl;

    private Set<String> roles;

    private Long createTime;

    private Long updateTime;

    public User() {
        this.createTime = System.currentTimeMillis() / 1000;
        this.updateTime = System.currentTimeMillis() / 1000;
    }

    public User(Long userId) {
        this.userId = userId;
        this.createTime = System.currentTimeMillis() / 1000;
        this.updateTime = System.currentTimeMillis() / 1000;
    }

    public User(String loginId, String name, String email, String password, String gender) {
        this.loginId = loginId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public void setUpdatedUser(User user) {
        // @TODO String utils 만들기.
        this.name =  StringUtils.isEmpty(user.getName()) ? this.name : user.getName();
        this.email =  StringUtils.isEmpty(user.getEmail()) ? this.email : user.getEmail();
        this.gender = StringUtils.isEmpty(user.getGender()) ? this.gender : user.getGender();
        this.phoneNo =  StringUtils.isEmpty(user.getPhoneNo()) ? this.phoneNo : user.getPhoneNo();
        this.mPhoneNo =  StringUtils.isEmpty(user.getmPhoneNo()) ? this.mPhoneNo : user.getmPhoneNo();
        this.birth =  StringUtils.isEmpty(user.getBirth()) ? this.birth : user.getBirth();
        this.zipCode =  StringUtils.isEmpty(user.getZipCode()) ? this.zipCode : user.getZipCode();
        this.address =  StringUtils.isEmpty(user.getAddress()) ? this.address : user.getAddress();
        this.imageUrl =  StringUtils.isEmpty(user.getImageUrl()) ? this.imageUrl : user.getImageUrl();
        this.updateTime = System.currentTimeMillis() / 1000;
    }

    public static User encryptUser(User user) {
        AESEncryptionUtil aesEncryptionUtil = new AESEncryptionUtil();

        try {
            user.setEmail(aesEncryptionUtil.encrypt(user.getEmail()));
            user.setPhoneNo(aesEncryptionUtil.encrypt(user.getPhoneNo()));
            user.setmPhoneNo(aesEncryptionUtil.encrypt(user.getmPhoneNo()));
            user.setAddress(aesEncryptionUtil.encrypt(user.getAddress()));
        } catch (Exception e) {
            throw new RuntimeException("개인정보 암호화 실패", e);
        }
        return user;
    }

    public static User decryptUser(User user) {
        AESEncryptionUtil aesEncryptionUtil = new AESEncryptionUtil();

        try {
            user.setEmail(aesEncryptionUtil.decrypt(user.getEmail()));
            user.setPhoneNo(aesEncryptionUtil.decrypt(user.getPhoneNo()));
            user.setmPhoneNo(aesEncryptionUtil.decrypt(user.getmPhoneNo()));
            user.setAddress(aesEncryptionUtil.decrypt(user.getAddress()));
        } catch (Exception e) {
            throw new RuntimeException("개인정보 복호화 실패", e);
        }

        return user;
    }

    // DTO
    public String getGenderText() {
        return this.gender.equals(Gender.MALE.name()) ? "남자" : "여자";
    }

    public Set<String> getRoleTextList() {
        Set<String> roleText = new HashSet<String>();
        for (String role : this.roles) {
            if (RoleType.ADMIN.name().equals(role)) {
                roleText.add(RoleType.ADMIN.getDesc());
            } else if (RoleType.SUBSCRIBER.name().equals(role)) {
                roleText.add(RoleType.SUBSCRIBER.getDesc());
            } else if (RoleType.HUMAN_BOOK.name().equals(role)) {
                roleText.add(RoleType.HUMAN_BOOK.getDesc());
            }
        }
        return roleText;
    }
    public Date getCreateDate() {
        return new Date(this.createTime * 1000);
    }

    public Date getUpdateDate() {
        return new Date(this.updateTime * 1000);
    }

}
