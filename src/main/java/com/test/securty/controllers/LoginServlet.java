package com.test.securty.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.securty.config.PasswordHashing;
import com.test.securty.dto.UserDto;
import com.test.securty.service.IUserService;
import com.test.securty.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(name = "login", value = "/login" )
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger log = LoggerFactory.getLogger(LoginServlet.class);
	private IUserService userService = new UserService();
	private PasswordHashing hashPassword = new PasswordHashing();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//log.info(" password:"+ password);
		log.info(" username:"+ username);
		try {
			Optional<UserDto> user = userService.login(username, hashPassword.hashPassword(password));
		if(user.isPresent()) {
			request.getSession().setAttribute("username", username);
			response.sendRedirect("admin");
		}else {
			response.sendRedirect("login");
		}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Erreur lors de la tentative de connexion");
			log.error("err", e);
			response.sendRedirect("login");
		}
	
	}

}
