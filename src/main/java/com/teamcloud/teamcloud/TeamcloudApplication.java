package com.teamcloud.teamcloud;

import com.teamcloud.teamcloud.domain.TeamBoard;
import com.teamcloud.teamcloud.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;


@SpringBootApplication
public class TeamcloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamcloudApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner runner(BoardRepository boardRepository) throws Exception {
//        return (args) -> {
//            IntStream.rangeClosed(1, 100).forEach(index ->
//                    boardRepository.save(TeamBoard.builder()
//                            .title("게시글" + index)
//                            .contents("내용" + index)
//                            .userid("아이디" + index)
//                            .likes(1)
//                            .views(2)
//                            .regdate(LocalDateTime.now())
//                            .updatedDate(LocalDateTime.now()).build()));
//        };
//    }

}

