drop table if exists users ;

create table if not exists users (
    id          bigserial primary key ,
    email       text not null UNIQUE
);