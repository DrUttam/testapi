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
	
	
	
	@GetMapping("/calculatetaxs/{id}")
	public ResponseEntity<Map> taxEmployee(@PathVariable Long id){
		EmployeeDetails employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		

		int empsalary = employee.getSalary();
		Date deoj = employee.getDoj();

		  ZoneId defaultZoneId = ZoneId.systemDefault();
		  LocalDate startdate = sdformat.parse("2022-04-01");
	      LocalDate enddate = sdformat.parse("2023-03-31");
	      LocalDate dojd = new java.sql.Date(deoj.getTime()).toLocalDate();
	      
	
	    int Totalsalary=0;
	    int month = 0;
	    int days = 0;
	      if(startdate.compareTo((ChronoLocalDate) dojd) > 0) {
	         month = 12; 
	         days= 0;
	         
	      } else {
	    	  Period p = Period.between(dojd, enddate);
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
				tax=0.05*(i-250000);
			else if(i<=1000000)
				tax=(0.1*(i-500000))+12500;
			
			else
				tax=(0.2*(i-1000000))+62500;
		
		if (i>2500000) {
		tax = tax + ((i-2500000)*0.2);		
		}

		Map map = new HashMap();
		map.put("tax", tax);
//		map.put("doj", dojd);
		map.put("salary", empsalary);
		map.put("Total salary", Totalsalary);
		//map.put("Total month", month);
		//map.put("Total day", days);
		map.put("name", employee.getFirstName());
		return ResponseEntity.ok(map);
	}

}
	