/*
 Navicat Premium Data Transfer

 Source Server         : root@10.102.1.121
 Source Server Type    : MySQL
 Source Server Version : 100323
 Source Host           : 10.102.1.121:3306
 Source Schema         : carrent

 Target Server Type    : MySQL
 Target Server Version : 100323
 File Encoding         : 65001

 Date: 28/09/2020 23:39:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bus_car
-- ----------------------------
DROP TABLE IF EXISTS `bus_car`;
CREATE TABLE `bus_car`  (
  `number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '车牌号',
  `brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '汽车品牌',
  `color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '汽车颜色',
  `buy_price` double(10, 2) NULL DEFAULT NULL COMMENT '购买价格',
  `rent_price` double(10, 2) NULL DEFAULT NULL COMMENT '出租价格',
  `deposit` double(10, 2) NULL DEFAULT NULL COMMENT '押金',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '车辆状态；0:未出租，1:已出租',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '汽车描述',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '汽车图片',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '录入时间',
  `operator` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `exist` tinyint(1) NULL DEFAULT 1 COMMENT '是否存在；0：报废；1：能用',
  PRIMARY KEY (`number`) USING BTREE,
  INDEX `fk_car_user`(`operator`) USING BTREE,
  CONSTRAINT `fk_car_user` FOREIGN KEY (`operator`) REFERENCES `sys_user` (`username`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bus_check
-- ----------------------------
DROP TABLE IF EXISTS `bus_check`;
CREATE TABLE `bus_check`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '检查单号',
  `check_date` datetime(0) NULL DEFAULT NULL COMMENT '检查时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `problem` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '存在的问题',
  `compensate` double(8, 2) NULL DEFAULT NULL COMMENT '赔偿金额',
  `operator` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人员',
  `rent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租车单号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_check_user`(`operator`) USING BTREE,
  INDEX `fk_check_rent`(`rent_id`) USING BTREE,
  CONSTRAINT `fk_check_rent` FOREIGN KEY (`rent_id`) REFERENCES `bus_rent` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_check_user` FOREIGN KEY (`operator`) REFERENCES `sys_user` (`username`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bus_customer
-- ----------------------------
DROP TABLE IF EXISTS `bus_customer`;
CREATE TABLE `bus_customer`  (
  `identity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` tinyint(1) NULL DEFAULT 0 COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `career` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '录入时间',
  `exist` tinyint(1) NULL DEFAULT 1 COMMENT '是否存在。1：存在；0:不存在',
  `operator` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '录入人员',
  PRIMARY KEY (`identity`) USING BTREE,
  INDEX `fk_customer_user`(`operator`) USING BTREE,
  CONSTRAINT `fk_customer_user` FOREIGN KEY (`operator`) REFERENCES `sys_user` (`username`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bus_rent
-- ----------------------------
DROP TABLE IF EXISTS `bus_rent`;
CREATE TABLE `bus_rent`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '出租单号',
  `price` double(8, 2) NULL DEFAULT NULL COMMENT '实际出租价格',
  `begin_time` date NULL DEFAULT NULL COMMENT '开始时间',
  `return_time` date NULL DEFAULT NULL COMMENT '还车时间',
  `real_time` datetime(0) NULL DEFAULT NULL COMMENT '实际还车时间',
  `rent_status` tinyint(1) NULL DEFAULT NULL COMMENT '出租状态：0：出租中；1：已归还',
  `customer_identity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户身份证号',
  `car_number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '汽车车牌',
  `operator` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人员',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '录入时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_rent_car`(`car_number`) USING BTREE,
  INDEX `fk_rent_customer`(`customer_identity`) USING BTREE,
  INDEX `fk_rent_user`(`operator`) USING BTREE,
  CONSTRAINT `fk_rent_car` FOREIGN KEY (`car_number`) REFERENCES `bus_car` (`number`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_rent_customer` FOREIGN KEY (`customer_identity`) REFERENCES `bus_customer` (`identity`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_rent_user` FOREIGN KEY (`operator`) REFERENCES `sys_user` (`username`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_announcement
-- ----------------------------
DROP TABLE IF EXISTS `sys_announcement`;
CREATE TABLE `sys_announcement`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `operator` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_new_user`(`operator`) USING BTREE,
  CONSTRAINT `fk_new_user` FOREIGN KEY (`operator`) REFERENCES `sys_user` (`username`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `username` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `identity` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '家庭地址',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '帐户类型：0：普通用户；1：管理员',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
