package kr.withever.humanlibrary.domain.common.user;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
public enum RoleType {

    SUBSCRIBER("SUBSCRIBER", "구독자"),
    HUMAN_BOOK("HUMAN_BOOK", "휴먼북"),
    ADMIN("ADMIN", "관리자");

    private String name;

    private String desc;

    RoleType(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() { return desc; }
}
