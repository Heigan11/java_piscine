drop table if exists chat_massages, chat_rooms, chat_users CASCADE;

create table if not exists chat_users (
    id     serial primary key ,
    login       text not null UNIQUE,
    password    text
);

create table if not exists chat_rooms (
    id              serial primary key ,
    owner   bigint not null references chat_users(id) ,
    name    text not null
);

create table if not exists chat_messages (
    id          serial primary key,
    messageRoom    bigint not null references chat_rooms(id),
    messageAuthor  bigint not null references chat_users(id),
    messageText    text not null ,
    messageTime   timestamp
);