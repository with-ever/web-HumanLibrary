package kr.withever.humanlibrary.domain.user;

import kr.withever.humanlibrary.domain.common.user.RoleType;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
public class Role {

    private Long userId;

    private String roleId;

    public Role() {
    }

    public Role(RoleType roleType) {
        this.roleId = roleType.getName();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
