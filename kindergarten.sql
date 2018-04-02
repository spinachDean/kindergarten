/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : kindergarten

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-04-02 11:32:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `uri` varchar(100) NOT NULL,
  `menuID` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(11) NOT NULL,
  `INSDATE` date DEFAULT NULL COMMENT '新增年月日',
  `INSUSERID` varchar(10) DEFAULT NULL COMMENT '更新年月日',
  `UPDATET` date DEFAULT NULL COMMENT '更新年月日',
  `UPUSERID` varchar(10) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`menuID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('/*', '1', '所有页面', null, null, null, null);
INSERT INTO `t_menu` VALUES ('/children/*', '2', '儿童管理', null, null, null, null);
INSERT INTO `t_menu` VALUES ('/admin/info', '3', '信息管理页', null, null, null, null);

-- ----------------------------
-- Table structure for `t_menu_list`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_list`;
CREATE TABLE `t_menu_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent` int(11) DEFAULT '-1',
  `name` varchar(50) NOT NULL,
  `url` varchar(50) DEFAULT '/',
  `icon` varchar(10) NOT NULL DEFAULT '&#xe616;',
  `roles` varchar(50) NOT NULL,
  `index` int(10) NOT NULL DEFAULT '0',
  `INSDATE` date DEFAULT NULL COMMENT '新增年月日',
  `INSUSERID` varchar(10) DEFAULT NULL COMMENT '更新年月日',
  `UPDATET` date DEFAULT NULL COMMENT '更新年月日',
  `UPUSERID` varchar(10) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu_list
-- ----------------------------
INSERT INTO `t_menu_list` VALUES ('1', '-1', '幼儿园管理', '/', '&#xe643;', '1,2', '0', null, null, null, null);
INSERT INTO `t_menu_list` VALUES ('2', '1', '基本信息', 'login.html', '&#xe616;', '2', '1', null, null, null, null);
INSERT INTO `t_menu_list` VALUES ('3', '-1', '班级管理', '/', '&#xe62b;', '1,2', '1', null, null, null, null);
INSERT INTO `t_menu_list` VALUES ('4', '3', '基本信息', 'index.html', '&#xe616;', '1', '0', null, null, null, null);
INSERT INTO `t_menu_list` VALUES ('5', '-1', '权限管理', '/', '&#xe616;', '1', '2', null, null, null, null);
INSERT INTO `t_menu_list` VALUES ('6', '5', '角色管理', 'admin/admin-role.jsp', '&#xe616;', '1', '0', null, null, null, null);
INSERT INTO `t_menu_list` VALUES ('7', '5', '访问管理', 'admin/admin-permission.jsp', '&#xe616;', '', '1', null, null, null, null);

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `roleID` int(11) NOT NULL,
  `roleName` varchar(20) NOT NULL,
  `INSDATE` date DEFAULT NULL COMMENT '新增年月日',
  `INSUSERID` varchar(10) DEFAULT NULL COMMENT '更新年月日',
  `UPDATET` date DEFAULT NULL COMMENT '更新年月日',
  `UPUSERID` varchar(10) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '系统管理员', null, null, null, null);
INSERT INTO `t_role` VALUES ('2', '院长', null, null, null, null);
INSERT INTO `t_role` VALUES ('3', '老师', null, null, null, null);
INSERT INTO `t_role` VALUES ('4', '家长', null, null, null, null);

-- ----------------------------
-- Table structure for `t_rolemenu`
-- ----------------------------
DROP TABLE IF EXISTS `t_rolemenu`;
CREATE TABLE `t_rolemenu` (
  `roleID` int(11) NOT NULL,
  `menuID` int(11) NOT NULL,
  `INSDATE` date DEFAULT NULL COMMENT '新增年月日',
  `INSUSERID` varchar(10) DEFAULT NULL COMMENT '更新年月日',
  `UPDATET` date DEFAULT NULL COMMENT '更新年月日',
  `UPUSERID` varchar(10) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`roleID`,`menuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_rolemenu
-- ----------------------------
INSERT INTO `t_rolemenu` VALUES ('1', '1', null, null, null, null);
INSERT INTO `t_rolemenu` VALUES ('1', '2', null, null, null, null);
INSERT INTO `t_rolemenu` VALUES ('1', '3', null, null, null, null);
INSERT INTO `t_rolemenu` VALUES ('4', '2', null, null, null, null);

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `username` varchar(40) NOT NULL,
  `password` varchar(32) NOT NULL,
  `roleID` int(11) NOT NULL,
  `logintime` timestamp(6) NULL DEFAULT NULL,
  `updatetime` timestamp(6) NULL DEFAULT NULL,
  `INSDATE` date DEFAULT NULL COMMENT '新增年月日',
  `INSUSERID` varchar(10) DEFAULT NULL COMMENT '更新年月日',
  `UPDATET` date DEFAULT NULL COMMENT '更新年月日',
  `UPUSERID` varchar(10) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`username`),
  KEY `userrole` (`roleID`),
  CONSTRAINT `userrole` FOREIGN KEY (`roleID`) REFERENCES `t_role` (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('admin', '21232F297A57A5A743894A0E4A801FC3', '1', '2018-03-23 16:35:04.000000', '0000-00-00 00:00:00.000000', null, null, null, null);
INSERT INTO `t_user` VALUES ('test', '21232F297A57A5A743894A0E4A801FC3', '2', '2018-03-22 16:35:10.000000', '2018-03-15 16:35:12.000000', null, null, null, null);
