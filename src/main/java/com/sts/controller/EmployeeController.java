package com.sts.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
	private LocalDate sdformat;
	
	
		
	
	// create employee rest api
	@PostMapping("/captureemployee")
	public EmployeeDetails createStudent(@RequestBody EmployeeDetails employee) {
		return employeeRepository.save(employee);
	}
	
	
	
	// get employee by id rest api
	@GetMapping("/calculatetaxs/{id}")
	public ResponseEntity<EmployeeDetails> getEmployeeById(@PathVariable Long id) {
		EmployeeDetails employee = employeeRepository.findById(id)
				.orElseThrow(() -> new com.sts.exception.ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	

	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Map> taxEmployee(@PathVariable Long id){
		EmployeeDetails employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		

		int empsalary = employee.getSalary();
		Date deoj = employee.getDoj();

		   	 ZoneId defaultZoneId = ZoneId.systemDefault();
		  LocalDate startdate = sdformat.parse("2022-04-01");
	      LocalDate enddate = sdformat.parse("2023-03-31");
	      LocalDate dojd = deoj.toInstant().atZone(ZoneId.of("America/Los_Angeles")).toLocalDate();
	      
	
	    int Totalsalary=0;
	    int month = 0;
	    int days = 0;
	      if(startdate.compareTo((ChronoLocalDate) dojd) > 0) {
	         month = 12; 
	         days= 0;
	         
	      } else {
	    	  Period p = Period.between(startdate, dojd);
	    	  month =p.getMonths();
	    	  days= p.getDays();
	    	 
	    	 
	      }
	
	      Totalsalary = (empsalary*month)+((empsalary/30)*days);
	      
		    int i = Totalsalary;
			double tax;	
			if(i<=250000){
				tax=0;
			}
			else if(i<=500000)
				tax=0.05*(i-200000);
			else if(i<=1000000)
				tax=(0.1*(i-500000))+12500;
			
			else
				tax=(0.2*(i-1000000))+62500;
		if (i>2500000) {
		tax = tax + (i-2500000)*0.2;		
		}
//         return(empsalary);
		Map map = new HashMap();
		map.put("name", employee.getFirstName());
		map.put("salary", empsalary);
		return ResponseEntity.ok(map);
	}

}
	