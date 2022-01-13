create table team_member
(
    id bigint auto_increment,
    email varchar(255),
    password varchar(255),
    primary key (id)
);

create table team_board
(
    bdno bigint auto_increment,
    title text,
    userid varchar(255),
    regdate varchar(255),
    updatedDate varchar(255),
    contents text,
    views bigint,
    likes bigint,
    primary key (bdno)
);