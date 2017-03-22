package mx.com.anzen.minio.testApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Credencials {

	public static void main(String[] args) {

		  try {

			URL url = new URL("http://52.34.132.4:8080/PrimerLogin/LoginDinamico");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			
			conn.setRequestProperty("cliente", "qwdertywined12345");
			conn.setRequestProperty("usuario", "wined");
			conn.setRequestProperty("identificador-de-sesion", "qwerty12345");
			
			
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
				System.out.println(output); 
				json=json+output;
				 
			}

			JSONParser parser = new JSONParser();  
			JSONArray newJObject = null;
			try {
				newJObject = (JSONArray) parser.parse(json);
				System.out.println("array Json "+newJObject);
				
				  
				
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			
			conn.disconnect();
			
			 

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

		}
}
