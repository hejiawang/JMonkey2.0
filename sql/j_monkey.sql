/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : j_monkey

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-01-26 10:14:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_button
-- ----------------------------
DROP TABLE IF EXISTS `sys_button`;
CREATE TABLE `sys_button` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '按钮名称',
  `permission` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限标识',
  `url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求链接',
  `method` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法 Get，Post，Put，Delete',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='按钮权限表';

-- ----------------------------
-- Records of sys_button
-- ----------------------------
INSERT INTO `sys_button` VALUES ('241846af380e4cc0bd6b4817565c5a9a', 'sys_get', 'sys_user_get', '/sys/**', 'Get', '2019-01-09 13:50:42', 'admin_test', '2019-01-17 11:31:17', 'admin_test', null, 'Used');
INSERT INTO `sys_button` VALUES ('5af77dfa167645e4a31faaf501532fdc', 'sys_post', 'sys_user_post', '/sys/**', 'Post', '2019-01-09 13:50:29', 'admin_test', '2019-01-17 11:31:19', 'admin_test', null, 'Used');
INSERT INTO `sys_button` VALUES ('95ea2fa6656d439382f8e42e6a926ced', 'sys_put', 'sys_user_put', '/sys/**', 'Put', '2019-01-09 13:50:54', 'admin_test', '2019-01-17 11:31:21', 'admin_test', null, 'Used');
INSERT INTO `sys_button` VALUES ('ade005be6b4e420d9e899284b3869dc2', 'sys_delete', 'sys_user_delete', '/sys/**', 'Delete', '2019-01-09 13:51:04', 'admin_test', '2019-01-17 11:31:23', 'admin_test', null, 'Used');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `parent_id` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '上级部门ID,null为顶级部门',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '部门名称',
  `code` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '部门编码',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='部门信息';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('052bc1e6bc20416dba6a47ea8cd26fa8', '50f2a61a8321423aa6534d36aa2dafb6', '财务部', '002', '1', '2019-01-09 11:03:54', 'admin', '2019-01-09 11:06:44', null, null, 'Used');
INSERT INTO `sys_dept` VALUES ('212b1467fb53491a9b80f7f689d4f435', '50f2a61a8321423aa6534d36aa2dafb6', '销售部', '009', '5', '2019-01-18 13:42:19', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_dept` VALUES ('2ccf9e01fb194b72bee71008fc8d3b1e', '5020de4a820c4be1bef0144836b26544', '产品组', '020', '6', '2019-01-18 13:43:21', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_dept` VALUES ('40b09f534fd644f793ecdcf9a243abfe', '5020de4a820c4be1bef0144836b26544', '测试组', '005', '1', '2019-01-09 11:04:37', 'admin', '2019-01-09 11:06:45', null, null, 'Used');
INSERT INTO `sys_dept` VALUES ('5020de4a820c4be1bef0144836b26544', '50f2a61a8321423aa6534d36aa2dafb6', '技术部', '004', '3', '2019-01-09 11:04:24', 'admin', '2019-01-09 11:06:45', null, null, 'Used');
INSERT INTO `sys_dept` VALUES ('50f2a61a8321423aa6534d36aa2dafb6', null, 'xxx公司', '001', '1', '2019-01-09 11:03:11', 'admin', '2019-01-09 11:06:46', null, null, 'Used');
INSERT INTO `sys_dept` VALUES ('7b5b0cc6c5b8467891c46dc945b0ef12', '50f2a61a8321423aa6534d36aa2dafb6', '商务部', '003', '1', '2019-01-09 11:04:06', 'admin', '2019-01-09 11:06:46', null, null, 'Used');
INSERT INTO `sys_dept` VALUES ('a35e5084e51e486e96615eba477ce68f', '052bc1e6bc20416dba6a47ea8cd26fa8', '出纳', '010', '1', '2019-01-18 13:42:46', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_dept` VALUES ('cfdfef67079e45139125c91c7e016e8a', '5020de4a820c4be1bef0144836b26544', '开发组', '006', '2', '2019-01-09 11:04:55', 'admin', '2019-01-09 11:06:47', null, null, 'Used');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `parent_id` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '上级字典ID',
  `lable` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '字典标签',
  `value` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '字典键值',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='字典值';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('08defdb3dc4b4bec85d9d78945b57702', '1eaee78771a249f5ac011e1055693216', '3-4', '3-4', '4', '2018-12-19 16:33:21', 'admin', '2019-01-09 11:06:25', 'admin_test', '3-4', 'Used');
INSERT INTO `sys_dict` VALUES ('0c3460177e044015b23a73e240b5fd28', 'a7156ad680da4e779596d563abde3120', '系统设置', 'sys_task_sys', '1', '2019-01-24 08:59:25', null, '2019-01-24 08:59:44', null, '系统设置模块定时任务', 'Used');
INSERT INTO `sys_dict` VALUES ('0ea035d2c8ec4177ab3fac0f89ae97c2', 'ba5d20e2317a4f82beac37e67d70453f', '5-2', '5-2', '1', '2019-01-25 13:49:25', null, null, null, null, 'Used');
INSERT INTO `sys_dict` VALUES ('18b0726a3a0941529500914836181e8f', null, '1', '1', '2', '2019-01-03 08:34:21', 'admin', '2019-01-09 11:06:27', null, '1', 'Used');
INSERT INTO `sys_dict` VALUES ('1eaee78771a249f5ac011e1055693216', null, '3', '3', '4', '2018-12-19 15:14:48', 'admin', '2019-01-09 11:06:29', 'admin_test', '3', 'Used');
INSERT INTO `sys_dict` VALUES ('4f62a323728a4fd7827535d63f36c3b3', 'ba5d20e2317a4f82beac37e67d70453f', '5-8', '5-8', '1', '2019-01-25 14:03:50', null, null, null, null, 'Used');
INSERT INTO `sys_dict` VALUES ('55f88b69673048eb80b252b5c9bd1363', '5f1b36f800cf4509b3df2ae17cc791d0', '1-1-1', '1-1-1', '1', '2019-01-03 08:34:47', 'admin', '2019-01-09 11:06:29', null, '1-1-1', 'Used');
INSERT INTO `sys_dict` VALUES ('5f1b36f800cf4509b3df2ae17cc791d0', '18b0726a3a0941529500914836181e8f', '1-1', '1-1', '1', '2019-01-03 08:34:35', 'admin', '2019-01-09 11:06:30', null, '1-1', 'Used');
INSERT INTO `sys_dict` VALUES ('6f041f8bfd134bda82ac0616af3bb398', 'ba5d20e2317a4f82beac37e67d70453f', '5-5', '5-5', '1', '2019-01-25 13:52:30', null, null, null, '5-5', 'Used');
INSERT INTO `sys_dict` VALUES ('75f6b9b807704b9ba12ea37857281666', '1eaee78771a249f5ac011e1055693216', '3-3', '3-3', '3', '2018-12-19 16:33:14', 'admin', '2019-01-09 11:06:30', 'admin_test', '3-3', 'Used');
INSERT INTO `sys_dict` VALUES ('83562137153245c3954280865a765fca', 'dff8a69d8258485082bd4833b7bb05ca', '4-1', '4-1', '1', '2018-12-21 12:59:41', 'admin', '2019-01-09 11:06:32', null, '4-1', 'Used');
INSERT INTO `sys_dict` VALUES ('836df09b5c2c42cd99c9e51ecdaa1f60', 'ba5d20e2317a4f82beac37e67d70453f', '5-4', '5-4', '1', '2019-01-25 13:51:06', null, null, null, '5-4', 'Used');
INSERT INTO `sys_dict` VALUES ('889d82bde33b48529a7f5ec7d5aff5b8', '1eaee78771a249f5ac011e1055693216', '3-1', '3-1', '1', '2018-12-19 15:26:19', 'admin', '2019-01-09 11:06:35', null, '3-1', 'Used');
INSERT INTO `sys_dict` VALUES ('913ffd0f6b874998aba6c453a57601e9', 'ba5d20e2317a4f82beac37e67d70453f', '5-7', '5-7', '1', '2019-01-25 13:56:58', null, null, null, '5-7', 'Used');
INSERT INTO `sys_dict` VALUES ('99262030d6be485a9d241448f649158c', 'c4ef3f0a369243ebb83523186cf0a514', '1-2-1', '1-2-1', '1', '2019-01-03 08:35:11', 'admin', '2019-01-09 11:06:35', null, '1-2-1', 'Used');
INSERT INTO `sys_dict` VALUES ('a7156ad680da4e779596d563abde3120', null, '定时任务分组', 'sys_task', '1', '2019-01-24 08:58:23', null, null, null, '定时任务分组sys_task表的group字段', 'Used');
INSERT INTO `sys_dict` VALUES ('afc1476ca976411da341f5d5f19d37ca', 'ba5d20e2317a4f82beac37e67d70453f', '5-3', '5-3', '1', '2019-01-25 13:50:31', null, null, null, '5-3', 'Used');
INSERT INTO `sys_dict` VALUES ('ba47cf8ff3554078822b047762597e7d', '0ea035d2c8ec4177ab3fac0f89ae97c2', '5-2-1', '5-2-1', '1', '2019-01-25 14:05:30', null, null, null, null, 'Used');
INSERT INTO `sys_dict` VALUES ('ba5d20e2317a4f82beac37e67d70453f', null, '5', '5', '5', '2018-12-21 11:08:59', 'admin', '2019-01-09 11:06:36', null, '5', 'Used');
INSERT INTO `sys_dict` VALUES ('bed5e6d7f5954f73bc02aabd49514b8d', 'ba5d20e2317a4f82beac37e67d70453f', '5-1', '5-1', '1', '2018-12-21 11:09:07', 'admin', '2019-01-25 14:07:45', null, '5-1', 'Delete');
INSERT INTO `sys_dict` VALUES ('c4ef3f0a369243ebb83523186cf0a514', '18b0726a3a0941529500914836181e8f', '1-2', '1-2', '1', '2019-01-03 08:35:03', 'admin', '2019-01-09 11:06:37', null, '1-2', 'Used');
INSERT INTO `sys_dict` VALUES ('ca1d11eaf62f4e268e0016980175ea3b', '1eaee78771a249f5ac011e1055693216', '3-2', '3-2', '2', '2018-12-19 16:32:27', 'admin', '2019-01-09 11:06:37', 'admin_test', '3-2', 'Used');
INSERT INTO `sys_dict` VALUES ('ddc398ace11a47d69e64d6cf71390027', 'a7156ad680da4e779596d563abde3120', '测试', 'sys_task_test', '2', '2019-01-24 13:56:55', null, null, null, null, 'Used');
INSERT INTO `sys_dict` VALUES ('dff8a69d8258485082bd4833b7bb05ca', null, '4', '4', '4', '2018-12-21 08:42:46', 'admin', '2019-01-09 11:06:38', 'admin_test', '4', 'Used');
INSERT INTO `sys_dict` VALUES ('ebc5d31387f44dc4a9583304c334212e', 'ba5d20e2317a4f82beac37e67d70453f', '5-6', '5-6', '1', '2019-01-25 13:54:12', null, null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_log_0
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_0`;
CREATE TABLE `sys_log_0` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `user_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户登录名称',
  `ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作ip',
  `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求路径',
  `http_method` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式',
  `class_method` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
  `param` text COLLATE utf8mb4_bin COMMENT '请求参数',
  `handle_length` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作时长',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志';

-- ----------------------------
-- Records of sys_log_0
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_1
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_1`;
CREATE TABLE `sys_log_1` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `user_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户登录名称',
  `ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作ip',
  `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求路径',
  `http_method` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式',
  `class_method` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
  `param` text COLLATE utf8mb4_bin COMMENT '请求参数',
  `handle_length` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作时长',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志';

-- ----------------------------
-- Records of sys_log_1
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_2
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_2`;
CREATE TABLE `sys_log_2` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `user_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户登录名称',
  `ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作ip',
  `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求路径',
  `http_method` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式',
  `class_method` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
  `param` text COLLATE utf8mb4_bin COMMENT '请求参数',
  `handle_length` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作时长',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志';

-- ----------------------------
-- Records of sys_log_2
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_3
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_3`;
CREATE TABLE `sys_log_3` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `user_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户登录名称',
  `ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作ip',
  `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求路径',
  `http_method` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式',
  `class_method` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
  `param` text COLLATE utf8mb4_bin COMMENT '请求参数',
  `handle_length` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作时长',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志';

-- ----------------------------
-- Records of sys_log_3
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_4
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_4`;
CREATE TABLE `sys_log_4` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `user_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户登录名称',
  `ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作ip',
  `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求路径',
  `http_method` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式',
  `class_method` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
  `param` text COLLATE utf8mb4_bin COMMENT '请求参数',
  `handle_length` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作时长',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志';

-- ----------------------------
-- Records of sys_log_4
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_5
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_5`;
CREATE TABLE `sys_log_5` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `user_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户登录名称',
  `ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作ip',
  `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求路径',
  `http_method` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式',
  `class_method` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
  `param` text COLLATE utf8mb4_bin COMMENT '请求参数',
  `handle_length` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作时长',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志';

-- ----------------------------
-- Records of sys_log_5
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_6
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_6`;
CREATE TABLE `sys_log_6` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `user_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户登录名称',
  `ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作ip',
  `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求路径',
  `http_method` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式',
  `class_method` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
  `param` text COLLATE utf8mb4_bin COMMENT '请求参数',
  `handle_length` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作时长',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志';

-- ----------------------------
-- Records of sys_log_6
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_7
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_7`;
CREATE TABLE `sys_log_7` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `user_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户登录名称',
  `ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作ip',
  `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求路径',
  `http_method` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式',
  `class_method` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
  `param` text COLLATE utf8mb4_bin COMMENT '请求参数',
  `handle_length` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作时长',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志';

-- ----------------------------
-- Records of sys_log_7
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_8
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_8`;
CREATE TABLE `sys_log_8` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `user_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户登录名称',
  `ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作ip',
  `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求路径',
  `http_method` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式',
  `class_method` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
  `param` text COLLATE utf8mb4_bin COMMENT '请求参数',
  `handle_length` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作时长',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志';

-- ----------------------------
-- Records of sys_log_8
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_9
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_9`;
CREATE TABLE `sys_log_9` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `user_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户登录名称',
  `ip` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作ip',
  `url` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求路径',
  `http_method` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方式',
  `class_method` varchar(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求方法',
  `param` text COLLATE utf8mb4_bin COMMENT '请求参数',
  `handle_length` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作时长',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志';

-- ----------------------------
-- Records of sys_log_9
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'router路径',
  `component` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'VUE页面',
  `is_show` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Yes' COMMENT '是否显示，Yes是，No否',
  `is_guide` varchar(10) DEFAULT 'No' COMMENT '是否在引导页显示',
  `is_index` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'No' COMMENT '是否是主页，Yes是，No否',
  `show_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Home' COMMENT '菜单路由方式，Home，Screen',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('14482180614349c39fe9bb70bd3e0fa9', '部门管理', 'logo-xbox', '/sys/dept', '/sys/dept', 'Yes', 'Yes', 'No', 'Home', '4', '2019-01-09 11:25:15', 'admin_test', '2019-01-10 13:08:57', 'admin_test', null, 'Used');
INSERT INTO `sys_menu` VALUES ('258dcbbefef04bf19ad39b3bcacfd022', '按钮管理', null, '/sys/button', '/sys/button', 'Yes', 'No', 'No', 'Home', '3', '2019-01-09 12:24:31', 'admin_test', '2019-01-09 12:24:40', 'admin_test', null, 'Used');
INSERT INTO `sys_menu` VALUES ('26c28c672b764157a29c2fc0ebde4522', '资源管理', 'ios-navigate', null, null, 'Yes', 'No', 'No', 'Home', '70', '2019-01-09 11:27:14', 'admin_test', '2019-01-22 17:42:27', null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('319b072a4f044442876ee65211f8aa78', '字典管理', 'ios-at-outline', '/sys/dict', '/sys/dict', 'Yes', 'Yes', 'No', 'Home', '5', '2019-01-09 11:25:45', 'admin_test', '2019-01-10 13:09:05', 'admin_test', null, 'Used');
INSERT INTO `sys_menu` VALUES ('44d8b4106ec7428c880bff606de532fb', '菜单管理', null, '/sys/menu', '/sys/menu', 'Yes', 'No', 'No', 'Home', '2', '2019-01-09 12:24:09', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('4f565e58e7be42c2ab7726494a1a9d1a', '系统首页', 'md-home', '/sys/home', '/sys/home', 'Yes', 'No', 'Yes', 'Home', '1', '2019-01-09 11:23:47', 'admin_test', '2019-01-16 10:56:30', 'admin_test', null, 'Used');
INSERT INTO `sys_menu` VALUES ('5a806b8031b64bc88591edb09f487313', '日志台账', 'logo-sass', '/sys/log', '/sys/log', 'Yes', 'No', 'No', 'Home', '6', '2019-01-22 17:43:54', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('71684cea9d654584bad93a20fcd52207', '角色管理', 'md-globe', '/sys/role', '/sys/role', 'Yes', 'Yes', 'No', 'Home', '3', '2019-01-09 11:24:53', 'admin_test', '2019-01-10 13:08:52', 'admin_test', null, 'Used');
INSERT INTO `sys_menu` VALUES ('7afcc5eb00c246d78d92e673b9679640', '全屏菜单', null, '/home', '/home', 'Yes', 'No', 'Yes', 'Screen', '1', '2019-01-10 13:29:01', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('863ea79c022d40f4a57a8ce54954c74d', '系统管理', null, '/sys/system', '/sys/system', 'Yes', 'No', 'No', 'Home', '1', '2019-01-09 12:23:37', 'admin_test', '2019-01-10 16:49:31', 'admin_test', null, 'Used');
INSERT INTO `sys_menu` VALUES ('ada820e2bd6345a2a882dd2526f16725', '用户管理', 'ios-contact', '/sys/user', '/sys/user', 'Yes', 'Yes', 'No', 'Home', '2', '2019-01-09 11:24:16', 'admin_test', '2019-01-16 16:10:46', 'admin_test', null, 'Used');
INSERT INTO `sys_menu` VALUES ('b5a6eeea310644e2a25e4e3a10cf0628', '定时任务', 'md-clock', '/sys/task', '/sys/task', 'Yes', 'No', 'No', 'Home', '7', '2019-01-24 13:59:20', null, null, null, null, 'Used');
INSERT INTO `sys_menu` VALUES ('b6620f37c1b247a586ae5414663299bc', '无权操作', 'md-book', null, null, 'Yes', 'Yes', 'No', 'Home', '1', '2019-01-11 09:03:17', 'admin_test', null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源类型 System,Menu,Button',
  `r_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源id 例 type==System r_id==sys_system.id',
  `parent_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '父资源ID',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('13704bf763904cfbb4ecd4395a7c7745', 'Menu', 'ada820e2bd6345a2a882dd2526f16725', '394b434defd74548ab04493b5fee924b', '2019-01-09 11:24:16', 'admin_test', '2019-01-10 13:08:41', 'admin_test', null, 'Used');
INSERT INTO `sys_resource` VALUES ('1419331c93f949fda927aa562363f0c9', 'Menu', '7afcc5eb00c246d78d92e673b9679640', '7d3065f62b184acba8be3323c40723ab', '2019-01-10 13:29:01', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('21e01b2da75c42e39968d514c25a1f56', 'Button', '5af77dfa167645e4a31faaf501532fdc', '13704bf763904cfbb4ecd4395a7c7745', '2019-01-09 13:50:29', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('2a63aec9db604fa898c11380e8893dd2', 'Menu', '44d8b4106ec7428c880bff606de532fb', '50226e046cab4cc9bdf88684698ee47f', '2019-01-09 12:24:09', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('394b434defd74548ab04493b5fee924b', 'System', 'c63493fc99c8489294cbe839ce2071ac', null, '2019-01-09 11:19:50', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('4196bc3de8254b2a95d03a79d40279bf', 'Menu', 'b6620f37c1b247a586ae5414663299bc', 'dd06238dfa334787a1cba25619d0bbc0', '2019-01-11 09:03:17', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('4f3355f7ae6c4156ac320f9691e91a4b', 'Menu', '258dcbbefef04bf19ad39b3bcacfd022', '50226e046cab4cc9bdf88684698ee47f', '2019-01-09 12:24:31', 'admin_test', '2019-01-09 12:24:40', 'admin_test', null, 'Used');
INSERT INTO `sys_resource` VALUES ('50226e046cab4cc9bdf88684698ee47f', 'Menu', '26c28c672b764157a29c2fc0ebde4522', '394b434defd74548ab04493b5fee924b', '2019-01-09 11:27:14', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('55910164c8fc4dd28a889059697b5b32', 'Button', '95ea2fa6656d439382f8e42e6a926ced', '13704bf763904cfbb4ecd4395a7c7745', '2019-01-09 13:50:54', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('7a684d1e725e4864a4d12b347ef97ce2', 'Menu', '319b072a4f044442876ee65211f8aa78', '394b434defd74548ab04493b5fee924b', '2019-01-09 11:25:45', 'admin_test', '2019-01-10 13:09:05', 'admin_test', null, 'Used');
INSERT INTO `sys_resource` VALUES ('7d3065f62b184acba8be3323c40723ab', 'System', 'd7065f3eba94409397f4d21f2692a8fa', null, '2019-01-10 13:24:35', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('8b181665db794069b476f02f42e1a8f8', 'Button', 'ade005be6b4e420d9e899284b3869dc2', '13704bf763904cfbb4ecd4395a7c7745', '2019-01-09 13:51:04', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('9aa69c54984c455daa3be9c574f4209d', 'Menu', '863ea79c022d40f4a57a8ce54954c74d', '50226e046cab4cc9bdf88684698ee47f', '2019-01-09 12:23:37', 'admin_test', '2019-01-10 16:49:31', 'admin_test', null, 'Used');
INSERT INTO `sys_resource` VALUES ('9cf2b9bf83164fb2978c2f434827b2b9', 'Menu', '5a806b8031b64bc88591edb09f487313', '394b434defd74548ab04493b5fee924b', '2019-01-22 17:43:54', null, null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('ade198a8d94d43829fff1ea35fc2bf37', 'Menu', 'b5a6eeea310644e2a25e4e3a10cf0628', '394b434defd74548ab04493b5fee924b', '2019-01-24 13:59:20', null, null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('b860f629bd3f4e118fa2b406c1684689', 'System', 'fa904fdc7ce74970a45d731ed3ba2364', null, '2019-01-11 09:01:28', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('b8c745e5a9ff4159ae4ea141db35a0e8', 'Menu', '71684cea9d654584bad93a20fcd52207', '394b434defd74548ab04493b5fee924b', '2019-01-09 11:24:53', 'admin_test', '2019-01-10 13:08:52', 'admin_test', null, 'Used');
INSERT INTO `sys_resource` VALUES ('b98f836b7276467ea18cca3900071c51', 'Menu', '14482180614349c39fe9bb70bd3e0fa9', '394b434defd74548ab04493b5fee924b', '2019-01-09 11:25:15', 'admin_test', '2019-01-10 13:08:57', 'admin_test', null, 'Used');
INSERT INTO `sys_resource` VALUES ('dd06238dfa334787a1cba25619d0bbc0', 'System', 'e2c1a10b8799418f80b99545d7b83296', null, '2019-01-11 09:01:56', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_resource` VALUES ('ec624a3e7cad4f5ea107902df3390ba3', 'Menu', '4f565e58e7be42c2ab7726494a1a9d1a', '394b434defd74548ab04493b5fee924b', '2019-01-09 11:23:47', 'admin_test', '2019-01-16 10:56:30', 'admin_test', null, 'Used');
INSERT INTO `sys_resource` VALUES ('f3bb0d693a124fdfbfff1fca745fa160', 'Button', '241846af380e4cc0bd6b4817565c5a9a', '13704bf763904cfbb4ecd4395a7c7745', '2019-01-09 13:50:42', 'admin_test', null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `code` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'admin', '2019-01-09 11:05:56', 'admin', '2019-01-09 11:06:12', null, '超级管理员', 'Used');
INSERT INTO `sys_role` VALUES ('b5270709547143e5afb16c1f5c61ce95', '普通用户', 'common', '2019-01-17 10:19:20', 'admin_test', null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  `resource_id` varchar(64) NOT NULL COMMENT '资源ID',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('1', '13704bf763904cfbb4ecd4395a7c7745', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '1419331c93f949fda927aa562363f0c9', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '21e01b2da75c42e39968d514c25a1f56', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '2a63aec9db604fa898c11380e8893dd2', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '394b434defd74548ab04493b5fee924b', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '4f3355f7ae6c4156ac320f9691e91a4b', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '50226e046cab4cc9bdf88684698ee47f', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '55910164c8fc4dd28a889059697b5b32', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '7a684d1e725e4864a4d12b347ef97ce2', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '7d3065f62b184acba8be3323c40723ab', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '8b181665db794069b476f02f42e1a8f8', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '9aa69c54984c455daa3be9c574f4209d', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', '9cf2b9bf83164fb2978c2f434827b2b9', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', 'ade198a8d94d43829fff1ea35fc2bf37', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', 'b8c745e5a9ff4159ae4ea141db35a0e8', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', 'b98f836b7276467ea18cca3900071c51', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', 'ec624a3e7cad4f5ea107902df3390ba3', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('1', 'f3bb0d693a124fdfbfff1fca745fa160', '2019-01-24 13:59:36', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('b5270709547143e5afb16c1f5c61ce95', '1419331c93f949fda927aa562363f0c9', '2019-01-17 10:19:46', null, null, null, null, 'Used');
INSERT INTO `sys_role_resource` VALUES ('b5270709547143e5afb16c1f5c61ce95', '7d3065f62b184acba8be3323c40723ab', '2019-01-17 10:19:46', null, null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_system
-- ----------------------------
DROP TABLE IF EXISTS `sys_system`;
CREATE TABLE `sys_system` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '系统名称',
  `icon` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `is_show` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Yes' COMMENT '是否显示，Yes是，No否',
  `show_guide` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'No' COMMENT '是否需要引导页，Yes是，No否',
  `show_menu` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'No' COMMENT '若显示引导页，在引导页是否显示子菜单，Yes是，No否',
  `show_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Tabs' COMMENT '系统显示方式，Tabs标签页方式 Breadcrumb导航条方式',
  `sort` int(11) DEFAULT '0' COMMENT '排序值',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置';

-- ----------------------------
-- Records of sys_system
-- ----------------------------
INSERT INTO `sys_system` VALUES ('c63493fc99c8489294cbe839ce2071ac', '系统设置', 'md-cog', 'Yes', 'Yes', 'Yes', 'Breadcrumb', '1', '2019-01-09 11:19:50', '', '2019-01-25 14:10:19', null, null, 'Used');
INSERT INTO `sys_system` VALUES ('d7065f3eba94409397f4d21f2692a8fa', '全屏系统', 'logo-angular', 'Yes', 'No', 'Yes', 'Breadcrumb', '2', '2019-01-10 13:24:35', '', '2019-01-25 14:10:19', '', null, 'Used');
INSERT INTO `sys_system` VALUES ('e2c1a10b8799418f80b99545d7b83296', '无权小的', 'ios-briefcase', 'Yes', 'No', 'Yes', 'Tabs', '4', '2019-01-11 09:01:56', '', '2019-01-25 14:10:20', '', null, 'Used');
INSERT INTO `sys_system` VALUES ('fa904fdc7ce74970a45d731ed3ba2364', '无权大的', 'md-at', 'Yes', 'No', 'Yes', 'Tabs', '3', '2019-01-11 09:01:28', '', '2019-01-25 14:10:21', '', null, 'Used');

-- ----------------------------
-- Table structure for sys_task
-- ----------------------------
DROP TABLE IF EXISTS `sys_task`;
CREATE TABLE `sys_task` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '任务名',
  `group` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '任务组',
  `rule` varchar(40) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '定时规则',
  `status` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '启用状态 Yes启用 No停用',
  `class_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '任务类',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='定时任务配置表';

-- ----------------------------
-- Records of sys_task
-- ----------------------------
INSERT INTO `sys_task` VALUES ('79eb74272c124cd388c659916711c9a2', '清空日志', 'sys_task_sys', '0 0 23 * * ?', 'No', 'com.wang.jmonkey.modules.sys.task.SysClearLogTask', '2019-01-25 15:31:09', null, '2019-01-25 15:51:54', null, null, 'Delete');
INSERT INTO `sys_task` VALUES ('99ef4a1cd212432898afae4793094aa1', '测试任务', 'sys_task_test', '0 */1 * * * ?', 'No', 'com.wang.jmonkey.modules.sys.task.SysTestTask', '2019-01-25 15:23:56', null, '2019-01-25 15:27:08', null, null, 'Used');
INSERT INTO `sys_task` VALUES ('c9c5681b0d794e708d00a728e453ed8a', '清空日志', 'sys_task_sys', '0 0 23 * * ?', 'No', 'com.wang.jmonkey.modules.sys.task.SysClearLogTask', '2019-01-25 15:31:09', null, '2019-01-25 15:32:36', null, null, 'Used');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `username` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号码',
  `real_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '真是姓名',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '性别 man男 woman女 other其他',
  `photo` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户头像',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$10$2KkX8XQk5D0/eOhoOZX/cuTGDId.0qa7iu4s21bhe.lTcIC7QkqnW', '13888888888', '超级管理员', '2019-01-09', 'Other', '', '2019-01-09 11:07:45', 'admin_test', '2019-01-10 08:43:40', 'admin_test', null, 'Used');
INSERT INTO `sys_user` VALUES ('36f8103bf41c4098b72d28734c5fb2ed', 'common', '$2a$10$7y1IOxvikqw3RmYTsRkDA.lBcp9sPWvvG8zHkLDIFAd7h3qMRHqia', '13555555555', '普通用户', '2019-01-18', 'Man', null, '2019-01-17 10:20:25', 'admin_test', null, null, null, 'Used');
INSERT INTO `sys_user` VALUES ('94492b8bd0d74afb9c1af5c8fc36d57e', 'common1', '$2a$10$1Y.BV0PuHPyz06FRxOE1J.AfZmZcso9MswvP7AUlOWyBaZwuFnc16', '13333333333', 'common1', '2019-01-25', 'Man', null, '2019-01-22 13:32:51', null, null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_dept`;
CREATE TABLE `sys_user_dept` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `dept_id` varchar(64) NOT NULL COMMENT '部门ID',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`user_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户部门表';

-- ----------------------------
-- Records of sys_user_dept
-- ----------------------------
INSERT INTO `sys_user_dept` VALUES ('1', '50f2a61a8321423aa6534d36aa2dafb6', '2019-01-11 19:06:38', null, null, null, null, 'Used');
INSERT INTO `sys_user_dept` VALUES ('36f8103bf41c4098b72d28734c5fb2ed', 'cfdfef67079e45139125c91c7e016e8a', '2019-01-17 10:20:25', null, null, null, null, 'Used');
INSERT INTO `sys_user_dept` VALUES ('94492b8bd0d74afb9c1af5c8fc36d57e', '7b5b0cc6c5b8467891c46dc945b0ef12', '2019-01-22 13:32:51', null, null, null, null, 'Used');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '2019-01-11 19:06:38', null, null, null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('36f8103bf41c4098b72d28734c5fb2ed', 'b5270709547143e5afb16c1f5c61ce95', '2019-01-17 10:20:25', null, null, null, null, 'Used');
INSERT INTO `sys_user_role` VALUES ('94492b8bd0d74afb9c1af5c8fc36d57e', 'b5270709547143e5afb16c1f5c61ce95', '2019-01-22 13:32:51', null, null, null, null, 'Used');

-- ----------------------------
-- Table structure for test_mb
-- ----------------------------
DROP TABLE IF EXISTS `test_mb`;
CREATE TABLE `test_mb` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `username` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(10) COLLATE utf8mb4_bin DEFAULT 'Used' COMMENT 'used启用 disable禁用 delete删除',
  `b` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='mybatis 测试';

-- ----------------------------
-- Records of test_mb
-- ----------------------------
INSERT INTO `test_mb` VALUES ('dd44edee2c1c4f4f81fd35ab9357327a', 'update', '123', '2018-11-09 11:25:36', 'admin_test', '2018-12-08 10:04:38', 'admin_test', null, 'Delete', '1');

-- ----------------------------
-- View structure for sys_log
-- ----------------------------
DROP VIEW IF EXISTS `sys_log`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sys_log` AS select `sys_log_0`.`id` AS `id`,`sys_log_0`.`user_name` AS `user_name`,`sys_log_0`.`ip` AS `ip`,`sys_log_0`.`url` AS `url`,`sys_log_0`.`http_method` AS `http_method`,`sys_log_0`.`class_method` AS `class_method`,`sys_log_0`.`param` AS `param`,`sys_log_0`.`handle_length` AS `handle_length`,`sys_log_0`.`create_date` AS `create_date`,`sys_log_0`.`create_by` AS `create_by`,`sys_log_0`.`update_date` AS `update_date`,`sys_log_0`.`update_by` AS `update_by`,`sys_log_0`.`remark` AS `remark`,`sys_log_0`.`delete_flag` AS `delete_flag` from `sys_log_0` union all select `sys_log_1`.`id` AS `id`,`sys_log_1`.`user_name` AS `user_name`,`sys_log_1`.`ip` AS `ip`,`sys_log_1`.`url` AS `url`,`sys_log_1`.`http_method` AS `http_method`,`sys_log_1`.`class_method` AS `class_method`,`sys_log_1`.`param` AS `param`,`sys_log_1`.`handle_length` AS `handle_length`,`sys_log_1`.`create_date` AS `create_date`,`sys_log_1`.`create_by` AS `create_by`,`sys_log_1`.`update_date` AS `update_date`,`sys_log_1`.`update_by` AS `update_by`,`sys_log_1`.`remark` AS `remark`,`sys_log_1`.`delete_flag` AS `delete_flag` from `sys_log_1` union all select `sys_log_2`.`id` AS `id`,`sys_log_2`.`user_name` AS `user_name`,`sys_log_2`.`ip` AS `ip`,`sys_log_2`.`url` AS `url`,`sys_log_2`.`http_method` AS `http_method`,`sys_log_2`.`class_method` AS `class_method`,`sys_log_2`.`param` AS `param`,`sys_log_2`.`handle_length` AS `handle_length`,`sys_log_2`.`create_date` AS `create_date`,`sys_log_2`.`create_by` AS `create_by`,`sys_log_2`.`update_date` AS `update_date`,`sys_log_2`.`update_by` AS `update_by`,`sys_log_2`.`remark` AS `remark`,`sys_log_2`.`delete_flag` AS `delete_flag` from `sys_log_2` union all select `sys_log_3`.`id` AS `id`,`sys_log_3`.`user_name` AS `user_name`,`sys_log_3`.`ip` AS `ip`,`sys_log_3`.`url` AS `url`,`sys_log_3`.`http_method` AS `http_method`,`sys_log_3`.`class_method` AS `class_method`,`sys_log_3`.`param` AS `param`,`sys_log_3`.`handle_length` AS `handle_length`,`sys_log_3`.`create_date` AS `create_date`,`sys_log_3`.`create_by` AS `create_by`,`sys_log_3`.`update_date` AS `update_date`,`sys_log_3`.`update_by` AS `update_by`,`sys_log_3`.`remark` AS `remark`,`sys_log_3`.`delete_flag` AS `delete_flag` from `sys_log_3` union all select `sys_log_4`.`id` AS `id`,`sys_log_4`.`user_name` AS `user_name`,`sys_log_4`.`ip` AS `ip`,`sys_log_4`.`url` AS `url`,`sys_log_4`.`http_method` AS `http_method`,`sys_log_4`.`class_method` AS `class_method`,`sys_log_4`.`param` AS `param`,`sys_log_4`.`handle_length` AS `handle_length`,`sys_log_4`.`create_date` AS `create_date`,`sys_log_4`.`create_by` AS `create_by`,`sys_log_4`.`update_date` AS `update_date`,`sys_log_4`.`update_by` AS `update_by`,`sys_log_4`.`remark` AS `remark`,`sys_log_4`.`delete_flag` AS `delete_flag` from `sys_log_4` union all select `sys_log_5`.`id` AS `id`,`sys_log_5`.`user_name` AS `user_name`,`sys_log_5`.`ip` AS `ip`,`sys_log_5`.`url` AS `url`,`sys_log_5`.`http_method` AS `http_method`,`sys_log_5`.`class_method` AS `class_method`,`sys_log_5`.`param` AS `param`,`sys_log_5`.`handle_length` AS `handle_length`,`sys_log_5`.`create_date` AS `create_date`,`sys_log_5`.`create_by` AS `create_by`,`sys_log_5`.`update_date` AS `update_date`,`sys_log_5`.`update_by` AS `update_by`,`sys_log_5`.`remark` AS `remark`,`sys_log_5`.`delete_flag` AS `delete_flag` from `sys_log_5` union all select `sys_log_6`.`id` AS `id`,`sys_log_6`.`user_name` AS `user_name`,`sys_log_6`.`ip` AS `ip`,`sys_log_6`.`url` AS `url`,`sys_log_6`.`http_method` AS `http_method`,`sys_log_6`.`class_method` AS `class_method`,`sys_log_6`.`param` AS `param`,`sys_log_6`.`handle_length` AS `handle_length`,`sys_log_6`.`create_date` AS `create_date`,`sys_log_6`.`create_by` AS `create_by`,`sys_log_6`.`update_date` AS `update_date`,`sys_log_6`.`update_by` AS `update_by`,`sys_log_6`.`remark` AS `remark`,`sys_log_6`.`delete_flag` AS `delete_flag` from `sys_log_6` union all select `sys_log_7`.`id` AS `id`,`sys_log_7`.`user_name` AS `user_name`,`sys_log_7`.`ip` AS `ip`,`sys_log_7`.`url` AS `url`,`sys_log_7`.`http_method` AS `http_method`,`sys_log_7`.`class_method` AS `class_method`,`sys_log_7`.`param` AS `param`,`sys_log_7`.`handle_length` AS `handle_length`,`sys_log_7`.`create_date` AS `create_date`,`sys_log_7`.`create_by` AS `create_by`,`sys_log_7`.`update_date` AS `update_date`,`sys_log_7`.`update_by` AS `update_by`,`sys_log_7`.`remark` AS `remark`,`sys_log_7`.`delete_flag` AS `delete_flag` from `sys_log_7` union all select `sys_log_8`.`id` AS `id`,`sys_log_8`.`user_name` AS `user_name`,`sys_log_8`.`ip` AS `ip`,`sys_log_8`.`url` AS `url`,`sys_log_8`.`http_method` AS `http_method`,`sys_log_8`.`class_method` AS `class_method`,`sys_log_8`.`param` AS `param`,`sys_log_8`.`handle_length` AS `handle_length`,`sys_log_8`.`create_date` AS `create_date`,`sys_log_8`.`create_by` AS `create_by`,`sys_log_8`.`update_date` AS `update_date`,`sys_log_8`.`update_by` AS `update_by`,`sys_log_8`.`remark` AS `remark`,`sys_log_8`.`delete_flag` AS `delete_flag` from `sys_log_8` union all select `sys_log_9`.`id` AS `id`,`sys_log_9`.`user_name` AS `user_name`,`sys_log_9`.`ip` AS `ip`,`sys_log_9`.`url` AS `url`,`sys_log_9`.`http_method` AS `http_method`,`sys_log_9`.`class_method` AS `class_method`,`sys_log_9`.`param` AS `param`,`sys_log_9`.`handle_length` AS `handle_length`,`sys_log_9`.`create_date` AS `create_date`,`sys_log_9`.`create_by` AS `create_by`,`sys_log_9`.`update_date` AS `update_date`,`sys_log_9`.`update_by` AS `update_by`,`sys_log_9`.`remark` AS `remark`,`sys_log_9`.`delete_flag` AS `delete_flag` from `sys_log_9` ;
