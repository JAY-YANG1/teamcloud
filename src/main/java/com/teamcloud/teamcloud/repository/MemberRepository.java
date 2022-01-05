package com.teamcloud.teamcloud.repository;

import com.teamcloud.teamcloud.domain.TeamMember;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    TeamMember save(TeamMember teamMember);
    Optional<TeamMember> findById(Long id);
    Optional<TeamMember> findByEmail(String email);
    List<TeamMember> findAll();
}
