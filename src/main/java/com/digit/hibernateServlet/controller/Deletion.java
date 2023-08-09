package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digit.hibernateServlet.model.HibernateManager;
@WebServlet("/delete")


public class Deletion extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int aadharno=Integer.parseInt(req.getParameter("aadharno"));
		AadharDetails ad=new AadharDetails();
		
		ad.setAadharno(aadharno);
		
		HibernateManager hbm= new HibernateManager();
		if(hbm.delete(aadharno)==true) {
			
			resp.sendRedirect("/ServletHibernate/DeleteSuccess.html");
		}
		else {
			resp.sendRedirect("/ServletHibernate/DeleteFailed.html");
			
		}
		//hbm.readAll();
	}

}
