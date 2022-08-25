package me.hanwook.member.service;

import me.hanwook.member.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MemberService memberService;

    @BeforeEach
    public void before() {
        entityManager.persist(
                Member.builder()
                        .loginId("test")
                        .password("p@ss")
                        .name("TEST")
                        .build()
        );
    }

    @Test
    @Transactional
    public void 사용자_단건_조회() throws Exception {
        // given
        Long id = 1L;

        // when
        Member member = memberService.findById(id);

        // then
        assertThat(member.getLoginId()).isEqualTo("test");
        assertThat(member.getPassword()).isEqualTo("p@ss");
        assertThat(member.getName()).isEqualTo("TEST");
    }
}