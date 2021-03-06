package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.bean.InPatient;
import com.cts.service.InPatientRecordsService;
import com.cts.service.InPatientRecordsServiceImpl;


@WebServlet("/InPatientDisplayController")
public class InPatientDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	InPatientRecordsService ips = new InPatientRecordsServiceImpl();
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();

		for (InPatient i : ips.displayRecords()) {
			pw.println(i);
		}
		
		HttpSession session = request.getSession(false);
		if(session != null)
			session.invalidate();

	}
}
