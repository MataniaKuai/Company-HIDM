
INSERT INTO t_permission(id, url, name)
 VALUES
(2, '/inventoryReport', '库存消耗趋势图');
commit;

INSERT INTO t_role (id, name)
 VALUES (2, 'inventoryReport');
commit;


INSERT INTO t_role_permission(id, rid, pid)
VALUES (2,2,2);
COMMIT;


INSERT INTO t_user_role (id, userid, rid)
VALUES(8,1,2);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(9,2,2);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(10,3,2);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(11,4,2);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(12,5,2);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(13,6,2);
commit;

INSERT INTO t_user_role (id, userid, rid)
VALUES(14,7,2);
commit;

insert into T_PERMISSION (id,URL,Name)
values ('4','/report4','Material KPI Index Report');
commit;
insert into T_ROLE_PERMISSION (id,rid,Pid)
values ('4','2','4');
commit;

alter table T_MATERIALTYPE add materialtype varchar(100);
commit;
update T_MATERIALTYPE s set materialtype='DM' where s.type='外延片 EPI Wafer';
update T_MATERIALTYPE s set materialtype='DM' where s.type='载片 Carrier Wafer';
update T_MATERIALTYPE s set materialtype='IDM' where s.type='控制片 Control Wafer';
update T_MATERIALTYPE s set materialtype='IDM' where s.type='化学品 Chemical';
update T_MATERIALTYPE s set materialtype='IDM' where s.type='研磨液类 Slurry';
update T_MATERIALTYPE s set materialtype='IDM' where s.type='气体 Gas';
update T_MATERIALTYPE s set materialtype='IDM' where s.type='光阻显影类 Photochemical';
update T_MATERIALTYPE s set materialtype='IDM' where s.type='靶材 Target';
update T_MATERIALTYPE s set materialtype='IDM' where s.type='研磨垫&修整盘 PAD&Disk';
update T_MATERIALTYPE s set materialtype='IDM' where s.type='石英 Quartz';
update T_MATERIALTYPE s set materialtype='IDM' where s.type='晶圆光罩盒类 Container';
update T_MATERIALTYPE s set materialtype='IDM' where s.type='生产性耗材 Consumable Material';
update T_MATERIALTYPE s set materialtype='IDM' where s.type='劳保用品 Supplies';
update T_MATERIALTYPE s set materialtype='R&M' where s.type='消耗性零配件 Consumable Parts';
update T_MATERIALTYPE s set materialtype='R&M' where s.type='非消耗性零配件 Non-Consumable Parts';
commit;
alter table T_KPIREPORT add MonthDate varchar(100);
commit;
alter table T_KPIREPORT_HIS add MonthDate varchar(100);
commit;