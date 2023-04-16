package br.com.alexandre.manager.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.manager.model.Company;
import br.com.alexandre.manager.model.Database;

public class FormNewCompany implements Action{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		return "forward:formNewCompany.jsp";		
	}

}
