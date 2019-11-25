
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

