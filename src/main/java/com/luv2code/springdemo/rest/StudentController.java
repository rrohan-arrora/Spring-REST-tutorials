package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	@GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Rohan", "Arora"));
		students.add(new Student("Sanju", "Mehla"));
		students.add(new Student("Aakash", "Gadekar"));
		
		return students;
	}
}
