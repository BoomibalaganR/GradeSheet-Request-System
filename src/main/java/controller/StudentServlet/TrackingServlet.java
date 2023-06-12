package controller.StudentServlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAO.StudentDAO;
import model.DBconnect.HibernateUtil;

@WebServlet("/TrackingServlet")
public class TrackingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		System.out.println("inside the tracking servlet...");
		String trackId = request.getParameter("refNo");
		System.out.println("trackId : " + trackId);

		new StudentDAO(HibernateUtil.getSessionFactory());
		String currentStatus = StudentDAO.checkStatus(trackId);

		if (currentStatus == null) {
			session.setAttribute("errorMsg", "Invalid Reference Number");
			response.sendRedirect("student/tracking.jsp");

		} else {
			session.setAttribute("currentStatus",currentStatus ); 
			session.setAttribute("ID", trackId);
			response.sendRedirect("student/tracking.jsp");
		}

	}

}
