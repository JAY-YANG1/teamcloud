package com.teamcloud.teamcloud.service;

import com.teamcloud.teamcloud.domain.TeamBoard;
import com.teamcloud.teamcloud.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    @Override
    public Page<TeamBoard> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize());
        return null; //boardRepository.findAll(pageable);
    }

    @Override
    public TeamBoard findBoardByBdno(Long bdno) {
        return null;
    }
}
