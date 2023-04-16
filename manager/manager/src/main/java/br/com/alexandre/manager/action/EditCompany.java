package br.com.alexandre.manager.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.manager.model.Company;
import br.com.alexandre.manager.model.Database;

public class EditCompany implements Action{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println("Editando empresa!");
		
		String companyName = request.getParameter("companyName");
		String openingDateString = request.getParameter("openingDate");
		String parameterId = request.getParameter("id");
		Integer id = Integer.valueOf(parameterId);
		
		Date openingDate = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			openingDate = simpleDateFormat.parse(openingDateString);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Database database = new Database();
		Company company = database.getCompanyById(id);
		company.setName(companyName);
		company.setOpeningDate(openingDate);
		
		return "redirect:entry?action=CompaniesList";
	}

}
