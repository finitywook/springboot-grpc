package me.hanwook.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hanwook.member.dto.MemberJoinParam;
import me.hanwook.member.dto.MemberJoinResult;
import me.hanwook.member.entity.Member;
import me.hanwook.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members/join")
    public ResponseEntity<MemberJoinResult> join(@RequestBody MemberJoinParam param) {
        log.debug("MemberController :: join");

        Member result = memberService.join(param.getLoginId(), param.getPassword(), param.getName());

        return ResponseEntity.ok(
                MemberJoinResult.toResult(result)
        );
    }
}
