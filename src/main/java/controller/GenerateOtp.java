package controller;

import java.util.Random;

public class GenerateOtp {

	public static String giveOtp(int otpLength) {

		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < otpLength; i++) {
			sb.append(random.nextInt(10));
		}
		String otp = sb.toString();
		return otp;
	}
}
