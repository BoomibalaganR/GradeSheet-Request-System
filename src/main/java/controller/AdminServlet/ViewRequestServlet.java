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

@WebServlet("/ViewRequest")
public class ViewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(); 
		session.removeAttribute("reqList");
		System.out.println("inside the view request servlet");

		new AdminDAO(HibernateUtil.getSessionFactory());
		List<MarkSheetRequest> msq = AdminDAO.getRequestDetail(); 
		
		if (msq.isEmpty()) { 
			System.out.println("list is empty .....");
			session.setAttribute("errorMsg", "No Request Found");
			response.sendRedirect("Admin/requestView.jsp");
		} else { 
			System.out.println("request list .....");
			session.setAttribute("listOfRequest", msq);
			response.sendRedirect("Admin/requestView.jsp");
		}

	}

}
