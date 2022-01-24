package com.teamcloud.teamcloud.service;

import com.teamcloud.teamcloud.domain.TeamMember;

import javax.servlet.http.HttpSession;

public interface MemberService {

    String join(TeamMember teamMember);

    Boolean login(TeamMember teamMember, HttpSession sess);
}
