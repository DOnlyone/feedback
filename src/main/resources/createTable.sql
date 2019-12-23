
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for AUTHORITY
-- ----------------------------
DROP TABLE IF EXISTS `AUTHORITY`;
CREATE TABLE `AUTHORITY` (
  `AUTH_ID` bigint(20) DEFAULT NULL,
  `AUTH_NAME` varchar(50) DEFAULT NULL,
  `DESC` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for CONTENT
-- ----------------------------
DROP TABLE IF EXISTS `CONTENT`;
CREATE TABLE `CONTENT` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATEUSER` bigint(20) DEFAULT NULL,
  `CONTEXT` varchar(500) DEFAULT NULL,
  `TYPE` int(11) DEFAULT NULL,
  `CTEATE_DATE` date DEFAULT NULL,
  `CURRENT_NODE` bigint(20) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `TITLE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dic
-- ----------------------------
DROP TABLE IF EXISTS `dic`;
CREATE TABLE `dic` (
  `DIC_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PARENT_ID` bigint(20) DEFAULT NULL,
  `DIC_DESC` varchar(0) DEFAULT NULL,
  `LEVEL` int(11) DEFAULT NULL,
  PRIMARY KEY (`DIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- ----------------------------
-- Table structure for ROLE
-- ----------------------------
DROP TABLE IF EXISTS `ROLE`;
CREATE TABLE `ROLE` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(40) DEFAULT NULL,
  `DESC` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ROLE_TO_AUTH
-- ----------------------------
DROP TABLE IF EXISTS `ROLE_TO_AUTH`;
CREATE TABLE `ROLE_TO_AUTH` (
  `ID` bigint(20) DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `AUTH_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for USER
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(11) DEFAULT NULL,
  `REAL_NAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(20) DEFAULT NULL,
  `CLASS` int(11) DEFAULT NULL,
  `GARDE` int(11) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `PHONE` varchar(15) DEFAULT NULL,
  `SEX` tinyint(4) DEFAULT NULL,
  `USER_NO` int(10) DEFAULT NULL COMMENT '如果为学生为学号，教师为工号',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for USER_TO_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `USER_TO_ROLE`;
CREATE TABLE `USER_TO_ROLE` (
  `ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for WF_DEF
-- ----------------------------
DROP TABLE IF EXISTS `WF_DEF`;
CREATE TABLE `WF_DEF` (
  `NODE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NEXT_NODE` bigint(20) DEFAULT NULL,
  `NODE_NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`NODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流定义';

-- ----------------------------
-- Table structure for WF_INSTANCE
-- ----------------------------
DROP TABLE IF EXISTS `WF_INSTANCE`;
CREATE TABLE `WF_INSTANCE` (
  `INSTANCE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATE_DATE` date DEFAULT NULL,
  `NODE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`INSTANCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流实例';

-- ----------------------------
-- Table structure for SYS_DIC
-- ----------------------------
DROP TABLE IF EXISTS `SYS_DIC`;
CREATE TABLE `SYS_DIC` (
  `DIC_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL COMMENT '字典名称',
  `TYPE` varchar(100) NOT NULL COMMENT '字典类型',
  `CODE` varchar(100) NOT NULL COMMENT '字典码',
  `VALUE` varchar(1000) NOT NULL COMMENT '字典值',
  `ORDER_NUM` int(11) DEFAULT '0' COMMENT '排序',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `DEL_FLAG` tinyint(4) DEFAULT '0' COMMENT '删除标记  -1：已删除  0：正常',
  `P_VALUE` tinyint(20) DEFAULT NULL COMMENT '上级',
  PRIMARY KEY (`DIC_ID`),
  UNIQUE KEY `type` (`TYPE`,`CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- ----------------------------
-- Records of SYS_DIC
-- ----------------------------
INSERT INTO `SYS_DIC` VALUES ('4', '年级', 'grade', '0', '一年级', '1', '', '0', null);
INSERT INTO `SYS_DIC` VALUES ('5', '年级', 'grade', '1', '二年级', '2', '', '0', null);
INSERT INTO `SYS_DIC` VALUES ('6', '年级', 'grade', '2', '三年级', '3', '', '0', null);
INSERT INTO `SYS_DIC` VALUES ('7', '班级', 'classNum', '0', '1918班', '1', '', '0', null);
INSERT INTO `SYS_DIC` VALUES ('17', '班级', 'classNum', '1', '1919班', '2', '', '0', '4');
INSERT INTO `SYS_DIC` VALUES ('18', '班级', 'classNum', '2', '1920班', '2', '', '0', '4');
INSERT INTO `SYS_DIC` VALUES ('22', '班级', 'classNum', '3', '1814班', '3', '', '0', '5');
INSERT INTO `SYS_DIC` VALUES ('23', '班级', 'classNum', '4', '1815班', '2', '', '0', '5');
INSERT INTO `SYS_DIC` VALUES ('24', '班级', 'classNum', '5', '1816班', '1', '', '0', '5');
INSERT INTO `SYS_DIC` VALUES ('25', '班级', 'classNum', '7', '1712班', '1', '', '0', '6');
INSERT INTO `SYS_DIC` VALUES ('26', '班级', 'classNum', '8', '1713班', '2', '', '0', '6');
