CREATE TABLE db_user (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         username VARCHAR(50) NOT NULL UNIQUE COMMENT '登录账号/学号',
                         password VARCHAR(100) NOT NULL COMMENT '密码',
                         name VARCHAR(50) COMMENT '姓名',
                         avatar VARCHAR(255) COMMENT '头像地址',
                         role VARCHAR(20) NOT NULL COMMENT '角色：student/admin',
                         major VARCHAR(50) COMMENT '专业',
                         create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) COMMENT='用户表';
