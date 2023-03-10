package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private List<Student> theStudents;
	
	// define @PostConstruct to define the List of students for once only
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Rohan", "Arora"));
		theStudents.add(new Student("Sanju", "Mehla"));
		theStudents.add(new Student("Aakash", "Gadekar"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){		
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// check the studentId against list size
		if((studentId >= theStudents.size()) || studentId<0) {
			throw new StudentNotFoundException("Student id not found - "+ studentId);
		}
		
		// here jackson will convert the POJO to JSON by itself...
		return theStudents.get(studentId);
	}
	
}
