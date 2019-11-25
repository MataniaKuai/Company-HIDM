CREATE SEQUENCE T_ACHIEVEMENTS_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;
CREATE table T_ACHIEVEMENTS
(
  id NUMBER not null,
  werks VARCHAR2(12),
  lgort VARCHAR2(12),
  matnr VARCHAR2(120),
  maktx VARCHAR2(120),
  zqcsl VARCHAR2(12),
  zqmsl VARCHAR2(48),
  zshsl VARCHAR2(48),
  zfhsl VARCHAR2(48),
  cdate VARCHAR2(48),
  update_time DATE default CURRENT_TIMESTAMP,
  constraint PK_T_ACHIEVEMENTS primary key (id)
  );