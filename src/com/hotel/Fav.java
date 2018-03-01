package com.hotel;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json=new JSONObject();
		JSONObject object;
		JSONArray arr=new JSONArray();
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String cuisine=request.getParameter("cuisine");
		try {
			 int count = 10;
			   for (int i=0 ; i<count ; i++)
			   {
			       object = new JSONObject();
			       object.put(i+"name",name);
				   object.put("address",address);
				   object.put("cuisine",cuisine);
			       arr.put(object);
			   }
			   json.put("Favourite List", arr);			
		}catch(JSONException e) {
			System.out.println("object not created");
		}
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
