INSERT INTO USER(id, name, surname, email, password, role) VALUES (1,'User Name','User Surname', 'user','user', 'ROLE_USER');
INSERT INTO USER(id, name, surname, email, password, role) VALUES (2,'Admin Name','Admin Surname', 'admin', 'admin', 'ROLE_ADMIN');
INSERT INTO USER(id, name, surname, email, password, role) VALUES (4,'Adam','Bak', 'adam@domain.com', 'password', 'ROLE_USER');
INSERT INTO MESSAGE(messageID, postID, commentID, name, message_date,  message_text) VALUES (1, 1, 0, 'Zenon', '2020-05-23', 'Example post of Zenek');
INSERT INTO MESSAGE(messageID, postID, commentID, name, message_date,  message_text) VALUES (3, 1, 1, 'Zenon', '2020-05-23', 'Example comment of Zenek');
INSERT INTO MESSAGE(messageID, postID, commentID, name, message_date,  message_text) VALUES (2, 2, 0, 'Marek', '2020-05-23', 'Example post of Mark');

