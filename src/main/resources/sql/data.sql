
SELECT pg_catalog.setval('appointment_id_seq', 16, true);

INSERT INTO carditem (id, complaint, date, prescription, result, doctor_id, patientcard_id) VALUES 
(3, 'xcvfdasg', '2016-06-08 23:20:10.255', 'adgadgasdg\r\ndsgadga', 'adgasdf\r\nadsgasdgag', 11, 18),
(4, 'Lorem ipsum', '2016-06-08 23:21:07.187', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 11, 18),
(5, 'Lorem ipsum', '2016-06-08 23:21:52.397', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 11, 17),
(11, 'Lorem ipsum',	'2016-06-08 23:23:54.998', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 'Lorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum\r\nLorem Ipsum', 7, 17),
(15, 'Lorem ipsum', '2016-06-09 12:49:55.852', 'Lorem ipsum\r\nLorem ipsum\r\nLorem ipsum\r\nLorem ipsum\r\nLorem ipsum', 'Lorem ipsum\r\nLorem ipsum\r\nLorem ipsum\r\nLorem ipsum\r\nLorem ipsumlogout', 12, 18);

SELECT pg_catalog.setval('carditem_id_seq', 15, true);

INSERT INTO databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels) VALUES
('1465423649552-1', 'admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:36.93656',1,'EXECUTED','7:e8518e074bc0056697a7c33f6746c2fe','createSequence','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-2','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:36.953966',2,'EXECUTED','7:aa70d416a4351e5584fca239e5660cf3','createSequence','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-3','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:36.967574',3,'EXECUTED','7:25f25e99cd3388719361f80fdbc2253a','createSequence','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-4','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:36.978252',4,'EXECUTED','7:f94333aa734b4d48de4993e8a93dd294','createSequence','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-5','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:36.989082',5,'EXECUTED','7:ad158f979c11ac63029ba39bb5e371f7','createSequence','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-6','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.000178',6,'EXECUTED','7:824c2a1a51aa62b0f331f4c1b8c082c0','createSequence','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-7','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.009203',7,'EXECUTED','7:9d45579eea7d243182d5bf1b3f16ef7d','createSequence','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-8','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.018078',8,'EXECUTED','7:0f660036d89a132ee26cdd8bc5db5ce0','createSequence','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-9','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.029175',9,'EXECUTED','7:4af6200dd58f10e77e533ac6950ec5cb','createSequence','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-10','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.03964',10,'EXECUTED','7:68c172b4585cae49e7a7a4757dffa35f','createSequence','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-11','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.046198',11,'EXECUTED','7:909ee99089b2dd58a5c925517f733081','createSequence','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-12','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.053521',12,'EXECUTED','7:918fe63811684fef24f4b3867f5fde68','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-13','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.122405',13,'EXECUTED','7:0928696b7e21c2013e5166465e7f8f8f','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-14','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.188845',14,'EXECUTED','7:de218f655a6a4b7f68fe243c18740e59','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-15','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.250138',15,'EXECUTED','7:fa9c255fc9089d2632bc936b3adacd5d','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-16','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.257899',16,'EXECUTED','7:66b6b2953ed96899428b9e4f0758068b','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-17','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.265883',17,'EXECUTED','7:c13931bc30da1021470df473ad8bff29','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-18','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.312433',18,'EXECUTED','7:45d441eaa2517d319dfdf1e0a144f8bd','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-19','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.357726',19,'EXECUTED','7:1e1be72eb6e1d063aaa877d7c82ca60d','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-20','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.365786',20,'EXECUTED','7:97d9f0e2fb05d29435c7de644d23ce56','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-21','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.373618',21,'EXECUTED','7:639eea1c89295f02aa6ccb16b12da76f','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-22','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.382035',22,'EXECUTED','7:ded4385b924854bdb04ac82fced65a73','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-23','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.425544',23,'EXECUTED','7:903bf58d5916074967924e32646dc583','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-24','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.432284',24,'EXECUTED','7:de4d3e8e6523f9f6822763ebf61ac6c7','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-25','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.481487',25,'EXECUTED','7:d3f7fe38969463b511faf0d5f521da44','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-26','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.554139',26,'EXECUTED','7:bb6ade8232c1b2b2b9eb4b1b7e9dc459','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-27','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.604828',27,'EXECUTED','7:19eb4748a27fcc521fc4e878ee9f4e24','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-28','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.653446',28,'EXECUTED','7:47d1be13b4c612d65ebb10443dbac672','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-29','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.706843',29,'EXECUTED','7:5c91e27dd024aad2bf42e83471b9089e','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-30','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.752411',30,'EXECUTED','7:680b5e3f53dacaeb9858603892e545f3','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-31','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.795844',31,'EXECUTED','7:9976548fa822b488ab7a9093857c1897','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-32','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.846031',32,'EXECUTED','7:2f58c24e1e1fcbadae1735dc9cd2747a','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-33','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.888068',33,'EXECUTED','7:84fb3a103a0514ae3f27f11e3f8d73db','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-34','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.936829',34,'EXECUTED','7:143b2115312689856570fa469088522c','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-35','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:37.970243',35,'EXECUTED','7:1928d8abbae40db8a6b2211c23c0f22f','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-36','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.01172',36,'EXECUTED','7:97d88469ab286fda0a64ce890fba4e43','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-37','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.053742',37,'EXECUTED','7:1eeb70005e2a2d250af75c70771e68c3','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-38','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.094839',38,'EXECUTED','7:3f0055b321756d4ba93357ab89d456a1','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-39','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.129134',39,'EXECUTED','7:1c5c969bb97d43f16c053e4f0d8511ed','addPrimaryKey','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-40','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.169347',40,'EXECUTED','7:7df1ec022fcd513ec9a68907cc4a371e','addUniqueConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-41','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.229276',41,'EXECUTED','7:49fae88f3ec2508e0499dd1e6d7d1c9d','addUniqueConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-42','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.369495',42,'EXECUTED','7:fafb596c17b5e47a4fab917663bd3a7c','addUniqueConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-43','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.434752',43,'EXECUTED','7:31e1f4ae7e2d5af9f0ffd8e922988a91','addUniqueConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-44','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.445553',44,'EXECUTED','7:abd1f5f212759dd9493bbfe519786af0','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-45','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.45642',45,'EXECUTED','7:01399aa283f4c143c31f7d4c96908147','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-46','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.465141',46,'EXECUTED','7:29bb09e754a759ea0c336ef7aef13e18','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-47','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.474664',47,'EXECUTED','7:9b164c039e3353f0667c24edcee106dd','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-48','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.482847',48,'EXECUTED','7:e04ab7b16f3da6fc83a2c52113a0207f','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-49','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.489566',49,'EXECUTED','7:fedd65e31c38611eee4f133eb53ad1cb','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-50','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.495606',50,'EXECUTED','7:d4b11d1d01ce643bb3c18ed2d857302b','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-51','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.502513',51,'EXECUTED','7:43b9049a067b5795dc1e74c7ac5c6fd9','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-52','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.511041',52,'EXECUTED','7:b43c2855d6aaf22acc714824d4070ae9','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-53','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.517346',53,'EXECUTED','7:50debdba33902d822f129252c7832393','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-54','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.523523',54,'EXECUTED','7:9994aa727c7f26647cace77682754796','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-55','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.529525',55,'EXECUTED','7:c75745ce8029d2c73382bc4c6a7a6e92','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-56','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.535612',56,'EXECUTED','7:1aa5139fdc681d69a95954b38e22c674','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-57','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.54304',57,'EXECUTED','7:0fee5e3599a8ce85b78c29b1981ecfb8','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-58','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.550224',58,'EXECUTED','7:16b1555a6f6fbdf53c9afb24fd40ac71','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-59','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.566061',59,'EXECUTED','7:86140231159ab3045048da6a79284de5','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-60','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.572359',60,'EXECUTED','7:06fa6fbdc42971cff8aa400ec1c7f4d9','addForeignKeyConstraint','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-61','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.625637',61,'EXECUTED','7:73a473a4342caf08a3aa8f0cd7672b65','createTable','NULL','NULL','3.4.2','NULL','NULL'),
('1465423649552-62','admin (generated)','classpath:liquibase-changeLog.xml','2016-06-21 00:39:38.635913',62,'EXECUTED','7:5106b37c6b7f59b636806dd4c6ca356b','sqlFile','NULL','NULL','3.4.2','NULL','NULL');




INSERT INTO databasechangeloglock (id, locked, lockgranted, lockedby) VALUES
(1, 'f', NULL, NULL);

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
(4, '218', 'Chernivtsi', 'Ukraine', 'Holovna St', '', 'Hospital_4.jpg', '48.255651399999998', '25.957666399999994', 'Hospital #7');

SELECT pg_catalog.setval('hospital_id_seq', 4, true);

INSERT INTO hospital_users (hospital_id, managers_id) VALUES
(4, 3),
(3, 5),
(2, 2),
(1, 4);

INSERT INTO patientcard (id, userdetail_id) VALUES
(1, NULL),
(2, NULL),
(3, NULL),
(4, NULL),
(5, NULL),
(6, NULL),
(7, NULL),
(8, NULL),
(9, NULL),
(10, NULL),
(11, NULL),
(12, NULL),
(13, NULL),
(14, NULL),
(15, NULL),
(16, NULL),
(17, NULL),
(18, NULL),
(19, NULL),
(20, NULL),
(21, NULL);

SELECT pg_catalog.setval('patientcard_id_seq', 31, true);

SELECT pg_catalog.setval('patientinfo_id_seq', 1, false);

INSERT INTO role (id, type) VALUES
(1, 'ADMIN'),
(2, 'PATIENT'),
(3, 'MANAGER'),
(4, 'DOCTOR');

SELECT pg_catalog.setval('role_id_seq', 1, false);

INSERT INTO role_users (users_id, role_id) VALUES
(1, 1),
(2,3),
(3,3),
(4,3),
(5,3),
(6,4),
(7,4),
(8,4),
(9,4),
(10,4),
(11,4),
(12,4),
(13,4),
(14,4),
(15,4),
(16,4),
(17,2),
(18,2),
(19,2),
(20,2),
(21, 2);

INSERT INTO userdetail (id, address, birthdate, firstname, gender, imagepath, lastname, phone, patientcard_id) VALUES
(1, '\N', NULL,	'Lars', 'MAN', '\N', 'Urlich', '\N', 1),
(2, '\N', NULL, 'James', 'MAN', '\N', 'Hatfield', '\N', 2),
(3, '\N', NULL, 'Kurt', 'MAN', '\N', 'Kobein', '\N', 3),
(4, '\N', NULL, 'Kirk', 'MAN', '\N', 'Hammet', '\N', 4),
(5, '\N', NULL, 'James', 'MAN', '\N', 'Nusted', '\N', 5),
(6, '\N', NULL, 'Gregory', 'MAN', 'gh.jpg', 'House', '\N', 6),
(7, '\N', NULL, 'Eric', 'MAN', 'ef.jpg', 'Foreman', '\N', 7),
(8, '\N', NULL,	'Lisa',	'WOMAN', 'lc.jpg', 'Cuddy', '\N', 8),
(9, '\N', NULL, 'Rhemy', 'WOMAN', 'rh.jpg', 'Hadley', '\N', 9),
(10, '\N', NULL, 'James', 'MAN', 'jw.jpg', 'Wilson', '\N', 10),
(11, '\N', NULL, 'Chester', 'MAN', 'cb.jpg', 'Benington', '\N', 11),
(12, '\N', NULL, 'Chris', 'MAN', 'ct.jpg', 'Terk', '\N', 12),
(13, '\N', NULL, 'Jhon', 'MAN', 'jd.jpg', 'Dorian', '\N', 13),
(14, '\N', NULL, 'Jhared', 'MAN', 'jl.jpg', 'Leto', '\N', 14),
(15, '\N', NULL, 'Mike', 'MAN', 'ms.jpg', 'Shinoda', '\N', 15),
(16, '\N', NULL, 'Marshal', 'MAN', 'mm.jpg', 'Matters', '\N', 16),
(17, '\N', NULL, 'Charles', 'MAN', '\N', 'Darvin', '\N', 17),
(18, '\N', NULL, 'Ilay', 'MAN', '\N', 'Nails', '\N', 18),
(19, '\N', NULL, 'Michael', 'MAN', '\N', 'Luter', '\N', 19),
(20, '\N', NULL, 'Richard', 'MAN', '\N', 'Rorshek', '\N', 20),
(21, '\N', NULL, 'Sam', 'MAN', '\N', 'Ferdinand', '\N', 21);

SELECT pg_catalog.setval('userdetail_id_seq', 31, true);

INSERT INTO users (id, email, enabled, password, userdetails_id) VALUES
(1, 'admin@hospitals.ua', 't', '$2a$10$N3rWp7etmNY23Zf6kFNLV.D/sT0tSJ9jHRiS0xEgiCtI2L.OQbBqi', 1),
(2,	'manager.jh@hospitals.ua', 't', '$2a$10$xEHQ5YGjKO0.CED2gkMBsOK7eR555Zo9XAkYKjGJTQcyxHgpAWV7e', 2),
(3, 'manager.kk@hospitals.ua', 't', '$2a$10$Y8Ou0AQGW/6UuLB6d0cqhOGZXOVzfmH.0pJnWTYjEHPXjEICAqE9u', 3),
(4, 'manager.kh@hospitals.ua', 't', '$2a$10$2mZHnyUAbDsX8341uT1UT.fYNzey/q/TYtoOVQreYDrJsxP7v1N/K', 4),
(5, 'manager.jn@hospitals.ua', 't', '$2a$10$bP/ijok5uiAGC4UsSp/QIujdYXT5ixCwnKkndTYW.1ml3m349w0lS', 5),
(6, 'doctor.gh@hospitals.ua', 't', '$2a$10$FbRxp4PdXuFHK7kU8hemMezGFc.iGXH6Bs5z6gZCImhh8YM3ZJn2K', 6),
(7, 'doctor.ef@hospitals.ua', 't', '$2a$10$Ah7jCL.GYHPWHXxQ4TPsJOok178L.SrKYIo5n3QmTy74LV1M0Clqi', 7),
(8, 'doctor.lhc@hospitals.ua', 't', '$2a$10$RjUyAGgaT0RW9wYXAJPGjuG1ooXdpBjI/4bQwmTbvMteimyiAjbum', 8),
(9, 'doctor.rh@hospitals.ua', 't', '$2a$10$jyvm38NWsC3WDklbGTxMRurM6SNULHlOSOFFqPGTGp2.c.UZTpxJC', 9),
(10, 'doctor.jw@hospitals.ua', 't', '$2a$10$18snRZ9iaK7iets6IN8XmOxTZiEebBCtUMLpY3/i72Nfk40iqbn2W', 10),
(11, 'doctor.cb@hospitals.ua', 't', '$2a$10$eNhH/O6Gb/Kzoxc7fZZJYOA9HQuYB6Pz4mrG/DJd35zHk0Nu7.32y', 11),
(12, 'doctor.ct@hospitals.ua', 't', '$2a$10$o3apAm429gfS2jRto.sHyOWAtQ..WgYC3HvThm3/8ZApV2gVqyTbO', 12),
(13, 'doctor.jd@hospitals.ua', 't', '$2a$10$ZbbcxIGBQFE8IxcB4GI7BeDH/kmTvMmonbCL7z0aMDglrK.6U65aW', 13),
(14, 'doctor.jl@hospitals.ua', 't', '$2a$10$bhW4V1uVETEQ/YSC3yQPm.lGPavROHB/fmzBtW0k3ppdZlABoMiiO', 14),
(15, 'doctor.ms@hospitals.ua', 't', '$2a$10$Hazi7OuRrnnLd6gmNWLCpOYr6dksKORDM4Xl.hB3YXbE/wl6YgA46', 15),
(16, 'doctor.mm@hospitals.ua', 't', '$2a$10$xeVfrEqprRSHSqo8yb/AWutiqEkLlVaNmrsWUxy5kYF5ksFcW17Iu', 16),
(17, 'patient.cd@hospitals.ua', 't', '$2a$10$lH5Sg.gocRCIuO17BV1BW.sUjVvPTXA7UokUsWtt7ODSOuRNMVhGW', 17),
(18, 'patient.in@hospitals.ua', 't', '$2a$10$ZNCZEfFLA/TZFuhk3aL1b.2KraEr7mSLGk5hWp9KliuBY8B5quryq', 18),
(19, 'patient.ml@hospitals.ua', 't', '$2a$10$wtRRo7Q6O.wPv8E/7M4kMebWHgdFf0GZYotCj3nBUYR2HLxQFqPMm', 19),
(20, 'patient.rr@hospitals.ua', 't', '$2a$10$DLdRb91MrBBhNxEr5AYXrOuSn5LieZFSXrVE7RZWEbglkdfsvptsm', 20),
(21, 'patient.sf@hospitals.ua', 't', '$2a$10$4TW.tWhaI4xoSGPZhA4iseizzcRpQB/yNessm204M7o0qXgsdJYm.', 21);

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


ALTER TABLE ONLY doctorinfo
    ADD CONSTRAINT "FK_1r6dadb3ajbaxwkpdx1v4u9n9" FOREIGN KEY (userdetails_id) REFERENCES userdetail(id);


--
-- TOC entry 2131 (class 2606 OID 23419)
-- Name: FK_2xe4lqrkwymg4aoshgadolask; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT "FK_2xe4lqrkwymg4aoshgadolask" FOREIGN KEY (userdetails_id) REFERENCES userdetail(id);


--
-- TOC entry 2115 (class 2606 OID 23424)
-- Name: FK_67w5hj99v5nvjexfv0cf1mxus; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role_users
    ADD CONSTRAINT "FK_67w5hj99v5nvjexfv0cf1mxus" FOREIGN KEY (role_id) REFERENCES role(id);


--
-- TOC entry 2125 (class 2606 OID 23429)
-- Name: FK_7uda74mreyd8pe0bc0rgm1ufe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT "FK_7uda74mreyd8pe0bc0rgm1ufe" FOREIGN KEY (consumer_id) REFERENCES users(id);


--
-- TOC entry 2119 (class 2606 OID 23434)
-- Name: FK_8hgkscyrlwhgtdgcljai40128; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY carditem
    ADD CONSTRAINT "FK_8hgkscyrlwhgtdgcljai40128" FOREIGN KEY (patientcard_id) REFERENCES patientcard(id);


--
-- TOC entry 2117 (class 2606 OID 23439)
-- Name: FK_b51bk1hxlblc0fq7l65dkcnc5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY appointment
    ADD CONSTRAINT "FK_b51bk1hxlblc0fq7l65dkcnc5" FOREIGN KEY (userdetail_id) REFERENCES userdetail(id);


--
-- TOC entry 2116 (class 2606 OID 23444)
-- Name: FK_cunrd1kjdr3pwcekkhw8r5k2l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY role_users
    ADD CONSTRAINT "FK_cunrd1kjdr3pwcekkhw8r5k2l" FOREIGN KEY (users_id) REFERENCES users(id);


--
-- TOC entry 2122 (class 2606 OID 23449)
-- Name: FK_ej88rho1obqsgettqaymg2ax8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY department_doctorinfo
    ADD CONSTRAINT "FK_ej88rho1obqsgettqaymg2ax8" FOREIGN KEY (departments_id) REFERENCES department(id);


--
-- TOC entry 2130 (class 2606 OID 23454)
-- Name: FK_exlldeucxpa91uwds0hpc97o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY userdetail
    ADD CONSTRAINT "FK_exlldeucxpa91uwds0hpc97o" FOREIGN KEY (patientcard_id) REFERENCES patientcard(id);


--
-- TOC entry 2118 (class 2606 OID 23459)
-- Name: FK_hx479pw4gje0ktsjfwvl9pwn8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY appointment
    ADD CONSTRAINT "FK_hx479pw4gje0ktsjfwvl9pwn8" FOREIGN KEY (doctorinfo_id) REFERENCES doctorinfo(id);


--
-- TOC entry 2123 (class 2606 OID 23464)
-- Name: FK_ibochgjqx1dyr7ysbeg0royt9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY department_doctorinfo
    ADD CONSTRAINT "FK_ibochgjqx1dyr7ysbeg0royt9" FOREIGN KEY (doctors_id) REFERENCES doctorinfo(id);


--
-- TOC entry 2127 (class 2606 OID 23469)
-- Name: FK_o7prsdub8c63s5w469e06q83; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospital_users
    ADD CONSTRAINT "FK_o7prsdub8c63s5w469e06q83" FOREIGN KEY (managers_id) REFERENCES users(id);


--
-- TOC entry 2120 (class 2606 OID 23474)
-- Name: FK_ohvlr9w2h9pvsj2bg12ox9b9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY carditem
    ADD CONSTRAINT "FK_ohvlr9w2h9pvsj2bg12ox9b9" FOREIGN KEY (doctor_id) REFERENCES users(id);


--
-- TOC entry 2126 (class 2606 OID 23479)
-- Name: FK_pvf13utfatebavsixvqxwo3ob; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT "FK_pvf13utfatebavsixvqxwo3ob" FOREIGN KEY (producer_id) REFERENCES users(id);


--
-- TOC entry 2129 (class 2606 OID 23484)
-- Name: FK_pwj6yvmnh4hwbo4148t3bwhd0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY patientcard
    ADD CONSTRAINT "FK_pwj6yvmnh4hwbo4148t3bwhd0" FOREIGN KEY (userdetail_id) REFERENCES userdetail(id);


--
-- TOC entry 2121 (class 2606 OID 23489)
-- Name: FK_spotjwwrelb9dhulkiivbl62b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY department
    ADD CONSTRAINT "FK_spotjwwrelb9dhulkiivbl62b" FOREIGN KEY (hospital_id) REFERENCES hospital(id);


--
-- TOC entry 2128 (class 2606 OID 23494)
-- Name: FK_tcu91xpek54a086jamuakvoh8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospital_users
    ADD CONSTRAINT "FK_tcu91xpek54a086jamuakvoh8" FOREIGN KEY (hospital_id) REFERENCES hospital(id);
	
REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;