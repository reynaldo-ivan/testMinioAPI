package mx.com.anzen.minio.testApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL; 
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 

public class Main {

	public static void main(String[] args) {

		  try {
			URL url = new URL("http://localhost:8080/minio/credenciales");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			  
			String output=null;  
			String json=""; 
			while ((output = br.readLine()) != null) {
//				System.out.println(output); 
				json=json+output;
				 
			}    
			
			
			Object object=null;
			JSONArray arrayObj=null;
			JSONParser jsonParser=new JSONParser();
			 
			try {
				object=jsonParser.parse(json.toString()); 
			 
				arrayObj=(JSONArray) object; 
				
				JSONObject obj2 = (JSONObject)arrayObj.get(0);
				 
				System.out.println("objexct  "+obj2.get("secretket"));
				 
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			conn.disconnect();
			 
		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

		}

}
