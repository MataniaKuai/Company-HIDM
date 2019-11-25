<!-- 库存消耗-->
CREATE SEQUENCE T_INVENTORY_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;
create table T_INVENTORY
(
  id          NUMBER not null,
  matnr VARCHAR2(120),
  maktx VARCHAR2(120),
  matkl VARCHAR2(27),
  wgbez VARCHAR2(240),
  werks VARCHAR2(12),
  lgort VARCHAR2(12),
  bwart VARCHAR2(9),
  z_bwart VARCHAR2(12),
  mblnr VARCHAR2(30),
  mjahr VARCHAR2(12),
  zeile VARCHAR2(12),
  budat VARCHAR2(24),
  erfmg VARCHAR2(40),
  erfme VARCHAR2(10),
  bktxt_jck VARCHAR2(30),
  ebeln VARCHAR2(30),
  ebelp VARCHAR2(15),
  mtart VARCHAR2(12),
  xblnr VARCHAR2(50),
  bktxt VARCHAR2(12),
  name_text VARCHAR2(240),
  stprs VARCHAR2(35),
  verpr VARCHAR2(35),
  vprsv VARCHAR2(10),
  waers VARCHAR2(15),
  update_time DATE default CURRENT_TIMESTAMP,
  constraint PK_T_INVENTORY_CONSUMPTION primary key (id)
);
