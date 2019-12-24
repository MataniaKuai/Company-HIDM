


CREATE SEQUENCE T_USER_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;

create table  T_USER 
(
   id                 NUMBER        not null,
   user_name          varchar2(20),
   password           varchar2(32),
   update_time        DATE     default SYSDATE not null,
   add_time           DATE     default SYSDATE not null,
   add_user           varchar2(100),
   update_user        varchar2(100),
   del_flag           integer   default 0,
   constraint PK_T_USER primary key (id)
);

comment on column T_USER.user_name is '用户';
comment on column T_USER.password is '密码';



CREATE SEQUENCE T_ROLE_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;


create table T_ROLE
(
  id  NUMBER NOT NULL ,
  name varchar2(32) DEFAULT NULL,
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  add_user varchar2(100) DEFAULT '',
  update_user varchar2(100) DEFAULT '',
  del_flag integer  DEFAULT 0,
  constraint PK_T_ROLE primary key (id)
);

comment on column T_ROLE.name is '角色名称';



CREATE SEQUENCE T_USER_ROLE_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;



CREATE TABLE T_USER_ROLE(
  id NUMBER NOT NULL,
  userid NUMBER(20) DEFAULT NULL,
  rid NUMBER(20) DEFAULT NULL,
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  add_user varchar2(100) DEFAULT '',
  update_user varchar2(100) DEFAULT '',
  del_flag integer  DEFAULT 0,
   constraint PK_USER_ROLE primary key (id)
);

comment on column T_USER_ROLE.userid is '用户ID';
comment on column T_USER_ROLE.rid is '角色ID';



CREATE SEQUENCE T_PERMISSION_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;



CREATE TABLE T_PERMISSION
(
  id NUMBER NOT NULL,
  url varchar2(256) DEFAULT NULL,
  name varchar2(64) DEFAULT NULL,
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  add_user varchar2(100) DEFAULT '',
  update_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_PERMISSION primary key (id)
);

comment on column T_PERMISSION.url is 'url地址';
comment on column T_PERMISSION.name is 'url描述';



CREATE SEQUENCE T_ROLE_PERMISSION_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;



CREATE TABLE T_ROLE_PERMISSION
(
  id NUMBER NOT NULL ,
  rid NUMBER(20) DEFAULT NULL,
  pid NUMBER(20) DEFAULT NULL,
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  add_user varchar2(100)  DEFAULT '',
  update_user varchar2(100)  DEFAULT '',
  del_flag integer  DEFAULT 0,
  constraint PK_T_ROLE_PERMISSION primary key (id)
);

comment on column T_ROLE_PERMISSION.rid is '角色ID';
comment on column T_ROLE_PERMISSION.pid is '权限ID';



CREATE SEQUENCE T_MATERIAL_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;



create table T_MATERIAL
(
  id NUMBER NOT NULL,
  material_no varchar2(100) NOT NULL,
  goods_code varchar2(100) DEFAULT '',
  hi_tech integer DEFAULT 0,
  custom_office varchar2(10)  DEFAULT '',
  unit varchar2(10)  DEFAULT '',
  bond_cla1 varchar2(10)  DEFAULT '',
  bond_cla2 varchar2(10)  DEFAULT '',
  hs_code varchar2(100)  DEFAULT '',
  currency varchar2(10)  DEFAULT '',
  goods_desc varchar2(500)  DEFAULT '',
  chinese_name varchar2(500)  DEFAULT '',
  tax_preperty varchar2(10)  DEFAULT '',
  free_no varchar2(10)  DEFAULT '',
  iterm varchar2(500)  DEFAULT '',
  file_id integer  DEFAULT 0,
  text_1 varchar2(500) DEFAULT '',
  text_2 varchar2(500) DEFAULT '',
  text_3 varchar2(500) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer  DEFAULT 0,
  constraint PK_T_MATERIAL primary key (id)
);

create unique index idx_material_no on T_MATERIAL(material_no);




CREATE SEQUENCE T_ASSET_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;


CREATE TABLE T_ASSET
(
  id NUMBER NOT NULL,
  asset_no varchar2(100) NOT NULL,
  goods_code varchar2(100) DEFAULT '',
  hi_tech integer DEFAULT 0,
  custom_office varchar2(10) DEFAULT '',
  unit varchar2(10)  DEFAULT '',
  bond_cla1 varchar2(10) DEFAULT '',
  bond_cla2 varchar2(10) DEFAULT '',
  hs_code varchar2(100) DEFAULT '',
  currency varchar2(10) DEFAULT '',
  goods_desc varchar2(500) DEFAULT '',
  chinese_name varchar2(500) DEFAULT '',
  tax_preperty varchar2(10) DEFAULT '',
  free_no varchar2(10)  DEFAULT '',
  iterm varchar2(500)  DEFAULT '',
  file_id integer  DEFAULT 0,
  text_1 varchar2(500) DEFAULT '',
  text_2 varchar2(500) DEFAULT '',
  text_3 varchar2(500) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_ASSET primary key (id)
);

create unique index idx_asset_no on T_ASSET(asset_no);



CREATE SEQUENCE T_GOODS_CODE_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;



CREATE TABLE T_GOODS_CODE
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100)  DEFAULT '',
  del_flag integer  DEFAULT 0,
  constraint PK_T_GOODS_CODE primary key (id)
);



CREATE SEQUENCE T_CUSTOM_OFFICE_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;



CREATE TABLE T_CUSTOM_OFFICE
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE default sysdate not null,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100)  DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_CUSTOM_OFFICE primary key (id)
);



CREATE SEQUENCE T_CURRENCY_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;


CREATE TABLE T_CURRENCY
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100)  DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_CURRENCY primary key (id)
);




CREATE SEQUENCE T_TAX_PREPERTY_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;


CREATE TABLE T_TAX_PREPERTY
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100)  DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_TAX_PREPERTY primary key (id)
);




CREATE SEQUENCE T_BOND_CLA1_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;



CREATE TABLE T_BOND_CLA1
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_BOND_CLA1 primary key (id)
);



CREATE SEQUENCE T_BOND_CLA2_SEQ 
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;



CREATE TABLE T_BOND_CLA2
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_BOND_CLA2 primary key (id)
);



create sequence T_FREE_NO_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;
 


CREATE TABLE T_FREE_NO
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_FREE_NO primary key (id)
);


create sequence T_FILE_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;

CREATE TABLE T_FILE
(
  id NUMBER NOT NULL,
  file_name varchar2(100) DEFAULT '',
  file_path varchar2(100) DEFAULT '',
  file_type integer DEFAULT 0,
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_FILE_NO primary key (id)
);

create sequence T_INOUT_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;
  
CREATE TABLE T_INOUT
(
  id NUMBER NOT NULL,
  material_no varchar2(100),
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_INOUT primary key (id)
);

CREATE TABLE T_CONTROL_STATUS
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_CONTROL_STATUS primary key (id)
);

CREATE TABLE t_relieve_mode
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_RELEASE_MODE primary key (id)
);

CREATE TABLE T_OUT_REASON
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_OUT_REASON primary key (id)
);

CREATE TABLE T_REEXPORT_REASON
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_REEXPORT_REASON primary key (id)
);

create sequence T_CONTROL_DETAIL_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;
  
CREATE TABLE T_CONTROL_DETAIL
(
  id NUMBER NOT NULL,
  material_no varchar2(100),
  asset_no varchar2(100),
  ir_no varchar2(100) NOT NULL,
  goods_code varchar2(100) DEFAULT '',
  goods_desc varchar2(500) DEFAULT '',
  chinese_name varchar2(500) DEFAULT '',
  release_time DATE,
  expire_time DATE,
  control_status varchar2(10) DEFAULT '',
  relieve_mode varchar2(10) DEFAULT '',
  tax_preperty varchar2(10) DEFAULT '',
  out_time DATE,
  out_reason varchar2(10) DEFAULT '',
  reexport_reason varchar2(10) DEFAULT '',
  reexport_no varchar2(100) DEFAULT '',
  out_release_no varchar2(100) DEFAULT '',
  is_return integer DEFAULT 0,
  return_time DATE,
  relieve_time DATE,
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_CONTROL_DETAIL primary key (id)
);

create index idx_detail_irno on T_CONTROL_DETAIL(ir_no);

create sequence T_IMPORT_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;

CREATE TABLE T_IMPORT
(
  id NUMBER NOT NULL,
  org varchar2(10),
  freight_type varchar2(100),
  goods_code varchar2(100) DEFAULT '',
  ir_no varchar2(100) NOT NULL,
  declaration_no  varchar2(100) DEFAULT '',
  declaration_time DATE,
  release_time DATE,
  arrive_time DATE,
  receive_time DATE,
  sailing_time DATE,
  gw NUMBER(38, 5),
  nw NUMBER(38, 5),
  chw NUMBER(38, 5),
  total_package integer default 0,
  packing_type varchar2(10) DEFAULT '',
  record_no varchar2(50) DEFAULT '',
  unusual integer default 0,
  app_type varchar2(10) DEFAULT '',
  broker varchar2(100) DEFAULT '',
  forwarder varchar2(100) DEFAULT '',
  freight_term varchar2(10) DEFAULT '',
  bl varchar2(100) DEFAULT '',
  mawb varchar2(100) DEFAULT '',
  hawb varchar2(100) DEFAULT '',
  flight_vessel_voy varchar2(100) DEFAULT '',
  ship_from_country varchar2(10) DEFAULT '',
  ship_from_port varchar2(10) DEFAULT '',
  loading_port varchar2(10) DEFAULT '',
  discharge_port varchar2(10) DEFAULT '',
  inhouse_date Date,
  outhouse_date Date,
  invoice_no varchar2(100) DEFAULT '',
  trading_type varchar2(10) DEFAULT '',
  tax_preperty varchar2(10) DEFAULT '',
  tariff_tax varchar2(100) DEFAULT '',
  tariff varchar2(100) DEFAULT '',
  value_added_tax varchar2(100) DEFAULT '',
  original_country varchar2(100) DEFAULT '',
  import_custom varchar2(10) DEFAULT '',
  declaring_custom varchar2(100) DEFAULT '',
  import_port varchar2(10) DEFAULT '',
  lc_no varchar2(100) DEFAULT '',
  container_no varchar2(100) DEFAULT '',
  car_type varchar2(10) DEFAULT '',
  car_no varchar2(100) DEFAULT '',
  rma_no varchar2(100) DEFAULT '',
  rma_qty integer default 0,
  original_declaration_no varchar2(100) DEFAULT '',
  original_ir_no varchar2(100) DEFAULT '',
  import_person varchar2(10) DEFAULT '',
  final_reviser varchar2(10) DEFAULT '',
  last_modified_time Date,  
  remarks varchar2(1000) DEFAULT '',  
  status integer DEFAULT 0,
  update_time DATE default SYSDATE not null,
  add_time DATE default SYSDATE not null,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_IMPORT primary key (id)
);

create unique index idx_ir_no on T_IMPORT(ir_no);

CREATE TABLE T_ORG
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_ORG primary key (id)
);

CREATE TABLE t_freight_type
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_T_freight_type primary key (id)
);

CREATE TABLE t_packing_type
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_packing_type primary key (id)
);

CREATE TABLE t_record_no
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_record_no primary key (id)
);

CREATE TABLE t_app_type
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_app_type primary key (id)
);

CREATE TABLE t_freight_term
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_freight_term primary key (id)
);

CREATE TABLE t_ship_from_country
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_ship_from_country primary key (id)
);

CREATE TABLE t_loading_port
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_loading_port primary key (id)
);

CREATE TABLE t_import_custom
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_import_custom primary key (id)
);

CREATE TABLE t_import_port
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_import_port primary key (id)
);

CREATE TABLE t_car_type
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_car_type primary key (id)
);

create sequence T_IR_NO_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;

CREATE TABLE t_ir_no
(
  id NUMBER NOT NULL,
  year_no integer NOT NULL,
  org varchar2(50) DEFAULT '' NOT NULL,
  seq_no integer NOT NULL,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_ir_no primary key (id)
);

create unique index idx_yearno_org on t_ir_no(year_no, org);

create sequence T_IMPORT_ITEM_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;

CREATE TABLE t_import_item
(
  id NUMBER NOT NULL,
  po_no varchar2(100) DEFAULT '' NOT NULL,
  po_item varchar2(100) DEFAULT '' NOT NULL,
  vendor varchar2(100) DEFAULT '',
  material_no varchar2(100),  
  import_id NUMBER NOT NULL, 
  goods_desc varchar2(500) DEFAULT '',
  chinese_name varchar2(500) DEFAULT '',
  unit varchar2(500) DEFAULT '',
  qty number(13,3),
  unit_price NUMBER(38, 5),
  total_amount NUMBER(38, 5),
  currency varchar2(10),
  asset_no varchar2(100),
  trade_term varchar2(500) DEFAULT '',
  hs_code varchar2(100)  DEFAULT '',
  gr_no varchar2(100) DEFAULT '',
  related_grno varchar2(100) DEFAULT '',
  dept varchar2(100) DEFAULT '', 
  employee_no varchar2(10) DEFAULT '', 
  stock varchar2(100) DEFAULT '', 
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  move_type varchar2(100) DEFAULT '',
  status integer DEFAULT 0 NOT NULL,
  gr_year varchar2(100) DEFAULT '',
  gr_item integer default 0,
  related_gr_year varchar2(100) DEFAULT '',
  related_gr_item integer default 0,
  isbatch integer default 0,
  constraint PK_t_import_item primary key (id)
);

create index idx_item_importid on t_import_item(import_id);

create sequence T_IMPORT_ITEM_HIS_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;

CREATE TABLE t_import_item_his
(
  id NUMBER NOT NULL,
  import_itemid NUMBER NOT NULL, 
  relatedmove_type varchar2(100) DEFAULT '',
  move_type varchar2(100) DEFAULT '',
  related_grno varchar2(100) DEFAULT '',
  grno varchar2(100) DEFAULT '',
  gr_year varchar2(100) DEFAULT '',
  related_gr_year varchar2(100) DEFAULT '',
  status integer DEFAULT 0 NOT NULL,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_import_item_his primary key (id)
);

create index idx_import_itemid on t_import_item_his(import_itemid);

create sequence T_IMPORT_BATCH_HIS_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;

CREATE TABLE t_import_batch_his
(
  id NUMBER NOT NULL,
  item_hisid NUMBER NOT NULL, 
  batch_no varchar2(100),
  po_no varchar2(100) DEFAULT '' NOT NULL,
  po_item varchar2(100) DEFAULT '' NOT NULL,
  sapbatch_no varchar2(100),
  unit varchar2(500) DEFAULT '',
  qty number(13,3),
  produce_time DATE,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_import_batch_his primary key (id)
);

create index idx_item_hisid on t_import_batch_his(item_hisid);


CREATE TABLE t_trading_type
(
  id NUMBER NOT NULL,
  code varchar2(100) NOT NULL,
  name varchar2(100) DEFAULT '',
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_trading_type primary key (id)
);

create sequence T_IMPORT_BATCH_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;
  
CREATE TABLE t_import_batch
(
  id NUMBER NOT NULL,
  po_no varchar2(100) DEFAULT '' NOT NULL,
  po_item varchar2(100) DEFAULT '' NOT NULL,
  factory varchar2(100) DEFAULT '',
  material_no varchar2(100),
  batch_no varchar2(100),
  sap_batch_no varchar2(100) DEFAULT '',
  import_id NUMBER NOT NULL, 
  unit varchar2(500) DEFAULT '',
  qty number(13,3),
  produce_time DATE,
  overdue_time DATE,
  update_time DATE default SYSDATE not null,
  add_time DATE DEFAULT SYSDATE NOT NULL,
  update_user varchar2(100) DEFAULT '',
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_import_batch primary key (id)
);

create index idx_batch_importid on t_import_batch(import_id);

create sequence t_movement_data_seq
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;
 
create table t_movement_data
(
   id NUMBER NOT NULL,
   certificate_no  varchar2(10),
   certificate_year varchar2(10),
   certificate_item varchar2(10),
   material_code varchar2(50),
   factory varchar2(10),
   inventory_location varchar2(10),
   movement_type varchar2(10),
   batch_number varchar2(10),
   qty number(13,3),
   post_date varchar2(10),
   certificate_no_s varchar2(10),
   certificate_item_s varchar2(4)     
);


create sequence t_material_inventory_seq
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;


create table t_material_inventory
(
  id NUMBER NOT NULL,
  histmon varchar2(20),
  goods_code varchar2(100),
  goods_description varchar2(100),
  goods_description_cn varchar2(100),
  hs_code varchar2(100),
  tax_preperty varchar2(10),
  free_no varchar2(10),
  iterm varchar2(500),
  unit varchar2(10),
  material_no varchar2(100),
  unit_price varchar2(20),
  vendor varchar2(100),
  dept varchar2(50),
  user_id varchar2(50),
  gr_qty NUMBER(38, 3),
  retreat_goods_qty NUMBER(38, 3),
  use_goods_qty number(38,3),
  return_material_qty number(38,3),
  production_scrap_qty number(38,3),
  inline_goods_qty number(38,3),
  inventory_scrap_qty number(38,3),
  resale_qty number(38,3),
  inventory_profit_qty number(38,3),
  inventory_losses_qty number(38,3),
  scrap_inventory_qty number(38,3),
  destroy_qty number(38,3),
  insert_time date
);

create index idx_histmon on t_material_inventory(histmon);

create sequence T_GR_RE_MOVEMENT_DATA_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;

create table T_GR_RE_MOVEMENT_DATA
(
  id                     NUMBER not null,
  po_certificate_no      VARCHAR2(10),
  po_certificate_item_no VARCHAR2(5),
  certificate_year       VARCHAR2(4),
  certificate_no         VARCHAR2(10),
  certificate_item       VARCHAR2(4),
  movement_type          VARCHAR2(10),
  qty                    NUMBER(13,3),
  post_date              VARCHAR2(10),
  factory   varchar2(4),
  material_code varchar2(40)
);

CREATE TABLE t_release_his
(
  id NUMBER NOT NULL,
  import_id NUMBER NOT NULL,
  ir_no varchar2(100) NOT NULL,
  action integer NOT NULL,    
  add_time DATE DEFAULT SYSDATE NOT NULL,
  add_user varchar2(100) DEFAULT '',
  del_flag integer DEFAULT 0,
  constraint PK_t_release_his primary key (id)
);

create index idx_release_his on t_release_his(import_id);

create sequence T_RELEASE_HIS_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;
  
  
  CREATE TABLE t_business_his
(
  id NUMBER NOT NULL,
  business_id varchar2(100) NOT NULL,
  business_no varchar2(100) DEFAULT '',
  business_type integer NOT NULL, 
  action integer NOT NULL,    
  add_time DATE DEFAULT SYSDATE NOT NULL,
  add_user varchar2(100) DEFAULT '',
  content varchar2(4000) DEFAULT '',
  constraint PK_t_business_his primary key (id)
);

create index idx_business_his on t_business_his(business_id);

create sequence T_BUSINESS_HIS_SEQ
  INCREMENT BY 1 
  START WITH 1 
  NOMAXvalue 
  NOCYCLE 
  NOCACHE;
