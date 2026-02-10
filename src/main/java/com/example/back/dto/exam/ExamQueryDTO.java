package com.example.back.dto.exam;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExamQueryDTO {
    private Long id;
    private String examName;
    private LocalDateTime examTime;
    private String examPlace;
    private String description;
    private String status;
    private Integer pageNum;
    private Integer pageSize;
}
