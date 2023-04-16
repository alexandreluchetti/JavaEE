package br.com.alexandre.manager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alexandre.manager.action.Action;

/**
 * Servlet Filter implementation class FilterAuthorization
 */
//@WebFilter("/entry")
public class FilterEntryController extends HttpFilter implements Filter {
       
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
    	System.out.println("FilterEntryCotroller");
    	
    	HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    	HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    	
    	String className = httpServletRequest.getParameter("action");
    	
    	String fullClassName = "br.com.alexandre.manager.action." + className;
		
		String stringReturn;
		try {
			
			Class classs = Class.forName(fullClassName);
			Action action = (Action) classs.newInstance();
			stringReturn = action.execute(httpServletRequest, httpServletResponse);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] typeAndAddress = stringReturn.split(":");
		if(typeAndAddress[0].equals("forward")) {
			RequestDispatcher requestDespatcher = httpServletRequest.getRequestDispatcher("WEB-INF/view/" + typeAndAddress[1]);
			requestDespatcher.forward(httpServletRequest, httpServletResponse);
		} else {
			httpServletResponse.sendRedirect(typeAndAddress[1]);
		}
	}
}
