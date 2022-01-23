package com.teamcloud.teamcloud.service;

import com.teamcloud.teamcloud.domain.TeamBoard;
import com.teamcloud.teamcloud.repository.BoardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
class BoardServiceImplTest {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;


    @Test
    public void 게시글번호로찾기() throws Exception {
        //given
        TeamBoard teamBoard = TeamBoard.builder()
                .userid("testId")
                .title("testTitle")
                .contents("testContents")
                .views(7)
                .likes(7)
                .regdate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now()).build();
        //when
        TeamBoard findBoard = boardService.findBoardByBdno(teamBoard.getBdno());

        //then
        Assertions.assertEquals(teamBoard.getBdno(), findBoard.getBdno());
    }



}