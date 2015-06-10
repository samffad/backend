CREATE TABLE `snap_user` (
  `user_id` int(11) DEFAULT NULL COMMENT 'ts-user表id',
  `user_code` varchar(64) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `user_desc` varchar(64) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL COMMENT '职位，如785综合经纪人...',
  `org_id` int(11) DEFAULT NULL COMMENT '组织id',
  `status` int(11) DEFAULT NULL,
  `year_month_snap` int(11) DEFAULT NULL COMMENT '快照年月：201502',
  `last_update_time` datetime DEFAULT NULL COMMENT 'se中最后更新时间',
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
