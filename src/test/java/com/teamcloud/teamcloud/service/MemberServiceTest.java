package com.teamcloud.teamcloud.service;

import com.teamcloud.teamcloud.domain.TeamMember;
import com.teamcloud.teamcloud.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;

    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //Given
        TeamMember teamMember = new TeamMember();
        teamMember.setEmail("hello");
        //When
        String saveEmail = memberService.join(teamMember);
        //Then
        TeamMember findMember = memberRepository.findByEmail(saveEmail).get();
        assertEquals(teamMember.getEmail(), findMember.getEmail());
    }

    @Test
    public void 중복_회원_예외() throws Exception {

        //Given
        TeamMember member1 = new TeamMember();
        member1.setEmail("spring");
        TeamMember member2 = new TeamMember();
        member2.setEmail("spring");

        //When
        memberService.join(member1);

        //Then
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}