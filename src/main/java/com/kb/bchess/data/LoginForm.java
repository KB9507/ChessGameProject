package com.kb.bchess.data;

import java.util.HashMap;
import java.util.Map;

public class LoginForm {

    private String login;
    private String password;

    public LoginForm(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("login", login);
        map.put("password", password);
        return map;
    }
}
