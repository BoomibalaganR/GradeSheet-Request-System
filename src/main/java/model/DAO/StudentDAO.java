package model.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Entity.FeeDueDetail;
import model.Entity.MarkSheetRequest;
import model.Entity.StudentLoginDetail;
import model.Entity.TrackingDetail;

public class StudentDAO {

	private static SessionFactory sf = null;

	public StudentDAO(SessionFactory sf) {
		StudentDAO.sf = sf;
	}

	// login...
	public static StudentLoginDetail verifyUser(int registerNo, String password) {
		Session session = sf.openSession();
		System.out.println("before get method...");
		StudentLoginDetail lg = session.get(StudentLoginDetail.class, registerNo);
		System.out.println("after get method..." + lg);
		if (lg == null) {
			return null;
		}
		if (lg.getPassword().equals(password)) {
			return lg;
		}
		return null;
	}

	// reset password....
	public static StudentLoginDetail resetPassword(int regno, String newPsd, String conPsd) {
		System.out.println(regno + " " + newPsd + " " + conPsd);

		Session session = sf.openSession();

		StudentLoginDetail lg = (StudentLoginDetail) session.get(StudentLoginDetail.class, regno); 
		System.out.println(lg);
		if (lg == null) {
			return null;
		}
		Transaction tx = session.beginTransaction();
		lg.setPassword(conPsd);
		tx.commit();
		return lg;

	}

	// request Raise
	public static void requestRaise(MarkSheetRequest msq) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(msq);
		tx.commit();

	}

	// save tracking detail
	public static void saveTrackId(TrackingDetail track) {
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		System.out.println(session.save(track));
		tx.commit();
		session.close();
	}

	// add foreign key for tracking table into markSheet Request table
	public static void addTrackId(MarkSheetRequest msq) {
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		MarkSheetRequest mq = (MarkSheetRequest) session.get(MarkSheetRequest.class, msq.getReqId());
		mq.setTrackId(msq.getTrackId());
		session.saveOrUpdate(mq);

		tx.commit();
		session.close();
	}

	// check status of the application
	public static String checkStatus(String trackId) {

		Session session = sf.openSession();

		TrackingDetail td = (TrackingDetail) session.get(TrackingDetail.class, trackId); 
		if(td == null) {
			System.out.println("invalid track Id"); 
			return null;
		}
		System.out.println("current status: " + td.getCurrentstatus());
		return td.getCurrentstatus();

	}

	// get the fee due detail
	public static List<FeeDueDetail> getFeeDetail(int regno) {

		Session session = sf.openSession();

		Query q = session.createQuery("from FeeDueDetail where regno = : reg AND status = :sta"); 
		q.setParameter("reg", regno); 
		q.setParameter("sta","not paid");
		List<FeeDueDetail> fd = q.list(); 
		
		return fd;

	}

}
