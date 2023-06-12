package controller.StudentServlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAO.StudentDAO;
import model.DBconnect.HibernateUtil;
import model.Entity.FeeDueDetail;
import model.Entity.StudentLoginDetail;

@WebServlet("/FeeDueServlet")
public class FeeDueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		StudentLoginDetail sld = (StudentLoginDetail) session.getAttribute("loginStudent"); 
		
		if (sld == null) {
			response.sendRedirect("StudentLogin.jsp");
		} else {
			System.out.println(sld.getRegisterNo());
			new StudentDAO(HibernateUtil.getSessionFactory());
			List<FeeDueDetail> fd = StudentDAO.getFeeDetail(sld.getRegisterNo());

			if (fd.isEmpty()) {
				System.out.println("no record found");
				session.setAttribute("emptyFee", "No Record Found");
				response.sendRedirect("student/feeDue.jsp");
			} else {
				System.out.println(fd);
				session.setAttribute("feeDetail", fd);
				response.sendRedirect("student/feeDue.jsp");
			}
		}

	}

}
