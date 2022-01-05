package com.teamcloud.teamcloud.repository;

import com.teamcloud.teamcloud.domain.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataJpaMemberRepository extends JpaRepository<TeamMember, Long>, MemberRepository {

    @Override
    Optional<TeamMember> findByEmail(String email);

}
