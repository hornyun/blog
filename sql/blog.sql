-- 创建文章表
drop table if exists t_blog_article;
CREATE TABLE `t_blog_article` (
    `id` varchar(32) NOT NULL,
    `article_title` varchar(123) DEFAULT NULL COMMENT '文章标题',
    `article_cover` varchar(255) DEFAULT NULL COMMENT '文章封面',
    `article_content` text COMMENT '文章内容',
    `article_introduction` varchar(255) DEFAULT NULL COMMENT '文章简介',
    `user_id` varchar(32) DEFAULT NULL COMMENT '作者id',
    `state` varchar(1) DEFAULT '0' COMMENT '文章状态 0=正常，1=废弃',
    `article_order` smallint(6) DEFAULT '0' COMMENT '文章排序',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `idx_article_title` (`article_title`) USING BTREE COMMENT '文章标题索引'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客文章表';

drop table if exists t_blog_article_category;
create table `t_blog_article_category`(
    `id` varchar(32) not null,
    `category_name` varchar(32) comment '类别名称',
    `parent_id` varchar(32) comment '类别父id',
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章种类表';

drop table if exists t_blog_article_category_map;
create table t_blog_article_category_map(

);