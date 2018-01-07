/*
MySQL Data Transfer
Source Host: localhost
Source Database: student_db
Target Host: localhost
Target Database: student_db
Date: 2018/1/7 23:11:00
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `uid` int(11) NOT NULL auto_increment COMMENT '标识ID',
  `uName` varchar(20) NOT NULL COMMENT '名姓',
  `uAccounts` varchar(20) NOT NULL COMMENT '账号',
  `uPassword` varchar(50) NOT NULL default '密码',
  `uRemark` varchar(50) default NULL COMMENT '注备',
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for t_score
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score` (
  `sid` int(11) NOT NULL auto_increment COMMENT '绩成标识ID',
  `stuNo` varchar(20) NOT NULL COMMENT '学生学号',
  `course` varchar(20) NOT NULL COMMENT '程课编号 ',
  `score` int(11) NOT NULL COMMENT '课程成绩',
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stuid` int(11) NOT NULL auto_increment COMMENT '生学标识ID',
  `stuName` varchar(20) NOT NULL,
  `stuNo` varchar(20) NOT NULL COMMENT '学号',
  `cno` varchar(20) default NULL COMMENT '级班编号',
  `gno` varchar(20) default NULL COMMENT '级年编号',
  `stuAge` int(11) default NULL COMMENT '龄年',
  `stuAddr` varchar(50) default NULL COMMENT '地址',
  `stuSex` char(2) NOT NULL COMMENT '性别',
  PRIMARY KEY  (`stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', '张三', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '测试');
