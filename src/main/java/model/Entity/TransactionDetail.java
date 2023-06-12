package model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionDetail {

	
	@Id  
	@Column(length=15)
	private String transID = null; 
	@Column(length=20)
	private String paymentType = null; 
	private int payableAmount;

	
	
	
	public String getTransID() {
		return transID;
	}

	public void setTransID(String transID) {
		this.transID = transID;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(int payableAmount) {
		this.payableAmount = payableAmount;
	} 
	

	
}
