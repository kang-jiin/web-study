package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.LoginModel;
import member.vo.MemberVO;

@WebServlet("/logincheck")
public class LoginCheckController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		LoginModel model = new LoginModel();
		
		MemberVO mvo = model.selectIdCheck(id, pwd);
//		int result = model.selectIdCheck(id, pwd);
		
		String path="";
		if(mvo != null) {
			path = "WEB-INF/index.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			request.setAttribute("loginFlag", "suc");
			
			HttpSession session = request.getSession();
			session.setAttribute("userID", mvo.getId());
			session.setAttribute("userNAME", mvo.getName());			

			rd.forward(request, response);
		} else {
			request.setAttribute("loginFlag", "Fail");
			response.sendRedirect("login");
		}		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
