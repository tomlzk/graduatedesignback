CREATE TABLE enroll (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        user_id BIGINT NOT NULL COMMENT '学生ID',
                        exam_id BIGINT NOT NULL COMMENT '考试ID',
                        status VARCHAR(20) DEFAULT 'pending' COMMENT '报名状态：pending/approved/rejected',
                        enroll_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                        CONSTRAINT fk_enroll_user FOREIGN KEY (user_id) REFERENCES user(id),
                        CONSTRAINT fk_enroll_exam FOREIGN KEY (exam_id) REFERENCES exam(id)
) COMMENT='报名表';