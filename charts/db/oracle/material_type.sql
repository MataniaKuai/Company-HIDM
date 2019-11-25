CREATE SEQUENCE T_MATERIALTYPE_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;
create table T_MATERIALTYPE
(
  id   NUMBER not null,
  type VARCHAR2(100),
  constraint PK_T_MATERIALTYPE primary key (id)
)
;
insert into T_MATERIALTYPE (id, type)
values (1, '外延片 EPI Wafer');
insert into T_MATERIALTYPE (id, type)
values (2, '载片 Carrier Wafer');
insert into T_MATERIALTYPE (id, type)
values (3, '控制片 Control Wafer');
insert into T_MATERIALTYPE (id, type)
values (4, '化学品 Chemical');
insert into T_MATERIALTYPE (id, type)
values (5, '研磨液类 Slurry');
insert into T_MATERIALTYPE (id, type)
values (6, '气体 Gas');
insert into T_MATERIALTYPE (id, type)
values (7, '光阻显影类 Photochemical');
insert into T_MATERIALTYPE (id, type)
values (8, '靶材 Target');
insert into T_MATERIALTYPE (id, type)
values (9, '研磨垫&修整盘 PAD&Disk');
insert into T_MATERIALTYPE (id, type)
values (10, '石英 Quartz');
insert into T_MATERIALTYPE (id, type)
values (11, '晶圆光罩盒类 Container');
insert into T_MATERIALTYPE (id, type)
values (12, '生产性耗材 Consumable Material');
insert into T_MATERIALTYPE (id, type)
values (13, '劳保用品 Supplies');
insert into T_MATERIALTYPE (id, type)
values (14, '消耗性零配件 Consumable Parts');
insert into T_MATERIALTYPE (id, type)
values (15, '非消耗性零配件 Non-Consumable Parts');
commit;
