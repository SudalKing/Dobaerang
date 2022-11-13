drop table if exists post;

create table post(
    id bigint auto_increment NOT NULL,
    title varchar(255) NOT NULL ,
    content varchar(500) NOT NULL ,
    created_at DATETIME NOT NULL ,
    updated_at DATETIME NOT NULL ,
    primary key (id)
)