package model.DBconnect;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Entity.AdminLoginDetail;
import model.Entity.FeeDueDetail;
import model.Entity.MarkSheetRequest;
import model.Entity.PaymentDetail;
import model.Entity.StudentLoginDetail;
import model.Entity.StudentOfficialDetail;
import model.Entity.StudentPersonalDetail;
import model.Entity.TrackingDetail;
import model.Entity.TransactionDetail;

public class HibernateUtil {

	public static SessionFactory getSessionFactory()  { 
		
		Configuration con = new Configuration(); 
		con.configure(); 
		   
		con.addAnnotatedClass(FeeDueDetail.class);
		con.addAnnotatedClass(AdminLoginDetail.class);
		con.addAnnotatedClass(StudentLoginDetail.class);
		con.addAnnotatedClass(StudentPersonalDetail.class);
		con.addAnnotatedClass(StudentOfficialDetail.class);  
		con.addAnnotatedClass(TransactionDetail.class); 
		con.addAnnotatedClass(MarkSheetRequest.class);	 
		con.addAnnotatedClass(TrackingDetail.class);  
		con.addAnnotatedClass(PaymentDetail.class); 
		
		//ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).getBootstrapServiceRegistry();
		SessionFactory sf = con.buildSessionFactory();
		return sf;
	}

}
