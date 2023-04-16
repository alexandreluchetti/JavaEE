package br.com.alexandre.manager.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

//@WebFilter("/entry")
public class FilterMonitoring implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		System.out.println("FilterMonitoring");
		
		long before = System.currentTimeMillis();
		
		String action = request.getParameter("action");
		
		filterChain.doFilter(request, response);
		
		long after = System.currentTimeMillis();
		System.out.println("Tempo de execução da ação: " + action + " " + (after - before));
		
	}

}
