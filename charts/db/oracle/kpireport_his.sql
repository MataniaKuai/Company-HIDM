CREATE SEQUENCE T_KPIREPORT_HIS_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;
create table T_KPIREPORT_HIS
(
  id          NUMBER not null,
  werks       VARCHAR2(12),
  matnr       VARCHAR2(120),
  maktx       VARCHAR2(120),
  lgort       VARCHAR2(12),
  lgpbe       VARCHAR2(30),
  meins       VARCHAR2(12),
  matkl       VARCHAR2(27),
  zqty        VARCHAR2(39),
  zprice      VARCHAR2(35),
  update_time DATE default CURRENT_TIMESTAMP,
  constraint PK_T_KPIREPORT_HIS_CONSUMPTION primary key (id)
);