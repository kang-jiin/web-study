package users.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import users.model.LoginModel;
import users.vo.UsersVO;

@WebServlet("/logincheck")
public class LoginCheckController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		LoginModel model = new LoginModel();
		
		UsersVO mvo = model.selectIdCheck(id, pwd);
		
		if(mvo.getId() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userID", mvo.getId());
			session.setAttribute("userNAME", mvo.getName());			

			response.sendRedirect("main");
		} else {
			request.setAttribute("loginFlag", "Fail");
			response.sendRedirect("login");
		}		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
