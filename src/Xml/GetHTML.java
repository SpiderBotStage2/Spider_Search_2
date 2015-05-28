package Xml;

import java.io.*;
import java.net.*;

public class GetHTML {
   
   public String getHTML(String urlToRead) {
      URL url; // The URL to read
      HttpURLConnection conn; // The actual connection to the web page
      BufferedReader rd; // Used to read results from the web page
      String line; // An individual line of the web page HTML
      String result = ""; // A long string containing all the HTML
      try {
         url = new URL(urlToRead);
         conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         while ((line = rd.readLine()) != null) {
            result += line;
         }
         rd.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return result;
      
   }
}