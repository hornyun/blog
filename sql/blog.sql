-- 创建文章表
drop table if exists t_blog_article;

CREATE TABLE `t_blog_article` (
    `id` varchar(32) NOT NULL,
    `article_title` varchar(123) DEFAULT NULL COMMENT '文章标题',
    `article_cover` varchar(255) DEFAULT NULL COMMENT '文章封面',
    `content_id` text COMMENT '文章内容id',
    `article_introduction` varchar(512) DEFAULT NULL COMMENT '文章简介',
    `user_id` varchar(32) DEFAULT NULL COMMENT '作者id',
    `state` varchar(1) DEFAULT '0' COMMENT '文章状态 0=正常，1=废弃',
    `article_order` smallint(6) DEFAULT '0' COMMENT '文章排序',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `idx_article_title` (`article_title`) USING BTREE COMMENT '文章标题索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='博客文章表';

drop table if exists t_blog_article_category;
create table `t_blog_article_category`(
    `id` varchar(32) not null,
    `category_name` varchar(32) comment '类别名称',
    `parent_id` varchar(32) comment '类别父id',
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章种类表';

drop table if exists t_blog_article_category_map;
create table `t_blog_article_category_map`(
    `id` varchar(32) not null,
    `category_id` varchar(32) comment '文章类别id'
    `article_id` varchar(32) comment '文章id'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章种类表';

drop table if exists `t_blog_article_content`;
create table `t_blog_article_content`(
    `id` varchar(32) not null,
    `article_id` varchar(32) not null,
    `content` text,
    primary key(`id) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章内容表';
-- 创建用户表
CREATE TABLE `t_blog_user` (
    `id` varchar(32) NOT NULL ,
    `username` varchar(50) NOT NULL COMMENT '用户名',
    `password` varchar(100) DEFAULT NULL COMMENT '密码',
    `salt` varchar(20) DEFAULT NULL COMMENT '盐',
    `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
    `github` varchar(100) DEFAULT NULL COMMENT 'github地址',
    `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
    `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：正常   1：金融',
    `create_id` varchar(32) DEFAULT NULL COMMENT '创建者ID',
    `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='博客系统用户表';
-- 创建博客系统菜单表
CREATE TABLE `t_blog_menu` (
    `id` varchar(32) NOT NULL,
    `parent_id` varchar(32) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
    `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
    `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
    `permission` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
    `type` varchar(1) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
    `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
    `order_num` int(11) DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='博客系统菜单管理';

-- 创建博客系统角色表
CREATE TABLE `t_blog_role` (
    `id` varchar(32) NOT NULL,
    `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
    `remark` varchar(100) DEFAULT NULL COMMENT '备注',
    `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
    `create_time` timestamp DEFAULT current_timestamp COMMENT '创建时间',
    `update_time` timestamp DEFAULT current_timestamp COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='博客系统角色';

-- 创建角色菜单表
CREATE TABLE `t_blog_role_menu` (
    `id` varchar(32) NOT NULL,
    `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
    `menu_id` varchar(32) DEFAULT NULL COMMENT '菜单ID',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色与菜单对应关系';

-- 创建用户角色表
CREATE TABLE `t_blog_user_role` (
    `id` varchar(32) NOT NULL,
    `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
    `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与角色对应关系';
