package br.com.alexandre.manager.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alexandre.manager.model.Database;
import br.com.alexandre.manager.model.User;

public class Login implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		System.out.println("Login " + login);
		
		Database database = new Database();
		User user = database.getUser(login, password);
		
		if(user != null) {
			System.out.print("Usuário existe");
			
			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", user);
			
			return "redirect:entry?action=CompaniesList";
		} else {
			return "redirect:entry?action=FormLogin";
		}
	}

}
