import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.DBconnect.HibernateUtil;
import model.Entity.StudentLoginDetail;
import model.Entity.StudentOfficialDetail;
import model.Entity.StudentPersonalDetail;

public class AddDetail {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		System.out.println(sf);

		StudentPersonalDetail spd1 = new StudentPersonalDetail(2312,"varshini kp","19-10-2000","kumaresan J","parvathi k", "2/321 yogam nagar,vinayakar temple,kumbakonam", "9488840673", "9791792079", "varshiniKp_01@gmail.com");
		
		Transaction tx = session.beginTransaction(); 
		session.save(spd1);
		tx.commit(); 
		
		StudentOfficialDetail sod = new StudentOfficialDetail("msc microbiology","3"); 
		sod.setSpd(spd1); 
		Transaction tx1 = session.beginTransaction(); 
		session.save(sod);
		tx1.commit(); 
		
		StudentLoginDetail sld = new StudentLoginDetail(2312,"varsh");  
		sld.setPersonalDetail(spd1);
		Transaction tx2 = session.beginTransaction(); 
		session.save(sld);
		tx2.commit();  
		
		Transaction tx3= session.beginTransaction();  
		StudentPersonalDetail s = (StudentPersonalDetail)session.get(StudentPersonalDetail.class, 2312); 
		s.setSod(sod);
		session.saveOrUpdate(sod);
		tx3.commit(); 
		session.close();
	}
}
