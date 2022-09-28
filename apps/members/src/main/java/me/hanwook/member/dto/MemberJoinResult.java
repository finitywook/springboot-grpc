package me.hanwook.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.hanwook.member.entity.Member;

@Builder
@Getter @Setter
public class MemberJoinResult {
    private Long id;
    private String loginId;
    private String password;
    private String name;

    public static MemberJoinResult toResult(Member member) {
        return MemberJoinResult.builder()
                .id(member.getId())
                .loginId(member.getLoginId())
                .password(member.getPassword())
                .name(member.getName())
                .build();
    }
}
