package com.kb.bchess.data;

import java.util.HashMap;
import java.util.Map;

public class RegistrationForm {

    private String email;
    private String nickname;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegistrationForm(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("nickname", nickname);
        map.put("password", password);
        return map;
    }
}
