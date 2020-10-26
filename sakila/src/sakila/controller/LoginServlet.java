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
	
	//�α��� ������ �̵�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		statsService = new StatsService();
		
		Map<String, Object> map = statsService.getStats();
		
		Stats stats = (Stats)map.get("stats");				//	����ȯ
		int totalCount = (Integer)map.get("totalCount");	//	����ȯ
		
		request.setAttribute("stats", stats);				//	���� ������ ��
		request.setAttribute("totalCount", totalCount);		//	��ü ������ ��
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	//�α��� �׼����� �̵�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String staffId = request.getParameter("id");
		String staffPw = request.getParameter("pw");
		System.out.println(staffId + ": ����� �α��� ���̵�");
		System.out.println(staffPw + ": ����� �α��� ��й�ȣ");
		
		
		//	������ �α���
		staffService = new StaffService();
		
		Staff returnStaff = staffService.getStaffByKey(staffId, staffPw);
		
		System.out.println(returnStaff + "returnStaff �Է°� Ȯ��");
		
		if(returnStaff != null) {		// �׻� �α��� ����
			//	session
			HttpSession session = request.getSession();	
			String email = returnStaff.getEmail();
			String username = returnStaff.getUsername();
			
			request.setAttribute("email", email);
			request.setAttribute("userName", username);
			
			//	indexServlet ������
			session.setAttribute("id", staffId);
			session.setAttribute("loginStaff", username);
			
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			System.out.println("�α��� ����");
			return;
		
		}
		response.sendRedirect(request.getContextPath() + "/LoginServlet");
	}

}
