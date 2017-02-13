package kr.withever.humanlibrary.domain.common.user;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
public enum RoleType {

    SUBSCRIBER("SUBSCRIBER"),
    HUMAN_BOOK("HUMAN_BOOK"),
    ADMIN("ADMIN");

    private String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
