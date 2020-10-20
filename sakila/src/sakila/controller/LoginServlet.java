package sakila.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StatsService;
import sakila.vo.Stats;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private StatsService statsService;
	
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

	}

}
