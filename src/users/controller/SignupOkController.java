package users.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.model.SignupModel;

/**
 * Servlet implementation class JoinOkController
 */
@WebServlet("/signupok")
public class SignupOkController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		SignupModel model = new SignupModel();
		
		int resultS = model.selectUserCheck(id);
		if(resultS == 1) {
			response.sendRedirect("signup");
		}else {
			int resultI = model.insertJoin(id, pwd, name);
			if(resultI == 1) {
				response.sendRedirect("login");
			}else {
				response.sendRedirect("signup");
			}
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
