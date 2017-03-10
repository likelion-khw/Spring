package emp;

public class EmpVO {
	private int id;
	private String name;
	private String role;
	private int salary;
	private String hiredate;
	private int deptNo;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	@Override
	public String toString() {
		return "(사원번호 = " + id + ", 이름 = " + name + ", 직책 = " + role + ", 급여 = " + salary + ", 입사일 = " + hiredate
				+ ", 부서번호 = " + deptNo +")";
	}

}
