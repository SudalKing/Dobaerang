drop table if exists role;

create table role(
    id bigint auto_increment,
    type varchar(255),
    primary key (id)
)