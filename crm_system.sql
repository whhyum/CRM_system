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

 Date: 28/06/2021 10:02:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for complain
-- ----------------------------
DROP TABLE IF EXISTS `complain`;
CREATE TABLE `complain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '匿名',
  `context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `input_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `core` int(255) NULL DEFAULT 0,
  `complain_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of complain
-- ----------------------------
INSERT INTO `complain` VALUES (1, '匿名', '他服务他态度太差了', 'employee2', -1, '2021-06-28');
INSERT INTO `complain` VALUES (2, '匿名', '他服务他态度太差了', 'employee3', -2, '2021-06-22');
INSERT INTO `complain` VALUES (3, '匿名', '他服务他态度太差了', 'whh', -3, '2021-06-22');
INSERT INTO `complain` VALUES (4, '匿名', '他服务他态度太差了', 'lhp', -2, '2021-06-02');
INSERT INTO `complain` VALUES (5, '匿名', '他服务他态度太差了', 'lyq', -1, '2021-06-17');
INSERT INTO `complain` VALUES (6, '匿名', '他服务他态度太差了', 'employee12', -3, '2021-06-27');
INSERT INTO `complain` VALUES (7, '匿名', '他服务他态度太差了', 'employee19', -3, '2021-06-27');
INSERT INTO `complain` VALUES (8, '匿名', '他服务他态度太差了', 'employee3', -2, '2021-06-28');
INSERT INTO `complain` VALUES (9, '匿名', '他服务他态度太差了', 'employee10', -2, '2021-06-28');
INSERT INTO `complain` VALUES (10, '匿名', '他服务他态度太差了', 'employee11', -1, '2021-06-16');
INSERT INTO `complain` VALUES (11, '匿名', '他服务他态度太差了', 'employee18', 0, '2021-06-29');
INSERT INTO `complain` VALUES (12, '匿名', '他服务他态度太差了', 'employee119', -2, '2021-06-15');
INSERT INTO `complain` VALUES (13, '匿名', '他服务他态度太差了', 'employee20', 0, '2021-06-29');
INSERT INTO `complain` VALUES (14, '匿名', '他服务他态度太差了', 'employee23', -2, '2021-06-24');
INSERT INTO `complain` VALUES (15, '匿名', '他服务他态度太差了', 'employee11', 0, '2021-06-25');
INSERT INTO `complain` VALUES (16, '匿名', '他服务他态度太差了', 'employee9', -1, '2021-06-30');
INSERT INTO `complain` VALUES (17, '匿名', '他服务他态度太差了', 'employee3', -2, '2021-06-29');
INSERT INTO `complain` VALUES (18, '匿名', '他服务他态度太差了', 'employee11', 0, '2021-06-20');
INSERT INTO `complain` VALUES (19, '匿名', '他服务他态度太差了', 'employee5', 0, '2021-06-18');
INSERT INTO `complain` VALUES (20, '匿名', '他服务他态度太差了', 'employee19', -3, '2021-06-24');
INSERT INTO `complain` VALUES (21, '匿名', '他服务他态度太差了', 'employee8', 0, '2021-06-30');
INSERT INTO `complain` VALUES (22, '匿名', '他服务他态度太差了', 'employee13', -2, '2021-06-30');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `servername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `part_a` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `part_b` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `seller` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creat_time` date NULL DEFAULT NULL,
  `finish_time` date NULL DEFAULT NULL,
  `server_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` int(255) NULL DEFAULT NULL,
  `pay_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trace_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES (1, '某某服务', 'xx公司', 'user23', 'whh', '2021-05-16', '2021-06-01', 'xxxx', 10000, '支付宝', '已付款', 3);
INSERT INTO `contract` VALUES (2, '某某某服务', 'xx公司', 'user4', 'hlh', '2021-06-01', '2021-06-03', '销售', 23331, '支付宝', '已付款', 9);
INSERT INTO `contract` VALUES (3, 'server1', 'xx公司', 'user3', 'lyq', '2021-06-15', '2021-06-20', 'xxx', 3232, '微信', '欠尾款1000', 15);
INSERT INTO `contract` VALUES (4, 'server2', 'xx公司', 'user20', 'employee1', '2021-06-22', '2021-06-23', 'xxx', 4563, '微信', '已付款', 18);
INSERT INTO `contract` VALUES (5, 'server3', 'xx公司', 'user22', 'whh', '2021-06-23', '2021-07-03', 'xxx', 2112, '微信', '已付款', 8);
INSERT INTO `contract` VALUES (6, 'server4', 'xx公司', 'user22', 'employee6', '2021-06-23', '2021-07-03', 'xxx', 2112, '微信', '已付款', 8);
INSERT INTO `contract` VALUES (7, 'server5', 'xx公司', 'user4', 'whh', '2021-05-16', '2021-06-01', 'xxxx', 10000, '支付宝', '已付款', 4);
INSERT INTO `contract` VALUES (8, 'server6', 'xx公司', 'user21', 'hlh', '2021-06-01', '2021-06-03', '销售', 23331, '支付宝', '已付款', 9);
INSERT INTO `contract` VALUES (9, 'server7', 'xx公司', 'user32', 'lyq', '2021-06-15', '2021-06-20', 'xxx', 3232, '微信', '欠尾款1000', 15);
INSERT INTO `contract` VALUES (10, 'server8', 'xx公司', 'user6', 'employee1', '2021-06-22', '2021-06-23', 'xxx', 4563, '微信', '已付款', 18);
INSERT INTO `contract` VALUES (11, 'server9', 'xx公司', 'user6', 'employee2', '2021-06-23', '2021-07-03', 'xxx', 2112, '微信', '已付款', 8);
INSERT INTO `contract` VALUES (12, 'server10', 'xx公司', 'user9', 'whh', '2021-06-23', '2021-07-03', 'xxx', 2112, '微信', '已付款', 8);
INSERT INTO `contract` VALUES (13, 'server11', 'xx公司', 'user11', 'employee5', '2021-05-16', '2021-06-01', 'xxxx', 10000, '支付宝', '已付款', 4);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '男',
  `age` int(11) NULL DEFAULT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hire_date` date NULL DEFAULT NULL,
  `state` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '正常',
  `admin` int(11) NULL DEFAULT 0,
  `role_id` int(11) NULL DEFAULT 2,
  `performance` double(255, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK__tb_UandR_Role`(`role_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 'whh', '123456', '2466921236@qq.com', '女', 22, '营销部', '2021-06-21', '正常', 0, 2, 7.80);
INSERT INTO `employee` VALUES (2, 'lhp', '131400', '1452588824@qq.com', '女', 23, '人力资源部', '2021-05-22', '正常', 0, 3, NULL);
INSERT INTO `employee` VALUES (3, 'employee1', 'FEERRr', '1452588824@qq.com', '男', 21, '财务部', '2021-05-22', '离职', 0, 2, NULL);
INSERT INTO `employee` VALUES (4, 'employee2', 'FEERRr', '1452588824@qq.com', '男', 22, '财务部', '2021-05-24', '正常', 0, 3, NULL);
INSERT INTO `employee` VALUES (5, 'employee3', 'FEERRr', '1452588824@qq.com', '女', 32, '人力资源部', '2021-05-24', '离职', 0, 2, NULL);
INSERT INTO `employee` VALUES (6, 'employee4', 'FEERRr', '1452588824@qq.com', '男', 23, '营销部', '2021-06-01', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (7, 'employee5', '22222', '1452588824@qq.com', '女', 12, '营销部', '2021-06-02', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (8, 'employee6', '4324', '1452588824@qq.com', '男', 23, '营销部', '2021-06-02', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (9, 'employee7', '323232', '1452588824@qq.com', '女', 23, '财务部', '2021-06-12', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (10, 'employee8', '123456', '22334243@qq.com', '男', 34, '人力资源部', '2021-06-12', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (11, 'employee9', '23456', '2364512323@qq.com', '男', 32, '营销部', '2021-06-14', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (12, 'employee10', '23123', '31323242343@qq.com', '女', 23, '财务部', '2021-06-22', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (13, 'lyq', '123456', '13560498764@qq.com', '女', 23, '营销部', '2021-06-22', '正常', 0, 3, NULL);
INSERT INTO `employee` VALUES (14, 'yrn', '232323', '19819122323@qq.com', '女', 22, '人力资源部', '2021-06-23', '正常', 0, 3, NULL);
INSERT INTO `employee` VALUES (15, 'hlh', '2343554', '52345675432@qq.com', '男', 20, '财务部', '2021-06-24', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (16, 'employee11', '23456', '52345675432@qq.com', '男', 22, '营销部', '2021-06-25', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (17, 'employee12', '54243545', '52345675432@qq.com', '男', 23, '营销部', '2021-06-25', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (18, 'employee13', '4544354', '52345675432@qq.com', '男', 43, '营销部', '2021-06-26', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (19, 'employee14', 'dsdds', '52345675432@qq.com', '男', 23, '营销部', '2021-06-27', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (20, 'employee15', 'dfdsf', '52345675432@qq.com', '男', 21, '营销部', '2021-06-27', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (21, 'employee16', 'sdfds', '52345675432@qq.com', '男', 22, '营销部', '2021-06-28', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (22, 'employee17', 'ewerw', '52345675432@qq.com', '男', 45, '营销部', '2021-06-28', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (23, 'employee18', 'ewrw', '52345675432@qq.com', '男', 21, '营销部', '2021-06-29', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (24, 'employee19', 'werwr', '52345675432@qq.com', '男', 22, '营销部', '2021-06-29', '正常', 0, 2, NULL);
INSERT INTO `employee` VALUES (25, 'employee20', 'wca232', '3245466897@qq.com', '男', 21, '财务部', '2021-06-30', '正常', 0, 2, NULL);

-- ----------------------------
-- Table structure for judge
-- ----------------------------
DROP TABLE IF EXISTS `judge`;
CREATE TABLE `judge`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `working_ability` int(10) NULL DEFAULT NULL,
  `working_attitude` int(10) NULL DEFAULT NULL,
  `environmental_behavior` int(10) NULL DEFAULT NULL,
  `discipline` int(10) NULL DEFAULT NULL,
  `bonus_point` int(10) NULL DEFAULT NULL,
  `deduct_point` int(10) NULL DEFAULT 0,
  `performance` double(255, 2) NULL DEFAULT NULL,
  `judge_time` date NULL DEFAULT NULL,
  `judge_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `judged_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of judge
-- ----------------------------
INSERT INTO `judge` VALUES (6, 7, 6, 5, 5, 6, -1, 7.99, '2021-06-27', 'lhp', 'whh');
INSERT INTO `judge` VALUES (7, 8, 9, 7, 8, 3, -3, 5.90, '2021-06-27', 'lhp', 'employee3');
INSERT INTO `judge` VALUES (8, 7, 6, 5, 5, 6, -1, 7.90, '2021-06-01', 'yrn', 'hlh');
INSERT INTO `judge` VALUES (9, 7, 6, 5, 5, 6, -2, 6.00, '2021-06-16', 'yrn', 'employee4');
INSERT INTO `judge` VALUES (10, 7, 6, 10, 10, 6, -2, 6.50, '2021-06-17', 'lhp', 'employee6');
INSERT INTO `judge` VALUES (11, 7, 6, 10, 10, 6, -1, 6.90, '2021-06-27', 'lhp', 'employee5');
INSERT INTO `judge` VALUES (12, 7, 6, 10, 10, 6, -1, 7.90, '2021-06-27', 'yrn', 'employee7');
INSERT INTO `judge` VALUES (13, 7, 6, 10, 10, 6, -2, 5.00, '2021-06-27', 'yrn', 'employee9');
INSERT INTO `judge` VALUES (14, 7, 6, 10, 10, 6, -1, 7.45, '2021-06-27', 'lhp', 'employee1');
INSERT INTO `judge` VALUES (15, 7, 6, 10, 10, 9, -1, 8.50, '2021-06-27', 'yrn', 'employee13');
INSERT INTO `judge` VALUES (16, 7, 6, 10, 10, 6, -3, 6.00, '2021-06-28', 'lhp', 'emlpoyee19');

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `server_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `communicate_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start` date NULL DEFAULT NULL,
  `end` date NULL DEFAULT NULL,
  `trace_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES (2, 'sssss', 'ddd', 'csds', '通过今天的沟通，按照沟通的内容进行调整，准备做什么什么', '2021-06-15', '2021-06-30', 4);
INSERT INTO `plan` VALUES (4, 'sfsds', 'ssss', 'sdfsf', '通过沟通，我决定干啥干啥来做啥，为这个沟通做个记录，以后怎么跟进比较好', '2021-06-22', '2021-06-30', 8);
INSERT INTO `plan` VALUES (5, '随便起的服务名', '起个标题', 'sds', 'xxxx', '2021-06-15', '2021-06-29', 9);

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
INSERT INTO `role` VALUES (2, '员工');
INSERT INTO `role` VALUES (3, '经理');

-- ----------------------------
-- Table structure for trace
-- ----------------------------
DROP TABLE IF EXISTS `trace`;
CREATE TABLE `trace`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trace_time` date NULL DEFAULT NULL,
  `trace_details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `end_time` date NULL DEFAULT NULL,
  `trace_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '潜在开发计划',
  `trace_result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `process_status` int(255) NULL DEFAULT NULL COMMENT '1,2,3,4四种取值，对应不同状态，了解服务，提供服务，服务中，服务完成',
  `input_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `praise` int(255) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `process_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trace
-- ----------------------------
INSERT INTO `trace` VALUES (1, '2021-06-24', '无人接听，联系不上', '2021-06-24', '潜在开发计划', '差', 'user1', 2, 'whh', '潜在客户', NULL, '电话沟通', NULL);
INSERT INTO `trace` VALUES (2, '2021-06-25', '考虑中', '2021-06-26', '客户跟进历史', '优', 'user2', 3, 'hlh', '潜在客户', NULL, '微信沟通', NULL);
INSERT INTO `trace` VALUES (3, '2021-06-26', '了解使用感受', '2021-06-27', '潜在开发计划', '中', 'user23', 4, 'whh', '潜在客户', NULL, '通过电话沟通', NULL);
INSERT INTO `trace` VALUES (4, '2021-06-26', 'xxx', '2021-06-27', '潜在开发计划', '中', 'user20', 1, 'hlh', '潜在客户', NULL, '通过电话沟通', NULL);
INSERT INTO `trace` VALUES (5, '2021-06-28', 'xxxx', '2021-06-28', '潜在开发计划', '中', 'user12', 1, 'employee1', '潜在客户', NULL, '通过电话沟通', NULL);
INSERT INTO `trace` VALUES (8, '2021-06-29', 'xxx', '2021-06-30', '潜在开发计划', '中', 'user9', 1, 'whh', '潜在客户', NULL, '通过电话沟通', NULL);
INSERT INTO `trace` VALUES (7, '2021-06-30', 'xxx', '2021-07-01', '潜在开发计划', '中', 'user8', 1, 'employee3', '潜在客户', NULL, '通过电话沟通', NULL);
INSERT INTO `trace` VALUES (9, '2021-07-01', 'xxxx', '2021-07-02', '潜在开发计划', '优', 'user4', 4, 'hlh', '正式客户', NULL, '通过qq确定', NULL);

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `customer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trans_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trans_time` date NULL DEFAULT NULL,
  `old_seller` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `new_seller` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trans_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transfer
-- ----------------------------
INSERT INTO `transfer` VALUES (1, 'user1', 'whh', '2021-06-25', 'whh', 'whhrr', 'sfdgsgfgfd');
INSERT INTO `transfer` VALUES (2, 'user19', 'lhp', '2021-06-28', 'whh', 'whhrr', 'sfdgsgfgfd');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '男' COMMENT '性别',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `age` int(11) NULL DEFAULT NULL,
  `tel` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `seller` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `input_user` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区',
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户来源',
  `input_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '资源池客户' COMMENT '5个状态',
  `positive_time` date NULL DEFAULT NULL COMMENT '最终提交时间',
  `star` int(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'user1', '111111', '男', '1452588824@qq.com', 23, '17876656571', 'employee4', 'lhp', '华北地区-北京', '互联网', '朋友介绍', '2021-06-01', '潜在客户', '2021-06-15', 0);
INSERT INTO `user` VALUES (4, 'user2', '123456', '女', '14528824@qq.com', 35, '13682800276', 'whh', 'whh', '华北地区-天津', '金融', '网上了解', '2021-05-01', '资源池用户', '2021-06-28', 1);
INSERT INTO `user` VALUES (5, 'user3', '123456', '男', '2234243@qq.com', 23, '19811941841', 'hlh', 'lhp', '东北地区-辽宁', '教育', '咨询了解', '2021-06-25', '资源池用户', '2021-06-25', 1);
INSERT INTO `user` VALUES (7, 'user4', '4444', '女', '2348824@qq.com', 22, '13560498764', 'whh', 'yrn', '华东地区-上海', '服务', '别人介绍', '2021-06-20', '正式客户', '2021-06-24', 0);
INSERT INTO `user` VALUES (9, 'user5', '123456', '女', '4588824@qq.com', 29, '13682842539', 'employee2', 'employee2', '中南地区-河南', '餐饮', '他人介绍', '2021-06-24', '潜在客户', '2021-06-24', 1);
INSERT INTO `user` VALUES (11, 'user6', '666666', '女', '1453524@qq.com', 29, '19719799771', 'employee4', 'employee4', '西南地区-重庆', '餐饮', '别人介绍', '2021-06-12', '流失', '2021-06-24', 0);
INSERT INTO `user` VALUES (13, 'user7', '123456', '女', '776546@qq.com', 21, '19811941841', 'employee3', 'lhp', '西北地区-陕西', '金融', '网上了解', '2021-06-24', '正式客户', '2021-06-24', 0);
INSERT INTO `user` VALUES (14, 'user8', '888888', '男', '67574556@qq.com', 22, '13232324321', 'employee4', 'whh', '西北地区-甘肃', '互联网', '咨询了解', '2021-06-28', '潜在客户', '2021-06-16', 0);
INSERT INTO `user` VALUES (15, 'user9', '123456', '男', '4534534@qq.cm', 43, '11133232211', 'employee8', 'employee09', '中南地区-湖南', '教育', '线上了解', '2021-05-01', '资源池客户', '2021-06-16', 1);
INSERT INTO `user` VALUES (16, 'user10', '101010', '男', '2234243@qq.com', 23, '17876656571', 'employee19', 'employee11', '中南地区-广东', '餐饮', '朋友介绍', '2021-02-25', '潜在客户', '2021-06-25', 0);
INSERT INTO `user` VALUES (18, 'user11', '123456', '女', '14452234243@qq.com', 23, '12776656571', 'whh', 'lhp', '西南地区-重庆', '服务', '网上了解', '2021-06-01', '正式客户', '2021-06-25', 1);
INSERT INTO `user` VALUES (19, 'user12', '121212', '男', '23422234243@qq.com', 23, '13676656571', 'whh', 'whh', '华东地区-上海', '金融', '宣传单', '2021-06-09', '正式客户', '2021-06-25', 0);
INSERT INTO `user` VALUES (20, 'user13', '123456', '男', '112234243@qq.com', 12, '13813899220', 'lyq', 'lyq', '东北地区-大连', '教育', '媒体了解', '2021-03-25', '正式客户', '2021-06-25', 1);
INSERT INTO `user` VALUES (23, 'user14', '141414', '男', '122233123@qq.com', 23, '12434243212', 'employee12', 'lhp', '华北地区-河北', '餐饮', '别人介绍', '2020-05-01', '正式客户', '2021-01-20', 0);
INSERT INTO `user` VALUES (24, 'user15', '123212', '男', '122233123@qq.com', 21, '12432423432', 'employee20', 'yrn', '西北地区-新疆', '教育', '别人介绍', '2021-06-28', '潜在客户', '2021-07-07', 0);
INSERT INTO `user` VALUES (25, 'user16', '123456', '男', '1452588824@qq.com', 23, '17876656571', 'employee13', 'employee13', '西北地区-陕西', '教育', '线上了解', '2021-06-30', '潜在客户', NULL, 1);
INSERT INTO `user` VALUES (26, 'user17', '123456', '男', '1452588824@qq.com', 12, '18876656571', 'employee6', 'employee6', '东北地区-大连', '餐饮', '线上了解', '2021-06-09', '潜在客户', NULL, 0);
INSERT INTO `user` VALUES (27, 'user18', '123456', '男', '588824@qq.com', 32, '19876656571', 'employee7', 'employee7', '华北地区-内蒙古', '服务', '线上了解', '2021-06-01', '潜在客户', NULL, 0);
INSERT INTO `user` VALUES (28, 'user19', '123456', '男', '443588824@qq.com', 43, '17876656571', 'employee10', 'lyq', '西南地区-西藏', '金融', '线上了解', '2021-01-28', '潜在客户', NULL, 1);
INSERT INTO `user` VALUES (29, 'user20', '23434532', '女', '72588824@qq.com', 22, '13666656571', 'employee2', 'employee2', '西北地区-宁夏', '互联网', '朋友介绍', '2020-10-28', '潜在客户', NULL, 1);
INSERT INTO `user` VALUES (30, 'user21', '123456', '男', '1452588824@qq.com', 22, '14556656571', 'employee8', 'employee8', '西南地区-贵州', '餐饮', '宣传单', '2021-02-28', '潜在客户', NULL, 0);
INSERT INTO `user` VALUES (31, 'user22', '123456', '女', '552588824@qq.com', 21, '14876656571', 'employee5', 'employee5', '中南地区-湖北', '教育', '朋友介绍', '2021-04-07', '潜在客户', NULL, 1);
INSERT INTO `user` VALUES (32, 'user23', '123456', '男', '252588824@qq.com', 32, '17376656571', 'employee11', 'employee15', '华东地区-江苏', '服务', '朋友介绍', '2021-06-23', '潜在客户', NULL, 1);
INSERT INTO `user` VALUES (33, 'user24', '43sfdsc', '女', '9588824@qq.com', 43, '17876656571', 'employee18', 'employee18', '中南地区-广东', '餐饮', '宣传单', '2021-06-07', '潜在客户', NULL, 0);
INSERT INTO `user` VALUES (34, 'user25', '23wd', '男', '121343@qq.com', 23, '12324323256', 'employee19', 'employee19', '中南地区-广东', '金融', '宣传单', '2021-06-28', '潜在客户', NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
