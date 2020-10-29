package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.dao.StaffListDao;
import sakila.service.StaffListService;
import sakila.vo.StaffList;


@WebServlet("/auth/StaffListServlet")
public class StaffListServlet extends HttpServlet {

	private StaffListService staffListService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		StaffListDao staffListDao = new StaffListDao();
		staffListService = new StaffListService(staffListDao);
		Object ob = session.getAttribute("staffId");
		System.out.println(ob+"세션 리스트 확인");
		
		int staffId = (Integer)ob;
		System.out.println(staffId+"스태프 아이디 확인");
		
		ArrayList<StaffList> list = staffListService.getStaffList(staffId);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/auth/StaffList.jsp").forward(request, response);
	}



}
