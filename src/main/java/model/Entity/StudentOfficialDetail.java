package model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StudentOfficialDetail {

	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length=20)
	private String departmentName; 
	
	@Column(length=10)
	private String currentSem; 
	
	@OneToOne
	private  StudentPersonalDetail spd;
	 
	
	
	
	public StudentOfficialDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentOfficialDetail( String departmentName, String currentSem) {
		super();
		
		this.departmentName = departmentName;
		this.currentSem = currentSem;
	}
	public StudentPersonalDetail getSpd() {
		return spd;
	}
	public void setSpd(StudentPersonalDetail spd) {
		this.spd = spd;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getCurrentSem() {
		return currentSem;
	}
	public void setCurrentSem(String currentSem) {
		this.currentSem = currentSem;
	} 
	
	
	
	
	
}
