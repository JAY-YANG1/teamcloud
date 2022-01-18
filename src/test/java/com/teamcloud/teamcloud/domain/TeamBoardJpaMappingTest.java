package com.teamcloud.teamcloud.domain;

import com.teamcloud.teamcloud.repository.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeamBoardJpaMappingTest {

    //given
    private final String title = "게시글1";
    private final String contents = "내용1";
    private final String userid = "아이디1";
    private final int views = 1;
    private final int likes = 2;

    @Autowired
    private BoardRepository boardRepository;

    //when
    @Before
    public void init() {
        boardRepository.save(TeamBoard.builder()
                .title(title)
                .contents(contents)
                .userid(userid)
                .regdate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .views(views)
                .likes(likes).build());
    }

    //then
    @Test
    public void test() {
        TeamBoard teamBoard = boardRepository.getOne((long) 1);
        assertThat(teamBoard.getTitle(), is(title));
        assertThat(teamBoard.getContents(), is(contents));
        assertThat(teamBoard.getUserid(), is(userid));
    }
}