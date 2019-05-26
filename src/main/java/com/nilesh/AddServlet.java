package com.nilesh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j;
		
		/*
		 *  Request Dispatching 
		 *  same req and res object get forwarded 
		//req.setAttribute("sum", k);
		//RequestDispatcher rd = req.getRequestDispatcher("sq");
		//rd.forward(req, res);
		*/
		
		// URL rewriting
		//res.sendRedirect("sq?k=" + k);
		
		/*
		 * Session
		HttpSession session = req.getSession();
		session.setAttribute("sum", k);
		*/
		
		/* 
		 * Cookie
		Cookie ck = new Cookie("sum", k+"");
		res.addCookie(ck);
		*/
		
		// redirect 
		//res.sendRedirect("sq");
		
		PrintWriter out = res.getWriter();
		out.print("<html><body bgcolor=#58D68D>");
		out.print("output is " + k);
		out.print("</body></html>");
	}
}
