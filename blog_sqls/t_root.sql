/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50162
Source Host           : 127.0.0.1:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2016-10-19 16:04:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_root`
-- ----------------------------
DROP TABLE IF EXISTS `t_root`;
CREATE TABLE `t_root` (
  `root` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `tips` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`root`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_root
-- ----------------------------
INSERT INTO `t_root` VALUES ('root', 'root', '159********', 'nothing tips');
