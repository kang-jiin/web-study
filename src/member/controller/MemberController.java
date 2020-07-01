package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.MemberModel;
import member.vo.MemberVO;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberModel model = new MemberModel();
		ArrayList<MemberVO> mlist = model.selectMembers();
		
		
		request.setAttribute("mlist", mlist);
							//mlist = model.selectMembers();
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/member-list.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
