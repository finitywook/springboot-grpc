package me.hanwook.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hanwook.member.entity.Member;
import me.hanwook.member.repository.MemberRepository;
import me.hanwook.order.service.OrderRequest;
import me.hanwook.order.service.OrderServiceGrpc;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

    /**
     * 회원가입
     * @param loginId
     * @param password
     * @param name
     * @return
     */
    @Transactional
    public Member join(String loginId, String password, String name) {

        Member member = memberRepository.save(
                Member.builder()
                        .loginId(loginId)
                        .password(password)
                        .name(name)
                        .build()
        );

        // 가입 축하 선물 발송
        sendJoinGift(member);

        return member;
    }

    /**
     * 가입 축하 선물 발송
     * @param member
     */
    private void sendJoinGift(Member member) {
        orderServiceBlockingStub.create(
                OrderRequest.newBuilder()
                        .setUserId(member.getId())
                        .setQuantity(1)
                        .setPrice(0)
                        .setName("가입 축하 선물을 발송합니다!")
                        .build()
        );
    }

}
