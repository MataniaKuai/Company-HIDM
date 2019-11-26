CREATE DATABASE importexport DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) DEFAULT NULL COMMENT '权限ID',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `dept`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `ename` varchar(500) NOT NULL,
  `usual_sort` int NOT NULL,
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `usual_system` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `url` varchar(500) NOT NULL DEFAULT '',
  `center` int NOT NULL,
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `usual_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `url` varchar(500) NOT NULL DEFAULT '',
  `center` int NOT NULL,
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `t_material` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `material_no` varchar(100) NOT NULL,
  `goods_code` varchar(100) NOT NULL DEFAULT '',
  `hi_tech` int(1) NOT NULL DEFAULT 0,
  `custom_office` varchar(10) NOT NULL DEFAULT '',
  `unit` varchar(10) NOT NULL DEFAULT '',
  `bond_cla1` varchar(10) NOT NULL DEFAULT '',
  `bond_cla2` varchar(10) NOT NULL DEFAULT '',
  `hs_code` varchar(100) NOT NULL DEFAULT '',
  `currency` varchar(10) NOT NULL DEFAULT '',
  `goods_desc` varchar(500) NOT NULL DEFAULT '',
  `chinese_name` varchar(500) NOT NULL DEFAULT '',
  `tax_preperty` varchar(10) NOT NULL DEFAULT '',
  `free_no` varchar(10) NOT NULL DEFAULT '',
  `iterm` varchar(500) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_asset` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `asset_no` varchar(100) NOT NULL,
  `goods_code` varchar(100) NOT NULL DEFAULT '',
  `hi_tech` int(1) NOT NULL DEFAULT 0,
  `custom_office` varchar(10) NOT NULL DEFAULT '',
  `unit` varchar(10) NOT NULL DEFAULT '',
  `bond_cla1` varchar(10) NOT NULL DEFAULT '',
  `bond_cla2` varchar(10) NOT NULL DEFAULT '',
  `hs_code` varchar(100) NOT NULL DEFAULT '',
  `currency` varchar(10) NOT NULL DEFAULT '',
  `goods_desc` varchar(500) NOT NULL DEFAULT '',
  `chinese_name` varchar(500) NOT NULL DEFAULT '',
  `tax_preperty` varchar(10) NOT NULL DEFAULT '',
  `free_no` varchar(10) NOT NULL DEFAULT '',
  `iterm` varchar(500) NOT NULL DEFAULT '',
  `text_1` varchar(500) NOT NULL DEFAULT '',
  `text_2` varchar(500) NOT NULL DEFAULT '',
  `text_3` varchar(500) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_goods_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_custom_office` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_currency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_tax_preperty` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_bond_cla1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_bond_cla2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_free_no` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;