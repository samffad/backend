/*
Navicat MySQL Data Transfer

Source Server         : 172.16.6.57线上sms
Source Server Version : 50622
Source Host           : 172.16.6.57:3306
Source Database       : sm

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-01-19 17:30:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_roles`
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_short` varchar(64) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `user_code` varchar(64) DEFAULT NULL,
  `roles` varchar(64) DEFAULT NULL,
  `roles_addition` varchar(64) DEFAULT NULL,
  `oper_code` varchar(64) DEFAULT NULL,
  `oper_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES ('1', '135029', 'liuyc47', '刘月超', '20091589', '0,21,31', 'test', 'init', '2015-01-16 10:50:33');
INSERT INTO `user_roles` VALUES ('2', '135029', 'wangll80', '王露露', '20096490', '0,21,31', '北京,1010', null, null);
INSERT INTO `user_roles` VALUES ('3', null, 'yanr4', null, null, '21', '北京,1010', null, null);
INSERT INTO `user_roles` VALUES ('4', null, 'zhangq249', null, null, '21', '北京,1010', null, null);
