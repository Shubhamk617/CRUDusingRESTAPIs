package com.shubham.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shubham.student.model.Student;
import com.shubham.student.service.studentService;

@RestController
public class studentController {

	@Autowired
	studentService studService;

	@RequestMapping(value = "/students/all", method = RequestMethod.GET)
	public List<Student> getStudents() {
		System.out.println(this.getClass().getSimpleName() + " - Get all Students service is invoked.");
		return studService.getStudents();
	}

	@RequestMapping(value = "/students/{sId}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable int sId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get Student details by id is invoked.");

		Optional<Student> stud = studService.getStudentById(sId);
		if (!stud.isPresent())
			throw new Exception("Could not find Student with id- " + sId);

		return stud.get();
	}

	@RequestMapping(value = "/students/add", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student stud) {
		System.out.println(this.getClass().getSimpleName() + " - Create new Student method is invoked.");
		return studService.addNewStudent(stud);
	}

	@RequestMapping(value = "/students/update/{sId}", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student stud, @PathVariable int sId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update Student details by id is invoked.");

		Optional<Student> stu = studService.getStudentById(sId);
		if (!stu.isPresent())
			throw new Exception("Could not find Student with id- " + sId);

		if (stud.getsName() == null || stud.getsName().isEmpty())
			stud.setsName(stu.get().getsName());

		if (stud.getsBranch() == null || stud.getsBranch().isEmpty())
			stud.setsBranch(stu.get().getsBranch());

		if (stud.getsEmail() == null || stud.getsEmail().isEmpty())
			stud.setsEmail(stu.get().getsEmail());

		stud.setsId(sId);
		return studService.updateStudent(stud);
	}

	@RequestMapping(value = "/students/delete/{sId}", method = RequestMethod.DELETE)
	public void deleteStudentById(@PathVariable int sId) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete Student by id is invoked.");

		Optional<Student> stud = studService.getStudentById(sId);
		if (!stud.isPresent())
			throw new Exception("Could not find Student with id- " + sId);

		studService.deleteStudentById(sId);
	}
	
	 @RequestMapping(value= "/students/deleteall", method= RequestMethod.DELETE)
	    public void deleteAll() {
	        System.out.println(this.getClass().getSimpleName() + " - Delete all students is invoked.");
	        studService.deleteAllStudents();
	    }

}
