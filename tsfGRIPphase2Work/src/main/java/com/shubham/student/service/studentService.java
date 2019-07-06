package com.shubham.student.service;
import java.util.List;
import java.util.Optional;

import com.shubham.student.model.Student;
public interface studentService {
	 public List<Student> getStudents();
	 public Optional<Student> getStudentById(int sId); 
	 public Student addNewStudent(Student stud);
	 public Student updateStudent(Student stud);
	 public void deleteStudentById(int sId);
	 public void deleteAllStudents();
}
