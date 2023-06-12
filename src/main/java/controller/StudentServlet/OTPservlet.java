package controller.StudentServlet;

import controller.GenerateOtp;
import controller.SendOtp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OTP")
public class OTPservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
//		String regno = request.getParameter("regno"); 
//		String conPassword1 = request.getParameter("password1"); 
//		String conPassword2 = request.getParameter("cnpassword");  

		String otp = GenerateOtp.giveOtp(5);
		String message = "your OTP is: " + otp;
		String no = "9488840671";
		String apiKey = "7lAivOGpo3EWusjtYndQQTpMKUoftssnBSI8mpjChITFoKi7XXfLkK4TEmXD";

		SendOtp.sendOtp(message,no,apiKey); 
		System.out.println("successfully send otp...");
	}
}
