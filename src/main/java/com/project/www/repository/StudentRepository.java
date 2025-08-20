package com.project.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.www.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
