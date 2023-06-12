package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;




public class SendOtp {
	public static void sendOtp(String message, String number,String apiKey) {
		try {
			String sendId="FSTSMS"; 
			String language="english"; 
			String route="p"; 
			
			message=URLEncoder.encode(message,"UTF-8");   
			
			
			String myUrl="https://www.fast2sms.com/dev/bulkauthorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number; 
			
			URL url=new URL(myUrl); 
			HttpsURLConnection con=(HttpsURLConnection)url.openConnection(); 
			
			con.setRequestMethod("GET"); 
			
			con.setRequestProperty("User-Agent", "Mozilla/110.0.1");
			con.setRequestProperty("cache-control", "no-cache"); 
			
			System.out.println("wait....");
			int responseCode = con.getResponseCode();  
			System.out.println(responseCode);
			StringBuffer response = new StringBuffer(); 
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));  
			
			
			while(true) {
				String line=br.readLine(); 
				if(line==null) {
					break;
				} 
				
				response.append(line);
			}  
			
			System.out.println(response);
			
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
