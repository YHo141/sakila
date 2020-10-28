package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.dao.StaffListDao;
import sakila.service.StaffListService;
import sakila.vo.StaffList;


@WebServlet("/auth/StaffListServlet")
public class StaffListServlet extends HttpServlet {

	private StaffListService staffListService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StaffListDao staffListDao = new StaffListDao();
		staffListService = new StaffListService(staffListDao);
		
		ArrayList<StaffList> list = new ArrayList<StaffList>();
		
		list = staffListService.getStaffList();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/auth/StaffList.jsp").forward(request, response);
	}



}
