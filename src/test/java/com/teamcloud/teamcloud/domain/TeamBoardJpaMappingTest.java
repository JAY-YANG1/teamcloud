package com.teamcloud.teamcloud.domain;

import com.teamcloud.teamcloud.repository.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TeamBoardJpaMappingTest {

    private final String title = "테스트";
    private final String contents = "내용";
    private final String views = "1";
    private final String likes = "2";

    @Autowired
    private BoardRepository boardRepository;


    @Before
    public void init() {
        boardRepository.save(TeamBoard.builder()
                .title(title)
                .contents(contents)
                .regdate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .views(views)
                .likes(likes).build());
    }

    @Test
    public void test() {
        TeamBoard board = boardRepository.getOne((long) 1);
        assertThat(board.getTitle(), is(title));
        assertThat(board.getContents(), is(contents));
    }
}