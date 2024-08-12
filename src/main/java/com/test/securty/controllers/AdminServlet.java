package com.test.securty.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
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
 * Servlet implementation class AdminServlet
 */

@WebServlet(name = "admin", value = "/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LoggerFactory.getLogger(AdminServlet.class);
	
	private IUserService userService = new UserService();
	private PasswordHashing hashPassword = new PasswordHashing();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		List<UserDto> userList = userService.getAll();
		log.info("list des utilisateurs enregistrés");
		log.info(userList.toString());
		request.setAttribute("userList", userList);
		//System.out.println("Users list size after setting attribute: " + request.getAttribute("userList").toString());
		request.getRequestDispatcher("WEB-INF/jsp/users/List.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("classe : AdminServlet, method : doPost");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		log.info("firstName : "+firstName);
		log.info("lastName : "+lastName);
		log.info("email : "+email);
		
		UserDto user = new UserDto( 
				0,
				firstName,
				lastName,
				email,
				hashPassword.hashPassword(password)
			);
		userService.addUser(user);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
