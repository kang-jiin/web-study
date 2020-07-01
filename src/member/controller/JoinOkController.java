package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.JoinModel;

/**
 * Servlet implementation class JoinOkController
 */
@WebServlet("/joinok")
public class JoinOkController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		JoinModel model = new JoinModel();
		
		int resultS = model.selectUserCheck(id);
		String path="";
		if(resultS == 1) {
			//회원가입 창 이동
//			path="WEB-INF/jsp/join.jsp";
			response.sendRedirect("join");
		}else {
			int resultI = model.insertJoin(id, pwd, name);
			if(resultI == 1) {
				//회원가입 성공 창
				path="WEB-INF/jsp/join-ok.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(path);
				rd.forward(request, response);
			}else {
				//회원가입 창 이동
//				path="WEB-INF/jsp/join.jsp";
				response.sendRedirect("join");
			}
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
