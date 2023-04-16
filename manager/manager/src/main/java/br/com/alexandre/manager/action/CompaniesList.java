package br.com.alexandre.manager.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alexandre.manager.model.Company;
import br.com.alexandre.manager.model.Database;

public class CompaniesList implements Action{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Listando empresas");
		
		Database database = new Database();
		List<Company> companies = database.getCompanies();
		
		request.setAttribute("companies", companies);
		
		return "forward:companiesList.jsp";
	}

}
