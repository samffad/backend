/*
Navicat MySQL Data Transfer

Source Server         : 172.16.6.57线上sms
Source Server Version : 50622
Source Host           : 172.16.6.57:3306
Source Database       : sm

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-01-19 17:30:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `org_permission`
-- ----------------------------
DROP TABLE IF EXISTS `org_permission`;
CREATE TABLE `org_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(64) DEFAULT NULL,
  `user_role` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  `oper_code` varchar(64) DEFAULT NULL,
  `oper_date` datetime DEFAULT NULL,
  `org_name` varchar(256) DEFAULT NULL,
  `org_code` varchar(64) DEFAULT NULL,
  `org_short_name` varchar(256) DEFAULT NULL,
  `whole_org_id` varchar(256) DEFAULT NULL,
  `whole_org_name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of org_permission
-- ----------------------------
INSERT INTO `org_permission` VALUES ('1', '20091589', '31', '388', 'test', '2015-01-01 11:59:26', '运营.京南区.京南运营.朝东区.柏林爱乐南门店', 'A13718', '柏林爱乐南门店', '/1/1010/103/854/19833/846/388', '/链家集团/北京链家/运营/京南区/京南运营/朝东区/柏林爱乐南门店');
INSERT INTO `org_permission` VALUES ('2', '20091589', '31', '1470', 'test', '2015-01-16 12:00:41', '运营.京北区.京北运营.望京大区.新澳洲康都店', 'A131009', '新澳洲康都店', '/1/1010/103/853/19834/13563/1470', '/链家集团/北京链家/运营/京北区/京北运营/望京大区/新澳洲康都店');
INSERT INTO `org_permission` VALUES ('3', '20096490', '31', '388', null, null, null, null, null, null, null);
INSERT INTO `org_permission` VALUES ('4', '20096490', '31', '1470', null, null, null, null, null, null, null);
