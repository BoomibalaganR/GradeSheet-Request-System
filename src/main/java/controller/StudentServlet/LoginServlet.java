package controller.StudentServlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAO.StudentDAO;
import model.DBconnect.HibernateUtil;
import model.Entity.StudentLoginDetail;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession sm=request.getSession(); 
		
		int regno= Integer.parseInt(request.getParameter("regno")); 
		String password= request.getParameter("password");
		System.out.println("before dao calling...");
		
		new StudentDAO(HibernateUtil.getSessionFactory()); 
		StudentLoginDetail lg = StudentDAO.verifyUser(regno, password);
		System.out.println("after dao calling..."); 
		
		if(lg == null) {  	
			sm.setAttribute("errorMsg", "invalid & password");
			response.sendRedirect("StudentLogin.jsp");
			System.out.println("invalid password.....");
		} 
		else {  
			sm.setAttribute("loginStudent", lg);
			System.out.println(lg.getPersonalDetail().getName()+" successfully login ");  
			response.sendRedirect("student/home.jsp");
		}
		
		
		
	}
		


}
