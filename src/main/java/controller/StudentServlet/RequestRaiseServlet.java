package controller.StudentServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.GenerateTrackId;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAO.StudentDAO;
import model.DBconnect.HibernateUtil;
import model.Entity.FeeDueDetail;
import model.Entity.MarkSheetRequest;
import model.Entity.StudentLoginDetail;
import model.Entity.TrackingDetail;

@WebServlet("/RequestRaise")
public class RequestRaiseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside the request raise servlet");

		HttpSession session = request.getSession();
		StudentLoginDetail sld = (StudentLoginDetail) session.getAttribute("loginStudent");

		int regno = sld.getRegisterNo();
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String reqGradesheet = request.getParameter("reqGradeSheet");
		String mobileNo = request.getParameter("mobileNo");
		String dispatchType = request.getParameter("flexRadioDefault");
		String address = request.getParameter("address");

		String trackId = "MSQ-" + GenerateTrackId.giveTrackId(10);

		TrackingDetail track = new TrackingDetail(trackId, "form submission");
		System.out.println("before: " + track.getTrackID() + " " + track.getCurrentstatus() + " " + track.getReqID());

		MarkSheetRequest msq = new MarkSheetRequest(regno, name, department, reqGradesheet, mobileNo, dispatchType,
				address);
		new StudentDAO(HibernateUtil.getSessionFactory());
		StudentDAO.requestRaise(msq);

		track.setReqID(msq);
		new StudentDAO(HibernateUtil.getSessionFactory());
		StudentDAO.saveTrackId(track);

		System.out.println("before update the foreign key" + msq); 

		msq.setTrackId(track);
		StudentDAO.addTrackId(msq);

		System.out.println("after update the foreign key" + msq);    

		
		PrintWriter out = response.getWriter();
		out.println("<h1>succussfully Raised Your Request....</h1>");  
		out.println("<h1>Your Tracking ID :  </h1> " + trackId);  
//		
//		session.setAttribute("showModal", true);
//		response.sendRedirect("student/Message.jsp");

	}

}
