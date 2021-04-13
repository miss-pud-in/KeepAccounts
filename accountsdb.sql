/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : accountsdb

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 13/04/2021 13:51:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_private` int(10) NOT NULL COMMENT '是否为私有账本，值为1时表示私有账本',
  `is_deletable` int(10) NOT NULL COMMENT '是否可删除，值为0表示不可删除，为默认账本',
  `is_lock` int(10) NOT NULL COMMENT '是否加密，值为1表示加密，需要password',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100008 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (100001, '2021年3月的账本', 1, 0, 0, '');
INSERT INTO `book` VALUES (100002, '2021年3月的账本', 1, 0, 1, '123456');
INSERT INTO `book` VALUES (100003, '2021年3月的账本', 1, 0, 1, '7777777');
INSERT INTO `book` VALUES (100004, '2021年3月的账本', 1, 0, 0, NULL);
INSERT INTO `book` VALUES (100005, '2021年3月的账本', 1, 0, 0, NULL);
INSERT INTO `book` VALUES (100006, '今天又逛tb了吗', 0, 1, 1, 'tay');
INSERT INTO `book` VALUES (100007, '121年3月的账本', 1, 0, 0, NULL);

-- ----------------------------
-- Table structure for book_record
-- ----------------------------
DROP TABLE IF EXISTS `book_record`;
CREATE TABLE `book_record`  (
  `book_id` int(11) NOT NULL,
  `record_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`, `record_id`) USING BTREE,
  INDEX `record_id`(`record_id`) USING BTREE,
  CONSTRAINT `book_record_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_record_ibfk_2` FOREIGN KEY (`record_id`) REFERENCES `record` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_record
-- ----------------------------
INSERT INTO `book_record` VALUES (100007, 1);
INSERT INTO `book_record` VALUES (100003, 2);

-- ----------------------------
-- Table structure for book_user
-- ----------------------------
DROP TABLE IF EXISTS `book_user`;
CREATE TABLE `book_user`  (
  `book_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `is_owner` int(11) NOT NULL COMMENT '该book是否被该user拥有，若是则值为1',
  PRIMARY KEY (`book_id`, `user_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `book_user_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_user_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_user
-- ----------------------------
INSERT INTO `book_user` VALUES (100001, 100001, 1);
INSERT INTO `book_user` VALUES (100002, 100002, 1);
INSERT INTO `book_user` VALUES (100003, 100003, 1);
INSERT INTO `book_user` VALUES (100004, 100004, 1);
INSERT INTO `book_user` VALUES (100005, 100006, 1);
INSERT INTO `book_user` VALUES (100006, 100003, 1);
INSERT INTO `book_user` VALUES (100007, 100003, 1);

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_favorite` int(10) NOT NULL COMMENT '是否为常用标签，值为0/1',
  PRIMARY KEY (`id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES (1, 100001, '无', 0);
INSERT INTO `label` VALUES (2, 100002, '无', 0);
INSERT INTO `label` VALUES (3, 100003, '无', 0);
INSERT INTO `label` VALUES (4, 100003, '学习', 0);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` int(11) NOT NULL COMMENT '发送用户',
  `to_id` int(11) NOT NULL COMMENT '接收用户',
  `type` int(11) NOT NULL COMMENT '消息的类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100004 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (100001, 100001, 100002, 0);
INSERT INTO `message` VALUES (100002, 100001, 100003, 0);
INSERT INTO `message` VALUES (100003, 100001, 100004, 0);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `date` date NOT NULL,
  `label_id` int(11) NOT NULL COMMENT '所属标签的id',
  `remarks` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (1, 100003, 100, '2021-04-12', 3, NULL);
INSERT INTO `record` VALUES (2, 100003, 300, '2021-04-12', 3, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `budget_for_month` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100007 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (100001, 'admin', 'admin', 0);
INSERT INTO `user` VALUES (100002, 'taylor', '7777777', 0);
INSERT INTO `user` VALUES (100003, 'tiantian', '123456', 0);
INSERT INTO `user` VALUES (100004, 'siyu', '123', 1);
INSERT INTO `user` VALUES (100005, 'random', 'qwe', 0);
INSERT INTO `user` VALUES (100006, 'test', 'test', 0);

SET FOREIGN_KEY_CHECKS = 1;
