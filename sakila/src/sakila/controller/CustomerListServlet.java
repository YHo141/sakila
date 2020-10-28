package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.dao.CustomerListDao;
import sakila.service.CustomerListService;
import sakila.vo.CustomerList;


@WebServlet("/auth/CustomerServlet")
public class CustomerListServlet extends HttpServlet {

	private CustomerListService customerService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerListDao customerDao = new CustomerListDao();
		customerService = new CustomerListService(customerDao);
		
		ArrayList<CustomerList> list = new ArrayList<CustomerList>();
		
		list = customerService.getCustomerList();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/auth/CustomerList.jsp").forward(request, response);
	}


}
