package br.com.alexandre.manager.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Database {

	private static List<Company> companies = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
	private static Integer primaryKey = 1;
	
	static {
		Date date = new Date();
		
		Company company = new Company();
		company.setId(primaryKey++);
		company.setName("Alura");
		company.setOpeningDate(date);
		companies.add(company);
		
		Company company1 = new Company();
		company1.setId(primaryKey++);
		company1.setName("Google");
		company1.setOpeningDate(date);
		companies.add(company1);
		
		Company company2 = new Company();
		company2.setId(primaryKey++);
		company2.setName("Facebook");
		company2.setOpeningDate(date);
		companies.add(company2);
		
		Company company3 = new Company();
		company3.setId(primaryKey++);
		company3.setName("Spotify");
		company3.setOpeningDate(date);
		companies.add(company3);
		
		User user = new User();
		user.setLogin("alexandre");
		user.setPassword("123456");
		users.add(user);
	}
	
	public void add(Company company) {
		company.setId(Database.primaryKey++);
		Database.companies.add(company);
	}
	
	public List<Company> getCompanies(){
		return Database.companies;
	}

	public void deleteCompany(Integer id) {
		
		Iterator<Company> iterator = companies.iterator();
		
		while(iterator.hasNext()) {
			Company company = iterator.next();
			
			if(company.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Company getCompanyById(Integer id) {
		
		for (Company company : companies) {
			if(company.getId() == id) {
				return company;
			}
		}
		
		return null;
	}

	public User getUser(String login, String password) {
		
		for(User user : users) {
			if(user.same(login, password)) {
				return user; 
			}
		}
		
		return null;
	}

}
