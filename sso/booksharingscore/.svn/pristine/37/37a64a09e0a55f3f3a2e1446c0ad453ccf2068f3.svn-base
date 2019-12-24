CREATE DATABASE booksharingscore DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employeeno` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL,
  `del_flag` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;


CREATE TABLE `t_score` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `courseid` bigint(20) DEFAULT NULL COMMENT '课程ID',
  `score` varchar(256) DEFAULT NULL COMMENT '个人评分',
  `comment` varchar(1000) DEFAULT NULL COMMENT '个人评论',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL,
  `del_flag` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(1000) DEFAULT NULL COMMENT '主题',
  `phase` varchar(1000) DEFAULT NULL COMMENT '期数',
  `week` varchar(1000) DEFAULT NULL COMMENT '周数',
  `coursestartdate` varchar(100) DEFAULT NULL COMMENT '开始日期',
  `courseenddate` varchar(100) DEFAULT NULL COMMENT '结束日期',
  `duration` varchar(100) DEFAULT NULL COMMENT '时长',
  `address` varchar(1000) DEFAULT NULL COMMENT '地址',
  `lecturername` varchar(256) DEFAULT NULL COMMENT '讲师姓名',
  `lecturerno` varchar(256) DEFAULT NULL COMMENT '讲师工号',
  `filename` varchar(1000) DEFAULT NULL COMMENT '文件名',
  `filepath` varchar(1000) DEFAULT NULL COMMENT '文件路径',
  `status` int(10) NOT NULL DEFAULT 0,
  `score` varchar(100) DEFAULT NULL COMMENT '评分',
  `comments` text DEFAULT NULL COMMENT '评论',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `add_time` timestamp NOT NULL,
  `add_user` varchar(100) NOT NULL DEFAULT '',
  `update_user` varchar(100) NOT NULL DEFAULT '',
  `del_flag` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;