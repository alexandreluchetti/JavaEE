package br.com.alexandre.manager.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.manager.model.Company;
import br.com.alexandre.manager.model.Database;

public class DisplayCompany implements Action{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Mostrando dados da empresa");
		
		String parameterId = request.getParameter("id");
		Integer id = Integer.valueOf(parameterId);
		
		Database database = new Database();
		Company company = database.getCompanyById(id);
		
		request.setAttribute("company", company);
		
		return "forward:formEditCompany.jsp";
	}

}
