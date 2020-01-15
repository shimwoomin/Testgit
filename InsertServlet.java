package com.naver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = getInitParameter("user");
		System.out.println(user);
		String password = getInitParameter("password");
		System.out.println(password);
		
		ServletContext ctx =getServletContext();
		String driver = ctx.getInitParameter("driver");
		System.out.println(driver);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");

		int age = -1;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}

		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age));
		
		
		ServletContext application = getServletContext();
		application.setAttribute("id", id);
		application.setAttribute("name", name);
		application.setAttribute("age", age);
		application.setAttribute("dto", new MemberDTO(id, name, age));
		
		response.sendRedirect("test.jsp");
		
	
		
	}
}
