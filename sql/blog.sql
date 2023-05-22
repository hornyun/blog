-- create t_blog_menu table
drop table if exists t_blog_menu;
CREATE TABLE `t_blog_menu` (
    `id` varchar(32),
    `menu_name` varchar(255) DEFAULT NULL,
    `parent_id` varchar(32) DEFAULT NULL,
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;
-- add img column
alter table t_blog_menu add column img varchar(32);

-- update colum
alter table `t_blog_menu` MODIFY COLUMN img varchar(255);