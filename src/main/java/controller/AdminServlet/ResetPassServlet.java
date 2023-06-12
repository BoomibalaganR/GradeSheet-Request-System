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



@WebServlet("/AdminReset")
public class ResetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sm = request.getSession();
	 
		String regno = request.getParameter("regno");
		String newPsd = request.getParameter("newPsd");
		String conPsd = request.getParameter("conPsd"); 
		
		if (regno.equals(null) && newPsd.equals(null) && conPsd.equals(null)) {
			sm.setAttribute("errorMsg", "Please Enter All Detail!!"); 
			response.sendRedirect("Admin/changePassword.jsp");

		} else {
			if (newPsd.equals(conPsd)) {
				new AdminDAO(HibernateUtil.getSessionFactory());
				if (AdminDAO.resetPassword(regno, newPsd, conPsd) == null) {
					sm.setAttribute("regError", "Enter Valid Regno!!!!");
					response.sendRedirect("Admin/changePassword.jsp");
				} else {
					sm.setAttribute("successMsg", "Password Changed Successfully!!!");
					response.sendRedirect("AdminLogin.jsp");
				}
			} else {
				sm.setAttribute("errorMsg", "Mis-match confirm password!!!");
				response.sendRedirect("Admin/changePassword.jsp");
			}
		}
	}
	
}
