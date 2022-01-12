package com.teamcloud.teamcloud.repository;

import com.teamcloud.teamcloud.domain.TeamBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataJpaBoardRepository extends JpaRepository<TeamBoard, Long> , BoardRepository {

    @Override
    Optional<TeamBoard> findByBdno(Long bdno);

    @Override
    void deleteByBdno(Long bdno);
}
