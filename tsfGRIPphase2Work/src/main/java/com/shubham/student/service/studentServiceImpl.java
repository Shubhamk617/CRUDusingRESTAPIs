package com.shubham.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.student.dao.studentDaoRepository;
import com.shubham.student.model.Student;

@Service
public class studentServiceImpl implements studentService {

	@Autowired
	studentDaoRepository studDao;

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studDao.findAll();
	}

	public Optional<Student> getStudentById(int sId) {
		// TODO Auto-generated method stub
		 return studDao.findById(sId);
	}

	public Student addNewStudent(Student stud) {
		// TODO Auto-generated method stub
		return studDao.save(stud);
	}

	public Student updateStudent(Student stud) {
		// TODO Auto-generated method stub
		 return studDao.save(stud);
	}

	public void deleteStudentById(int sId) {
		// TODO Auto-generated method stub
		studDao.deleteById(sId);
	}

	public void deleteAllStudents() {
		// TODO Auto-generated method stub
		studDao.deleteAll();
	}

}
