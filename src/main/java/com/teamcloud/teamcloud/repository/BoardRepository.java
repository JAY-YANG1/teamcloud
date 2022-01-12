package com.teamcloud.teamcloud.repository;


import com.teamcloud.teamcloud.domain.TeamBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BoardRepository {
    Page<TeamBoard> findAll(Pageable pageable);

    Optional<TeamBoard> findByBdno(Long bdno);

    void save(TeamBoard board);

    TeamBoard getOne(Long bdno);

    void deleteByBdno(Long bdno);
}
