package com.teamcloud.teamcloud.controller;

import com.teamcloud.teamcloud.domain.TeamMember;
import com.teamcloud.teamcloud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
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
}
