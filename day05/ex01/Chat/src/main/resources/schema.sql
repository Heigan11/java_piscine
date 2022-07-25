drop table if exists chat_massages, chat_rooms, chat_users CASCADE;

create table if not exists chat_users (
    userId      serial primary key ,
    login       text not null UNIQUE,
    password    text
);

create table if not exists chat_rooms (
    roomId  serial primary key ,
    owner   bigint not null references chat_users(userId) ,
    name    text not null
);

create table if not exists chat_messages (
    messageId      serial primary key,
    messageRoom    bigint not null references chat_rooms(roomId),
    messageAuthor  bigint not null references chat_users(userId),
    messageText    text not null ,
    messageTime    timestamp
);