package kr.withever.humanlibrary.domain.user;

import kr.withever.humanlibrary.domain.common.PageSearch;

/**
 * Created by youngjinkim on 2017. 3. 8..
 */
public class UserSearch extends PageSearch<User> {

    private String name;

    private String email;

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
}
