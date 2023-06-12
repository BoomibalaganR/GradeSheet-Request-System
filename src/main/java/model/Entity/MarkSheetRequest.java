package model.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class MarkSheetRequest {
 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reqId; 
	private int regno;
	@Column(length=20) 
	private String  name; 
	@Column(length=20)
	private String department; 
	@Column(length=10)
	private String reqGradesheet; 
	@Column(length=10)
	private String mobileNo;  
	@Column(length=10)
	private String dispatchType; 
	@Column(length=30)
	private String Address;  
	@OneToOne 
	private TrackingDetail trackId;
	@OneToOne 
	private FeeDueDetail fd; 
	@OneToOne 
	private TransactionDetail td; 
	
	
	
	
	public MarkSheetRequest(int regno, String name, String department, String reqGradesheet, String mobileNo,
			String dispatchType, String address) {
		super();
		this.regno = regno;
		this.name = name;
		this.department = department;
		this.reqGradesheet = reqGradesheet;
		this.mobileNo = mobileNo;
		this.dispatchType = dispatchType;
		this.Address = address;	
	
	}

	public MarkSheetRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MarkSheetRequest [reqId=" + reqId + ", regno=" + regno + ", name=" + name + ", department=" + department
				+ ", reqGradesheet=" + reqGradesheet + ", mobileNo=" + mobileNo + ", dispatchType=" + dispatchType
				+ ", Address=" + Address + ", trackId=" + trackId + "]";
	}



	
	public FeeDueDetail getFd() {
		return fd;
	}

	public void setFd(FeeDueDetail fd) {
		this.fd = fd;
	}

	public TransactionDetail getTd() {
		return td;
	}

	public void setTd(TransactionDetail td) {
		this.td = td;
	}

	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public TrackingDetail getTrackId() {
		return trackId;
	}
	public void setTrackId(TrackingDetail trackId) {
		this.trackId = trackId;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getReqGradesheet() {
		return reqGradesheet;
	}
	public void setReqGradesheet(String reqGradesheet) {
		this.reqGradesheet = reqGradesheet;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDispatchType() {
		return dispatchType;
	}
	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}
