

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.JSONException;
import org.json.JSONObject;





/** Servlet that prints out the param1, param2, and param3
 *  request parameters. Does not filter out HTML tags.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */

@WebServlet("/restaraunt")
public class testRestaraunt extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Invoking Restaraunt Service";
    String restId= request.getParameter("param1");
    HttpURLConnection conn=null;
    BufferedReader reader=null;
    StringBuilder strBuf = new StringBuilder();  
    String apiUrl="http://localhost:8091/v1/restaurants/" + restId;
   // UriTemplate restTemplate;
   // Restaurant restaurant = restTemplate.getForObject("http://restaraunt-service/v1/restaurants/" + restId, Restaurant.class);
   try {
    URL url = new URL(apiUrl);  
    conn = (HttpURLConnection)url.openConnection();  
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Accept", "application/json");
    if(conn.getResponseCode() != 200) {
    	System.out.println("connection error: "+conn.getResponseCode());
    }
    reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
    String output = null;  
    while ((output = reader.readLine()) != null)  
        strBuf.append(output);  
   }catch(Exception e) {
	   System.out.println(e.getMessage());
   }
   System.out.println("**************");
   System.out.println(strBuf.toString());
   System.out.println("**************");
   JSONObject json=null;
   String name="";
   String id="";
   String address="";
try {
	json = new JSONObject(strBuf.toString());
	id=json.getString("id");
	name=json.getString("name");
	address=json.getString("address");
	System.out.println("values :: "+id+name+address);

    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<UL>\n" +
                "  <LI><B>param1</B>: "
                + id + "\n" +
                "  <LI><B>param2</B>: "
                + name + "\n" +
                "  <LI><B>param3</B>: "
                + address+ "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  }
}
