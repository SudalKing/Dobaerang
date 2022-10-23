drop table if exists user;

create table user(
    id bigint auto_increment,
    username varchar(255) NOT NULL ,
    password varchar(255) NOT NULL ,
    enabled BIT(1) NOT NULL ,
    created_at DATETIME,
    updated_at DATETIME,
    primary key (id)
)