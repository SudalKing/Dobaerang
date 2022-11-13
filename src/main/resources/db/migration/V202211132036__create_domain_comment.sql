drop table if exists comment;

create table comment(
                     id bigint auto_increment NOT NULL,
                     content varchar(500) NOT NULL ,
                     created_at DATETIME NOT NULL ,
                     updated_at DATETIME NOT NULL ,
                     primary key (id)
)