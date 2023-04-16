package br.com.alexandre.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import br.com.alexandre.manager.model.Company;
import br.com.alexandre.manager.model.Database;

@WebServlet("/companies")
public class ServiceCompanies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Company> companies = new Database().getCompanies();
		
		String headerValue = request.getHeader("Accept");
		
		System.out.println(headerValue);
		
		if(headerValue.contains("xml")) {
			XStream xstream = new XStream(new StaxDriver());
			xstream.alias("company", Company.class);
			String xml = xstream.toXML(companies);
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		} else if(headerValue.contains("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(companies);
			
			response.setContentType("application/json");
			response.getWriter().print(json);
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
		}
	}

}
