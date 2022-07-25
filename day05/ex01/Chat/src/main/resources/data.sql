INSERT INTO chat_users (login, password) values  ('user1', '111'),
                                                                ('user2', '222'),
                                                                ('user3', '333'),
                                                                ('user4', '444'),
                                                                ('user5', '555');

INSERT INTO chat_rooms(name, owner) values ('chat1', 1),
                                                        ('chat2', 2),
                                                        ('chat3', 3),
                                                        ('chat4', 4),
                                                        ('chat5', 5);

INSERT INTO chat_messages(messageAuthor, messageRoom, messageText, messageTime) values (2, 3, 'user1 chat1', NOW()),
                                                                          (2, 2, 'user2 chat2', NOW()),
                                                                          (3, 3, 'user3 chat3', NOW()),
                                                                          (4, 4, 'user4 chat4', NOW()),
                                                                          (5, 5, 'user5 chat5', NOW());