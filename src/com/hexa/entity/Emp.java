package com.hexa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
@Table(name="hexa_employee")
public class Emp {

	@Id
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_name", length=25, nullable=false)
	private String empName;
	
	@Column(name="emp_sal", nullable=false)
	private double empSal;
	
	@Column(name="emp_dept", length=20,nullable=false)
	private String dept;
	
	@Column(name="emp_doj", nullable=false)
	private LocalDate doj;
	
	public Emp() {
		
	}

	public Emp(int empId, String empName, double empSal, String dept, LocalDate doj) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.dept = dept;
		this.doj = doj;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
	   return empId + " " + empName + " " + empSal + " " + dept + " " + doj + " ";
	}
	
	
	
	
}
