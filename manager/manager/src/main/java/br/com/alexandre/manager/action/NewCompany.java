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

public class NewCompany implements Action{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println("Cadastrando nova empresa!");
		
		PrintWriter out = response.getWriter();
		
		String companyName = request.getParameter("companyName");
		String openingDateString = request.getParameter("openingDate");
		
		Date openingDate = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			openingDate = simpleDateFormat.parse(openingDateString);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Company company = new Company();
		company.setName(companyName);
		company.setOpeningDate(openingDate);
		
		Database database = new Database();
		database.add(company);
		
		return "redirect:entry?action=CompaniesList";		
	}

}
