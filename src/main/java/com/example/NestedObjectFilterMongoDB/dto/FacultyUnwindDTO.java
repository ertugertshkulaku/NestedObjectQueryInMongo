package com.example.NestedObjectFilterMongoDB.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyUnwindDTO {
    private String _id;
    private FacultyDTO faculty;

}
