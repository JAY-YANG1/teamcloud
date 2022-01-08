package com.teamcloud.teamcloud.service;

import com.teamcloud.teamcloud.domain.TeamBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    Page<TeamBoard> findBoardList(Pageable pageable);
    TeamBoard findBoardByBdno(Long bdno);
}
