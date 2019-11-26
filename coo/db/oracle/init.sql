--
-- 转存表中的数据 't_permission'
--
INSERT INTO t_permission(id, url, name)
 VALUES
(1, '/userBase/manage', 'User数据维护');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(2, '/proBase/manage', 'PRO数据维护');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(3, '/opBase/manage', 'OP数据维护');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(4, '/mfgBase/manage', 'MFG数据维护');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(5, '/mcBase/manage', 'MC数据维护');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(6, '/ieBase/manage', 'IE数据维护');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(7, '/others/manage', '其他参数维护');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(8, '/eqType/manage', 'EQ_Type维护');
INSERT INTO t_permission(id, url, name)
 VALUES
(9, '/materialCoefficient/manage', 'Material Coefficient维护');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(10, '/utility/manage', 'Utility维护');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(11, '/report/contrastReport', '数据对比');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(12, '/userManage/manage', 'User管理');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(13, '/manage/businessHis', '操作日志管理');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(14, '/vendor/manage', 'Vendor维护');
commit;
INSERT INTO t_permission(id, url, name)
 VALUES
(15, '/model/manage', 'Model维护');
commit;
--
-- 转存表中的数据 't_role'
--
INSERT INTO t_role (id, name)
 values(1, 'admin');
commit;

INSERT INTO t_role (id, name)
 VALUES (2, 'user');
 commit;

INSERT INTO t_role (id, name)
 VALUES (3, 'pro');
 commit;

INSERT INTO t_role (id, name)
 VALUES (4, 'op');
 commit;

INSERT INTO t_role (id, name)
 VALUES (5, 'mfg');
 commit;

INSERT INTO t_role (id, name)
 VALUES (6, 'mc');
 commit;

INSERT INTO t_role (id, name)
 VALUES (7, 'ie');
 commit;

INSERT INTO t_role (id, name)
 VALUES (8, 'contrast');
 commit;

--
-- 转存表中的数据 't_role_permission'
--
INSERT INTO t_role_permission(id, rid, pid)
VALUES (1,1,12);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (2,1,13);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (3,2,1);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (4,3,2);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (5,4,3);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (6,4,10);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (7,5,4);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (8,6,5);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (9,6,9);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (10,7,6);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (11,7,7);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (12,7,8);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (13,8,11);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (14,2,14);
commit;
INSERT INTO t_role_permission(id, rid, pid)
VALUES (15,2,15);
commit;
--
-- 转存表中的数据 't_user'
--
INSERT INTO t_user(id, user_name, moudule)
VALUES(1,'E100225','ET');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(2,'E100636','ET');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(3,'E100041','ET');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(4,'E100223','ET');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(5,'E100200','ET');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(6,'E100615','ET');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(7,'E101161','ET');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(8,'E100102','PH');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(9,'E100047','PH');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(10,'E100045','PH');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(11,'E100248','PH');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(12,'E101220','PH');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(13,'E100152','PH');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(14,'E100111','PH');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(15,'E100207','WAT');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(16,'E100423','WAT');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(17,'E100112','WAT');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(18,'E100830','QRA');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(19,'E100312','QRA');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(20,'E100455','QRA');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(21,'E100445','QRA');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(22,'E100726','QRA');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(23,'E100996','QRA');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(24,'E100201','QRA');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(25,'E100442','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(26,'E100180','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(27,'E101043','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(28,'E100436','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(29,'E101122','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(30,'E100604','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(31,'E100780','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(32,'E100208','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(33,'E100159','TF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(34,'E100049','TF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(35,'E100026','DF/TF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(36,'E100105','TF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(37,'E100082','TF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(38,'E100187','TF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(39,'E101215','TF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(40,'E100211','DF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(41,'E100541','DF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(42,'E100783','DF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(43,'E101118','DF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(44,'E100215','DF');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(45,'E100509','MFG');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(46,'E100177','MFG');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(47,'E100096','MFG');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(48,'E100435','PRO');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(49,'E100311','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(50,'E100224','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(51,'E100738','OP');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(52,'E100123','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(53,'E100100','MC');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(54,'E100048','MC');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(55,'E100522','MC');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(56,'E100978','MC');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(57,'E100577','IE');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(58,'E100043','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(59,'E100613','IE');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(60,'E100677','IE');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(61,'E100904','IE');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(62,'E100001','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(63,'E100003','DF/PH/ET/TF/WAT');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(64,'E100130','DF/PH/ET/TF/WAT');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(65,'E100434','PH/ET');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(66,'E100033','WAT');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(67,'E100423','WAT');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(68,'E100039','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(69,'E100208','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(70,'E100180','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(71,'E100901','TD');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(72,'E100353','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(73,'E100920','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(74,'E100018','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(75,'E100433','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(76,'E100191','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(77,'E100426','QRA');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(78,'E100066','QRA');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(79,'E100455','QRA');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(80,'A100014','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(81,'A100015','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(82,'E100485','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(83,'E100953','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(84,'E100593','All');
commit;
INSERT INTO t_user(id, user_name, moudule)
VALUES(85,'E101157','All');
commit;


--
-- 转存表中的数据 't_user_role'
--
INSERT INTO t_user_role (id, userid, rid)
VALUES(1,1,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(2,2,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(3,3,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(4,4,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(5,5,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(6,6,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(7,7,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(8,8,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(9,9,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(10,10,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(11,11,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(12,12,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(13,13,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(14,14,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(15,15,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(16,16,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(17,17,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(18,18,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(19,19,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(20,20,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(21,21,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(22,22,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(23,23,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(24,24,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(25,25,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(26,26,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(27,27,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(28,28,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(29,29,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(30,30,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(31,31,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(32,32,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(33,33,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(34,34,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(35,35,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(36,36,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(37,37,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(38,38,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(39,39,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(40,40,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(41,41,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(42,42,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(43,43,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(44,44,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(45,45,5);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(46,46,5);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(47,47,5);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(48,48,3);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(49,49,3);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(50,50,3);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(51,51,4);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(52,52,4);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(53,53,6);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(54,54,6);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(55,55,6);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(56,56,6);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(57,57,7);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(58,58,7);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(59,59,7);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(60,60,7);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(61,61,7);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(62,62,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(63,63,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(64,64,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(65,65,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(66,66,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(67,67,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(68,68,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(69,69,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(70,70,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(71,71,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(72,72,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(73,73,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(74,74,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(75,75,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(76,76,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(77,77,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(78,78,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(79,79,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(80,80,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(81,81,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(82,82,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(83,10,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(84,3,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(85,34,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(86,44,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(87,35,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(88,50,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(89,49,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(90,58,8);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(91,52,8);
commit;


INSERT INTO t_user_role (id, userid, rid)
VALUES(92,83,1);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(93,83,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(94,83,3);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(95,83,4);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(96,83,5);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(97,83,6);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(98,83,7);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(99,83,8);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(100,84,1);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(101,84,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(102,84,3);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(103,84,4);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(104,84,5);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(105,84,6);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(106,84,7);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(107,84,8);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(108,85,1);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(109,85,2);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(110,85,3);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(111,85,4);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(112,85,5);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(113,85,6);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(114,85,7);
commit;
INSERT INTO t_user_role (id, userid, rid)
VALUES(115,85,8);
commit;


INSERT INTO T_EQ_Moudule (id, moudule)
VALUES(1,'DF');
commit;
INSERT INTO T_EQ_Moudule (id, moudule)
VALUES(2,'ET');
commit;
INSERT INTO T_EQ_Moudule (id, moudule)
VALUES(3,'PH');
commit;
INSERT INTO T_EQ_Moudule (id, moudule)
VALUES(4,'QRA');
commit;
INSERT INTO T_EQ_Moudule (id, moudule)
VALUES(5,'TD');
INSERT INTO T_EQ_Moudule (id, moudule)
VALUES(6,'TF');
commit;
INSERT INTO T_EQ_Moudule (id, moudule)
VALUES(7,'WAT');
commit;



insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (1, 'PHOTO', 'AFM', to_date('17-07-2019 14:27:19', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('17-07-2019 14:27:19', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (2, 'TF', 'AL_PAD', to_date('17-07-2019 14:27:10', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('17-07-2019 14:27:10', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (3, 'DIFF', 'ALD_OX_BSI', to_date('17-07-2019 14:27:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('17-07-2019 14:27:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (4, 'DIFF', 'ALLOY_CU', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (5, 'DIFF', 'AMORPHOUS_POLY', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (6, 'DIFF', 'ANNEAL_LDD', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (7, 'DIFF', 'ANNEAL_SAB', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (8, 'DIFF', 'ANNEAL_STI', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (9, 'QRA', 'AOI', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (10, 'PHOTO', 'ARF', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (11, 'ETCH', 'ASHER_CU', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (12, 'ETCH', 'ASHER_DTI', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (13, 'ETCH', 'ASHER_FEOL', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (14, 'WAT', 'AUTO_PROBER', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (15, 'WAT', 'AUTO_TESTER', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (16, 'TF', 'BARRIER_TTN_BSI', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (17, 'TF', 'BARRIER_TTN_FEOL', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (18, 'TF', 'Bonding', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (19, 'DIFF', 'BONDING_ANNEAL_BSI', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (20, 'PHOTO', 'Bright_field', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (21, 'PHOTO', 'Bright_field_CU', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (22, 'TF', 'BSIOX_CMP', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (23, 'TF', 'BSISi_CMP', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (24, 'PHOTO', 'CD_SEM', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (25, 'PHOTO', 'CD_SEM_Cu', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (26, 'PHOTO', 'CN concentration', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (27, 'TD', 'CP prober', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (28, 'TD', 'CP tester', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (29, 'TF', 'CU_BARRIER_SEED', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (30, 'TF', 'Cu_CMP', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (31, 'TF', 'CU_ECP', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (32, 'TF', 'CVD_ALDOX', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (33, 'TF', 'CVD_BD1', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (34, 'TF', 'CVD_HARP', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (35, 'TF', 'CVD_HTSIN', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (36, 'TF', 'CVD_ILD', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (37, 'TF', 'CVD_IMD', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (38, 'TF', 'CVD_NDC', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (39, 'TF', 'CVD_SAB', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (40, 'TF', 'CVD_SIN_BSI', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (41, 'TF', 'CVD_TEOS', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (42, 'TF', 'CVD_TEOS_CU', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (43, 'PHOTO', 'Dark_field', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (44, 'PHOTO', 'Dark_field_Cu', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (45, 'PHOTO', 'Dosage measurement', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (46, 'PHOTO', 'Ebeam', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (47, 'PHOTO', 'EDGE_COATER', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (48, 'ETCH', 'EDT_HMDTI', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (49, 'ETCH', 'EOX_DV', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (50, 'ETCH', 'EOX_TSVHM2', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (51, 'ETCH', 'Etch parts clean', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (52, 'ETCH', 'Etch parts clean HF', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (53, 'ETCH', 'ETCH_AIO', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (54, 'ETCH', 'ETCH_BEVEL', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (55, 'ETCH', 'ETCH_CONTACT', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (56, 'ETCH', 'ETCH_DEEP_TRENCH', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (57, 'ETCH', 'ETCH_METAL', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (58, 'ETCH', 'ETCH_OXIDE', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (59, 'ETCH', 'ETCH_PAD', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (60, 'ETCH', 'ETCH_POLY', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (61, 'ETCH', 'ETCH_ROUNDING', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (62, 'ETCH', 'ETCH_W', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (63, 'DIFF', 'FHB_ALO', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (64, 'QRA', 'FIB', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (65, 'QRA', 'FIB#2', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (66, 'ETCH', 'FOUP clean', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (67, 'ETCH', 'FOUP clean Cu', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (68, 'PHOTO', 'FOUP inspection', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (69, 'QRA', 'FT handler', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (70, 'QRA', 'FT Tester', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (71, 'PHOTO', 'FTIR', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (72, 'DIFF', 'Furnace parts clean', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (73, 'QRA', 'GC-MS', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (74, 'PHOTO', 'GOI', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (75, 'TF', 'Grinding', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (76, 'QRA', 'HAST Tester', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (77, 'DIFF', 'HCI_LOGIC', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (78, 'DIFF', 'HCI_PD', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (79, 'DIFF', 'HEI', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (80, 'DIFF', 'HFO_BSI', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (81, 'DIFF', 'H-quartz clean', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (82, 'QRA', 'HTOL Tester', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (83, 'QRA', 'IC', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (84, 'QRA', 'ICPMS', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (85, 'DIFF', 'IHE-PVXE', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (86, 'TF', 'ILD_CMP', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (87, 'PHOTO', 'I-LINE', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (88, 'QRA', 'In-line FIB', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (89, 'PHOTO', 'KRF', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (90, 'QRA', 'LAB Prober', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (91, 'QRA', 'LAB Tester', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (92, 'QRA', 'Laser OM', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (93, 'DIFF', 'LASER_MARK', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (94, 'QRA', 'LTOL Tester', to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:44', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (95, 'QRA', 'LTS Tester', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (96, 'PHOTO', 'Macro', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (97, 'PHOTO', 'Macro_Cu', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (98, 'TD', 'Manual prober', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (99, 'TD', 'Manual tester', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (100, 'PHOTO', 'Mask inspection', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (101, 'DIFF', 'MCI_LOGIC', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (102, 'DIFF', 'MCI_PD', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (103, 'PHOTO', 'Metal contamination', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (104, 'PHOTO', 'Metal contamination VPD', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (105, 'TF', 'METAL_HM_TIN', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (106, 'QRA', 'Multi site', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (107, 'ETCH', 'N2_PURGE', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (108, 'ETCH', 'N2_PURGE_CU', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (109, 'QRA', 'Nanoprobe', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (110, 'TF', 'NIPT_SPUTTER', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (111, 'QRA', 'OBIRCH+PEM', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (112, 'PHOTO', 'OCD', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (113, 'PHOTO', 'OM', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (114, 'QRA', 'OQA_PACK', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (115, 'ETCH', 'Oven etch', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (116, 'DIFF', 'Oven furnace', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (117, 'PHOTO', 'Overlay', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (118, 'PHOTO', 'Overlay_bonding', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (119, 'DIFF', 'PAD_OX', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (120, 'PHOTO', 'Particle measurement', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (121, 'PHOTO', 'Particle measurement Cu', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (122, 'TF', 'PBD_HBD', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (123, 'TF', 'PCU_PTM', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (124, 'QRA', 'PLR EMLsystem ', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (125, 'QRA', 'PLR HCI/TDDB Tester', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (126, 'QRA', 'Polish', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (127, 'ETCH', 'POST_CLN', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (128, 'ETCH', 'PRE_CLN', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (129, 'QRA', 'Probe station', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (130, 'PHOTO', 'Reticle changer', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (131, 'PHOTO', 'Review', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (132, 'PHOTO', 'Review Cu', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (133, 'QRA', 'RIE', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (134, 'PHOTO', 'RS', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (135, 'PHOTO', 'RS Cu', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (136, 'DIFF', 'RTO_DPN', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (137, 'DIFF', 'RTO_DRY', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (138, 'DIFF', 'RTO_ISSG', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (139, 'DIFF', 'RTP_ANNEAL', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (140, 'DIFF', 'RTP_NI', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (141, 'QRA', 'SCM', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (142, 'QRA', 'SEM', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (143, 'QRA', 'SEM#2', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (144, 'TD', 'Semi-auto prober', to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:45', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (145, 'TD', 'Semi-auto tester', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (146, 'QRA', 'Semiconductor Device Analyzer', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (147, 'DIFF', 'SIN_DCS', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (148, 'DIFF', 'SIN_HCD', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (149, 'PHOTO', 'Sorter', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (150, 'PHOTO', 'Sorter_Cu', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (151, 'QRA', 'Sputter coating', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (152, 'QRA', 'SRP', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (153, 'QRA', 'Station OM', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (154, 'TF', 'STI_CMP', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (155, 'QRA', 'TD', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (156, 'TD', 'TD Auto prober', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (157, 'TD', 'TD Auto tester', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (158, 'QRA', 'TEM', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (159, 'QRA', 'TEM sample pick up system', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (160, 'DIFF', 'TEOS', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (161, 'QRA', 'Thermal', to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:46', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (162, 'PHOTO', 'THK', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (163, 'PHOTO', 'THK_Cu', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (164, 'PHOTO', 'THK_metal_Cu', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (165, 'PHOTO', 'THK_silicon', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (166, 'PHOTO', 'TRACK ArF', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (167, 'PHOTO', 'TRACK I-Line', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (168, 'PHOTO', 'TRACK KrF', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (169, 'TF', 'Trimming', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (170, 'TF', 'TSVW_CMP', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (171, 'DIFF', 'Tube storage', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (172, 'DIFF', 'UNDOPED_POLY', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (173, 'QRA', 'VBA', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (174, 'PHOTO', 'Void_measurement', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (175, 'DIFF', 'V-quartz clean', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (176, 'TF', 'VTO_VTO', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (177, 'TF', 'W_CMP', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (178, 'ETCH', 'Wafer recycle Cu', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (179, 'ETCH', 'Wafer recycle metal', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (180, 'ETCH', 'Wafer recycle OX', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (181, 'ETCH', 'Wafer recycle poly', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (182, 'ETCH', 'WAR_FEC', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (183, 'ETCH', 'WBC_CU', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (184, 'ETCH', 'WCS_FEC', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (185, 'TF', 'WCVD_BSI', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (186, 'TF', 'WCVD_FEOL', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (187, 'ETCH', 'WDR_BSIC', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (188, 'ETCH', 'WNI_NI', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (189, 'ETCH', 'WNR_FEC', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (190, 'ETCH', 'WPC_CU', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (191, 'ETCH', 'WPF_FEC', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (192, 'ETCH', 'WPM_HK', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (193, 'ETCH', 'WSC_CU', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (194, 'ETCH', 'WSF_FEC', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (195, 'ETCH', 'WSM_FE', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (196, 'ETCH', 'WSN_NI', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (197, 'ETCH', 'WSS_CU', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (198, 'ETCH', 'WTH_BSIC', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (199, 'QRA', '高温高湿存储机台', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (200, 'QRA', '高温厌氧烘箱', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_EQ_TYPE (id, eq_module, eq_type, add_time, add_user_id, update_time, update_user_id, del_flag)
values (201, 'QRA', '快速温变机台', to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 08:58:47', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;



insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (1, 'W1170001', '外延片 EPI Wafer', 'EPI P/P 8-12ohm 5um+/- 0.1 with LTO', 'Pcs', '1', '23', to_date('17-07-2019 14:27:30', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('17-07-2019 14:27:30', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (2, 'W1160001', '载片 Carrier Wafer', 'Carrier P 12-20ohm', 'Pcs', '1', '12', to_date('17-07-2019 14:27:35', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('17-07-2019 14:27:35', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (3, 'C100003', '化学品 Chemical', 'HF 49% 190L/Dr', 'L', '0.005263158', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (4, 'C000004', '化学品 Chemical', 'NH4OH 29% Lorry', 'L', '0.9', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (5, 'C000009', '化学品 Chemical', 'HCl 36% 195L/Dr', 'L', '0.005128205', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (6, 'C000002', '化学品 Chemical', 'H2O2 31% Lorry', 'L', '1.11', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (7, 'C000021', '化学品 Chemical', 'Trans-LC(DCE) 7N5 1.5L 1.75Kg/BT 3/8"', 'KG', '0.571428571', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (8, 'G000053', '气体 Gas', 'DCS 3N 44L 41Kg/Cyl DISS636', 'L', '0.000101709', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (9, 'G000022', '气体 Gas', 'NH3 5N5 440L 230Kg/Ycl CGA720M', 'KG', '0.004166667', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (10, 'G000030', '气体 Gas', '20%F2/N2 3N 47L 3525L/Cyl DISS679', 'L', '0.000283688', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (11, 'C000100', '化学品 Chemical', 'Acetone 2N7 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (12, 'CR00001', '光阻显影类 Photochemical', 'TMAH 2.38%with  surfactant Lorry', 'L', '1', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (13, 'CR00002', '光阻显影类 Photochemical', 'OK73 THINNER Lorry', 'L', '0.93', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (14, 'RB00002', '光阻显影类 Photochemical', 'AR40-800 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (15, 'RA00002', '光阻显影类 Photochemical', 'AM2073J-19 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (16, 'G000035', '气体 Gas', '0.95%F2/3.5%Ar/Ne 49L 7500L/Cyl DISS640', 'L', '0.000133333', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (17, 'G000036', '气体 Gas', '10ppmXe/3.5%Ar/Ne 49L 7500L/Cyl DISS718', 'L', '0.000133333', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (18, 'G000045', '气体 Gas', 'CF4 5N7 47L 30Kg/Cyl DISS716', 'L', '0.000130952', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (19, 'G000049', '气体 Gas', 'CHF3 5N 47L 35Kg/Cyl DISS716', 'L', '8.92985E-05', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (20, 'G000046', '气体 Gas', 'CH2F2 4N8 47L 27.3Kg/Cyl DISS724', 'L', '8.49834E-05', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (21, 'G000054', '气体 Gas', 'HBr 5N 47L 50Kg/Cyl DISS634', 'L', '7.22411E-05', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (22, 'G000021', '气体 Gas', 'NF3 4N 440L 200Kg/Ycl CGA640', 'L', '1.48001E-05', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (23, 'G000057', '气体 Gas', 'SiCL4 6N 10L 10Kg/Cyl JIS22.14R', 'L', '0.000733676', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (24, 'G000056', '气体 Gas', 'SF6 5N 47L 50Kg/Cyl DISS716', 'L', '0.000121951', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (25, 'C000001', '化学品 Chemical', 'H2SO4 96% Lorry', 'L', '1.84', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (26, 'CR00003', '光阻显影类 Photochemical', 'HMDS 2N5 OAP 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (27, 'RL00004', '光阻显影类 Photochemical', 'IX420H-4cp 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (28, 'G000050', '气体 Gas', 'Cl2 5N 47L 50Kg/Cyl DISS634', 'L', '6.33036E-05', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (29, 'C000008', '化学品 Chemical', 'H3PO4 86% 187L/Dr', 'L', '0.005347594', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (30, 'C000005', '化学品 Chemical', 'IPA 4N Lorry', 'L', '0.785', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (31, 'C000018', '化学品 Chemical', 'TEOS 9N 53Gal 180Kg/BT', 'KG', '0.005555556', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (32, 'CS00003', '研磨液类 Slurry', 'Oxide slurry D9225 200L/Dr', 'L', '0.005', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (33, 'CS00006', '研磨液类 Slurry', 'STI slurry Ceria STI2305 200L/Dr', 'L', '0.005', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (34, 'C000091', '研磨液类 Slurry', 'STI buff chemical STI2950 200L/Dr', 'L', '0.005', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (35, 'C000013', '研磨液类 Slurry', 'TMAH 25% 200L/Dr', 'L', '0.005', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (36, 'K000004', '研磨垫 PAD', 'Pad for STI CMP and ILD CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (37, 'D000001', '研磨垫 PAD', 'Condition Disk for STI CMP and ILD CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (38, 'G000023', '气体 Gas', 'SiH4 6N 440L 125Kg/Ycl CGA632 P', 'KG', '0.008333333', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (39, 'G000051', '气体 Gas', 'ClF3 3N 40L 5300L/Cyl JIS-22-14R', 'L', '0.000188857', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (40, 'RL00001', '光阻显影类 Photochemical', 'ZR8690PB-70cp 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (41, 'G000011', '气体 Gas', 'AsH3 5N5 2.2L 0.65Kg/Cyl 1/2''''VCR', 'KG', '1.538461538', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (42, 'C000006', '化学品 Chemical', 'HNO3 70% 176L/Dr', 'L', '0.005681818', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (43, 'G000037', '气体 Gas', '0.95%F2/1.25%Kr/Ne 49L 7500L/Cyl DISS640', 'L', '0.000133333', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (44, 'G000038', '气体 Gas', '1.25%Kr/Ne 49L 7500L/Cyl DISS718', 'L', '0.000133333', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (45, 'RK00002', '光阻显影类 Photochemical', 'DP033AE-73cp 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (46, 'G000013', '气体 Gas', 'BF3 3N 2.2L 0.335Kg/Cyl 1/4'''' VCR', 'KG', '2.985074627', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (47, 'G000016', '气体 Gas', 'Xe 5N 1L 45L/Cyl CGA580', 'L', '0.02', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (48, 'RK00004', '光阻显影类 Photochemical', 'UV26G/2.5 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (49, 'G000012', '气体 Gas', 'PH3 5N7 2.2L 0.52Kg/Cyl 1/2'''' VCR', 'KG', '1.923076923', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (50, 'RK00003', '光阻显影类 Photochemical', 'UV26G/1.3A 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (51, 'RK00005', '光阻显影类 Photochemical', 'UV56-0.19 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (52, 'RT00001', '光阻显影类 Photochemical', 'AQUATAR-VIII-A 30-S-1G 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (53, 'RK00001', '光阻显影类 Photochemical', 'P6101N EL-25cP 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (54, 'C000024', '化学品 Chemical', 'InF3 2N 0.025Kg/BT', 'KG', '40', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (55, 'RK00008', '光阻显影类 Photochemical', 'V146G-9cp 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (56, 'RK00006', '光阻显影类 Photochemical', 'UV49G-0.3 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:13', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (57, 'G000058', '气体 Gas', 'SO2 3N8 44L 110LB/Cyl CGA660', 'L', '0.0000572', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (58, 'G000014', '气体 Gas', 'GeF4 4N 2.2L 0.7Kg/Cyl 1/4'''' VCR', 'KG', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (59, 'G000015', '气体 Gas', 'Xe/H2 5N 2.2L 84L/Cyl 1/2'''' VCR', 'L', '0.011904762', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (60, 'C000016', '化学品 Chemical', 'HCDS 6N 20Kg/BT 1/4''''VCR', 'KG', '0.05', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (61, 'G000066', '气体 Gas', 'C2H4 5N 17L 4.99Kg/Cyl DISS724', 'KG', '0.200400802', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (62, 'G000060', '气体 Gas', 'HF 5N 40L 12244L/Cyl DISS638', 'L', '8.18666E-05', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (63, 'G000047', '气体 Gas', 'CH3F 4N 47L 7.2Kg/Cyl DISS724', 'L', '0.000207143', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (64, 'G000020', '气体 Gas', 'N2O 5N5 440L 272Kg/Ycl CGA712M', 'L', '0.00000875', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (65, 'T000005', '靶材 Target', 'NiPt Target 4N5 NO.0190-26281', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (66, 'T000010', '靶材 Target', 'Ti Target 5N NO.0190-23987', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (67, 'C000020', '化学品 Chemical', 'TEPO 7N5 5Gal 15Kg/BT', 'KG', '0.066666667', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (68, 'G000063', '气体 Gas', 'C2H2 3N3 67L 10.671Kg/Cyl CGA510', 'KG', '0.09371193', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (69, 'RA00001', '光阻显影类 Photochemical', 'P7145ME-2.1cP 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (70, 'G000042', '气体 Gas', 'C4F6 4N 47L 25Kg/Cyl DISS724', 'L', '0.000289339', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (71, 'G000052', '气体 Gas', 'CO 4N8 47L 6800L/Cyl DISS724', 'L', '0.000147059', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (72, 'C000017', '化学品 Chemical', 'TDMAT 6N 5Gal 2.2Kg/BT', 'KG', '0.454545455', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (73, 'T000003', '靶材 Target', 'Ti Coil 4N5 NO.0040-03899', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (74, 'T000008', '靶材 Target', 'Ti Target 5N NO.0190-07114', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (75, 'G000032', '气体 Gas', '5%B2H6/N2 4N/5N 44L 1500psi/Cyl CGA632', 'L', '0.000222727', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (76, 'G000059', '气体 Gas', 'WF6 5N 40L 50Kg/Cyl CGA638', 'L', '0.00024667', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (77, 'CS00007', '研磨液类 Slurry', 'W slurry W7801 200L/Dr', 'L', '0.005', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (78, 'K000006', '研磨垫 PAD', 'Pad for W CMP and TSVW CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (79, 'D000002', '研磨垫 PAD', 'Condition Disk for W CMP and TSVW CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (80, 'T000009', '靶材 Target', 'Ti Target 5N NO.0021-20123', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (81, 'G000048', '气体 Gas', 'CH4 5N 44L 8100L/Cyl DISS724', 'L', '0.000123457', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (82, 'C000011', '化学品 Chemical', 'Solvent clean R2307 170L/Dr', 'L', '0.005882353', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (83, 'G000043', '气体 Gas', 'C4F8 5N 47L 50Kg/Cyl DISS716', 'L', '0.000166667', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (84, 'T000007', '靶材 Target', 'Ta Coil 4N5 NO.0190-17191', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (85, 'T000006', '靶材 Target', 'Ta Target 4N5 NO.0190-23999', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (86, 'T000002', '靶材 Target', 'Cu Target 6N NO.0190-37380', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (87, 'C000030', '化学品 Chemical', 'VMS 200L/Dr', 'L', '0.005', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (88, 'C000031', '化学品 Chemical', 'Accelerator 4L/BT', 'L', '0.25', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (89, 'C000032', '化学品 Chemical', 'Leveler 4L/BT', 'L', '0.25', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (90, 'C000033', '化学品 Chemical', 'Suppressor 4L/BT', 'L', '0.25', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (91, 'CS00002', '研磨液类 Slurry', 'Cu slurry CU3929 200L/Dr', 'L', '0.005', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (92, 'CS00001', '研磨液类 Slurry', 'Cu barrier slurry BAR6610R 200L/Dr', 'L', '0.005', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (93, 'C000092', '研磨液类 Slurry', 'Cu clean chemical PCMP5670 189.25L/Dr', 'L', '0.005284016', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (94, 'K000003', '研磨垫 PAD', 'Pad for Cu CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (95, 'D000003', '研磨垫 PAD', 'Condition Disk for Cu CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (96, 'K000008', '研磨垫 PAD', 'Soft Pad for Cu CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (97, 'G000067', '气体 Gas', '5%H2/He 6N/6N 40L 5000L/Cyl DISS724', 'L', '0.0002', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (98, 'RB00005', '光阻显影类 Photochemical', 'GF52-380 4L/BT', 'L', '0.25', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (99, 'RB00003', '光阻显影类 Photochemical', 'DUV42P-6 4L/BT', 'L', '0.25', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (100, 'RK00007', '光阻显影类 Photochemical', 'M91Y-9cp 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (101, 'K000002', '研磨垫 PAD', 'Pad for BSIOX CMP and BSISi CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (102, 'D000005', '研磨垫 PAD', 'Condition Disk for BSIOX CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (103, 'CS00010', '研磨液类 Slurry', 'Silicon slurry 1 PL6103 20L/BT', 'L', '0.05', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (104, 'CS00008', '研磨液类 Slurry', 'Silicon slurry 2 GL3108 20Kg/BT', 'L', '0.05', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (105, 'K000001DO', '研磨垫 PAD', 'Supreme RN-H Pad 180mmD PJ;XA63, Z4 pad', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (106, 'K000001DI', '研磨垫 PAD', 'S Pad 450 X 4T', 'Pcs', '1', null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:14', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (107, 'C000105', '化学品 Chemical', 'Spinetch D 191L/Dr', 'L', '0.005235602', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (108, 'C000106', '化学品 Chemical', 'HHC 192L/Dr', 'L', '0.005208333', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (109, 'CS00009', '研磨液类 Slurry', 'Silicon slurry 1 PL6103 220L/Dr', 'L', '0.004545455', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (110, 'C000090', '研磨液类 Slurry', 'Silicon buff slurry PL6501 200L/Dr', 'L', '0.005', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (111, 'D000006', '研磨垫 PAD', 'Condition Disk for BSISi CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (112, 'K000007', '研磨垫 PAD', 'Soft Pad for BSISi CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (113, 'C000022', '化学品 Chemical', 'LTO520 6N 19L 13.28Kg/BT', 'KG', '0.075301205', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (114, 'RA00003', '光阻显影类 Photochemical', 'P6111ME-2.6cp 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (115, 'C000014', '化学品 Chemical', 'TDMAH 6N 5Kg/BT', 'KG', '0.2', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (116, 'C000023', '化学品 Chemical', 'SAM24 5N 18.9L 10Kg/BT 1/4''''VCR', 'KG', '0.1', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (117, 'RL00003', '光阻显影类 Photochemical', 'IX420H-9cp 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (118, 'CS00005', '研磨液类 Slurry', 'SiN slurry PL6125N 200L/Dr', 'L', '0.005', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (119, 'D000004', '研磨垫 PAD', 'Condition Disk for Nitride CMP', 'Pcs', '1', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (120, 'T000001', '靶材 Target', 'Al Target 5N5 BKM NO.0190-23518', 'Pcs', '1', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (121, 'G000040', '气体 Gas', 'BCl3 6N 47L 50Kg/Cyl DISS634', 'L', '9.70026E-05', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (122, 'C000012', '化学品 Chemical', 'Solvent clean NE111 193L/Dr', 'L', '0.005181347', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;
insert into T_MATERIAL_COEFFICIENT (id, material_no, material_group, material_name, bom_unit, coefficient, material_price, add_time, add_user_id, update_time, update_user_id, del_flag)
values (123, 'RL00002', '光阻显影类 Photochemical', 'IX420H-38cp 1Gal/BT', 'L', '0.264200793', null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('18-07-2019 09:08:15', 'dd-mm-yyyy hh24:mi:ss'), null, 0);
commit;

