package com.sts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.exception.ResourceNotFoundException;
import com.sts.model.EmployeeDetails;
import com.sts.repository.EmployeeRepository;





@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	// get all student
//	@GetMapping("/students")
//	public List<EmployeeDetails> getAllStudents(){
//		return studentRepository.findAll();
//	}		
	
	// create employee rest api
	@PostMapping("/employees")
	public EmployeeDetails createStudent(@RequestBody EmployeeDetails employee) {
		return employeeRepository.save(employee);
	}
	
	// get student by id rest api
//	@GetMapping("/students/{id}")
//	public ResponseEntity<EmployeeDetails> getStudentById(@PathVariable Long id) {
//		EmployeeDetails student = studentRepository.findById(id)
//				.orElseThrow(() -> new com.sts.exception.ResourceNotFoundException("Student not exist with id :" + id));
//		return ResponseEntity.ok(student);
//	}
//	
	// update student rest api
	
//	@PutMapping("/students/{id}")
//	public ResponseEntity<EmployeeDetails> updateStudent(@PathVariable Long id, @RequestBody EmployeeDetails studentDetails){
//		EmployeeDetails student = studentRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
//		
//		student.setfirstName(studentDetails.getfirstName());
//		student.setaddress(studentDetails.getaddress());
//		student.setEmailId(studentDetails.getEmailId());
//		student.setMobileNo(studentDetails.getMobileNo());
//		student.setParance_mobileNo(studentDetails.getParance_mobileNo());
//		student.setRegdNo(studentDetails.getRegdNo());
//		student.setPickUpAddress(studentDetails.getPickUpAddress());
//	
//		
//		EmployeeDetails updatedStudent = studentRepository.save(student);
//		return ResponseEntity.ok(updatedStudent);
//	}
//	
	// delete student rest api
//	@DeleteMapping("/students/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){
//		EmployeeDetails student = studentRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
//		
//		studentRepository.delete(student);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
	
	// get student by id rest api
//	@GetMapping("/students/{name}")
//	public ResponseEntity<List<Student>> getStudentByName(@PathVariable String name) {
//		List<Student> listStudents = studentRepository.findByName(name);
//		if(listStudents.size()==0)
//				throw new com.sts.exception.ResourceNotFoundException("Student not exist with  :");
//		return ResponseEntity.ok(listStudents);
//	}

	// Find By User Name
//	@GetMapping("/studentsCallByName/{name}")
//	public List<EmployeeDetails> getAllStudentsByName(@PathVariable String name){
//		return studentRepository.findByName(name);
//	}	
	
}
