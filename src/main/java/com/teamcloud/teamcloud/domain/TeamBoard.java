package com.teamcloud.teamcloud.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class TeamBoard {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bdno;

    @Column
    private String title;

    @Column
    private String userid;

    @Column
    private LocalDateTime regdate;

    @Column
    private LocalDateTime updatedDate;

    @Column
    private String contents;

    @Column
    private String views;

    @Column
    private String likes;

    @Builder
    public TeamBoard(Long bdno, String title, String userid, LocalDateTime regdate, LocalDateTime updatedDate, String contents, String views, String likes) {
        this.bdno = bdno;
        this.title = title;
        this.userid = userid;
        this.regdate = regdate;
        this.updatedDate = updatedDate;
        this.contents = contents;
        this.views = views;
        this.likes = likes;
    }
}