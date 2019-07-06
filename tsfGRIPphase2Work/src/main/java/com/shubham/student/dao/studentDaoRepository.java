package com.shubham.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shubham.student.model.Student;
@Repository
public interface studentDaoRepository extends JpaRepository<Student, Integer>{

}
