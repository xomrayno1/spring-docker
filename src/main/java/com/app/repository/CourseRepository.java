package com.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Course;

 

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
	
	@Override
	List<Course> findAll();

}
