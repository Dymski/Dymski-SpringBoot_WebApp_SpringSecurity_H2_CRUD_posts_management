INSERT INTO USER(id, name, surname, email, password, role) VALUES (1,'user','user', 'user','user', 0);
INSERT INTO USER(id, name, surname, email, password, role) VALUES (2,'admin','user', 'admin', 'admin', 1);
INSERT INTO USER(id, name, surname, email, password, role) VALUES (3,'Krystian','Urbanik', 'krystian@domain.com', 'password', 0);
INSERT INTO USER(id, name, surname, email, password, role) VALUES (4,'Adam','Bak', 'adam@domain.com', 'password', 0);
INSERT INTO MESSAGE(messageID, postID, commentID, name, message_date,  message_text) VALUES (1, 1, 0, 'Zenon', '2020-05-23', 'Przykładowy post Zenka');
INSERT INTO MESSAGE(messageID, postID, commentID, name, message_date,  message_text) VALUES (2, 2, 0, 'Marek', '2020-05-23', 'Przykładowy post Marka');
INSERT INTO MESSAGE(messageID, postID, commentID, name, message_date,  message_text) VALUES (3, 1, 1, 'Zenon', '2020-05-23', 'Przykładowy comment Zenka');
