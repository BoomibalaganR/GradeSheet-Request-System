package model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TrackingDetail {

	@Id 
	@Column(length=20)
	private String trackID; 
	@Column(length=20)
	private String currentstatus=null; 
	@OneToOne
	private MarkSheetRequest reqID; 
	
	
	public TrackingDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrackingDetail(MarkSheetRequest reqID) {
		super();
		this.reqID = reqID;
	}
	public TrackingDetail(String trackID, String currentstatus) {
		super();
		this.trackID = trackID;
		this.currentstatus = currentstatus;
	}
	public String getTrackID() {
		return trackID;
	}
	public void setTrackID(String trackID) {
		this.trackID = trackID;
	}
	public String getCurrentstatus() {
		return currentstatus;
	}
	@Override
	public String toString() {
		return "TrackingDetail [trackID=" + trackID + ", currentstatus=" + currentstatus +  "]";
	}
	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}
	public MarkSheetRequest getReqID() {
		return reqID;
	}
	public void setReqID(MarkSheetRequest reqID) {
		this.reqID = reqID;
	}
	
	
}
