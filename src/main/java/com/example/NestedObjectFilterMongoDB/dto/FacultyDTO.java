package com.example.NestedObjectFilterMongoDB.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Data
@NoArgsConstructor
public class FacultyDTO {

    private String uuid;
    private String facultyName;
    private List<DepartmentDTO> department;



}
