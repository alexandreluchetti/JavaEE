package br.com.alexandre.manager.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.manager.model.Database;

public class DeleteCompany implements Action{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("Deletando empresa");
		
		String parameterId = request.getParameter("id");
		Integer id = Integer.valueOf(parameterId);
		
		System.out.println(id);
		
		Database database = new Database();
		database.deleteCompany(id);
		
		return "redirect:entry?action=CompaniesList";
	}

}
