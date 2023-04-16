package br.com.alexandre.manager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alexandre.manager.action.Action;

//@WebServlet("/entry")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String className = request.getParameter("action");
		
//		HttpSession session = request.getSession();
//		
//		boolean protectedAction = !(className.equals("Login") || className.equals("FormLogin"));
//		if(session.getAttribute("loggedUser") == null && protectedAction) {
//			response.sendRedirect("entry?action=FormLogin");
//			return;
//		}
		
		String fullClassName = "br.com.alexandre.manager.action." + className;
		
		String stringReturn;
		try {
			
			Class classs = Class.forName(fullClassName);
			Action action = (Action) classs.newInstance();
			stringReturn = action.execute(request, response);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] typeAndAddress = stringReturn.split(":");
		if(typeAndAddress[0].equals("forward")) {
			RequestDispatcher requestDespatcher = request.getRequestDispatcher("WEB-INF/view/" + typeAndAddress[1]);
			requestDespatcher.forward(request, response);
		} else {
			response.sendRedirect(typeAndAddress[1]);
		}
	}

}
