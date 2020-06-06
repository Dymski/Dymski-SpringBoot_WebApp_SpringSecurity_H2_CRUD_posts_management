INSERT INTO USER(id, name, surname, email, password, role) VALUES (1,'user','user', 'user','user', 'ROLE_USER');
INSERT INTO USER(id, name, surname, email, password, role) VALUES (2,'admin','user', 'admin', 'admin', 'ROLE_ADMIN');
INSERT INTO USER(id, name, surname, email, password, role) VALUES (3,'Krystian','Urbanik', 'krystian@domain.com', 'password', 'ROLE_ADMIN');
INSERT INTO MESSAGE(messageID, postID, commentID, name, message_date,  message_text) VALUES (1, 1, 0, 'Zenon', '2020-05-23', 'Przykładowy post Zenka');
INSERT INTO MESSAGE(messageID, postID, commentID, name, message_date,  message_text) VALUES (2, 1, 2, 'Zenon', '2020-05-24', 'Przykładowy Comment do 1 postu Zenka');
INSERT INTO MESSAGE(messageID, postID, commentID, name, message_date,  message_text) VALUES (3, 3, 0, 'Marek', '2020-05-23', 'Przykładowy Post Marka');
INSERT INTO MESSAGE(messageID, postID, commentID, name, message_date,  message_text) VALUES (4, 4, 0, 'Marek', '2020-05-24', 'Przykładowy post 2 Marka');
