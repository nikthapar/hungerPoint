package com.hotel;

import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class Fav extends HttpServlet { 
	private static final long serialVersionUID = 1L;  	
    public Fav() {
        super();
    }
    JSONArray arr;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json=new JSONObject();
		JSONObject object= new JSONObject();;
		arr=new JSONArray();
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String cuisine=request.getParameter("cuisine");
		try {			
			   object.put("name",name);
			   object.put("address",address);
			   object.put("cuisine",cuisine);			       			 
			   arr.put(object);
			   json.put("Favourite List", arr);		
			   System.out.println(json);
			   FileWriter fw=new FileWriter("result.json",true);
				fw.write(json.toString());
				fw.flush();
				fw.close();
		}catch(JSONException e) {
			System.out.println("object not created");
		}finally {
		response.setContentType("application/json");
		response.getWriter();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
