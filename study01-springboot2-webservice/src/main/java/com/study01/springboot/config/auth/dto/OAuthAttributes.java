package com.study01.springboot.config.auth.dto;

import com.study01.springboot.domain.user.Role;
import com.study01.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.awt.*;
import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String nickname;
    private String gender;
    private String birthdate;
    private String mobile;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String name, String email,
                           String nickname, String gender,
                           String birthdate, String mobile){

        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.mobile = mobile;
    }

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes){

        if("naver".equals(registrationId)){
            return ofNaver("id", attributes);
        } else if ("kakao".equals(registrationId)) {
            return ofKakao("id", attributes);
        } else {
            return ofGoogle(userNameAttributeName, attributes);
        }
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes){

        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName,
                                           Map<String, Object> attributes){
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .nickname((String) response.get("nickname"))
                .gender((String) response.get("gender"))
                .birthdate((String) response.get("birthyear") + "-" + (String) response.get("birthday"))
                .mobile((String) response.get("mobile"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName,
                                           Map<String, Object> attributes){

        Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");

        String email = (String) kakao_account.get("email");
        String birthday = (String) kakao_account.get("birthday");
        String gender = (String) kakao_account.get("gender");

        Map<String, Object> profile = (Map<String, Object>) kakao_account.get("profile");
        String name = (String) profile.get("nickname");

        return OAuthAttributes.builder()
                .name(name)
                .email(email)
                .gender(gender)
                .birthdate(birthday)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .nickname(nickname)
                .gender(gender)
                .birthdate(birthdate)
                .mobile(mobile)
                .role(Role.GUEST)
                .build();
    }
}
