package controller.AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAO.AdminDAO;
import model.DBconnect.HibernateUtil;
import model.Entity.MarkSheetRequest;

@WebServlet("/FormVerifyServlet")
public class FormVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		MarkSheetRequest msq = (MarkSheetRequest) session.getAttribute("verifyStudent");

		new AdminDAO(HibernateUtil.getSessionFactory()); 
		AdminDAO.toVerifyForm(msq); 
		PrintWriter out = response.getWriter();
		out.println("<h1>succussfully verified form....</h1>");  
		
		
	}

}
