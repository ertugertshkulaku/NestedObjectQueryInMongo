package com.example.NestedObjectFilterMongoDB.model;

import com.example.NestedObjectFilterMongoDB.dto.UniversityDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Document(collection = "university")
public class University extends UniversityDTO {


    @Override
    public String getId() {
        return super.getId();
    }
}
