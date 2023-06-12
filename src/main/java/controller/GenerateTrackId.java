package controller;

import java.util.Random;

public class GenerateTrackId {

	public static String giveTrackId(int otpLength) {

		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < otpLength; i++) {
			sb.append(random.nextInt(10));
		}
		String trackId = sb.toString(); 
		System.out.println("inside the generate : "+trackId);
		return trackId;
	}
}
