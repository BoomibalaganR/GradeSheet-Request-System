package model.Entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FeeDueDetail {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;  
	private int regno;
	@Column(length=30)
	private String particular = null; 
	private int dueAmount; 
	@Column(length=15)
	private String dueDate = null;   
	@Column(length=10) 
	private String status = null; 
	
	
	public FeeDueDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeeDueDetail(int regno, String particular, int dueAmount, String dueDate, String status) {
		super();
		this.regno = regno;
		this.particular = particular;
		this.dueAmount = dueAmount;
		this.dueDate = dueDate;
		this.status = status;
	} 
	
	

	@Override
	public String toString() {
		return "FeeDueDetail [id=" + id + ", regno=" + regno + ", particular=" + particular + ", dueAmount=" + dueAmount
				+ ", dueDate=" + dueDate + ", status=" + status + "]";
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public int getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(int dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	
	
	
}
