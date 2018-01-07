/*
MySQL Data Transfer
Source Host: localhost
Source Database: student_db
Target Host: localhost
Target Database: student_db
Date: 2018/1/7 12:00:20
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
INSERT INTO `t_score` VALUES ('13', '433', 'dd', '33');
INSERT INTO `t_score` VALUES ('14', '2323', 'sada', '66');
INSERT INTO `t_score` VALUES ('15', '324', 'fd', '77');
INSERT INTO `t_score` VALUES ('16', '2323', 'fd', '43');
INSERT INTO `t_score` VALUES ('17', '2323', 'lfd', '99');
INSERT INTO `t_score` VALUES ('18', '3241', 'w43', '66');
INSERT INTO `t_score` VALUES ('19', '2323', 'klsdwe', '88');
INSERT INTO `t_score` VALUES ('20', '222', '可困', '121');
INSERT INTO `t_score` VALUES ('21', '222', '顾', '21');
INSERT INTO `t_score` VALUES ('22', '222', '夺', '133');
INSERT INTO `t_score` VALUES ('23', '3241', 'sdf', '123');
INSERT INTO `t_score` VALUES ('24', '3241', 'sdkj', '123');
INSERT INTO `t_score` VALUES ('25', '433', 'qwkj', '123');
INSERT INTO `t_score` VALUES ('26', '222', '顺口在', '123');
INSERT INTO `t_student` VALUES ('1', '耙耳朵', '111', '123', 'd', '1', 'a', '1');
INSERT INTO `t_student` VALUES ('2', '张三', '222', '124', '22', '23', '22222222111', '1');
INSERT INTO `t_student` VALUES ('3', '风车车', '333', '125', '11', '22', '1312312313', '1');
INSERT INTO `t_student` VALUES ('4', '王五', '444', '126', '555', '22', '6666', '1');
INSERT INTO `t_student` VALUES ('5', '李四', '555', '127', 'ddd', '33', '', '1');
INSERT INTO `t_student` VALUES ('6', '假老练', '666', '128', '22344', '22', '', '0');
INSERT INTO `t_student` VALUES ('7', 'aaaa', '433', '444', '55', '12', '2345', '1');
INSERT INTO `t_student` VALUES ('8', 'fdd', '3241', '123', '1234', '23', '4', '1');
INSERT INTO `t_student` VALUES ('9', 'qww', '23', '234', '243', '44', '24', '1');
INSERT INTO `t_student` VALUES ('10', '323445', '2323', '22323', '3223', '23', '23', '1');
INSERT INTO `t_student` VALUES ('11', '345', '324', '32', '2234', '31', '2345', '1');
INSERT INTO `t_student` VALUES ('12', '呵呵', 'jslkl2', '233', '232323', '22', '', '1');
INSERT INTO `t_student` VALUES ('13', '爱国人士', '2345', '234', '23', '22', '呀劳动用工脸上', '1');
INSERT INTO `t_student` VALUES ('14', '炒作', '234', '5667', '2345', '33', '222这信用报告&#13361;信用报告', '男');
