package com.backend.crudbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.crudbackend.models.CourseModel;
@Repository
public interface CourseRepository extends JpaRepository<CourseModel,Long>{

}
