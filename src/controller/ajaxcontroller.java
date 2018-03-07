package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.JOptionPane;

@WebServlet("/ajaxcontroller")
public class ajaxcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray fav = new JSONArray();
	JSONObject obj = new JSONObject();
	public ajaxcontroller() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
                response.setContentType("text/plain");		
		String name = request.getParameter("obj");
		String address = request.getParameter("id");
		JSONObject obj1 = new JSONObject();
		obj1.put("Name",name );
		obj1.put("Address", address);
		if (fav.size() <10)
		{
			fav.add(obj1);
			JOptionPane.showMessageDialog(null, "Added to favourites!");
			JOptionPane.showMessageDialog(null, fav.size()+" favourites are added");
		}
		else
			JOptionPane.showMessageDialog(null, "Only 10 favourites are allowed!");
		try {  

			// Writing to a file  
			File file=new File("/home/sapient/Documents/Favourites.json");  
			System.out.println("Writing JSON object to file");   
			file.createNewFile();  
			FileWriter fileWriter = new FileWriter(file);  
			fileWriter.write(fav.toJSONString());  
			fileWriter.flush();  
			fileWriter.close();  
		} 
		catch (IOException e)
		{  
			e.printStackTrace();  
		}  
		}
		catch(Exception e)
		{
			e.printStackTrace();  
		}
	}
}
