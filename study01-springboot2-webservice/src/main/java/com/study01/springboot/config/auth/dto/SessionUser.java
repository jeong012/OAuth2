package com.study01.springboot.config.auth.dto;

import com.study01.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String nickname;
    private String mobile;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.mobile = user.getMobile();
    }
}
