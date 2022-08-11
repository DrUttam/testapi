package com.sts.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employeedetals")
public class EmployeeDetails {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "firstName")
	private String firstName;

		@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	//@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "doj")	
	private Date doj;
	
	@Column(name = "salary")
	private int salary;

	
	

	
	public EmployeeDetails() {
		
	}
	
	
	

	


//	public EmployeeDetails(String firstName, String lastName, String emailId, String mobileNo, Date doj,
//			int salary) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.emailId = emailId;
//		this.mobileNo = mobileNo;
//		this.doj = doj;
//		this.salary = salary;
//	}







	public long getId() {
		return id;
	}







	public EmployeeDetails(long id, String firstName, String lastName, String emailId, String mobileNo, Date doj,
			int salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.doj = doj;
		this.salary = salary;
	}







	public void setId(long id) {
		this.id = id;
	}







	public String getFirstName() {
		return firstName;
	}







	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}







	public String getLastName() {
		return lastName;
	}







	public void setLastName(String lastName) {
		this.lastName = lastName;
	}







	public String getEmailId() {
		return emailId;
	}







	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}







	public String getMobileNo() {
		return mobileNo;
	}







	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}







	public Date getDoj() {
		return doj;
	}







	public void setDoj(Date doj) {
		this.doj = doj;
	}







	public int getSalary() {
		return salary;
	}







	public void setSalary(int salary) {
		this.salary = salary;
	}






	
}

