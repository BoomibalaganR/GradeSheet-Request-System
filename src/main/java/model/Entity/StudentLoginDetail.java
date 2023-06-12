package model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity 
public class StudentLoginDetail {

	@Id   
	private int RegisterNo;  
	@Column(length=10)
	private String password = null;  
	@OneToOne
	private StudentPersonalDetail personalDetail;

	

	
	public StudentLoginDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentLoginDetail(int registerNo, String password) {
		super();
		RegisterNo = registerNo;
		this.password = password;
	}

	public StudentPersonalDetail getPersonalDetail() {
		return personalDetail;
	}

	public void setPersonalDetail(StudentPersonalDetail personalDetail) {
		this.personalDetail = personalDetail;
	}
	

	public int getRegisterNo() {
		return RegisterNo;
	}

	public void setRegisterNo(int registerNo) {
		RegisterNo = registerNo;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
