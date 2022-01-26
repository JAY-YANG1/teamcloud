package com.teamcloud.teamcloud.service;

import com.teamcloud.teamcloud.domain.TeamMember;
import com.teamcloud.teamcloud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

@Service @Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    // 회원가입
    @Override
    public String join(TeamMember teamMember) {
        long start = System.currentTimeMillis();
        try {
            validateDuplicateMember(teamMember); // 중복 회원 검증
            memberRepository.save(teamMember);
            return teamMember.getEmail();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join " + timeMs + "ms");
        }
    }

    @Override
    public Boolean login(TeamMember teamMember, HttpSession sess) {
        boolean isLogin = false;

        Optional<TeamMember> teamMember2 = memberRepository.findByEmail(teamMember.getEmail());
        if (teamMember2.get().equals(teamMember)) {
            sess.setAttribute("UserId",teamMember.getEmail());
            isLogin = true;
        }

        return isLogin;
    }

    private void validateDuplicateMember(TeamMember teamMember) {
        memberRepository.findByEmail(teamMember.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
