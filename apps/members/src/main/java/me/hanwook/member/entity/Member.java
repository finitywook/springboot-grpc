package me.hanwook.member.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 20)
    private String loginId;

    @Column(length = 200)
    private String password;

    @Column(length = 100)
    private String name;

    @Builder
    public Member(String loginId, String password, String name) {
        Assert.hasText(loginId, "loginId must not be null!");
        Assert.hasText(password, "password must not be null!");
        Assert.hasText(name, "name must not be null!");

        this.loginId = loginId;
        this.password = password;
        this.name = name;
    }
}
