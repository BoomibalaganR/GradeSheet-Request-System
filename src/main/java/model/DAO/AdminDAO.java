package model.DAO;

import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Entity.AdminLoginDetail;
import model.Entity.FeeDueDetail;
import model.Entity.MarkSheetRequest;
import model.Entity.StudentPersonalDetail;
import model.Entity.TrackingDetail;

public class AdminDAO {

	private static SessionFactory sf = null;

	public AdminDAO(SessionFactory sf) {
		AdminDAO.sf = sf;
	}

	// login verify
	public static AdminLoginDetail verifyAdmin(String adminId, String password) {

		Session session = sf.openSession();

		AdminLoginDetail ad = (AdminLoginDetail) session.get(AdminLoginDetail.class, adminId);

		if (ad != null) {
			if (ad.getPassword().equals(password)) {
				return ad;
			}
		}

		return null;

	}

//reset login password
	public static AdminLoginDetail resetPassword(String regno, String newPsd, String conPsd) {

		Session session = sf.openSession();
		AdminLoginDetail lg = (AdminLoginDetail) session.get(AdminLoginDetail.class, regno);
		if (lg == null) {
			return null;
		}
		Transaction tx = session.beginTransaction();
		lg.setPassword(conPsd);
		tx.commit();
		return lg;
	}

	// get RequestDetail
	public static List<MarkSheetRequest> getRequestDetail() {

		Session session = sf.openSession();
		String query = "from MarkSheetRequest where trackId.currentstatus = 'form submission'";

		Query q = session.createQuery(query);
		List<MarkSheetRequest> msq = q.list();

//		for (MarkSheetRequest i : msq) {
//			System.out.println(i);
//		}
		return msq;

	}

	// get FeeDueRaise Detail
	public static List<MarkSheetRequest> getDueRaiseDetail() {

		Session session = sf.openSession();
		String query = "from MarkSheetRequest where trackId.currentstatus = 'form verified'";

		Query q = session.createQuery(query);
		List<MarkSheetRequest> msq = q.list();
		for (MarkSheetRequest i : msq) {
			System.out.println(i);
		}
		return msq;
	}

	// raise due for student
	public static boolean toRaiseDue(String Id) {

		int amount = 1200;
		int post = 0;
		Session session = sf.openSession();

		TrackingDetail td = (TrackingDetail) session.get(TrackingDetail.class, Id);

		if (td.getReqID().getDispatchType().equals("By post")) {
			post = 100;
		}
		FeeDueDetail fd = new FeeDueDetail(td.getReqID().getRegno(), "GradeSheet", amount + post, "24-10-2023",
				"not paid");
		session.save(fd);
		System.out.println("successfully inserted into fee due detail...");

		MarkSheetRequest msq = (MarkSheetRequest) session.get(MarkSheetRequest.class, td.getReqID().getReqId());
		msq.setFd(fd);
		session.saveOrUpdate(msq);

		System.out.println("before update:  " + td.getCurrentstatus());

		td.setCurrentstatus("payment raised");
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(td);

		tx.commit();

		System.out.println("after update:  " + td.getCurrentstatus());
		return true;
	}

	// verify form
	public static void toVerifyForm(MarkSheetRequest msq) {

		Session session = sf.openSession();

		StudentPersonalDetail spd = (StudentPersonalDetail) session.get(StudentPersonalDetail.class, msq.getRegno());

		if (spd == null) {
			System.out.println("student not their.....");
		} else {
			System.out.println("student is their.....");
			TrackingDetail td = (TrackingDetail) session.get(TrackingDetail.class, msq.getTrackId().getTrackID());
			td.setCurrentstatus("form verified");

			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(td);
			System.out.println("successfully updated....");
			System.out.println(td);
			tx.commit();
		}

	}

	// get paymentpaid detail
	public static List<MarkSheetRequest> getPaymentPaidDetail() {

		Session session = sf.openSession();
		String query = "from MarkSheetRequest where fd.status = 'paid' AND trackId.currentstatus = 'payment raised' ";
		Query q = session.createQuery(query);
		List<MarkSheetRequest> msq = q.list();

		for (MarkSheetRequest i : msq) {
			System.out.println(i);
		} 
		
		if(msq.isEmpty()) {
			return null;
		} 
		return msq;
	} 
	
	
	//to change status payment verifiedd 
	public static void toVerifyPayment(int reqId) {
		
		Session session = sf.openSession();  
		MarkSheetRequest msq = (MarkSheetRequest)session.get(MarkSheetRequest.class, reqId); 
		
		System.out.println(msq);
		Transaction tx = session.beginTransaction(); 
		msq.getTrackId().setCurrentstatus("payment verification"); 
		session.saveOrUpdate(msq);
		tx.commit();
		
	}
	
	

}
