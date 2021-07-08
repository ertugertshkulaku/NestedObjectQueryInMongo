package com.example.NestedObjectFilterMongoDB.service;

import com.example.NestedObjectFilterMongoDB.dto.DepartmentDTO;
import com.example.NestedObjectFilterMongoDB.dto.FacultyDTO;
import com.example.NestedObjectFilterMongoDB.dto.UniversityDTO;
import com.example.NestedObjectFilterMongoDB.repository.UniversityRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityServiceInterface{

    @Autowired
    private UniversityRepositoryInterface universityRepositoryInterface;

    @Override
    public UniversityDTO saveUniversity(UniversityDTO universityDTO) {
        return universityRepositoryInterface.save(universityDTO);
    }

    @Override
    public FacultyDTO saveFaculty(String universityId, FacultyDTO facultyDTO) {
        return universityRepositoryInterface.saveFaculty(universityId, facultyDTO);
    }

    @Override
    public DepartmentDTO saveDepartment(String universityId, String facultyId, DepartmentDTO departmentDTO) {
        return universityRepositoryInterface.saveDepartment(universityId, facultyId, departmentDTO);
    }

    @Override
    public FacultyDTO findFacultyByName(String universityId, String facultyName) {
        return universityRepositoryInterface.findFacultyByName(universityId, facultyName);
    }

    @Override
    public List<DepartmentDTO> findDepartmentByName(String universityId, String facultyId, String departmentName) {
        return universityRepositoryInterface.findDepartmentByName(universityId, facultyId, departmentName);
    }
}
