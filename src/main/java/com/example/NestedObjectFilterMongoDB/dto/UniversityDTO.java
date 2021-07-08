package com.example.NestedObjectFilterMongoDB.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UniversityDTO {

    private String id;
    private String name;
    private List<FacultyDTO> faculty;
    private String createdDate;
    private String rate;


}
