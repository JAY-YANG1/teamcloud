package com.teamcloud.teamcloud.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamBoard {

    @Id
    private String bdno;

    private String title;
    private String userid;
    private String regdate;
    private String contents;
    private String views;
    private String likes;

    public String getBdno() {
        return bdno;
    }

    public void setBdno(String bno) {
        this.bdno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}