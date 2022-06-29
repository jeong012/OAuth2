package com.fdproject.config.auth.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String userId;
    private String name;
    private String phoneNumber;
    private String sex;
    private String birthYear;
    private String birthDay;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String userId, String name,
                           String phoneNumber, String sex,
                           String birthYear, String birthDay){
    	
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.birthYear = birthYear;
        this.birthDay = birthDay;
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
                .userId((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName,
                                           Map<String, Object> attributes){
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .userId((String) response.get("email"))
                .name((String) response.get("name"))
                .phoneNumber((String) response.get("mobile"))
                .sex((String) response.get("gender"))
                .birthYear((String) response.get("birthyear"))
                .birthDay((String) response.get("birthday"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName,
                                           Map<String, Object> attributes){

        Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");

        String userId = (String) kakao_account.get("email");
        Map<String, Object> profile = (Map<String, Object>) kakao_account.get("profile");
        String name = (String) profile.get("nickname");
        String sex = (String) kakao_account.get("gender");
        String birthday = (String) kakao_account.get("birthday");

        return OAuthAttributes.builder()
                .userId(userId)
                .name(name)
                .sex(sex)
                .birthDay(birthday)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
}
