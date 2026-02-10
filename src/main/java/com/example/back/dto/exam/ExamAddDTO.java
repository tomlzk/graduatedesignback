package com.example.back.dto.exam;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ExamAddDTO {
    private String examName;
    private LocalDateTime examTime;
    private String examPlace;
    private String description;
    private String status;
}
