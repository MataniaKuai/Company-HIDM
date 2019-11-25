
--
-- ת����е����� 't_permission'
--

INSERT INTO t_permission(id, url, name)
 VALUES
(1, '/report1', '���������ݱ���');

commit;

--
-- ת����е����� 't_role'
--

INSERT INTO t_role (id, name)
 VALUES (1, 'report1');
 commit;

--
-- ת����е����� 't_role_permission'
--
INSERT INTO t_role_permission(id, rid, pid)
VALUES (1,1,1);
COMMIT;
--
-- ת����е����� 't_user'
--
INSERT INTO t_user(id, user_name)
VALUES(1,'E100100');
COMMIT;

INSERT INTO t_user(id, user_name)
VALUES(2,'E100048');
COMMIT;

INSERT INTO t_user(id, user_name)
VALUES(3,'E100593');
COMMIT;

INSERT INTO t_user(id, user_name)
VALUES(4,'E100522');
COMMIT;

INSERT INTO t_user(id, user_name)
VALUES(5,'E100978');
COMMIT;

INSERT INTO t_user(id, user_name)
VALUES(6,'E101157');
COMMIT;


--
-- ת����е����� 't_user_role'
--

INSERT INTO t_user_role (id, userid, rid)
VALUES(1,1,1);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(2,2,1);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(3,3,1);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(4,4,1);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(5,5,1);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(6,6,1);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(7,7,1);
commit;



