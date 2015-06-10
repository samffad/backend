/*
Navicat MySQL Data Transfer

Source Server         : 172.16.6.57线上sms
Source Server Version : 50622
Source Host           : 172.16.6.57:3306
Source Database       : sm

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-01-19 17:30:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `authority`
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissions` varchar(200) NOT NULL COMMENT '权限组合，参考PermissionEnum',
  `access_url` varchar(200) NOT NULL COMMENT '授权的地址',
  `vaild_time` datetime DEFAULT NULL COMMENT '生效时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('12', '10,20,30', '/managerDetail/liststoredetail.json', '2014-12-28 17:33:34', '2014-12-28 17:33:42', '2014-12-28 17:33:45');
INSERT INTO `authority` VALUES ('13', '10,20,30', '/managerDetail/downloadexcel.json', '2015-01-07 12:11:40', '2015-01-07 12:11:43', '2015-01-07 12:11:46');
INSERT INTO `authority` VALUES ('14', '10,20,30', '/brokerDetail/listbrokerdetail.json', '2015-01-07 12:12:03', '2015-01-07 12:12:07', '2015-01-07 12:12:10');
INSERT INTO `authority` VALUES ('15', '10,20,30', '/brokerDetail/downloadexcel.json', '2015-01-07 12:12:37', '2015-01-07 12:12:41', '2015-01-07 12:12:45');
INSERT INTO `authority` VALUES ('16', '10,20,30', '/userinfo/indexdata.json', '2015-01-07 12:13:19', '2015-01-07 12:13:22', '2015-01-07 12:13:25');
INSERT INTO `authority` VALUES ('17', '0', '/userinfo/index.json', '2015-01-07 12:14:26', '2015-01-07 12:14:29', '2015-01-07 12:14:31');
INSERT INTO `authority` VALUES ('18', '40', '/typecost/upload.json', '2015-01-07 13:57:40', '2015-01-07 13:57:44', '2015-01-07 13:57:47');
INSERT INTO `authority` VALUES ('19', '10,20,30', '/mentor/addRelation.json', '2015-01-07 14:01:04', '2015-01-07 14:01:06', '2015-01-07 14:01:09');
INSERT INTO `authority` VALUES ('20', '10,20,30', '/mentor/modifyRelation.json', '2015-01-07 14:01:24', '2015-01-07 14:01:26', '2015-01-07 14:01:28');
INSERT INTO `authority` VALUES ('21', '10,20,30', '/mentor/deleteRelation.json', '2015-01-07 14:01:45', '2015-01-07 14:01:48', '2015-01-07 14:01:51');
INSERT INTO `authority` VALUES ('22', '10,20,30', '/mentor/getAllBrokers.json', '2015-01-07 14:02:22', '2015-01-07 14:02:24', '2015-01-07 14:02:27');
