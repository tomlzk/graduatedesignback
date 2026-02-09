CREATE TABLE exam (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      exam_name VARCHAR(100) NOT NULL COMMENT '考试名称',
                      exam_time DATETIME COMMENT '考试时间',
                      exam_place VARCHAR(100) COMMENT '考试地点',
                      description VARCHAR(255) COMMENT '考试说明',
                      status VARCHAR(20) DEFAULT 'open' COMMENT '状态：open/close',
                      create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) COMMENT='考证信息表';