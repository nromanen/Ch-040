
INSERT INTO appointment (id, color, end_date, start_date, text, doctorinfo_id, userdetail_id) VALUES (
1, '#00BFFF', '\\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770905000007e0060d13eb78', '\\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770805000007e0060dec78',	'New event', 9, 17),
(2, '#66CDAA', '\\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770905000007e0060d13d778', '\\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770905000007e0060d13eb78',	'New event', 9,	29),
(3, '#ADFF2F', '\\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770805000007e0060deb78', '\\xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770905000007e0060d13d778', 'New event', 9, 24);

SELECT pg_catalog.setval('appointment_id_seq', 16, true);

INSERT INTO carditem (id, complaint, date, prescription, result, doctor_id, patientcard_id) VALUES (
3, 'xcvfdasg', '2016-06-08 23:20:10.255', 'adgadgasdg\r\ndsgadga', 'adgasdf\r\nadsgasdgag', 11, 18),
(4, 'Lorem ipsum', '2016-06-08 23:21:07.187', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 11, 18),
(5, 'Lorem ipsum', '2016-06-08 23:21:52.397', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 11, 17),
(11, 'Lorem ipsum',	'2016-06-08 23:23:54.998', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 7, 17),
(15, 'Lorem ipsum', '2016-06-09 12:49:55.852', 'Lorem ipsum\r\nLorem ipsum\r\nLorem ipsum\r\nLorem ipsum\r\nLorem ipsum', 'Lorem ipsum\r\nLorem ipsum\r\nLorem ipsum\r\nLorem ipsum\r\nLorem ipsumlogout', 12, 18);

SELECT pg_catalog.setval('carditem_id_seq', 15, true);

INSERT INTO department (id, imagepath, name, hospital_id) VALUES 
(1, 'service1.png', 'Diagnostician', 1),
(2, 'service2.png', 'Therapistician', 1),
(3, 'service2.png', 'Therapistician', 1),
(4, 'service4.png',	'Diagnostician', 2),
(5,	'service1.png',	'Therapistician', 3),
(6,	'service2.png', 'Oncologian', 3),
(7, 'service3.png', 'Diagnostician', 4),
(8, 'service4.png', 'Therapistician', 4);

INSERT INTO department_doctorinfo (departments_id, doctors_id) VALUES 
(1, 1),
(1,	2),
(2,	3),
(2,	4),
(3,	5),
(4,	6),
(5,	7),
(6,	8),
(7,	9),
(8,	10);

SELECT pg_catalog.setval('department_id_seq', 1, false);

INSERT INTO doctorinfo (id, specialization, userdetails_id) VALUES
(1, 'Diagnostician', 6),
(2, 'Neurologist', 7),
(3, 'Endocrinologist', 8),
(4, 'Diagnostician', 9),
(5, 'Oncologist', 10),
(6, 'Diagnostician', 11),
(7,	'Oncologist', 12),
(8, 'Neurologist', 13),
(9, 'Diagnostician', 14),
(10, 'Endocrinologist', 15),
(11, 'Oncologist', 16);

SELECT pg_catalog.setval('doctorinfo_id_seq', 1, false);

INSERT INTO hospital (id, building, city, country, street, description, imagepath, latitude, longitude, name) VALUES
(1, '137', 'Chernivtsi', 'Ukraine', 'Holovna St', '',	'Hospital_1.jpg', '48.279439400000001', '25.943196899999975', 'Chernivtsi Regional Clinical Hospital'),
(2, '11',	'Chernivtsi', 'Ukraine', 'Lesi Ukrainky St', '', 'Hospital_2.jpg', '48.290980500000003', '25.929598499999997', 'Miska Poliklinika'),
(3,	'185В',	'Chernivtsi', 'Ukraine', 'Ruska St', '', 'Hospital_3.jpg', '48.283664100000003', '25.973487500000033', 'Angelholm'),
(4, '218', 'Chernivtsi', 'Ukraine', 'Holovna St', '', 'Hospital_4.jpg', '48.255651399999998', '25.957666399999994', 'Міська дитяча поліклініка №7');

SELECT pg_catalog.setval('hospital_id_seq', 4, true);

INSERT INTO hospital_users (hospital_id, managers_id) VALUES
(4, 3),
(3, 5),
(2, 2),
(1, 4);

INSERT INTO patientcard (id, userdetail_id) VALUES
(1, NULL),
(2, NULL),
(3, NULL);

SELECT pg_catalog.setval('patientcard_id_seq', 31, true);

SELECT pg_catalog.setval('patientinfo_id_seq', 1, false);

INSERT INTO role (id, type) VALUES
(1, 'ADMIN'),
(2, 'PATIENT'),
(3, 'MANAGER'),
(4, 'DOCTOR');

SELECT pg_catalog.setval('role_id_seq', 1, false);

INSERT INTO role_users (users_id, role_id) VALUES
(1, 1)
(2,3)
(3,3)
(4,3)
(5,3)
(6,4)
(7,4)
(8,4)
(9,4)
(10,4)
(11,4)
(12,4)
(13,4)
(14,4)
(15,4)
(16,4)
(17,2)
(18,2)
(19,2)
(20,2)
(21,2)
(22,2)
(23,2)
(24,2)
(25,2)
(26,2)
(28,2)
(29,2)
(30,2)
(31,2);

INSERT INTO userdetail (id, address, birthdate, firstname, gender, imagepath, lastname, phone, patientcard_id) VALUES
(1, '\N', NULL,	'Lars', 'MAN', '\N', 'Urlich', '\N', 1),
(2, '\N', NULL, 'James', 'MAN', '\N', 'Hatfield', '\N', 2),
(3, '\N', NULL, 'Kurt', 'MAN', '\N', 'Kobein', '\N', 3),
(6, '\N', NULL, 'Gregory', 'MAN', 'gh.jpg', 'House', '\N', 6),
(7, '\N', NULL, 'Eric', 'MAN', 'ef.jpg', 'Foreman', '\N', 7),
(8, '\N', NULL,	'Lisa',	'WOMAN', 'lc.jpg', 'Cuddy', '\N', 8),
(17, '\N', NULL, 'Charles', 'MAN', '\N', 'Darvin', '\N', 17),
(18, '\N', NULL, 'Ilay', 'MAN', '\N', 'Nails', '\N', 18);

SELECT pg_catalog.setval('userdetail_id_seq', 31, true);

INSERT INTO users (id, email, enabled, password, userdetails_id) VALUES
(1, 'admin@hospitals.ua', 't', '$2a$10$N3rWp7etmNY23Zf6kFNLV.D/sT0tSJ9jHRiS0xEgiCtI2L.OQbBqi', 1),
(2,	'manager.jh@hospitals.ua', 't', '$2a$10$xEHQ5YGjKO0.CED2gkMBsOK7eR555Zo9XAkYKjGJTQcyxHgpAWV7e', 2),
(3, 'manager.kk@hospitals.ua', 't', '$2a$10$Y8Ou0AQGW/6UuLB6d0cqhOGZXOVzfmH.0pJnWTYjEHPXjEICAqE9u', 3),
(6, 'doctor.gh@hospitals.ua', 't', '$2a$10$FbRxp4PdXuFHK7kU8hemMezGFc.iGXH6Bs5z6gZCImhh8YM3ZJn2K', 6),
(7, 'doctor.ef@hospitals.ua', 't', '$2a$10$Ah7jCL.GYHPWHXxQ4TPsJOok178L.SrKYIo5n3QmTy74LV1M0Clqi', 7),
(8, 'doctor.lhc@hospitals.ua', 't', '$2a$10$RjUyAGgaT0RW9wYXAJPGjuG1ooXdpBjI/4bQwmTbvMteimyiAjbum', 8),
(17, 'patient.cd@hospitals.ua', 't', '$2a$10$lH5Sg.gocRCIuO17BV1BW.sUjVvPTXA7UokUsWtt7ODSOuRNMVhGW', 17),
(18, 'patient.in@hospitals.ua', 't', '$2a$10$ZNCZEfFLA/TZFuhk3aL1b.2KraEr7mSLGk5hWp9KliuBY8B5quryq', 18);

SELECT pg_catalog.setval('users_id_seq', 31, true);

ALTER TABLE ONLY appointment
    ADD CONSTRAINT appointment_pkey PRIMARY KEY (id);


--
-- Name: carditem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY carditem
    ADD CONSTRAINT carditem_pkey PRIMARY KEY (id);


--
-- Name: department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- Name: doctorinfo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doctorinfo
    ADD CONSTRAINT doctorinfo_pkey PRIMARY KEY (id);


--
-- Name: feedback_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT feedback_pkey PRIMARY KEY (id);


--
-- Name: hospital_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospital
    ADD CONSTRAINT hospital_pkey PRIMARY KEY (id);


--
-- Name: patientcard_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY patientcard
    ADD CONSTRAINT patientcard_pkey PRIMARY KEY (id);


--
-- Name: patientinfo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY patientinfo
    ADD CONSTRAINT patientinfo_pkey PRIMARY KEY (id);


--
-- Name: persistent_logins_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persistent_logins
    ADD CONSTRAINT persistent_logins_pkey PRIMARY KEY (series);

--
-- Name: role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: role_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role_users
    ADD CONSTRAINT role_users_pkey PRIMARY KEY (users_id, role_id);


--
-- Name: uk_6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- Name: uk_93vn3jeavtylq20tjdx2p2kkd; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role
    ADD CONSTRAINT uk_93vn3jeavtylq20tjdx2p2kkd UNIQUE (type);


--
-- Name: uk_mb4c7ta7x0g5jxjuaqw47ayov; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persistent_logins
    ADD CONSTRAINT uk_mb4c7ta7x0g5jxjuaqw47ayov UNIQUE (token);


--
-- Name: uk_rpl2mjerve4d0pcau4usm8lmg; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persistent_logins
    ADD CONSTRAINT uk_rpl2mjerve4d0pcau4usm8lmg UNIQUE (username);


--
-- Name: userdetail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY userdetail
    ADD CONSTRAINT userdetail_pkey PRIMARY KEY (id);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: fk_1r6dadb3ajbaxwkpdx1v4u9n9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doctorinfo
    ADD CONSTRAINT fk_1r6dadb3ajbaxwkpdx1v4u9n9 FOREIGN KEY (userdetails_id) REFERENCES userdetail(id);


--
-- Name: fk_2xe4lqrkwymg4aoshgadolask; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT fk_2xe4lqrkwymg4aoshgadolask FOREIGN KEY (userdetails_id) REFERENCES userdetail(id);


--
-- Name: fk_67w5hj99v5nvjexfv0cf1mxus; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role_users
    ADD CONSTRAINT fk_67w5hj99v5nvjexfv0cf1mxus FOREIGN KEY (role_id) REFERENCES role(id);


--
-- Name: fk_7uda74mreyd8pe0bc0rgm1ufe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT fk_7uda74mreyd8pe0bc0rgm1ufe FOREIGN KEY (consumer_id) REFERENCES users(id);


--
-- Name: fk_8hgkscyrlwhgtdgcljai40128; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY carditem
    ADD CONSTRAINT fk_8hgkscyrlwhgtdgcljai40128 FOREIGN KEY (patientcard_id) REFERENCES patientcard(id);


--
-- Name: fk_b51bk1hxlblc0fq7l65dkcnc5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY appointment
    ADD CONSTRAINT fk_b51bk1hxlblc0fq7l65dkcnc5 FOREIGN KEY (userdetail_id) REFERENCES userdetail(id);


--
-- Name: fk_cunrd1kjdr3pwcekkhw8r5k2l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role_users
    ADD CONSTRAINT fk_cunrd1kjdr3pwcekkhw8r5k2l FOREIGN KEY (users_id) REFERENCES users(id);


--
-- Name: fk_ej88rho1obqsgettqaymg2ax8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY department_doctorinfo
    ADD CONSTRAINT fk_ej88rho1obqsgettqaymg2ax8 FOREIGN KEY (departments_id) REFERENCES department(id);


--
-- Name: fk_exlldeucxpa91uwds0hpc97o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY userdetail
    ADD CONSTRAINT fk_exlldeucxpa91uwds0hpc97o FOREIGN KEY (patientcard_id) REFERENCES patientcard(id);


--
-- Name: fk_hx479pw4gje0ktsjfwvl9pwn8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY appointment
    ADD CONSTRAINT fk_hx479pw4gje0ktsjfwvl9pwn8 FOREIGN KEY (doctorinfo_id) REFERENCES doctorinfo(id);


--
-- Name: fk_ibochgjqx1dyr7ysbeg0royt9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY department_doctorinfo
    ADD CONSTRAINT fk_ibochgjqx1dyr7ysbeg0royt9 FOREIGN KEY (doctors_id) REFERENCES doctorinfo(id);


--
-- Name: fk_o7prsdub8c63s5w469e06q83; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospital_users
    ADD CONSTRAINT fk_o7prsdub8c63s5w469e06q83 FOREIGN KEY (managers_id) REFERENCES users(id);


--
-- Name: fk_ohvlr9w2h9pvsj2bg12ox9b9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY carditem
    ADD CONSTRAINT fk_ohvlr9w2h9pvsj2bg12ox9b9 FOREIGN KEY (doctor_id) REFERENCES users(id);


--
-- Name: fk_ov506nbhqxddqios9pxlb21ie; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY patientcard
    ADD CONSTRAINT fk_ov506nbhqxddqios9pxlb21ie FOREIGN KEY (userdetail_id) REFERENCES userdetail(id);


--
-- Name: fk_pvf13utfatebavsixvqxwo3ob; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT fk_pvf13utfatebavsixvqxwo3ob FOREIGN KEY (producer_id) REFERENCES users(id);


--
-- Name: fk_spotjwwrelb9dhulkiivbl62b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY department
    ADD CONSTRAINT fk_spotjwwrelb9dhulkiivbl62b FOREIGN KEY (hospital_id) REFERENCES hospital(id);


--
-- Name: fk_tcu91xpek54a086jamuakvoh8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospital_users
    ADD CONSTRAINT fk_tcu91xpek54a086jamuakvoh8 FOREIGN KEY (hospital_id) REFERENCES hospital(id);