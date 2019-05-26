package com.nilesh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int k = 0;
		/*
		 * Request Dispatching
		//k = (int)req.getAttribute("sum");
		*/
		
		// URL rewriting
		//k = Integer.parseInt(req.getParameter("k"));
		
		/*
		 * Session
		HttpSession session = req.getSession();
		k = (int)session.getAttribute("sum"); 
		*/
		
		/* 
		 * Cookie
		Cookie cookies[] = req.getCookies();
		for(Cookie ck: cookies) {
			if(ck.getName().equals("sum")) {
				k = Integer.parseInt(ck.getValue());
				break;
			}
		}
		*/
		
		//k = k*k;
		//res.getWriter().println("<h2>sq is</h2> " + k);
	}
}
