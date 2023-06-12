package controller.AdminServlet;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAO.AdminDAO;
import model.DBconnect.HibernateUtil;
import model.Entity.AdminLoginDetail;


@WebServlet("/AdminLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String adminId=request.getParameter("adminId"); 
		String password=request.getParameter("password");  
		
		new AdminDAO(HibernateUtil.getSessionFactory());
		AdminLoginDetail ad =  AdminDAO.verifyAdmin(adminId,password); 
		
		if(ad == null) { 
			session.setAttribute("errorMsg","Invalid Register Number or Password!"); 
			response.sendRedirect("AdminLogin.jsp");
			System.out.println("invalid...");
		} 
		else { 
			session.setAttribute("loginAdmin", ad); 
			response.sendRedirect("Admin/home.jsp");
			System.out.println("successfully");
		}
		System.out.println( adminId +"   "+password);
	}

}
