/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : hand_demo

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-11-29 18:21:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee_info
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info` (
  `EMP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMP_CODE` varchar(25) NOT NULL,
  `EMP_NAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `SEX` varchar(2) DEFAULT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  `UNIT_ID` int(11) DEFAULT NULL,
  `EMP_JOB` varchar(50) DEFAULT NULL,
  `SALARY` varchar(50) DEFAULT NULL,
  `CREATION_DATE` datetime NOT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`EMP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employee_info
-- ----------------------------
INSERT INTO `employee_info` VALUES ('1', '23234', '张三1', '123456', '1', '2019-11-13', '1', '技术顾问', '5000', '2019-10-31 16:00:00', '2019-11-29 08:29:36');
INSERT INTO `employee_info` VALUES ('2', '12342', '李四', '123456', '1', '2019-11-02', '2', '人事', '3000', '2019-11-05 13:08:38', '2019-11-15 13:08:41');
INSERT INTO `employee_info` VALUES ('3', '12343', '王五', '123456', '1', '2019-11-03', '3', '总经理', '7000', '2019-11-16 19:49:20', '2019-11-16 19:49:24');
INSERT INTO `employee_info` VALUES ('4', '34567', '孙六', '123456', '0', '2019-11-01', '3', '助理', '5000', '2019-11-05 19:51:10', '2019-11-16 19:51:14');
INSERT INTO `employee_info` VALUES ('5', '34123', '钱无', '123456', '0', '2019-11-02', '3', '技术开发', '3000', '2019-11-03 19:54:40', '2019-11-16 19:54:46');
INSERT INTO `employee_info` VALUES ('6', '45678', 'gh', '123456', '1', '2019-11-01', '1', 'kafu', '3000', '2019-11-29 07:41:27', '2019-11-29 07:41:27');
INSERT INTO `employee_info` VALUES ('7', '45676', 'fhjk', '123456', '1', '2019-11-09', '2', 'dgh', '4600', '2019-11-29 07:42:24', '2019-11-29 07:42:24');

-- ----------------------------
-- Table structure for unit_info
-- ----------------------------
DROP TABLE IF EXISTS `unit_info`;
CREATE TABLE `unit_info` (
  `UNIT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `UNIT_NAME` varchar(50) NOT NULL,
  `ENABLED_FLAG` varchar(2) NOT NULL,
  `CREATION_DATE` datetime NOT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`UNIT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of unit_info
-- ----------------------------
INSERT INTO `unit_info` VALUES ('1', '技术部', '1', '2019-11-02 10:51:55', '2019-11-10 10:51:59');
INSERT INTO `unit_info` VALUES ('2', '人事部', '1', '2019-11-13 13:06:26', '2019-11-27 13:06:29');
INSERT INTO `unit_info` VALUES ('3', '管理部', '1', '2019-11-16 13:07:00', '2019-11-23 13:07:05');
INSERT INTO `unit_info` VALUES ('4', '人事部1', '0', '2019-11-29 08:06:02', '2019-11-29 09:15:38');
INSERT INTO `unit_info` VALUES ('5', 'hgh', '0', '2019-11-29 09:16:12', '2019-11-29 10:21:13');
