package com.example.NestedObjectFilterMongoDB.repository;

import com.example.NestedObjectFilterMongoDB.dto.DepartmentDTO;
import com.example.NestedObjectFilterMongoDB.dto.FacultyDTO;
import com.example.NestedObjectFilterMongoDB.dto.UniversityDTO;

import java.util.List;

public interface UniversityRepositoryInterface {

    UniversityDTO getUniversityById(String universityId);

    UniversityDTO save(UniversityDTO universityDTO);

    FacultyDTO saveFaculty(String universityId, FacultyDTO facultyDTO);

    List<FacultyDTO> findFacultyByName(String universityId, String facultyName);

    DepartmentDTO saveDepartment(String universityId, String facultyId, DepartmentDTO departmentDTO);

    List<DepartmentDTO> findDepartmentByName(String universityId, String facultyId, String departmentName);
}
