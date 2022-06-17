package com.fdproject.config.auth;

import javax.servlet.http.HttpSession;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.fdproject.config.auth.dto.OAuthAttributes;
import com.fdproject.config.auth.dto.SessionUser;
import com.fdproject.domain.UserDTO;
import com.fdproject.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    
    private final UserRepository userRepository;
    private final HttpSession httpSession;
    
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
       OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // 현재 로그인 진행 중인 서비스를 구분하는 코드
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // 키가 되는 필드값 (=Primary Key)
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        // OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담을 클래스
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
//        User user = saveOrUpdate(attributes);

        // 세션에 사용자 정보를 저장하기 위한 Dto 클래스
        String userId = attributes.getUserId();
        String birthDay = attributes.getBirthDay();
        String birthYear = attributes.getBirthYear();
        String name = attributes.getName();
        String phoneNumber = attributes.getPhoneNumber();
        String sex = attributes.getSex();
        System.out.println("=======================================");
        System.out.println(userId + "\n" + birthYear + "\n" + birthDay + "\n" + name + "\n" + phoneNumber + "\n" + sex);
        System.out.println("=======================================");
        
        UserDTO user = new UserDTO();
        httpSession.setAttribute("user", new SessionUser(user));
        
        return oAuth2User;
        
//        return new DefaultOAuth2User(
//                                        Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
//                                        attributes.getAttributes(),
//                                        attributes.getNameAttributeKey());
    }
    
//    private User saveOrUpdate(OAuthAttributes attributes){
//        User user = userRepository.findByEmail(attributes.getEmail())
//                .map(entity -> entity.update(attributes.getName(), attributes.getNickname(), attributes.getMobile()))
//                .orElse(attributes.toEntity());
//        
//        return userRepository.save(user);
//    }
}
