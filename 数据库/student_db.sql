/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : student_db

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-12-27 20:21:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_courses`
-- ----------------------------
DROP TABLE IF EXISTS `t_courses`;
CREATE TABLE `t_courses` (
  `cs_no` varchar(20) NOT NULL COMMENT '课程编号',
  `cs_name` varchar(20) DEFAULT NULL COMMENT '课程名称',
  `cs_hour` int(11) DEFAULT NULL COMMENT '课时',
  `cs_score` int(11) DEFAULT NULL COMMENT '学分',
  PRIMARY KEY (`cs_no`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_courses
-- ----------------------------

-- ----------------------------
-- Table structure for `t_score`
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score` (
  `sc_id` int(11) NOT NULL COMMENT '成绩标识ID',
  `cs_no` varchar(20) NOT NULL COMMENT '课程编号',
  `stu_no` varchar(20) NOT NULL COMMENT '学号',
  `sc_score` int(11) NOT NULL COMMENT '成绩',
  PRIMARY KEY (`sc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_score
-- ----------------------------

-- ----------------------------
-- Table structure for `t_students`
-- ----------------------------
DROP TABLE IF EXISTS `t_students`;
CREATE TABLE `t_students` (
  `stu_no` varchar(20) NOT NULL COMMENT '学号',
  `stu_name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `stu_sex` char(2) DEFAULT NULL COMMENT '性别',
  `stu_age` int(11) DEFAULT NULL COMMENT '年龄',
  `stu_class` varchar(20) DEFAULT NULL COMMENT '班级',
  `stu_grade` varchar(20) DEFAULT NULL COMMENT '年级',
  `stu_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`stu_no`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_students
-- ----------------------------
