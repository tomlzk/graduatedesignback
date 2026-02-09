CREATE TABLE score (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       enroll_id BIGINT NOT NULL COMMENT '报名ID',
                       score INT COMMENT '成绩',
                       result VARCHAR(20) COMMENT '结果：pass/fail',
                       CONSTRAINT fk_score_enroll FOREIGN KEY (enroll_id) REFERENCES enroll(id)
) COMMENT='成绩表';