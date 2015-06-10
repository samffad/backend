CREATE TABLE `snap_org` (
  `org_type` enum('2','5','6','7','8') DEFAULT NULL COMMENT '组织类型：2分公司；5大区；6区；7店；8组',
  `org_id` int(11) DEFAULT NULL COMMENT 'se组织ID',
  `org_name` varchar(64) DEFAULT NULL,
  `org_code` varchar(64) DEFAULT NULL,
  `office_address` varchar(64) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL COMMENT '公司id',
  `region_id` int(11) DEFAULT NULL COMMENT '大区id',
  `area_id` int(11) DEFAULT NULL COMMENT '区id',
  `store_id` int(11) DEFAULT NULL COMMENT '店ID',
  `year_month_snap` int(11) DEFAULT NULL COMMENT '快照年月：201502',
  `last_update_time` datetime DEFAULT NULL COMMENT 'se中最后更新时间',
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

