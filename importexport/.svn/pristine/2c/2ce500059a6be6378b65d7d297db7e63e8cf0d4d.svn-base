alter table T_MATERIAL
add (employee_no varchar2(100) DEFAULT '');

alter table T_ASSET
add (employee_no varchar2(100) DEFAULT '');

alter table T_CONTROL_DETAIL
add (import_itemid NUMBER);

alter table T_CONTROL_DETAIL
add (employee_no varchar2(100) DEFAULT '');

alter table T_CONTROL_DETAIL
add (out_qty number(13,3));

alter table T_IMPORT_ITEM
add (ISEDIT NUMBER DEFAULT 0);

alter table T_IMPORT
add (text1 varchar2(500) DEFAULT '');
alter table T_IMPORT
add (text2 varchar2(500) DEFAULT '');
alter table T_IMPORT
add (text3 varchar2(500) DEFAULT '');

alter table t_import_batch
add (g_weight number(13,3));
alter table t_import_batch
add (n_weight number(13,3));
alter table t_import_batch
add (package_type varchar2(100) DEFAULT '');
alter table t_import_batch
add (b_size varchar2(100) DEFAULT '');

alter table t_import_item
add (tariff_rate number(13,3));
alter table t_import_item
add (trading_unit varchar2(100) DEFAULT '');
alter table t_import_item
add (transaction_volume number(13,3));
alter table t_import_item
add (legal_unit varchar2(100) DEFAULT '');
alter table t_import_item
add (legal_quantity number(13,3));

alter table T_PERMISSION
add (code varchar2(64) DEFAULT NULL);

--删除按钮权限的相关sql------------start--
INSERT INTO t_role (id, name)
 values(5, 'importDel');
commit;

INSERT INTO t_role (id, name)
 values(6, 'storageDel');
commit;

INSERT INTO t_role (id, name)
 values(7, 'storageEdit');
commit;

INSERT INTO t_permission(id, url, name, code)
 VALUES
(17, '/material/delete', '原材料删除', 'materialDelete');
commit;

INSERT INTO t_permission(id, url, name, code)
 VALUES
(18, '/asset/delete', '资产删除', 'assetDelete');
commit;

INSERT INTO t_permission(id, url, name, code)
 VALUES
(19, '/importInfo/delete', '进出口信息删除', 'importDelete');
commit;

INSERT INTO t_permission(id, url, name, code)
 VALUES
(20, '/material/save', '原材料新增编辑', 'materialSave');
commit;

INSERT INTO t_permission(id, url, name, code)
 VALUES
(21, '/asset/save', '资产新增编辑', 'assetSave');
commit;

INSERT INTO t_role_permission(id, rid, pid)
VALUES (T_ROLE_PERMISSION_SEQ.NEXTVAL,6,17);
COMMIT;

INSERT INTO t_role_permission(id, rid, pid)
VALUES (T_ROLE_PERMISSION_SEQ.NEXTVAL,6,18);
COMMIT;

INSERT INTO t_role_permission(id, rid, pid)
VALUES (T_ROLE_PERMISSION_SEQ.NEXTVAL,5,19);
COMMIT;

INSERT INTO t_user_role (id, userid, rid)
VALUES(T_USER_ROLE_SEQ.NEXTVAL,1,5);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(T_USER_ROLE_SEQ.NEXTVAL,1,6);
commit;
--删除按钮权限的相关sql------------start--

--增加刘剑锋查看权限的相关sql------------start--

update T_PERMISSION t set t.code = 'materialManage' where t.url='/material/manage';
commit;

update T_PERMISSION t set t.code = 'importManage' where t.url='/importInfo/manage';
commit;

update T_PERMISSION t set t.code = 'importImport' where t.url='/importInfo/import';
commit;

update T_PERMISSION t set t.code = 'assetManage' where t.url='/asset/manage';
commit;

update T_PERMISSION t set t.code = 'controlManage' where t.url='/controlDetail/manage';
commit;

update T_PERMISSION t set t.code = 'releaseManage' where t.url='/receive/release/manage';
commit;

update T_PERMISSION t set t.code = 'receiveManage' where t.url='/receive/receive/manage';
commit;

update T_PERMISSION t set t.code = 'unreceiveManage' where t.url='/receive/unreceive/manage';
commit;

update T_PERMISSION t set t.code = 'receivedManage' where t.url='/receive/received/manage';
commit;

update T_PERMISSION t set t.code = 'report1' where t.url='/report/report1';
commit;

update T_PERMISSION t set t.code = 'report2' where t.url='/report/report2';
commit;

update T_PERMISSION t set t.code = 'report3' where t.url='/report/report3';
commit;

update T_PERMISSION t set t.code = 'report4' where t.url='/report/report4';
commit;

update T_PERMISSION t set t.code = 'reportImport' where t.url='/report/reportImportInfo';
commit;

update T_PERMISSION t set t.code = 'releaseHis' where t.url='/manage/releaseHis';
commit;

update T_PERMISSION t set t.code = 'businessHis' where t.url='/manage/businessHis';
commit;


update t_role_permission t set t.rid=7 where t.pid=5;
commit;

update t_role_permission t set t.rid=7 where t.pid=10;
commit;

update t_role_permission t set t.rid=7 where t.pid=11;
commit;


INSERT INTO t_role_permission(id, rid, pid)
VALUES (T_ROLE_PERMISSION_SEQ.NEXTVAL,7,20);
COMMIT;

INSERT INTO t_role_permission(id, rid, pid)
VALUES (T_ROLE_PERMISSION_SEQ.NEXTVAL,7,21);
COMMIT;

INSERT INTO t_user_role (id, userid, rid)
VALUES(T_USER_ROLE_SEQ.NEXTVAL,1,7);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(T_USER_ROLE_SEQ.NEXTVAL,3,7);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(T_USER_ROLE_SEQ.NEXTVAL,4,7);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(T_USER_ROLE_SEQ.NEXTVAL,7,7);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(T_USER_ROLE_SEQ.NEXTVAL,13,7);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(T_USER_ROLE_SEQ.NEXTVAL,14,7);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(T_USER_ROLE_SEQ.NEXTVAL,15,7);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(T_USER_ROLE_SEQ.NEXTVAL,16,7);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(T_USER_ROLE_SEQ.NEXTVAL,8,2);
commit;
--增加刘剑锋查看权限的相关sql------------end--

