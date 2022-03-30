CREATE TABLE `t_project` (
  `project_id` varchar(32) NOT NULL,

  `project_desc` varchar(250) DEFAULT NULL COMMENT '项目描述',
  `project_name` varchar(50) NOT NULL COMMENT '项目名称',
  `project_owner` varchar(50) NOT NULL COMMENT '项目owner',
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  UNIQUE KEY `UK_88xp0a2hd9et4fd4idlkv5ew1` (`project_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- 创建  user
CREATE TABLE IF NOT EXISTS `t_user` (
    `user_id`                   varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'User ID',
    `user_name`                 varchar(64) NOT NULL COMMENT 'User name',
    `email`                varchar(64) NOT NULL COMMENT 'E-Mail address',
    `password`             varchar(256) COLLATE utf8mb4_bin DEFAULT NULL,
    `status`               INT DEFAULT 0 COMMENT 'User status: 0-inactive; 1-active',
    `created_time` datetime DEFAULT NULL COMMENT 'created time',
    `updated_time` datetime DEFAULT NULL COMMENT 'updated time',
    PRIMARY KEY (`id`),
    UNIQUE KEY `t_user_unique_key` (`name`, `email`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci;

-- 创建 mock
CREATE TABLE IF NOT EXISTS `t_mock`(
    `mock_id` varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'primary key',
    `t_project_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `mock_name` varchar(50) not null comment 'mock name',
    `mock_desc` varchar(250) comment 'mock desc',
    `mock_path` varchar(250) not null comment 'mock path',
    `mock_method` varchar(10) not null comment 'mock method',
    `mock_headers` longtext comment 'mock headers',
    `mock_cookies` longtext comment 'mock cookies',
    `mock_body` longtext comment 'mock body',
    UNIQUE KEY `t_mock` (`mock_path`, `mock_name`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `t_data`(
    `data_id` varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'primary key',
    `t_project_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `t_scenario_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'scenario',
    `user_id` varchar(32) COLLATE utf8mb4_general_ci NOT null comment '创建人',
    `data_name` varchar(50) not null comment 'name',
    `data_desc` varchar(250) comment 'desc',
    `data_path` varchar(250) not null comment 'path',
    `data_method` varchar(10) not null comment 'method',
    `data_body` longtext comment '所有的可变参数都通过 data body 传入',
    `created_time` datetime DEFAULT NULL COMMENT 'created time',
    `updated_time` datetime DEFAULT NULL COMMENT 'updated time',
    UNIQUE KEY `t_data` (`data_path`, `data_name`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci

-- 场景集合
CREATE TABLE IF NOT EXISTS `t_scenario_folder` (
    `id` bigint(11) auto_increment primary key comment 'primary key',
    `t_project_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `name`  varchar(32) COLLATE utf8mb4_general_ci NOT NULL comment '名字',
    `parent_id` bigint(11) default 0,
    `tree_path` varchar(255) NOT NULL comment ''
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci

-- 创建场景表
CREATE TABLE IF NOT EXISTS `t_scenario` (
    `scenario_id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL primary key comment 'primary key',
    `t_project_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `t_data_id` varchar(32) COLLATE utf8mb4_general_ci not null comment '构造数据的请求 1对1 ',
    `t_env_id` varchar(32) COLLATE utf8mb4_general_ci not null comment '环境变量 variables',
    `t_scenario_folder_id` bigint(11) not null comment '所属 folder',
    `t_scenario_var_id` varchar(32) COLLATE utf8mb4_general_ci not null comment '场景变量 variables',
    `scenario_name` varchar(64) COLLATE utf8mb4_general_ci not null comment 'scenario name',
    `scenario_desc` varchar(250) COLLATE utf8mb4_general_ci comment 'description',
    `scenario_status` int default 0 comment '0-active 1-inactive',
    `user_id` varchar(32) not null comment 'owner',
    `created_time` datetime DEFAULT NULL COMMENT 'created time',
    `updated_time` datetime DEFAULT NULL COMMENT 'updated time',
    UNIQUE KEY `t_scenario` (`scenario_name`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci

-- 需要注意循环依赖
-- 如果 main = 1 sub = 2
-- 那么就不能存在 main = 2 sub = 1
CREATE TABLE IF NOT EXISTS `t_scenario_relation` (
    `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL primary key comment 'primary key',
    `t_project_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `t_scenario_folder_id` bigint(11) not null comment 'folder',
    `main_scenario` varchar(32) COLLATE utf8mb4_general_ci not null comment '主要的场景',
    `sub_scenario` varchar(32) COLLATE utf8mb4_general_ci not null comment '次要的场景',
    `created_time` datetime DEFAULT NULL COMMENT 'created time',
    `updated_time` datetime DEFAULT NULL COMMENT 'updated time'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci

-- 场景变量
-- 如果是场景嵌套的前提下， 变量名称相同该如何处理？  就近原则处理，
-- 嵌套情况下， 先搜索嵌套的变量，如果有则直接取值， 如果没有，就取外面变量， 最后是环境变量
CREATE TABLE IF NOT EXISTS `t_scenario_variables` (
    `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL primary key comment 'primary key',
    `t_project_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `t_scenario_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `t_scenario_folder_id` bigint(11) not null comment 'folder',
    `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL comment 'key',
    `value` varchar(128) COLLATE utf8mb4_general_ci NOT NULL comment 'value',
    `created_time` datetime DEFAULT NULL COMMENT 'created time',
    `updated_time` datetime DEFAULT NULL COMMENT 'updated time'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci

-- 环境变量
CREATE TABLE IF NOT EXISTS `t_env`(
    `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL primary key comment 'primary key',
    `t_project_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL comment 'name'
    `created_time` datetime DEFAULT NULL COMMENT 'created time',
    `updated_time` datetime DEFAULT NULL COMMENT 'updated time'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci

CREATE TABLE IF NOT EXISTS `t_env_variable`(
    `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL primary key comment 'primary key',
    `t_project_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `t_env_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'env',
    `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL comment 'name',
    `value` varchar(128) COLLATE utf8mb4_general_ci NOT NULL comment 'value',
    `created_time` datetime DEFAULT NULL COMMENT 'created time',
    `updated_time` datetime DEFAULT NULL COMMENT 'updated time'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci

CREATE TABLE IF NOT EXISTS `t_api_test`(
    `id` varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'primary key',
    `t_project_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `t_scenario_folder_id` bigint(11) not null comment 'folder',
    `parent_id` varchar(32) not null comment '上一级ID',
    `user_id` varchar(32) COLLATE utf8mb4_general_ci NOT null comment '创建人',
    `name` varchar(50) not null comment 'name',
    `desc` varchar(250) comment 'desc',
    `path` varchar(250) not null comment 'path',
    `method` varchar(10) not null comment 'method',
    `body` longtext comment '所有的可变参数都通过 data body 传入',
    `created_time` datetime DEFAULT NULL COMMENT 'created time',
    `updated_time` datetime DEFAULT NULL COMMENT 'updated time',
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci

CREATE TABLE IF NOT EXISTS `t_api_loop`(
    `id` varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'primary key',
    `status` int default 0 comment '0-active, 1-inactive',
    `parent_id` varchar(32) not null comment '上一级ID不能为空',
    `times` int default 0 comment 'loop times'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci

CREATE TABLE IF NOT EXISTS `t_api_foreach` (
    `id` varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'primary key',
    `status` int default 0 comment '0-active, 1-inactive',
    `parent_id` varchar(32) not null comment '上一级ID',
    `prefix_var` varchar(32) not null comment '输入',
    `output_var` varchar(32) not null comment '输出'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci

CREATE IF NOT EXISTS `t_api_script`(
    `id` varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'primary key',
    `parent_id` varchar(32) not null comment '上一级ID',
    `status` int default 0 comment '0-active, 1-inactive',
    `type` int not null comment '0-if, 1-while, 2-jsr223 pre,3-jsr223-post',
    `script` varchar(250) not null comment 'script'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci



CREATE TABLE IF NOT EXISTS `t_api_header` (
    `id` varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'primary key',
    `t_project_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `t_scenario_folder_id` bigint(11) not null comment 'folder',
    `t_api_id` varchar(32) COLLATE utf8mb4_general_ci not null comment 'project',
    `status` int default 0 comment '0-active, 1-inactive',
    `name` varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'header 头',
    `value` varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'header 值'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci


CREATE TABLE IF NOT EXISTS `t_api_scenario_relation`(
    `id` varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'primary key',
    `t_scenario_folder_id` bigint(11) not null comment 'folder',
    `t_scenario_id` varchar(32) COLLATE utf8mb4_general_ci NOT null,
    `t_api_id` varchar(32) COLLATE utf8mb4_general_ci NOT null
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE utf8mb4_general_ci
