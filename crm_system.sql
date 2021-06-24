/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : crm_system

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 24/06/2021 22:05:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achievement
-- ----------------------------
DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `server_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `performance` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for complain
-- ----------------------------
DROP TABLE IF EXISTS `complain`;
CREATE TABLE `complain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '匿名',
  `context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `complained_id` int(11) NULL DEFAULT NULL,
  `core` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of complain
-- ----------------------------
INSERT INTO `complain` VALUES (1, '匿名', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `part_a` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `part_b` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `server_id` int(11) NULL DEFAULT NULL,
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `finish_time` datetime(0) NULL DEFAULT NULL,
  `server_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` int(255) NULL DEFAULT NULL,
  `pay_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contract_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dairy
-- ----------------------------
DROP TABLE IF EXISTS `dairy`;
CREATE TABLE `dairy`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diary_date` datetime(0) NULL DEFAULT NULL,
  `communicate_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `communicate_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hire_date` datetime(0) NULL DEFAULT NULL,
  `state` int(255) NULL DEFAULT NULL,
  `admin` int(255) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 'whh', '123456', NULL, 22, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `employee` VALUES (2, 'lhp', '131400', NULL, 23, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `employee` VALUES (3, 'EWRTRERrrr', 'FEERRr', '1452588824@qq.com', NULL, NULL, '2021-06-24 19:30:27', NULL, NULL, 2);
INSERT INTO `employee` VALUES (4, 'EWRTRERuuu', 'FEERRr', '1452588824@qq.com', NULL, NULL, '2021-06-24 19:33:11', NULL, NULL, 2);
INSERT INTO `employee` VALUES (5, 'EWR', 'FEERRr', '1452588824@qq.com', NULL, NULL, '2021-06-24 19:38:19', NULL, NULL, 2);
INSERT INTO `employee` VALUES (6, 'EWRee', 'FEERRr', '1452588824@qq.com', NULL, NULL, '2021-06-24 19:41:18', NULL, NULL, 2);
INSERT INTO `employee` VALUES (7, 'wwhw', '22222', '1452588824@qq.com', NULL, NULL, '2021-06-24 19:46:11', NULL, NULL, 1);

-- ----------------------------
-- Table structure for judge
-- ----------------------------
DROP TABLE IF EXISTS `judge`;
CREATE TABLE `judge`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `proportion` double(10, 2) NULL DEFAULT NULL,
  `score` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of judge
-- ----------------------------
INSERT INTO `judge` VALUES (1, '工作能力', 0.40, NULL);
INSERT INTO `judge` VALUES (2, '工作态度', 0.20, NULL);
INSERT INTO `judge` VALUES (3, '环境行为', 0.10, NULL);
INSERT INTO `judge` VALUES (4, '纪律', 0.20, NULL);
INSERT INTO `judge` VALUES (5, '扣分项', 0.10, NULL);

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `server_id` int(11) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `diary_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '客户');
INSERT INTO `role` VALUES (2, '员工');
INSERT INTO `role` VALUES (3, '经理');

-- ----------------------------
-- Table structure for trace
-- ----------------------------
DROP TABLE IF EXISTS `trace`;
CREATE TABLE `trace`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trace_time` datetime(0) NULL DEFAULT NULL,
  `trace_details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `trace_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trace_result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_id` int(11) NULL DEFAULT NULL,
  `process_status` double(255, 0) NULL DEFAULT NULL,
  `input_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `process_day` int(255) NULL DEFAULT NULL,
  `praise` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `customer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trans_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trans_time` datetime(0) NULL DEFAULT NULL,
  `old_seller` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `new_seller` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trans_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `gender` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `age` int(11) NULL DEFAULT NULL,
  `tel` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `seller` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `input_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区',
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户来源',
  `input_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '5个状态',
  `positive_time` datetime(0) NULL DEFAULT NULL COMMENT '最终提交时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'luguo', 'nv', '1452588824@qq.com', NULL, 'ddd', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, 'ssdsds33', 'weew', '1452588824@qq.com', NULL, 'tetre', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, 'ssdsds33', 'e', '1452588824@qq.com', NULL, 'te', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (4, 'ssdsds33', 'e', '1452588824@qq.com', NULL, 'te', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, 'eer', 'wer', 'ew', NULL, 'wr', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, 'we', 'err', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (7, 'www', '女', '1452588824@qq.com', 22, '17876656571', '', '', '华东', '你猜', '别人介绍', '2021-06-24 11:51:56', '', '2021-06-24 11:51:56');
INSERT INTO `user` VALUES (8, 'luguo', '男', '1452588824@qq.com', 23, '17876656571', '', '', '华东', '你猜', '别人介绍', '2021-06-24 12:13:44', '', '2021-06-24 12:13:44');
INSERT INTO `user` VALUES (9, 'luguoww', '女', '1452588824@qq.com', 29, '17876656571', '', '', '华东', '你猜', '别人介绍', '2021-06-24 13:19:44', '', '2021-06-24 13:19:44');
INSERT INTO `user` VALUES (10, 'lug', '女', '1452588824@qq.com', 29, '17876656571', '', '', '华东', '你猜', '别人介绍', '2021-06-24 16:25:04', '', '2021-06-24 16:25:04');
INSERT INTO `user` VALUES (11, 'lugERT', '女', '1452588824@qq.com', 29, '17876656571', '', '', '华东', '你猜', '别人介绍', '2021-06-24 16:26:13', '', '2021-06-24 16:26:13');

SET FOREIGN_KEY_CHECKS = 1;
