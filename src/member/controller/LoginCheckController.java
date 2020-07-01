package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.LoginModel;

@WebServlet("/logincheck")
public class LoginCheckController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		LoginModel model = new LoginModel();
		int result = model.selectIdCheck(id, pwd);
		
		String path="";
		if(result == 1) {
			System.out.println("로그인 완료");
			path = "WEB-INF/jsp/main.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else {
			System.out.println("로그인 실패");
//			path = "WEB-INF/jsp/login.jsp";
			response.sendRedirect("login");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
