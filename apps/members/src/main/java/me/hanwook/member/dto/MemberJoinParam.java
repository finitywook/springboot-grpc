package me.hanwook.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class MemberJoinParam {
    private String loginId;
    private String password;
    private String name;
}
