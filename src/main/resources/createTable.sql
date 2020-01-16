ET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for AUTHORITY
-- ----------------------------
DROP TABLE IF EXISTS `AUTHORITY`;
CREATE TABLE `AUTHORITY` (
  `AUTH_ID` bigint(20) DEFAULT NULL,
  `AUTH_NAME` varchar(50) DEFAULT NULL,
  `DESC` char(10) DEFAULT NULL,
  `SCOPE` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of AUTHORITY
-- ----------------------------
INSERT INTO `AUTHORITY` VALUES ('1', '', null, '17');

-- ----------------------------
-- Table structure for CONTENT
-- ----------------------------
DROP TABLE IF EXISTS `CONTENT`;
CREATE TABLE `CONTENT` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(100) DEFAULT NULL,
  `CONTEXT` varchar(500) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `URGENT` varchar(20) DEFAULT NULL,
  `CREATEUSER` varchar(50) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `CTEATE_DATE` date DEFAULT NULL,
  `CURRENT_NODE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of CONTENT
-- ----------------------------
INSERT INTO `CONTENT` VALUES ('7', '测试流程', '测试微信小程序客户端添加内容', 'notice', 'no', null, '0', '2020-01-13', null);
INSERT INTO `CONTENT` VALUES ('8', null, null, null, null, null, null, '2020-01-13', null);
INSERT INTO `CONTENT` VALUES ('9', '测试', '测试微信小程序添加', 'news', 'no', '5', '1', '2020-01-13', '1');
INSERT INTO `CONTENT` VALUES ('10', null, '测试微信小程序提交内容', 'notice', 'no', '5', '1', '2020-01-13', null);

-- ----------------------------
-- Table structure for ROLE
-- ----------------------------
DROP TABLE IF EXISTS `ROLE`;
CREATE TABLE `ROLE` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(40) DEFAULT NULL,
  `DESC` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ROLE
-- ----------------------------
INSERT INTO `ROLE` VALUES ('1', 'monitor', '班长');
INSERT INTO `ROLE` VALUES ('2', 'classMaster', '班主任');
INSERT INTO `ROLE` VALUES ('3', 'minister', '部长');
INSERT INTO `ROLE` VALUES ('4', 'director', '主任');
INSERT INTO `ROLE` VALUES ('5', 'sutdent', '学生');

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
-- Records of ROLE_TO_AUTH
-- ----------------------------
INSERT INTO `ROLE_TO_AUTH` VALUES ('1', '1', '1');
INSERT INTO `ROLE_TO_AUTH` VALUES ('1', '2', '1');
INSERT INTO `ROLE_TO_AUTH` VALUES ('1', '3', '1');
INSERT INTO `ROLE_TO_AUTH` VALUES ('1', '4', '1');

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

-- ----------------------------
-- Table structure for USER
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户',
  `USER_NAME` varchar(50) NOT NULL COMMENT '登录名',
  `USER_NO` bigint(20) NOT NULL COMMENT '学号/工号',
  `REAL_NAME` varchar(50) NOT NULL COMMENT '真实姓名',
  `PASSWORD` varchar(100) DEFAULT NULL COMMENT '密码',
  `SEX` int(11) DEFAULT NULL COMMENT '性别',
  `CLASS_NUM` int(11) DEFAULT NULL COMMENT '班级ID',
  `GARDE_ID` int(11) DEFAULT NULL COMMENT '年级ID',
  `EMAIL` varchar(20) DEFAULT NULL,
  `MOBILE` bigint(20) DEFAULT NULL,
  `TITLE` int(11) DEFAULT NULL COMMENT '职位',
  `IS_DEL` tinyint(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of USER
-- ----------------------------
INSERT INTO `USER` VALUES ('1', 'lisi', '2019001', '李四', '123456', '0', '17', '4', '888@ww.com', '18303412058', null, null);
INSERT INTO `USER` VALUES ('2', 'zhangsan1', '2019003', '张三三', '123456', '0', '18', '4', '987@qq.com', '18300983456', '1', null);
INSERT INTO `USER` VALUES ('3', 'zhaoliu', '2019004', '赵六六', '123456', '1', '17', '4', 'zhaoliu@ww.com', '19134521923', '2', null);
INSERT INTO `USER` VALUES ('4', 'liuneng', '2017002', '刘能', 'e10adc3949ba59abbe56e057f20f883e', '0', '26', '6', 'liuneng@ww.com', '18323452343', '1', null);
INSERT INTO `USER` VALUES ('5', 'zhangsan', '2019008', '张三', 'e10adc3949ba59abbe56e057f20f883e', '0', '17', '4', 'zhangsan@qq.com', '18309898909', '1', null);

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
-- Records of USER_TO_ROLE
-- ----------------------------
INSERT INTO `USER_TO_ROLE` VALUES ('1', '5', '1');
INSERT INTO `USER_TO_ROLE` VALUES ('2', '5', '2');
INSERT INTO `USER_TO_ROLE` VALUES ('3', '5', '3');
INSERT INTO `USER_TO_ROLE` VALUES ('4', '5', '4');

-- ----------------------------
-- Table structure for WF_DEF
-- ----------------------------
DROP TABLE IF EXISTS `WF_DEF`;
CREATE TABLE `WF_DEF` (
  `NODE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NEXT_NODE` bigint(20) DEFAULT NULL,
  `PROCESS_ROLE` varchar(20) DEFAULT NULL COMMENT '当前节点处理的角色',
  `NODE_DESC` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`NODE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='工作流定义';

-- ----------------------------
-- Records of WF_DEF
-- ----------------------------
INSERT INTO `WF_DEF` VALUES ('1', '2', 'monitor', '心理委员上报');
INSERT INTO `WF_DEF` VALUES ('2', '3', 'classMaster', '班主任审批');
INSERT INTO `WF_DEF` VALUES ('3', '4', 'minister', '部长审批');
INSERT INTO `WF_DEF` VALUES ('4', null, 'director', '系主任审批');

-- ----------------------------
-- Table structure for WF_INSTANCE
-- ----------------------------
DROP TABLE IF EXISTS `WF_INSTANCE`;
CREATE TABLE `WF_INSTANCE` (
  `INSTANCE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATE_DATE` date DEFAULT NULL,
  `NODE_ID` bigint(20) DEFAULT NULL,
  `BIZ_ID` bigint(20) DEFAULT NULL COMMENT '业务ID',
  `CREATEUSER` bigint(20) DEFAULT NULL,
  `OPINION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`INSTANCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='工作流实例';

-- ----------------------------
-- Records of WF_INSTANCE
-- ----------------------------
INSERT INTO `WF_INSTANCE` VALUES ('2', '2020-01-13', '1', '9', '5', null);
INSERT INTO `WF_INSTANCE` VALUES ('3', '2020-01-13', '1', '1', '5', null);