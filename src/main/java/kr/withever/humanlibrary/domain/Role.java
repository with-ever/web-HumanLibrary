package kr.withever.humanlibrary.domain;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
public class Role {

    private String roleId;

    public Role() {
    }

    public Role(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
