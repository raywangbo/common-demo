/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : common1

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-01-10 20:19:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '姓名',
  `account` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '账号',
  `password` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '密码',
  `salt` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '盐',
  `locked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'qqjbest', 'qqj', 'd11c387b16fdd06d872da731d6e031bf', 'ca9b04badd4856cad4e2c3b7be5e19c0', '0');

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `admin_id` int(11) NOT NULL DEFAULT '0' COMMENT '管理员ID',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色ID',
  PRIMARY KEY (`admin_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `remark` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '用户管理', '用户管理', '1', '2017-10-12 09:26:48', '2017-10-13 10:12:54');
INSERT INTO `role` VALUES ('2', '同学说员', '同学说管理', '0', '2017-10-13 10:09:31', '2017-10-13 10:09:33');

-- ----------------------------
-- Table structure for role_strategy
-- ----------------------------
DROP TABLE IF EXISTS `role_strategy`;
CREATE TABLE `role_strategy` (
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色ID',
  `strategy_id` int(11) NOT NULL DEFAULT '0' COMMENT '策略ID',
  PRIMARY KEY (`role_id`,`strategy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role_strategy
-- ----------------------------
INSERT INTO `role_strategy` VALUES ('1', '1');
INSERT INTO `role_strategy` VALUES ('1', '2');
INSERT INTO `role_strategy` VALUES ('1', '3');
INSERT INTO `role_strategy` VALUES ('1', '4');

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `remark` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `permission` tinyint(4) DEFAULT NULL COMMENT '权限',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of strategy
-- ----------------------------
INSERT INTO `strategy` VALUES ('1', 'admin', '用户管理', '11', '1', '0', '2017-10-12 09:30:32', '2017-10-12 10:08:37');
INSERT INTO `strategy` VALUES ('2', 'generator', '代码生成管理', '10', '1', '0', '2017-10-12 17:20:54', '2017-10-13 10:21:05');
INSERT INTO `strategy` VALUES ('3', 'dynamic', '同学说管理', '1', '1', '0', '2017-10-13 10:10:01', '2017-10-13 10:10:03');
INSERT INTO `strategy` VALUES ('4', 'charts', '图表管理', '11', '1', '0', '2017-10-13 16:02:16', '2017-10-13 16:02:56');
