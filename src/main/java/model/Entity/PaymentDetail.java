package model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payId;
	@Column(length = 16)
	private String cardNo = null;
	@Column(length = 20)
	private String holderName = null;
	@Column(length = 5)
	private String expiryDate = null;
	@Column(length = 3)
	private String cvvNo = null;

	public PaymentDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentDetail(String cardNo, String holderName, String expiryDate, String cvvNo) {
		super();
		this.cardNo = cardNo;
		this.holderName = holderName;
		this.expiryDate = expiryDate;
		this.cvvNo = cvvNo;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvvNo() {
		return cvvNo;
	}

	public void setCvvNo(String cvvNo) {
		this.cvvNo = cvvNo;
	}

}
