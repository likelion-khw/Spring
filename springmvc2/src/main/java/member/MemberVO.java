package member;

public class MemberVO {
	
	String userid;
	String password;
	String name;
	String address;
	String gender;
	String date;
	String callnum;
	String email;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCallnum() {
		return callnum;
	}

	public void setCallnum(String callnum) {
		this.callnum = callnum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MemberVO(String userid, String password, String name, String address, String gender, String date,
			String callnum, String email) {
		super();
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.date = date;
		this.callnum = callnum;
		this.email = email;
	}
	
	

}
