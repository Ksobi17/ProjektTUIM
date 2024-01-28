Insert into DOCTOR(id, name) VALUES (1,'Kornelia Trafna');
Insert into DOCTOR(id, name) VALUES (2,'Michał Flisikowski');
Insert into DOCTOR(id, name) VALUES (3,'Mirosława Gębarowska');
Insert into DOCTOR(id, name) VALUES (4,'Walentyna Bielik');
Insert into DOCTOR(id, name) VALUES (5,'Kacper Fołta');
Insert into DOCTOR(id, name) VALUES (6,'Andrzej Zubek');
Insert into DOCTOR(id, name) VALUES (7,'Piotr Horbacz');
Insert into DOCTOR(id, name) VALUES (8,'Justyna Wojnicz');
ALTER TABLE DOCTOR ALTER COLUMN ID RESTART WITH (SELECT MAX(ID) FROM DOCTOR) + 1;
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (1,1,'Danuta Betlejewska','2012-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (2,1,'Krystian Niedzwiecki','2013-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (3,1,'Bogusław Malcher','2014-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (4,1,'Daria Juchniewicz','2015-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (5,1,'Bohdan Łochowski','2016-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (6,2,'Andrzej Bazan','2017-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (7,2,'Kajetan Łyżwa','2018-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (8,3,'Karina Liber','2019-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (9,3,'Lena Zaika','2020-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (10,4,'Mariia Obszyńska','2012-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (11,5,'Kajetan Chłopek','2012-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (12,5,'Małgorzata Wasiak','2012-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (13,5,'Danuta Lejkowska','2012-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (14,5,'Ewa Fołta','2012-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (15,5,'Alan Nitkowski','2012-09-17 18:47:52.69');
Insert into APPOINTMENT(id,doctor_id,name,date) VALUES (16,5,'Diana Rzeczycka','2012-09-17 18:47:52.69');
ALTER TABLE APPOINTMENT ALTER COLUMN ID RESTART WITH (SELECT MAX(ID) FROM APPOINTMENT) + 1;
Insert into LOGIN(id,login,password) VALUES (1,'login','haslo');
ALTER TABLE LOGIN ALTER COLUMN ID RESTART WITH (SELECT MAX(ID) FROM LOGIN) + 1;










