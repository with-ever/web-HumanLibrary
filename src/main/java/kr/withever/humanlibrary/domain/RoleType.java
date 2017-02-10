package kr.withever.humanlibrary.domain;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
public enum RoleType {

    SUBSCRIBER("SUBSCRIBER"),
    HUMAN_BOOK("HUMAN_BOOK");

    private String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
