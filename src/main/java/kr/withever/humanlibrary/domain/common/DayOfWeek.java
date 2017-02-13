package kr.withever.humanlibrary.domain.common;

/**
 * Created by youngjinkim on 2017. 2. 13..
 */
public enum DayOfWeek {

    SUNDAY(1, "SUNDAY"),
    MONDAY(2, "MONDAY"),
    TUESDAY(3, "TUESDAY"),
    WEDNESDAY(4, "WEDNESDAY"),
    THURSDAY(5, "THURSDAY"),
    FRIDAY(6, "FRIDAY"),
    SATURDAY(7, "SATURDAY");

    private int code;

    private String name;

    DayOfWeek(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
