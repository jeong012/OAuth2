package com.fdproject.config.auth.dto;

import java.io.Serializable;

import com.fdproject.domain.UserDTO;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
	private int userNo;
    private String name;
    private String userId;
    private String phoneNumber;
    private String sex;
    private String mobile;
    private String birthDate;

    public SessionUser(UserDTO user){
    	this.userNo = user.getUserNo();
        this.userId = user.getUserId();
        this.name = user.getName();
        this.phoneNumber = user.getPhoneNumber();
        this.sex = user.getSex();
        this.birthDate = user.getBirthDate();
    }
}
