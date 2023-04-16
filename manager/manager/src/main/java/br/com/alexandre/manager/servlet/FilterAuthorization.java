package br.com.alexandre.manager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterAuthorization
 */
//@WebFilter("/entry")
public class FilterAuthorization extends HttpFilter implements Filter {
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	public void destroy() {}
       
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
    	System.out.println("FilterAuthorization");
    	
    	HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    	HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    	
    	String className = httpServletRequest.getParameter("action");
    	
    	HttpSession session = httpServletRequest.getSession();
		
		boolean protectedAction = !(className.equals("Login") || className.equals("FormLogin"));
		if(session.getAttribute("loggedUser") == null && protectedAction) {
			httpServletResponse.sendRedirect("entry?action=FormLogin");
			return;
		}
    	
    	chain.doFilter(httpServletRequest, httpServletResponse);
	}
}
