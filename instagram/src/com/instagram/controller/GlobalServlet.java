package com.instagram.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.instagram.entity.InstagramEmployee;
import com.instagram.service.InstagramService;
import com.instagram.service.InstagramServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		String s=request.getParameter("ac");
		if(s.equals("register"))
		{
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			
			InstagramEmployee ie=new InstagramEmployee();
			ie.setName(name);
			ie.setPass(pass);
			ie.setEmail(email);
			ie.setAddress(address);
			InstagramServiceInterface is = InstagramService.createServiceObject();
			int i = is.createProfile(ie);
			if(i>0)
			{
				out.println("profile created");
			}
			else
			{
				out.println("could not create profile");
			}
			out.println("</body></html>");
		}
	}

}
