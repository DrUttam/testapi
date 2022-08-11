package com.sts.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.model.EmployeeDetails;



@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long>{
	
	//public java.util.List<EmployeeDetails> findByName(String firstName);
//	public java.util.List<EmployeeDetails> findBySallary(String salary);

	public int findBySalary(int salary);

	public Date findByDoj(Date doj); 

}
