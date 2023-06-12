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

@WebServlet("/ResetPassword")
public class ResetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sm = request.getSession();
		int regno = Integer.parseInt(request.getParameter("regno")); 
		//String regno = request.getParameter("regno");
		String newPsd = request.getParameter("newPsd");
		String conPsd = request.getParameter("conPsd");
		if (regno == 0 && newPsd.equals(null) && conPsd.equals(null)) {
			sm.setAttribute("errorMsg", "Please Enter All Detail!!"); 
			response.sendRedirect("student/changePassword.jsp");

		} else {
			if (newPsd.equals(conPsd)) {
				new StudentDAO(HibernateUtil.getSessionFactory());
				if (StudentDAO.resetPassword(regno, newPsd, conPsd) == null) {
					sm.setAttribute("regError", "Enter Valid studentReg!!!!");
					response.sendRedirect("student/changePassword.jsp");
				} else {
					sm.setAttribute("successMsg", "Password Changed Successfully!!!");
					response.sendRedirect("StudentLogin.jsp");
				}
			} else {
				sm.setAttribute("errorMsg", "Mis-match confirm password!!!");
				response.sendRedirect("student/changePassword.jsp");
			}
		}
	}

}
