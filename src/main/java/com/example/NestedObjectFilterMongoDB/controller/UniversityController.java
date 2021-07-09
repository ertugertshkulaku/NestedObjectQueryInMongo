package com.example.NestedObjectFilterMongoDB.controller;

import com.example.NestedObjectFilterMongoDB.dto.DepartmentDTO;
import com.example.NestedObjectFilterMongoDB.dto.FacultyDTO;
import com.example.NestedObjectFilterMongoDB.dto.UniversityDTO;
import com.example.NestedObjectFilterMongoDB.service.UniversityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    private UniversityServiceInterface universityServiceInterface;

    @PostMapping("/saveUniversity")
    public UniversityDTO saveUniversity(@RequestBody UniversityDTO universityDTO){
        return universityServiceInterface.saveUniversity(universityDTO);
    }

    @PostMapping("/saveFaculty")
    public FacultyDTO saveFaculty(@RequestParam("id")  String universityId, @RequestBody FacultyDTO facultyDTO){
        return universityServiceInterface.saveFaculty(universityId, facultyDTO);
    }
    @PostMapping("/saveDepartment")
    public DepartmentDTO saveDepartment(@RequestParam("id")  String universityId,
                                        @RequestParam("facultyId") String facultyId,
                                        @RequestBody DepartmentDTO departmentDTO){
        return universityServiceInterface.saveDepartment(universityId, facultyId, departmentDTO);
    }

    @GetMapping("/findFacultyByName")
    public List<FacultyDTO> findFacultyByName(@RequestParam("id")  String universityId,@RequestParam("name")  String facultyName){
        return universityServiceInterface.findFacultyByName(universityId, facultyName);
    }

    @GetMapping("/findDepartmentByName")
    public List<DepartmentDTO> findDepartmentByName(@RequestParam("id")  String universityId,
                                                   @RequestParam("facultyId") String facultyId,
                                                   @RequestParam("name")  String departmentName){
        return universityServiceInterface.findDepartmentByName(universityId, facultyId, departmentName);
    }

}
