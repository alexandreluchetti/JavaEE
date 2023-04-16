package br.com.alexandre.manager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		out.println("Hello world!<br/>Parabéns! Você escreveu seu primeiro Servlet.");
		
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("O servlet Hello World foi chamado!");
		
	}

}
