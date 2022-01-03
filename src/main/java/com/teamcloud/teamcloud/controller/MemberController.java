package com.teamcloud.teamcloud.controller;

import com.teamcloud.teamcloud.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/login")
    public String login() {
        return "/members/login";
    }

    @PostMapping("/members/login")
    public String validateLogin() {
        return null;
    }

    @GetMapping("/members/createMember")
    public String createMember() {
        return "/members/createMember";
    }

    @PostMapping("/members/createMember")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());

        // memberService.join(member);

        return "redirect:/";
    }
}
