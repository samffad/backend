CREATE TABLE `battle_team_leader` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `leader_code` varchar(50) NOT NULL COMMENT '组长id',
  `leader_name` varchar(20) DEFAULT NULL COMMENT '组长姓名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator_code` varchar(50) DEFAULT NULL COMMENT '创建id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '元组状态，0-正常，1-已删除',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `updater_code` varchar(50) DEFAULT NULL COMMENT '最后更新id',
  `org_code` varchar(50) NOT NULL COMMENT '商圈组id',
  `office_address` varchar(10) DEFAULT NULL COMMENT '城市id',
  `comp_id` int(11) DEFAULT NULL COMMENT '分公司id',
  PRIMARY KEY (`id`),
  KEY `org_code` (`org_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `battle_team_relation` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
  `member_code` varchar(50) NOT NULL COMMENT '组员经纪人id',
  `member_name` varchar(20) DEFAULT NULL COMMENT '组员姓名',
  `leader_code` varchar(50) NOT NULL COMMENT '组长id',
  `leader_name` varchar(20) DEFAULT NULL COMMENT '组长姓名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `creator_code` varchar(50) DEFAULT NULL COMMENT '创建者id',
  `org_code` varchar(50) NOT NULL COMMENT '商圈组id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '元组状态，0-正常，1-已被删除',
  `update_time` datetime DEFAULT NULL,
  `updater_code` varchar(50) DEFAULT NULL,
  `office_address` varchar(10) DEFAULT NULL COMMENT '公司城市代码',
  `comp_id` int(11) DEFAULT NULL COMMENT '分公司id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `member_leader_unique` (`member_code`,`leader_code`) USING BTREE,
  KEY `leader_index` (`leader_code`) USING BTREE,
  KEY `orgcode_index` (`org_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `battle_team_relation_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键id',
  `member_code` varchar(50) DEFAULT NULL COMMENT '组员经纪人id',
  `member_name` varchar(20) DEFAULT NULL COMMENT '组员姓名',
  `origin_leader_code` varchar(50) DEFAULT NULL COMMENT '老的组长id',
  `new_leader_code` varchar(50) DEFAULT NULL COMMENT '新的组长id',
  `org_code` varchar(50) DEFAULT NULL COMMENT '商圈组id',
  `op_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '变更操作时间',
  `oper_code` varchar(50) DEFAULT NULL COMMENT '变更操作执行者id',
  `reason` varchar(200) DEFAULT NULL COMMENT '备注变更原因',
  `office_address` varchar(10) DEFAULT NULL COMMENT '城市id',
  `comp_id` int(11) DEFAULT NULL COMMENT '分公司id',
  PRIMARY KEY (`id`),
  KEY `op_time` (`op_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

