package sakila.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StaffService;
import sakila.service.StatsService;
import sakila.vo.Staff;
import sakila.vo.Stats;


@WebServlet({"/","/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private StatsService statsService;
	private StaffService staffService;
	
	//로그인 폼으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		statsService = new StatsService();
		
		Map<String, Object> map = statsService.getStats();
		
		Stats stats = (Stats)map.get("stats");				//	형변환
		int totalCount = (Integer)map.get("totalCount");	//	형변환
		
		request.setAttribute("stats", stats);				//	오늘 접속자 수
		request.setAttribute("totalCount", totalCount);		//	전체 접속자 수
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	//로그인 액션으로 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String staffId = request.getParameter("id");
		String staffPw = request.getParameter("pw");
		System.out.println(staffId + ": 사용자 로그인 아이디");
		System.out.println(staffPw + ": 사용자 로그인 비밀번호");
		
		
		//	스태프 로그인
		staffService = new StaffService();
		
		Staff returnStaff = staffService.getStaffByKey(staffId, staffPw);
		
		System.out.println(returnStaff + "returnStaff 입력값 확인");
		
		if(returnStaff != null) {		// 항상 로그인 성공
			//	session
			HttpSession session = request.getSession();	
			String email = returnStaff.getEmail();
			String username = returnStaff.getUsername();
			
			request.setAttribute("email", email);
			request.setAttribute("userName", username);
			
			//	indexServlet 포워딩
			session.setAttribute("id", staffId);
			session.setAttribute("loginStaff", username);
			
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			System.out.println("로그인 성공");
			return;
		
		}
		response.sendRedirect(request.getContextPath() + "/LoginServlet");
	}

}
