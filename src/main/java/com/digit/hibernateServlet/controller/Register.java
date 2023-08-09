package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.digit.hibernateServlet.model.*;

import com.digit.hibernateServlet.bean.AadharDetails;



@WebServlet("/Register")
public class Register extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int aadharno=Integer.parseInt(req.getParameter("aadharno"));
		String name=req.getParameter("name");
		//String father_name=req.getParameter("father_name");
		int age=Integer.parseInt(req.getParameter("age"));
		String address=req.getParameter("address");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String country=req.getParameter("country");
		long  phoneno=Integer.parseInt(req.getParameter("phoneno"));
		//long pin=Integer.parseInt(req.getParameter("pin"));
		//String email=req.getParameter("email_id");
		
		
		 AadharDetails ad=new AadharDetails();
	    ad.setAadharno(aadharno);
		ad.setName(name);
		ad.setAge(age);
		ad.setAddr(address);
		ad.setCity(city);
		ad.setState(state);
		ad.setCountry(country);
		ad.setPhoneno(phoneno);
		HibernateManager hbm=new HibernateManager();

		if(hbm.saveObj(ad)==true) {
			
			resp.sendRedirect("/ServletHibernate/RegisterSuccesshtml.html");
		}
		else {
			resp.sendRedirect("/ServletHibernate/RegisterFail.html");
					
		}
		//hbm.readAll();
		
		
	}

}
