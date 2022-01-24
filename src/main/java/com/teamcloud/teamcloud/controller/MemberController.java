package com.teamcloud.teamcloud.controller;

import com.teamcloud.teamcloud.domain.TeamMember;
import com.teamcloud.teamcloud.repository.MemberRepository;
import com.teamcloud.teamcloud.service.MemberService;
import com.teamcloud.teamcloud.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;

    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }




    @GetMapping("/login")
    public String login() {
        return "/members/login";
    }

    @GetMapping("/createMember")
    public String createMember() {
        return "/members/createMember";
    }

    @PostMapping("/members/createMember")
    public String create(MemberForm form) {
        TeamMember teamMember = new TeamMember();
        teamMember.setEmail(form.getEmail());
        teamMember.setPassword(form.getPassword());

        memberService.join(teamMember);

        return "redirect:/";
    }

    @PostMapping("/members/login")
    public String signin(MemberForm form, HttpSession sess) {
        TeamMember teamMember = new TeamMember();
        teamMember.setEmail(form.getEmail());
        teamMember.setPassword(form.getPassword());

        memberService.login(teamMember, sess);

        return "redirect:/";
    }
}
