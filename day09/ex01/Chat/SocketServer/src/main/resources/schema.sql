drop table if exists users ;

create table if not exists users (
    id          bigserial primary key ,
    username    text not null UNIQUE ,
    password    text not null
);

drop table if exists messages ;

create table if not exists messages (
                                        id      bigserial primary key ,
                                        author  bigint not null references users(id) ,
                                        text    text not null ,
                                        time    timestamp DEFAULT NULL
);