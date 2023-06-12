package controller.AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAO.AdminDAO;
import model.DAO.StudentDAO;
import model.DBconnect.HibernateUtil;
import model.Entity.MarkSheetRequest;

@WebServlet(name = "PaymentVerifyServlet", urlPatterns = { "/PaymentVerifyServlet" })
public class PaymentVerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside the payment verification servlet");

		HttpSession session = request.getSession();

		new AdminDAO(HibernateUtil.getSessionFactory());
		List<MarkSheetRequest> msq = AdminDAO.getPaymentPaidDetail();

		if (msq == null) {
			session.setAttribute("errorMsg", "No Record Found");
			response.sendRedirect("Admin/paymentVerification.jsp");
		} else {
			session.setAttribute("listOfPaid", msq);
			response.sendRedirect("Admin/paymentVerification.jsp");
		}

//		PrintWriter out = response.getWriter();
//		out.println("<h1> inside the payment verification page....</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		HttpSession session = request.getSession();

		int reqId = Integer.parseInt(request.getParameter("k")); 
		
		new AdminDAO(HibernateUtil.getSessionFactory());
		AdminDAO.toVerifyPayment(reqId);
		
		session.removeAttribute("listOfPaid"); 
		
		session.setAttribute(""
				+ "", "verified Successfully");
		response.sendRedirect("PaymentVerifyServlet");
		
	}
	
	
	

}
