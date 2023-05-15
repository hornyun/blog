-- blog 创建数据库sql

DROP TABLE IF EXISTS t_user;
CREATE TABLE if not exists t_user
(
    uid          int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    username     varchar(32)  DEFAULT NULL COMMENT '用户名',
    password     varchar(64)  DEFAULT NULL COMMENT '密码',
    email        varchar(200) DEFAULT NULL COMMENT '邮箱',
    homeUrl      varchar(200) DEFAULT NULL COMMENT '个人主页',
    screenName   varchar(32)  DEFAULT NULL,
    created_id   int(10) unsigned DEFAULT '0' COMMENT '创建人id',
    created_time TIMESTAMP    default current_timestamp COMMENT '创建时间',
    activated    int(10) unsigned DEFAULT '0',
    logged       int(10) unsigned DEFAULT '0',
    groupName    varchar(16)  DEFAULT 'visitor',
    PRIMARY KEY (uid),
    UNIQUE KEY name ( username ),
    UNIQUE KEY mail ( email )
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

