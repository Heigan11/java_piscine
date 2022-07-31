drop table if exists users ;

create table if not exists users (
    id          bigserial primary key ,
    username    text not null UNIQUE ,
    password    text not null
);