DROP DATABASE IF EXISTS student_stsyem; 
CREATE DATABASE student_system CHARACTER SET utf8; 
use student_system;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------
-- Table structure for student_stsyem
-- ----------------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `admin_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '管理员Id',
  `admin_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `admin_password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `idx_admin_username`(`admin_username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', '123456');
INSERT INTO `t_admin` VALUES (2, 'manager', 'password');

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course`  (
  `course_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '课程Id',
  `course_teacher_id` int(10) UNSIGNED NOT NULL COMMENT '授课教师Id',
  `course_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程名称',
  `course_time` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上课时间 星期几-第几节-几节课',
  `course_location` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上课地址',
  PRIMARY KEY (`course_id`) USING BTREE,
  INDEX `fk_course_teacher_id`(`course_teacher_id`) USING BTREE,
  INDEX `idx_course_name`(`course_name`) USING BTREE,
  CONSTRAINT `fk_course_teacher_id` FOREIGN KEY (`course_teacher_id`) REFERENCES `t_teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES (1, 1, 'C语言程序设计', '1-1-2', 'E-107');
INSERT INTO `t_course` VALUES (2, 1, 'Java程序设计','1-3-2', 'E-106');
INSERT INTO `t_course` VALUES (3, 1, '数据库实用技术','2-3-2', 'E-202');
INSERT INTO `t_course` VALUES (4, 1, '智能系统', '5-5-3', 'E-518');
INSERT INTO `t_course` VALUES (5, 1, '软件工程', '3-9-2', 'E-305');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department`  (
  `department_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '系Id',
  `department_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '系名称',
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES (1, '计算机系');
INSERT INTO `t_department` VALUES (2, '数学系');
INSERT INTO `t_department` VALUES (3, '物理系');
INSERT INTO `t_department` VALUES (4, '化学系');
INSERT INTO `t_department` VALUES (5, '生物系');

-- ----------------------------
-- Table structure for t_major
-- ----------------------------
DROP TABLE IF EXISTS `t_major`;
CREATE TABLE `t_major`  (
  `major_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '专业Id',
  `major_department_id` int(10) UNSIGNED NOT NULL COMMENT '系Id',
  `major_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '专业名称',
  PRIMARY KEY (`major_id`) USING BTREE,
  INDEX `fk_major_department_id`(`major_department_id`) USING BTREE,
  INDEX `idx_major_name`(`major_name`) USING BTREE,
  CONSTRAINT `fk_major_department_id` FOREIGN KEY (`major_department_id`) REFERENCES `t_department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_major
-- ----------------------------
INSERT INTO `t_major` VALUES (1, 1, '计算机科学与技术');
INSERT INTO `t_major` VALUES (2, 1, '软件工程');
INSERT INTO `t_major` VALUES (3, 1, '信息工程');
INSERT INTO `t_major` VALUES (4, 2, '应用数学');
INSERT INTO `t_major` VALUES (5, 3, '理论物理');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `student_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学生Id',
  `student_major_id` int(10) UNSIGNED NOT NULL COMMENT '专业Id',
  `student_number` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号',
  `student_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `student_password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `student_sex` tinyint(1) UNSIGNED NOT NULL COMMENT '性别',
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `fk_student_major_id`(`student_major_id`) USING BTREE,
  UNIQUE INDEX `idx_student_number`(`student_number`) USING BTREE,
  INDEX `idx_student_name`(`student_name`) USING BTREE,
  CONSTRAINT `fk_student_major_id` FOREIGN KEY (`student_major_id`) REFERENCES `t_major` (`major_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, 1, '202312310001', '李雨轩', '123456', 1);
INSERT INTO `t_student` VALUES (2, 1, '202312310002', '宋健', '123456', 1);
INSERT INTO `t_student` VALUES (3, 2, '202312310003', '李同学1', '123456', 0);
INSERT INTO `t_student` VALUES (4, 3, '202312310004', '李同学2', '123456', 0);
INSERT INTO `t_student` VALUES (5, 4, '202312310005', '李同学3', '123456', 0);

-- ----------------------------
-- Table structure for t_student_course
-- ----------------------------
DROP TABLE IF EXISTS `t_student_course`;
CREATE TABLE `t_student_course`  (
  `sc_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '选课Id',
  `sc_student_id` int(10) UNSIGNED NOT NULL COMMENT '学生Id',
  `sc_course_id` int(10) UNSIGNED NOT NULL COMMENT '课程Id',
  PRIMARY KEY (`sc_id`) USING BTREE,
  INDEX `fk_sc_course_id`(`sc_course_id`) USING BTREE,
  INDEX `fk_sc_student_id`(`sc_student_id`) USING BTREE,
  CONSTRAINT `fk_sc_course_id` FOREIGN KEY (`sc_course_id`) REFERENCES `t_course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_sc_student_id` FOREIGN KEY (`sc_student_id`) REFERENCES `t_student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student_course
-- ----------------------------
INSERT INTO `t_student_course` VALUES (1, 1, 1);
INSERT INTO `t_student_course` VALUES (2, 2, 1);
INSERT INTO `t_student_course` VALUES (3, 3, 1);
INSERT INTO `t_student_course` VALUES (4, 4, 1);
INSERT INTO `t_student_course` VALUES (5, 5, 1);

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `teacher_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '教师Id',
  `teacher_department_id` int(10) UNSIGNED NOT NULL COMMENT '系Id',
  `teacher_number` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '工号',
  `teacher_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教师姓名',
  `teacher_password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`teacher_id`) USING BTREE,
  INDEX `fk_teacher_department_id`(`teacher_department_id`) USING BTREE,
  UNIQUE INDEX `idx_teacher_number`(`teacher_number`) USING BTREE,
  CONSTRAINT `fk_teacher_department_id` FOREIGN KEY (`teacher_department_id`) REFERENCES `t_department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (1, 1, '202312310001', '张三', '123456');
INSERT INTO `t_teacher` VALUES (2, 3, '202312310002', '宋老师', '123456');
INSERT INTO `t_teacher` VALUES (3, 1, '202312310003', '宋老师', '123456');
INSERT INTO `t_teacher` VALUES (4, 1, '202312310004', '张老师', '123456');
INSERT INTO `t_teacher` VALUES (5, 1, '202312310005', '吕老师', '123456');

SET FOREIGN_KEY_CHECKS = 1;
