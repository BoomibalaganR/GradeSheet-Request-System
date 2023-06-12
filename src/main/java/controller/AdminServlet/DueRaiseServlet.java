package controller.AdminServlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAO.AdminDAO;
import model.DBconnect.HibernateUtil;
import model.Entity.MarkSheetRequest;

@WebServlet("/DueRaiseServlet")
public class DueRaiseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside the due raise servlet");

		HttpSession session = request.getSession();
		new AdminDAO(HibernateUtil.getSessionFactory());
		List<MarkSheetRequest> msq = AdminDAO.getDueRaiseDetail();

		if (msq.isEmpty()) {
			System.out.println("list is empty .....");
			session.setAttribute("errorMsg", "No Record Found");
			response.sendRedirect("Admin/DueRaise.jsp");
		} else {
			System.out.println("request list .....");
			session.setAttribute("listOfDue", msq);
			response.sendRedirect("Admin/DueRaise.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		System.out.println("inside the due raise servlet with post method"); 
	
		HttpSession session = request.getSession();  
		
		
		String Id = request.getParameter("k");
	  //  String Id = (String)session.getAttribute("raiseStudentId");
		System.out.println("inside post method:  "+Id);

		new AdminDAO(HibernateUtil.getSessionFactory());  
		
		if(AdminDAO.toRaiseDue(Id)) { 
			System.out.println("successfully in if .."); 
			
			session.setAttribute("succesRaise", "successfully raised");  

			session.removeAttribute("listOfDue");
			response.sendRedirect("DueRaiseServlet");
		}
		

	}

}
