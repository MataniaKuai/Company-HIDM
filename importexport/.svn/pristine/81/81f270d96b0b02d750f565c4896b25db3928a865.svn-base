INSERT INTO `dept` (`id`, `name`, `ename`, `usual_sort`, `update_time`, `add_time`, `update_user`, `del_flag`) VALUES
(1, '总经理办公室', 'CEO', 5, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0),
(5, '产品', 'PDT', 8, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0),
(6, '质量管理', 'QM', 2, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0),
(9, '财务', 'CFA', 3, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0),
(14, '人力资源', 'HRC', 1, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0),
(22, '第一事业部', 'BU1', 9, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0),
(36, '第二事业部', 'BU2', 10, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0),
(68, '战略企划发展', 'SPD', 4, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0),
(89, '淮安厂区', 'FAB', 6, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0),
(182, '研发', 'TD', 7, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0),
(196, '淮安元源', 'HYY', 11, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0),
(205, '董事长办公室', 'CHO', 12, '2018-08-22 07:00:03', '2018-08-22 07:00:03', '', 0);

--
-- 转存表中的数据 `t_goods_code`
--

INSERT INTO `t_goods_code` (`id`, `code`, `name`, `update_time`, `add_time`, `update_user`, `add_user`, `del_flag`) VALUES
(1, 'H11001001', 'PLCC', '2018-08-22 07:22:26', '2018-08-22 07:22:26', '', '', 0),
(2, 'H11001002', 'Camera Module', '2018-08-22 07:22:26', '2018-08-22 07:22:26', '', '', 0);

--
-- 转存表中的数据 `t_custom_office`
--

INSERT INTO `t_custom_office` (`id`, `code`, `name`) VALUES
(1, '100', '北京关区'),
(2, '101', '机场单证');


--
-- 转存表中的数据 `t_currency`
--

INSERT INTO `t_currency` (`id`, `code`, `name`) VALUES
(1, 'USD', 'USD'),
(2, 'JPY', 'JPY');


--
-- 转存表中的数据 `t_tax_preperty`
--

INSERT INTO `t_tax_preperty` (`id`, `code`, `name`) VALUES
(1, '101', '一般征税'),
(2, '118', '整车征税');


--
-- 转存表中的数据 `t_bond_cla1`
--

INSERT INTO `t_bond_cla1` (`id`, `code`, `name`) VALUES
(1, 'B', 'B'),
(2, 'N', 'N');


--
-- 转存表中的数据 `t_bond_cla2`
--

INSERT INTO `t_bond_cla2` (`id`, `code`, `name`) VALUES
(1, 'C', 'C'),
(2, 'T', 'T');


--
-- 转存表中的数据 `t_free_no`
--

INSERT INTO `t_free_no` (`id`, `code`, `name`) VALUES
(1, '1', '财关税【2015】46号'),
(2, '2', '署税发【2002】329号');


--
-- 转存表中的数据 `t_permission`
--

INSERT INTO `t_permission` (`id`, `url`, `name`, `update_time`, `add_time`, `add_user`, `update_user`, `del_flag`) VALUES
(1, '/importexport/materia/manage', '原材料维护', '2018-08-22 08:31:31', '2018-07-24 00:40:49', '', '', 0);

--
-- 转存表中的数据 `t_role`
--

INSERT INTO `t_role` (`id`, `name`, `update_time`, `add_time`, `add_user`, `update_user`, `del_flag`) VALUES
(1, 'import', '2018-08-22 08:30:46', '2018-07-24 00:05:51', '', '', 0),
(2, 'storage', '2018-08-22 08:31:04', '2018-07-24 00:05:51', '', '', 0);

--
-- 转存表中的数据 `t_role_permission`
--

INSERT INTO `t_role_permission` (`id`, `rid`, `pid`, `update_time`, `add_time`, `add_user`, `update_user`, `del_flag`) VALUES
(1, 1, 1, '2018-08-22 08:37:54', '2018-08-22 08:37:54', '', '', 0);

--
-- 转存表中的数据 `t_user`
--

INSERT INTO `t_user` (`id`, `user_name`, `password`, `update_time`, `add_time`, `add_user`, `update_user`, `del_flag`) VALUES
(1, 'admin', '123456', '2018-08-22 08:32:57', '2018-07-24 00:06:19', '', '', 0),
(2, 'importer', '123456', '2018-08-22 08:33:16', '2018-07-24 00:36:58', '', '', 0),
(3, 'storager', '123456', '2018-08-22 08:33:30', '2018-07-24 00:44:51', '', '', 0);

--
-- 转存表中的数据 `t_user_role`
--

INSERT INTO `t_user_role` (`id`, `userid`, `rid`, `update_time`, `add_time`, `add_user`, `update_user`, `del_flag`) VALUES
(1, 2, 1, '2018-08-22 08:37:18', '2018-08-22 08:37:18', '', '', 0),
(2, 3, 2, '2018-08-22 08:37:18', '2018-08-22 08:37:18', '', '', 0),
(3, 1, 1, '2018-08-22 08:38:29', '2018-08-22 08:38:29', '', '', 0),
(4, 1, 2, '2018-08-22 08:38:29', '2018-08-22 08:38:29', '', '', 0);
