package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.Service;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digit.hibernateServlet.model.HibernateManager;
@WebServlet("/update")

public class update extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int aadharno=Integer.parseInt(req.getParameter("aadharno"));
		String name=req.getParameter("name");
		AadharDetails ad=new AadharDetails();
		ad.setAadharno(aadharno);
		ad.setName(name);
		
		
		HibernateManager hbm= new HibernateManager();
		if(hbm.update(aadharno,name)==true) {
			
			resp.sendRedirect("/ServletHibernate/UpdateSuccess.html");
		}
		else {
			resp.sendRedirect("/ServletHibernate/UpdateFailed.html");
			
		}
		//hbm.readAll();
	}
		
	}
	


