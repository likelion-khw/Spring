package com.spring.mybatis;

import org.springframework.stereotype.Component;

@Component
public class EmpVO {
	
	int id;
	String name;
	String email;
	String hire_date;
	String job_id;
	double salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "사번 =" + id + ", 이름 =" + name + ", 이메일 =" + email + ", 입사일 =" + hire_date + ", 직종 ="
				+ job_id + ", 급여 =" + salary;
	}
	
	// 변수가 sql 의 변수와 이름이 같아야하는게 아니라 getter / setter의 메소드 이름이 같아야한다
	
	
}
