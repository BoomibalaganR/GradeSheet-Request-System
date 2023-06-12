package model.Entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StudentPersonalDetail {

	@Id
	private int regno;  
	@Column(length=15)
	private String name=null; 
	@Column(length=10) 
	private String dateOfBirth=null; 
	@Column(length=15)
	private String fatherName=null; 
	@Column(length=15)
	private String motherName=null; 
	
	private String Address = null;  
	@Column(length=10)
	private String phoneNumber;  
	@Column(length=10)
	private String alterPhoneNumber;
	@Column(length=25)
	private String email=null;  
	@OneToOne
	private StudentOfficialDetail sod; 
	
	


	public StudentPersonalDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public StudentPersonalDetail(int regno, String name, String dateOfBirth, String fatherName, String motherName,
			String address, String phoneNumber, String alterPhoneNumber, String email) {
		super();
		this.regno = regno;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.Address = address;
		this.phoneNumber = phoneNumber;
		this.alterPhoneNumber = alterPhoneNumber;
		this.email = email;
	}


	public int getRegno() {
		return regno;
	}

	public StudentOfficialDetail getSod() {
		return sod;
	}

	public void setSod(StudentOfficialDetail sod) {
		this.sod = sod;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAlterPhoneNumber() {
		return alterPhoneNumber;
	}

	public void setAlterPhoneNumber(String alterPhoneNumber) {
		this.alterPhoneNumber = alterPhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
