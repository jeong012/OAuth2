package com.study01.springboot.domain.user;

import com.study01.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String nickname;

    @Column
    private String gender;

    @Column
    private String birthdate;

    @Column
    private String mobile;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, Role role, String nickname, String gender, String birthdate, String mobile){
        this.name = name;
        this.email = email;
        this.role = role;
        this.nickname = nickname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.mobile = mobile;
    }

    public User update(String name, String nickname, String mobile) {
        this.name = name;
        this.nickname = nickname;
        this.mobile = mobile;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
