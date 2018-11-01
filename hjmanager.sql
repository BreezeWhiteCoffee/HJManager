/*
MySQL Data Transfer
Source Host: localhost
Source Database: hjmanager
Target Host: localhost
Target Database: hjmanager
Date: 2018/9/30 17:04:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for logs
-- ----------------------------
CREATE TABLE `logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=276 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Table structure for orders
-- ----------------------------
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `employeename` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '员工名称',
  `articlenumber` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '货物号',
  `createTime` datetime DEFAULT NULL COMMENT '订单创建时间',
  `money` double(50,2) unsigned zerofill DEFAULT NULL COMMENT '订单总金额',
  `amount` int(50) DEFAULT NULL COMMENT '货物数量',
  `store_id` int(20) DEFAULT NULL COMMENT '门店id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for product
-- ----------------------------
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articlenumber` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `gender` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `season` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `price` double(20,0) DEFAULT NULL,
  `saleprice` double(20,0) DEFAULT NULL,
  `color` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `Purchasetime` datetime DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
CREATE TABLE `roles` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `permission` varchar(50) DEFAULT NULL COMMENT '角色权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stores
-- ----------------------------
CREATE TABLE `stores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `store_id` int(11) unsigned NOT NULL COMMENT '用户门店id',
  `store_name` varchar(100) DEFAULT NULL COMMENT '门店具体信息',
  `store_address` varchar(100) DEFAULT NULL COMMENT '门店地址',
  `createTime` datetime DEFAULT NULL COMMENT '门店创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '门店信息修改时间',
  `store_telephone` varchar(50) DEFAULT NULL COMMENT '门店座机电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
CREATE TABLE `users` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',
  `gender` varchar(50) DEFAULT NULL COMMENT '性别',
  `age` int(20) DEFAULT NULL COMMENT '年龄',
  `mobile` varchar(100) DEFAULT NULL COMMENT '电话号码',
  `salary` int(20) DEFAULT NULL COMMENT '工资',
  `store_id` int(20) DEFAULT NULL COMMENT '用户所在门店信息',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `logs` VALUES ('41', 'admin', 'findObjects', '{, 1}', '41', '0:0:0:0:0:0:0:1', '2018-09-24 15:35:00');
INSERT INTO `logs` VALUES ('42', 'admin', 'doFindObjectById', '{24}', '9', '0:0:0:0:0:0:0:1', '2018-09-24 15:35:06');
INSERT INTO `logs` VALUES ('43', 'admin', 'findObjects', '{, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-24 15:35:12');
INSERT INTO `logs` VALUES ('44', 'admin', 'findObjects', '{, 1}', '38', '0:0:0:0:0:0:0:1', '2018-09-24 15:36:15');
INSERT INTO `logs` VALUES ('45', 'admin', 'doFindObjectById', '{24}', '11', '0:0:0:0:0:0:0:1', '2018-09-24 15:36:21');
INSERT INTO `logs` VALUES ('46', 'admin', 'findObjects', '{, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-24 15:36:24');
INSERT INTO `logs` VALUES ('47', 'admin', 'findObjects', '{, 1}', '34', '0:0:0:0:0:0:0:1', '2018-09-24 15:37:41');
INSERT INTO `logs` VALUES ('48', 'admin', 'doFindObjectById', '{24}', '5', '0:0:0:0:0:0:0:1', '2018-09-24 15:37:43');
INSERT INTO `logs` VALUES ('49', 'admin', 'findObjects', '{, 1}', '3', '0:0:0:0:0:0:0:1', '2018-09-24 15:37:46');
INSERT INTO `logs` VALUES ('50', 'admin', 'doFindObjectById', '{24}', '8', '0:0:0:0:0:0:0:1', '2018-09-24 15:38:45');
INSERT INTO `logs` VALUES ('51', 'admin', 'findObjects', '{, 1}', '31', '0:0:0:0:0:0:0:1', '2018-09-24 15:43:55');
INSERT INTO `logs` VALUES ('52', 'admin', 'findObjects', '{, 1}', '177', '0:0:0:0:0:0:0:1', '2018-09-25 08:26:32');
INSERT INTO `logs` VALUES ('53', 'admin', 'findObjects', '{, 1}', '32', '0:0:0:0:0:0:0:1', '2018-09-25 11:49:20');
INSERT INTO `logs` VALUES ('54', 'admin', 'findObjects', '{, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-25 11:53:28');
INSERT INTO `logs` VALUES ('55', 'admin', 'findObjects', '{, 1}', '3', '0:0:0:0:0:0:0:1', '2018-09-25 11:54:35');
INSERT INTO `logs` VALUES ('56', 'admin', 'findObjects', '{, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-25 11:55:02');
INSERT INTO `logs` VALUES ('57', 'admin', 'findObjects', '{, 1}', '30', '0:0:0:0:0:0:0:1', '2018-09-25 14:38:01');
INSERT INTO `logs` VALUES ('58', 'admin', 'findObjects', '{, 1}', '3', '0:0:0:0:0:0:0:1', '2018-09-25 14:39:39');
INSERT INTO `logs` VALUES ('59', 'admin', 'findObjects', '{, 1}', '6', '0:0:0:0:0:0:0:1', '2018-09-25 14:46:26');
INSERT INTO `logs` VALUES ('60', 'admin', 'findObjects', '{, 1}', '3', '0:0:0:0:0:0:0:1', '2018-09-25 14:47:17');
INSERT INTO `logs` VALUES ('61', 'admin', 'findObjects', '{, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-25 14:47:44');
INSERT INTO `logs` VALUES ('62', 'admin', 'findObjects', '{, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-25 14:48:46');
INSERT INTO `logs` VALUES ('63', 'admin', 'findObjects', '{, 1}', '6', '0:0:0:0:0:0:0:1', '2018-09-25 14:51:10');
INSERT INTO `logs` VALUES ('64', 'admin', 'findObjects', '{, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-25 14:54:17');
INSERT INTO `logs` VALUES ('65', 'admin', 'findObjects', '{, 1}', '30', '0:0:0:0:0:0:0:1', '2018-09-25 15:00:54');
INSERT INTO `logs` VALUES ('66', 'admin', 'findObjects', '{, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-25 15:04:14');
INSERT INTO `logs` VALUES ('67', 'admin', 'findObjects', '{, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-25 15:07:59');
INSERT INTO `logs` VALUES ('68', 'admin', 'findObjects', '{, 1}', '27', '0:0:0:0:0:0:0:1', '2018-09-25 15:10:46');
INSERT INTO `logs` VALUES ('69', 'admin', 'FindPageObjectsByStoreId', '{4, 1}', '6', '0:0:0:0:0:0:0:1', '2018-09-25 15:10:51');
INSERT INTO `logs` VALUES ('70', 'admin', 'findObjects', '{, 1}', '26', '0:0:0:0:0:0:0:1', '2018-09-25 15:14:49');
INSERT INTO `logs` VALUES ('71', 'admin', 'findObjects', '{, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-25 15:15:39');
INSERT INTO `logs` VALUES ('72', 'admin', 'findObjects', '{, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-25 15:16:46');
INSERT INTO `logs` VALUES ('73', 'admin', 'findObjects', '{, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-25 15:17:09');
INSERT INTO `logs` VALUES ('74', 'admin', 'findObjects', '{, 1}', '2', '0:0:0:0:0:0:0:1', '2018-09-25 15:22:40');
INSERT INTO `logs` VALUES ('76', 'admin', 'findObjects', '{, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-25 15:23:58');
INSERT INTO `logs` VALUES ('77', 'admin', 'findObjects', '{, 1}', '33', '0:0:0:0:0:0:0:1', '2018-09-25 15:56:24');
INSERT INTO `logs` VALUES ('78', 'admin', 'findObjects', '{, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-25 15:57:33');
INSERT INTO `logs` VALUES ('99', 'admin', 'findObjects', '{, 1}', '36', '0:0:0:0:0:0:0:1', '2018-09-25 21:02:32');
INSERT INTO `logs` VALUES ('100', 'zhaoqing', 'findObjects', '{zhaoqing, 1}', '119', '0:0:0:0:0:0:0:1', '2018-09-26 10:39:04');
INSERT INTO `logs` VALUES ('101', 'zhaoqing', 'findObjects', '{, 1}', '10', '0:0:0:0:0:0:0:1', '2018-09-26 10:39:25');
INSERT INTO `logs` VALUES ('102', 'zhaoqing', 'findObjects', '{zhaoqing, 1}', '3', '0:0:0:0:0:0:0:1', '2018-09-26 10:42:24');
INSERT INTO `logs` VALUES ('103', 'zhaoqing', 'findObjects', '{zhaoqing, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-26 10:43:27');
INSERT INTO `logs` VALUES ('104', 'zhaoqing', 'findObjects', '{zhaoqing, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 10:44:38');
INSERT INTO `logs` VALUES ('105', 'zhaoqing', 'findObjects', '{zhaoqing, 1}', '3', '0:0:0:0:0:0:0:1', '2018-09-26 10:45:12');
INSERT INTO `logs` VALUES ('106', 'admin', 'findObjects', '{admin, 1}', '60', '0:0:0:0:0:0:0:1', '2018-09-26 10:45:56');
INSERT INTO `logs` VALUES ('107', 'zhaoqing', 'findObjects', '{zhaoqing, 1}', '62', '0:0:0:0:0:0:0:1', '2018-09-26 10:49:19');
INSERT INTO `logs` VALUES ('108', 'zhaoqing', 'findObjects', '{, 1}', '6', '0:0:0:0:0:0:0:1', '2018-09-26 10:53:08');
INSERT INTO `logs` VALUES ('109', 'admin', 'findObjects', '{admin, 1}', '78', '0:0:0:0:0:0:0:1', '2018-09-26 10:58:06');
INSERT INTO `logs` VALUES ('110', 'admin', 'findObjects', '{, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 10:58:20');
INSERT INTO `logs` VALUES ('111', 'admin', 'doFindObjectById', '{25}', '17', '0:0:0:0:0:0:0:1', '2018-09-26 10:58:34');
INSERT INTO `logs` VALUES ('112', 'admin', 'findObjects', '{, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 10:58:46');
INSERT INTO `logs` VALUES ('113', 'admin', 'findObjects', '{admin, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-26 10:58:58');
INSERT INTO `logs` VALUES ('114', 'admin', 'findObjects', '{, 1}', '13', '0:0:0:0:0:0:0:1', '2018-09-26 10:59:05');
INSERT INTO `logs` VALUES ('115', 'admin', 'doFindObjectById', '{25}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 10:59:08');
INSERT INTO `logs` VALUES ('116', 'admin', 'doUpdateObject', '{SysUser [id=25, username=pengbosheng, password=null, salt=null, gender=男, age=30, mobile=13026393016, salary=10000, storeId=4, createTime=null, modifiedTime=null, sysRole=null], 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 10:59:32');
INSERT INTO `logs` VALUES ('117', 'admin', 'doUpdateObject', '{SysUser [id=25, username=pengbosheng, password=null, salt=null, gender=男, age=30, mobile=13026393016, salary=10000, storeId=4, createTime=null, modifiedTime=null, sysRole=null], 1}', '2', '0:0:0:0:0:0:0:1', '2018-09-26 10:59:32');
INSERT INTO `logs` VALUES ('118', 'admin', 'findObjects', '{, 1}', '9', '0:0:0:0:0:0:0:1', '2018-09-26 10:59:36');
INSERT INTO `logs` VALUES ('119', 'admin', 'findObjects', '{, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 10:59:36');
INSERT INTO `logs` VALUES ('120', 'pengbosheng', 'findObjects', '{pengbosheng, 1}', '80', '0:0:0:0:0:0:0:1', '2018-09-26 11:18:32');
INSERT INTO `logs` VALUES ('121', 'pengbosheng', 'findObjects', '{, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 11:18:40');
INSERT INTO `logs` VALUES ('122', 'pengbosheng', 'findObjects', '{, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 11:18:51');
INSERT INTO `logs` VALUES ('123', 'pengbosheng', 'findObjects', '{, 1}', '16', '0:0:0:0:0:0:0:1', '2018-09-26 11:19:28');
INSERT INTO `logs` VALUES ('124', 'admin', 'findObjects', '{admin, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 11:20:59');
INSERT INTO `logs` VALUES ('125', 'admin', 'findObjects', '{admin, 1}', '68', '0:0:0:0:0:0:0:1', '2018-09-26 11:22:22');
INSERT INTO `logs` VALUES ('126', 'admin', 'findObjects', '{admin, 1}', '92', '0:0:0:0:0:0:0:1', '2018-09-26 11:38:50');
INSERT INTO `logs` VALUES ('127', 'admin', 'findObjects', '{, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 11:39:03');
INSERT INTO `logs` VALUES ('128', 'admin', 'findObjects', '{admin, 1}', '60', '0:0:0:0:0:0:0:1', '2018-09-26 11:49:21');
INSERT INTO `logs` VALUES ('129', 'admin', 'findObjects', '{admin, 1}', '61', '0:0:0:0:0:0:0:1', '2018-09-26 11:50:52');
INSERT INTO `logs` VALUES ('130', 'admin', 'findObjects', '{admin, 1}', '87', '0:0:0:0:0:0:0:1', '2018-09-26 11:52:14');
INSERT INTO `logs` VALUES ('131', 'admin', 'findObjects', '{, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 11:52:22');
INSERT INTO `logs` VALUES ('132', 'admin', 'findObjects', '{, 1}', '6', '0:0:0:0:0:0:0:1', '2018-09-26 11:52:32');
INSERT INTO `logs` VALUES ('133', 'admin', 'findObjects', '{admin, 1}', '69', '0:0:0:0:0:0:0:1', '2018-09-26 11:54:21');
INSERT INTO `logs` VALUES ('134', 'admin', 'findObjects', '{admin, 1}', '63', '0:0:0:0:0:0:0:1', '2018-09-26 12:25:36');
INSERT INTO `logs` VALUES ('135', 'admin', 'findObjects', '{admin, 1}', '62', '0:0:0:0:0:0:0:1', '2018-09-26 12:27:44');
INSERT INTO `logs` VALUES ('136', 'admin', 'findObjects', '{admin, 1}', '84', '0:0:0:0:0:0:0:1', '2018-09-26 12:28:59');
INSERT INTO `logs` VALUES ('137', 'admin', 'findObjects', '{admin, 1}', '63', '0:0:0:0:0:0:0:1', '2018-09-26 12:31:01');
INSERT INTO `logs` VALUES ('138', 'admin', 'findObjects', '{admin, 1}', '60', '0:0:0:0:0:0:0:1', '2018-09-26 12:34:10');
INSERT INTO `logs` VALUES ('139', 'admin', 'findObjects', '{admin, 1}', '66', '0:0:0:0:0:0:0:1', '2018-09-26 12:37:16');
INSERT INTO `logs` VALUES ('140', 'admin', 'findObjects', '{admin, 1}', '63', '0:0:0:0:0:0:0:1', '2018-09-26 12:39:25');
INSERT INTO `logs` VALUES ('141', 'admin', 'findObjects', '{admin, 1}', '85', '0:0:0:0:0:0:0:1', '2018-09-26 12:41:55');
INSERT INTO `logs` VALUES ('142', 'admin', 'findObjects', '{admin, 1}', '57', '0:0:0:0:0:0:0:1', '2018-09-26 13:19:44');
INSERT INTO `logs` VALUES ('143', 'admin', 'findObjects', '{admin, 1}', '85', '0:0:0:0:0:0:0:1', '2018-09-26 13:26:12');
INSERT INTO `logs` VALUES ('144', 'admin', 'findObjects', '{admin, 1}', '93', '0:0:0:0:0:0:0:1', '2018-09-26 13:27:09');
INSERT INTO `logs` VALUES ('145', 'admin', 'findObjects', '{admin, 1}', '61', '0:0:0:0:0:0:0:1', '2018-09-26 13:37:25');
INSERT INTO `logs` VALUES ('146', 'admin', 'findObjects', '{admin, 1}', '81', '0:0:0:0:0:0:0:1', '2018-09-26 13:40:44');
INSERT INTO `logs` VALUES ('147', 'admin', 'findObjects', '{admin, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-26 13:49:33');
INSERT INTO `logs` VALUES ('148', 'admin', 'findObjects', '{admin, 1}', '56', '0:0:0:0:0:0:0:1', '2018-09-26 13:52:47');
INSERT INTO `logs` VALUES ('149', 'admin', 'findObjects', '{admin, 1}', '87', '0:0:0:0:0:0:0:1', '2018-09-26 14:02:00');
INSERT INTO `logs` VALUES ('150', 'admin', 'findObjects', '{admin, 1}', '75', '0:0:0:0:0:0:0:1', '2018-09-26 14:04:53');
INSERT INTO `logs` VALUES ('151', 'admin', 'findObjects', '{admin, 1}', '86', '0:0:0:0:0:0:0:1', '2018-09-26 14:10:52');
INSERT INTO `logs` VALUES ('152', 'admin', 'saveObject', '{SysUser [id=29, username=张海贝, password=424c2d04324b8793b98dd63773e3606f, salt=b1dbf4e7-cda6-40f8-bdec-dab09ad1f4b6, gender=男, age=29, mobile=18236625281, salary=3000, storeId=4, createTime=null, modifiedTime=null, sysRole=null], 2}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 14:12:44');
INSERT INTO `logs` VALUES ('153', 'admin', 'findObjects', '{, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 14:12:45');
INSERT INTO `logs` VALUES ('154', 'admin', 'doFindObjectById', '{29}', '3', '0:0:0:0:0:0:0:1', '2018-09-26 14:12:50');
INSERT INTO `logs` VALUES ('155', 'admin', 'doUpdateObject', '{SysUser [id=29, username=张海贝, password=null, salt=null, gender=男, age=29, mobile=18236625281, salary=300, storeId=4, createTime=null, modifiedTime=null, sysRole=null], 2}', '2', '0:0:0:0:0:0:0:1', '2018-09-26 14:12:59');
INSERT INTO `logs` VALUES ('156', 'admin', 'findObjects', '{, 1}', '10', '0:0:0:0:0:0:0:1', '2018-09-26 14:13:01');
INSERT INTO `logs` VALUES ('157', 'admin', 'doDeleteObjects', '{26}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 14:13:12');
INSERT INTO `logs` VALUES ('158', 'admin', 'findObjects', '{, 1}', '6', '0:0:0:0:0:0:0:1', '2018-09-26 14:13:12');
INSERT INTO `logs` VALUES ('159', 'admin', 'findObjects', '{, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 14:14:35');
INSERT INTO `logs` VALUES ('160', 'admin', 'findObjects', '{, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 14:14:53');
INSERT INTO `logs` VALUES ('161', 'admin', 'findObjects', '{, 1}', '9', '0:0:0:0:0:0:0:1', '2018-09-26 14:14:57');
INSERT INTO `logs` VALUES ('162', 'admin', 'findObjects', '{, 1}', '11', '0:0:0:0:0:0:0:1', '2018-09-26 14:15:04');
INSERT INTO `logs` VALUES ('163', 'admin', 'findObjects', '{, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 14:16:56');
INSERT INTO `logs` VALUES ('164', 'admin', 'findObjects', '{admin, 1}', '60', '0:0:0:0:0:0:0:1', '2018-09-26 14:19:30');
INSERT INTO `logs` VALUES ('165', 'admin', 'findObjects', '{admin, 1}', '58', '0:0:0:0:0:0:0:1', '2018-09-26 14:21:24');
INSERT INTO `logs` VALUES ('166', 'admin', 'findObjects', '{admin, 1}', '57', '0:0:0:0:0:0:0:1', '2018-09-26 14:22:39');
INSERT INTO `logs` VALUES ('167', 'admin', 'findObjects', '{admin, 1}', '71', '0:0:0:0:0:0:0:1', '2018-09-26 14:29:53');
INSERT INTO `logs` VALUES ('168', 'admin', 'findObjects', '{admin, 1}', '89', '0:0:0:0:0:0:0:1', '2018-09-26 14:33:15');
INSERT INTO `logs` VALUES ('169', 'admin', 'findObjects', '{admin, 1}', '66', '0:0:0:0:0:0:0:1', '2018-09-26 14:40:51');
INSERT INTO `logs` VALUES ('170', 'admin', 'findObjects', '{admin, 1}', '10', '0:0:0:0:0:0:0:1', '2018-09-26 14:44:38');
INSERT INTO `logs` VALUES ('171', 'admin', 'findObjects', '{admin, 1}', '61', '0:0:0:0:0:0:0:1', '2018-09-26 14:46:18');
INSERT INTO `logs` VALUES ('172', 'admin', 'findObjects', '{admin, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-26 14:48:22');
INSERT INTO `logs` VALUES ('173', 'admin', 'findObjects', '{admin, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 14:48:30');
INSERT INTO `logs` VALUES ('174', 'admin', 'findObjects', '{admin, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 14:50:11');
INSERT INTO `logs` VALUES ('175', 'admin', 'findObjects', '{admin, 1}', '70', '0:0:0:0:0:0:0:1', '2018-09-26 14:50:39');
INSERT INTO `logs` VALUES ('176', 'admin', 'findObjects', '{admin, 1}', '69', '0:0:0:0:0:0:0:1', '2018-09-26 14:53:12');
INSERT INTO `logs` VALUES ('177', 'admin', 'findObjects', '{admin, 1}', '59', '0:0:0:0:0:0:0:1', '2018-09-26 14:54:33');
INSERT INTO `logs` VALUES ('178', 'admin', 'findObjects', '{admin, 1}', '58', '0:0:0:0:0:0:0:1', '2018-09-26 15:00:43');
INSERT INTO `logs` VALUES ('179', 'admin', 'findObjects', '{admin, 1}', '67', '0:0:0:0:0:0:0:1', '2018-09-26 15:03:28');
INSERT INTO `logs` VALUES ('180', 'admin', 'findObjects', '{admin, 1}', '61', '0:0:0:0:0:0:0:1', '2018-09-26 15:05:12');
INSERT INTO `logs` VALUES ('181', 'admin', 'findObjects', '{admin, 1}', '84', '0:0:0:0:0:0:0:1', '2018-09-26 15:09:17');
INSERT INTO `logs` VALUES ('182', 'admin', 'findObjects', '{admin, 1}', '62', '0:0:0:0:0:0:0:1', '2018-09-26 15:12:27');
INSERT INTO `logs` VALUES ('183', 'admin', 'findObjects', '{admin, 1}', '58', '0:0:0:0:0:0:0:1', '2018-09-26 15:17:52');
INSERT INTO `logs` VALUES ('184', 'admin', 'findObjects', '{admin, 1}', '65', '0:0:0:0:0:0:0:1', '2018-09-26 15:21:11');
INSERT INTO `logs` VALUES ('185', 'admin', 'findObjects', '{admin, 1}', '76', '0:0:0:0:0:0:0:1', '2018-09-26 15:23:31');
INSERT INTO `logs` VALUES ('186', 'admin', 'findObjects', '{, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 15:24:16');
INSERT INTO `logs` VALUES ('187', 'admin', 'saveObject', '{SysUser [id=30, username=zhanghaibei, password=2844f20e545ede6254167a2e31bc174a, salt=d6fa88d4-c59c-4736-b573-2dae0b513a10, gender=男, age=29, mobile=1823665223, salary=300, storeId=4, createTime=null, modifiedTime=null, sysRole=null], 2}', '6', '0:0:0:0:0:0:0:1', '2018-09-26 15:24:59');
INSERT INTO `logs` VALUES ('188', 'admin', 'findObjects', '{, 1}', '10', '0:0:0:0:0:0:0:1', '2018-09-26 15:25:01');
INSERT INTO `logs` VALUES ('189', 'admin', 'doFindObjectById', '{30}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 15:25:07');
INSERT INTO `logs` VALUES ('190', 'admin', 'doUpdateObject', '{SysUser [id=30, username=zhanghaibei, password=null, salt=null, gender=男, age=29, mobile=1823665223, salary=3000, storeId=4, createTime=null, modifiedTime=null, sysRole=null], 2}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 15:25:13');
INSERT INTO `logs` VALUES ('191', 'admin', 'findObjects', '{, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 15:25:16');
INSERT INTO `logs` VALUES ('192', 'admin', 'doDeleteObjects', '{30}', '32', '0:0:0:0:0:0:0:1', '2018-09-26 15:25:23');
INSERT INTO `logs` VALUES ('193', 'admin', 'findObjects', '{, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 15:25:23');
INSERT INTO `logs` VALUES ('194', 'admin', 'findObjects', '{王五, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 15:25:28');
INSERT INTO `logs` VALUES ('195', 'admin', 'findObjects', '{admin, 1}', '64', '0:0:0:0:0:0:0:1', '2018-09-26 15:58:22');
INSERT INTO `logs` VALUES ('196', 'admin', 'findObjects', '{admin, 1}', '75', '0:0:0:0:0:0:0:1', '2018-09-26 16:13:48');
INSERT INTO `logs` VALUES ('197', 'admin', 'findObjects', '{admin, 1}', '70', '0:0:0:0:0:0:0:1', '2018-09-26 16:16:08');
INSERT INTO `logs` VALUES ('198', 'admin', 'findObjects', '{admin, 1}', '59', '0:0:0:0:0:0:0:1', '2018-09-26 16:25:22');
INSERT INTO `logs` VALUES ('199', 'admin', 'findObjects', '{admin, 1}', '61', '0:0:0:0:0:0:0:1', '2018-09-26 16:28:22');
INSERT INTO `logs` VALUES ('200', 'admin', 'findObjects', '{admin, 1}', '56', '0:0:0:0:0:0:0:1', '2018-09-26 16:30:58');
INSERT INTO `logs` VALUES ('201', 'admin', 'findObjects', '{admin, 1}', '61', '0:0:0:0:0:0:0:1', '2018-09-26 16:36:32');
INSERT INTO `logs` VALUES ('202', 'admin', 'findObjects', '{admin, 1}', '3', '0:0:0:0:0:0:0:1', '2018-09-26 16:39:57');
INSERT INTO `logs` VALUES ('203', 'admin', 'findObjects', '{admin, 1}', '77', '0:0:0:0:0:0:0:1', '2018-09-26 16:41:12');
INSERT INTO `logs` VALUES ('204', 'admin', 'findObjects', '{admin, 1}', '9', '0:0:0:0:0:0:0:1', '2018-09-26 16:42:22');
INSERT INTO `logs` VALUES ('205', 'admin', 'findObjects', '{admin, 1}', '61', '0:0:0:0:0:0:0:1', '2018-09-26 16:42:59');
INSERT INTO `logs` VALUES ('206', 'admin', 'findObjects', '{admin, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 16:43:44');
INSERT INTO `logs` VALUES ('207', 'admin', 'findObjects', '{admin, 1}', '61', '0:0:0:0:0:0:0:1', '2018-09-26 16:45:10');
INSERT INTO `logs` VALUES ('208', 'admin', 'findObjects', '{admin, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 16:46:10');
INSERT INTO `logs` VALUES ('209', 'admin', 'findObjects', '{admin, 1}', '70', '0:0:0:0:0:0:0:1', '2018-09-26 16:47:44');
INSERT INTO `logs` VALUES ('210', 'admin', 'findObjects', '{admin, 1}', '56', '0:0:0:0:0:0:0:1', '2018-09-26 16:52:10');
INSERT INTO `logs` VALUES ('211', 'admin', 'findObjects', '{admin, 1}', '65', '0:0:0:0:0:0:0:1', '2018-09-26 16:57:23');
INSERT INTO `logs` VALUES ('212', 'admin', 'findObjects', '{admin, 1}', '70', '0:0:0:0:0:0:0:1', '2018-09-26 17:15:33');
INSERT INTO `logs` VALUES ('213', 'admin', 'findObjects', '{admin, 1}', '16', '0:0:0:0:0:0:0:1', '2018-09-26 17:16:03');
INSERT INTO `logs` VALUES ('214', 'admin', 'findObjects', '{admin, 1}', '6', '0:0:0:0:0:0:0:1', '2018-09-26 17:17:22');
INSERT INTO `logs` VALUES ('215', 'admin', 'findObjects', '{admin, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 17:17:23');
INSERT INTO `logs` VALUES ('216', 'admin', 'findObjects', '{admin, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 17:17:23');
INSERT INTO `logs` VALUES ('217', 'admin', 'findObjects', '{admin, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 17:17:24');
INSERT INTO `logs` VALUES ('218', 'admin', 'findObjects', '{admin, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 17:17:28');
INSERT INTO `logs` VALUES ('219', 'admin', 'findObjects', '{admin, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 17:17:34');
INSERT INTO `logs` VALUES ('220', 'admin', 'findObjects', '{admin, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-26 17:19:07');
INSERT INTO `logs` VALUES ('221', 'admin', 'findObjects', '{admin, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 17:19:08');
INSERT INTO `logs` VALUES ('222', 'admin', 'findObjects', '{admin, 1}', '12', '0:0:0:0:0:0:0:1', '2018-09-26 17:19:09');
INSERT INTO `logs` VALUES ('223', 'admin', 'findObjects', '{admin, 1}', '61', '0:0:0:0:0:0:0:1', '2018-09-26 17:40:42');
INSERT INTO `logs` VALUES ('224', 'admin', 'findObjects', '{admin, 1}', '69', '0:0:0:0:0:0:0:1', '2018-09-26 17:42:12');
INSERT INTO `logs` VALUES ('225', 'admin', 'findObjects', '{admin, 1}', '57', '0:0:0:0:0:0:0:1', '2018-09-26 17:45:36');
INSERT INTO `logs` VALUES ('226', 'admin', 'findObjects', '{admin, 1}', '59', '0:0:0:0:0:0:0:1', '2018-09-26 17:47:22');
INSERT INTO `logs` VALUES ('227', 'admin', 'findObjects', '{, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 17:47:42');
INSERT INTO `logs` VALUES ('228', 'admin', 'findObjects', '{admin, 1}', '61', '0:0:0:0:0:0:0:1', '2018-09-26 18:36:10');
INSERT INTO `logs` VALUES ('229', 'admin', 'findObjects', '{, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-26 18:36:24');
INSERT INTO `logs` VALUES ('230', 'kobe', 'findObjects', '{kobe, 1}', '70', '0:0:0:0:0:0:0:1', '2018-09-26 19:01:09');
INSERT INTO `logs` VALUES ('231', 'kobe', 'findObjects', '{, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 19:01:20');
INSERT INTO `logs` VALUES ('232', 'kobe', 'findObjects', '{kobe, 1}', '13', '0:0:0:0:0:0:0:1', '2018-09-26 19:12:53');
INSERT INTO `logs` VALUES ('234', 'admin', 'findObjects', '{admin, 1}', '69', '178.10.140.181', '2018-09-26 19:34:17');
INSERT INTO `logs` VALUES ('235', 'admin', 'findObjects', '{, 1}', '8', '178.10.140.181', '2018-09-26 19:40:49');
INSERT INTO `logs` VALUES ('236', 'admin', 'saveObject', '{SysUser [id=31, username=zhangsan, password=ec700f93f41ca49d973dde034971e355, salt=b316000e-e622-459f-a947-62e4949f26db, gender=男, age=22, mobile=1655522, salary=3000, storeId=4, createTime=null, modifiedTime=null, sysRole=null], 1}', '11', '178.10.140.181', '2018-09-26 19:42:10');
INSERT INTO `logs` VALUES ('237', 'admin', 'findObjects', '{, 1}', '6', '178.10.140.181', '2018-09-26 19:42:12');
INSERT INTO `logs` VALUES ('238', 'admin', 'findObjects', '{, 1}', '13', '178.10.140.181', '2018-09-26 19:42:53');
INSERT INTO `logs` VALUES ('239', 'zhangsan', 'findObjects', '{zhangsan, 1}', '9', '178.10.140.181', '2018-09-26 19:43:46');
INSERT INTO `logs` VALUES ('240', 'zhangsan', 'findObjects', '{, 1}', '5', '178.10.140.181', '2018-09-26 19:44:09');
INSERT INTO `logs` VALUES ('241', 'zhangsan', 'findObjects', '{, 1}', '4', '178.10.140.181', '2018-09-26 19:44:15');
INSERT INTO `logs` VALUES ('242', 'admin', 'findObjects', '{admin, 1}', '63', '0:0:0:0:0:0:0:1', '2018-09-26 19:55:26');
INSERT INTO `logs` VALUES ('243', 'admin', 'findObjects', '{admin, 1}', '56', '0:0:0:0:0:0:0:1', '2018-09-26 20:49:15');
INSERT INTO `logs` VALUES ('244', 'admin', 'findObjects', '{, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 21:20:47');
INSERT INTO `logs` VALUES ('245', 'admin', 'findObjects', '{, 1}', '12', '0:0:0:0:0:0:0:1', '2018-09-26 21:20:50');
INSERT INTO `logs` VALUES ('246', 'admin', 'findObjects', '{, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-26 21:20:55');
INSERT INTO `logs` VALUES ('247', 'admin', 'findObjects', '{, 1}', '10', '0:0:0:0:0:0:0:1', '2018-09-26 21:20:57');
INSERT INTO `logs` VALUES ('248', 'admin', 'findObjects', '{, 1}', '12', '0:0:0:0:0:0:0:1', '2018-09-26 21:22:01');
INSERT INTO `logs` VALUES ('249', 'admin', 'findObjects', '{admin, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-26 21:27:03');
INSERT INTO `logs` VALUES ('250', 'admin', 'findObjects', '{admin, 1}', '59', '0:0:0:0:0:0:0:1', '2018-09-26 21:59:29');
INSERT INTO `logs` VALUES ('251', 'admin', 'findObjects', '{, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 22:09:01');
INSERT INTO `logs` VALUES ('252', 'admin', 'findObjects', '{, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-26 22:09:05');
INSERT INTO `logs` VALUES ('253', 'admin', 'findObjects', '{, 1}', '14', '0:0:0:0:0:0:0:1', '2018-09-26 22:09:09');
INSERT INTO `logs` VALUES ('254', 'admin', 'doFindObjectById', '{31}', '6', '0:0:0:0:0:0:0:1', '2018-09-26 22:09:11');
INSERT INTO `logs` VALUES ('255', 'admin', 'findObjects', '{admin, 1}', '69', '0:0:0:0:0:0:0:1', '2018-09-27 09:47:04');
INSERT INTO `logs` VALUES ('256', 'admin', 'findObjects', '{admin, 1}', '12', '0:0:0:0:0:0:0:1', '2018-09-27 09:47:06');
INSERT INTO `logs` VALUES ('257', 'admin', 'findObjects', '{admin, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-27 09:47:07');
INSERT INTO `logs` VALUES ('258', 'admin', 'findObjects', '{admin, 1}', '6', '0:0:0:0:0:0:0:1', '2018-09-27 09:47:10');
INSERT INTO `logs` VALUES ('259', 'admin', 'findObjects', '{admin, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-27 09:47:15');
INSERT INTO `logs` VALUES ('260', 'admin', 'findObjects', '{admin, 1}', '7', '0:0:0:0:0:0:0:1', '2018-09-27 09:47:23');
INSERT INTO `logs` VALUES ('261', 'admin', 'findObjects', '{, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-27 09:47:35');
INSERT INTO `logs` VALUES ('262', 'admin', 'findObjects', '{admin, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-27 09:49:32');
INSERT INTO `logs` VALUES ('263', 'admin', 'findObjects', '{admin, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-27 09:49:41');
INSERT INTO `logs` VALUES ('264', 'admin', 'findObjects', '{admin, 1}', '60', '0:0:0:0:0:0:0:1', '2018-09-27 09:50:45');
INSERT INTO `logs` VALUES ('265', 'admin', 'findObjects', '{admin, 1}', '8', '0:0:0:0:0:0:0:1', '2018-09-27 10:13:23');
INSERT INTO `logs` VALUES ('266', 'admin', 'findObjects', '{, 1}', '5', '0:0:0:0:0:0:0:1', '2018-09-27 10:13:52');
INSERT INTO `logs` VALUES ('267', 'admin', 'findObjects', '{, 1}', '10', '0:0:0:0:0:0:0:1', '2018-09-27 10:14:01');
INSERT INTO `logs` VALUES ('268', 'admin', 'findObjects', '{, 1}', '10', '0:0:0:0:0:0:0:1', '2018-09-27 10:14:08');
INSERT INTO `logs` VALUES ('269', 'admin', 'findObjects', '{, 1}', '6', '0:0:0:0:0:0:0:1', '2018-09-27 10:14:16');
INSERT INTO `logs` VALUES ('270', 'admin', 'findObjects', '{, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-27 10:14:22');
INSERT INTO `logs` VALUES ('271', 'admin', 'findObjects', '{, 1}', '16', '0:0:0:0:0:0:0:1', '2018-09-27 10:14:25');
INSERT INTO `logs` VALUES ('272', 'admin', 'findObjects', '{admin, 1}', '4', '0:0:0:0:0:0:0:1', '2018-09-27 10:18:31');
INSERT INTO `logs` VALUES ('273', 'admin', 'findObjects', '{admin, 1}', '55', '0:0:0:0:0:0:0:1', '2018-09-27 10:37:42');
INSERT INTO `logs` VALUES ('274', 'admin', 'findObjects', '{admin, 1}', '78', '0:0:0:0:0:0:0:1', '2018-09-27 11:00:32');
INSERT INTO `logs` VALUES ('275', 'admin', 'findObjects', '{admin, 1}', '84', '0:0:0:0:0:0:0:1', '2018-09-27 11:05:07');
INSERT INTO `orders` VALUES ('1', '张三', 'G00001', '2018-09-25 18:31:35', '00000000000000000000000000000000000000000000231.30', '2', '4');
INSERT INTO `orders` VALUES ('2', '李四', 'G00002', '2018-09-25 18:32:24', '00000000000000000000000000000000000000000000354.30', '4', '1');
INSERT INTO `orders` VALUES ('3', '王五', 'G00003', '2018-09-25 18:36:38', '00000000000000000000000000000000000000000000362.21', '1', '1');
INSERT INTO `orders` VALUES ('4', '张三', 'G00003', '2018-09-25 18:44:08', '00000000000000000000000000000000000000000000362.21', '3', '4');
INSERT INTO `orders` VALUES ('22', 'zhaoqing', 'G85612', '2018-09-26 15:58:34', '00000000000000000000000000000000000000000012000.00', '20', '1');
INSERT INTO `orders` VALUES ('23', 'zhaoqing', 'G6522', '2018-09-26 16:03:55', '00000000000000000000000000000000000000000000600.00', '2', '1');
INSERT INTO `orders` VALUES ('24', 'zhaoqing', 'G6522', '2018-09-26 16:04:09', '00000000000000000000000000000000000000000000900.00', '3', '1');
INSERT INTO `orders` VALUES ('25', 'zhaoqing', 'G85612', '2018-09-26 16:04:22', '00000000000000000000000000000000000000000001800.00', '3', '1');
INSERT INTO `orders` VALUES ('26', 'zhaoqing', 'G85612', '2018-09-26 16:04:38', '00000000000000000000000000000000000000000001800.00', '3', '1');
INSERT INTO `orders` VALUES ('27', 'zhaoqing', 'G85612', '2018-09-26 16:04:38', '00000000000000000000000000000000000000000001800.00', '3', '1');
INSERT INTO `orders` VALUES ('29', 'zhaoqing ', 'G65221', '2018-09-26 21:07:14', '00000000000000000000000000000000000000000000362.00', '1', '1');
INSERT INTO `orders` VALUES ('30', 'zhaoqing', 'G8563', '2018-09-26 21:07:31', '00000000000000000000000000000000000000000000500.00', '1', '1');
INSERT INTO `orders` VALUES ('31', 'zhaoqing', 'G85624', '2018-09-26 21:07:45', '00000000000000000000000000000000000000000000300.00', '1', '1');
INSERT INTO `product` VALUES ('7', 'G6522', '女', '春', '20', '20', '300', 'BLUE', '2018-10-04 16:45:54', '292');
INSERT INTO `product` VALUES ('9', 'G85612', '男', '春', '23', '200', '600', '红色', '2018-09-14 16:45:59', '274');
INSERT INTO `product` VALUES ('10', 'G65221', '男', '春', '39', '22', '362', '蓝色', '2018-09-26 16:33:06', '232');
INSERT INTO `product` VALUES ('11', 'G8563', '男', '春', '30', '20', '500', '黑色', '2018-09-26 16:37:05', '19');
INSERT INTO `product` VALUES ('12', 'G85624', '男', '春', '20', '20', '300', '蓝', '2018-09-26 19:40:19', '21');
INSERT INTO `roles` VALUES ('1', '店员', '负责库存信息更新、打印订单', 'sys:employee');
INSERT INTO `roles` VALUES ('2', '店长', '负责员工信息、库存信息更新', 'sys:manager');
INSERT INTO `roles` VALUES ('3', '管理员', '负责门店的管理以及店长的增删改', 'sys:admin');
INSERT INTO `stores` VALUES ('1', '1', '北京华贸购物中心店', '北京市朝阳区建国路79号', '2018-09-25 16:58:03', null, '027-2547901');
INSERT INTO `stores` VALUES ('2', '2', '成都太古里店', '成都市中纱帽街8号', '2018-09-25 16:58:11', null, '027-2547902');
INSERT INTO `stores` VALUES ('3', '3', '南宁万象城店', ' 南宁市青秀区民族大道136号', '2018-09-25 16:58:14', null, '027-2547903');
INSERT INTO `stores` VALUES ('4', '4', '天津大悦城店', '天津市南开区南门外大街 2 号', '2018-09-25 16:58:17', null, '027-2547904');
INSERT INTO `user_role` VALUES ('2', '13', '1');
INSERT INTO `user_role` VALUES ('7', '18', '2');
INSERT INTO `user_role` VALUES ('8', '19', '1');
INSERT INTO `user_role` VALUES ('13', '24', '2');
INSERT INTO `user_role` VALUES ('14', '25', '1');
INSERT INTO `user_role` VALUES ('16', '27', '1');
INSERT INTO `user_role` VALUES ('17', '28', '1');
INSERT INTO `user_role` VALUES ('18', '29', '2');
INSERT INTO `user_role` VALUES ('20', '31', '1');
INSERT INTO `users` VALUES ('18', 'admin', '6bdf9869fde9f1e4fc52e659e7f2d6b4', '41f62501-6cb6-452d-b541-3919a1856de9', '男', '40', '13240449999', '15000', '4', '2018-09-24 14:10:33', '2018-09-24 14:10:33');
INSERT INTO `users` VALUES ('19', 'kobe', '8f73ffc8d667c464f8ec227c1d3851f0', '8ce76d05-7f1c-4f7d-b499-92ab3fd0f611', '男', '30', '13241871000', '4500', '4', '2018-09-24 14:11:01', '2018-09-24 14:11:01');
INSERT INTO `users` VALUES ('24', 'zhaoqing', '797b90a6bd34ddeafe09e06706c70f77', '9faa2462-694c-4497-8491-445d961ce99e', '男', '24', '13241871000', '15000', '1', '2018-09-24 14:40:21', '2018-09-24 14:40:21');
INSERT INTO `users` VALUES ('25', 'pengbosheng', 'cee2e7e27c97afc677884dd601151acb', '30a908e0-2650-4233-a067-4d7135297368', '男', '30', '13026393016', '10000', '4', '2018-09-25 15:23:57', '2018-09-26 10:59:32');
INSERT INTO `users` VALUES ('27', '李四', 'e9b0bd463f8bcfed620fe9988b0544f0', 'ac24ca87-4161-4639-b50e-fd0469d62b9f', '男', '30', '13241871000', '5000', '1', '2018-09-25 18:41:40', '2018-09-25 18:41:40');
INSERT INTO `users` VALUES ('28', '王五', 'a812a55b8cbec05b2fd79da983c6ff3d', 'cd89e9a0-e3cd-44a6-b23d-d74205a83f3b', '男', '24', '13241871000', '6000', '1', '2018-09-25 18:42:18', '2018-09-25 18:42:18');
INSERT INTO `users` VALUES ('29', '张海贝', '424c2d04324b8793b98dd63773e3606f', 'b1dbf4e7-cda6-40f8-bdec-dab09ad1f4b6', '男', '29', '18236625281', '300', '4', '2018-09-26 14:12:44', '2018-09-26 14:12:59');
INSERT INTO `users` VALUES ('31', 'zhangsan', 'ec700f93f41ca49d973dde034971e355', 'b316000e-e622-459f-a947-62e4949f26db', '男', '22', '1655522', '3000', '4', '2018-09-26 19:42:10', '2018-09-26 19:42:10');
