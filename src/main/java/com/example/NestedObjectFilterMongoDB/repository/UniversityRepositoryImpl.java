package com.example.NestedObjectFilterMongoDB.repository;

import com.example.NestedObjectFilterMongoDB.dto.DepartmentDTO;
import com.example.NestedObjectFilterMongoDB.dto.FacultyDTO;
import com.example.NestedObjectFilterMongoDB.dto.UniversityDTO;
import com.example.NestedObjectFilterMongoDB.model.University;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UniversityRepositoryImpl implements UniversityRepositoryInterface{

    @Autowired
    private UniversityMongoRepository universityMongoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UniversityDTO getUniversityById(String universityId) {
        UniversityDTO universityDTO = new UniversityDTO();
        University university = universityMongoRepository.findUniversityById(universityId);
        BeanUtils.copyProperties(university, universityDTO);
        return universityDTO;
    }

    @Override
    public UniversityDTO save(UniversityDTO universityDTO) {
        University university = new University();
        BeanUtils.copyProperties(universityDTO, university);
        universityMongoRepository.save(university);
        BeanUtils.copyProperties(university, universityDTO);
        return universityDTO;
    }

    @Override
    public FacultyDTO saveFaculty(String universityId, FacultyDTO facultyDTO) {
        UniversityDTO universityDTO = getUniversityById(universityId);
        facultyDTO.setUuid(UUID.randomUUID().toString());
       universityDTO.getFaculty().add(facultyDTO);
       save(universityDTO);
        return facultyDTO;
    }

    @Override
    public DepartmentDTO saveDepartment(String universityId, String facultyId, DepartmentDTO departmentDTO) {
        UniversityDTO universityDTO = getUniversityById(universityId);
        List<FacultyDTO> facultyDTOS = universityDTO.getFaculty();
        for (FacultyDTO dto : facultyDTOS){
            if (dto.getUuid().equals(facultyId)){
                departmentDTO.setUuid(UUID.randomUUID().toString());
                if (dto.getDepartment() == null){
                    dto.setDepartment(new ArrayList<>());
                }
                dto.getDepartment().add(departmentDTO);
            }
        }
        save(universityDTO);
        return departmentDTO;
    }

    @Override
    public FacultyDTO findFacultyByName(String universityId, String facultyName) {
        FacultyDTO dto = new FacultyDTO();
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(universityId).and("faculty.facultyName").regex(facultyName));
        List<University> universities =
                mongoTemplate.find(query, University.class, "university");
        for (University university : universities){
            UniversityDTO universityDTO  = new UniversityDTO();
            BeanUtils.copyProperties(university, universityDTO);
            dto = university.getFaculty().get(0);

        }
        return dto;
    }

    @Override
    public List<DepartmentDTO> findDepartmentByName(String universityId, String facultyId, String departmentName) {
        List<DepartmentDTO> dto = new ArrayList<>();
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(universityId).and("faculty.uuid").is(facultyId).and("faculty.department.departmentName").regex(departmentName));
        List<University> universities =
                mongoTemplate.find(query, University.class, "university");
        for (University university : universities){
           FacultyDTO facultyDTO = university.getFaculty().get(0);
           dto = facultyDTO.getDepartment();

        }
        return dto;
    }
}
