package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import sakila.dao.CustomerListDao;
import sakila.util.DBUtil;
import sakila.vo.CustomerList;

public class CustomerListService {
	private CustomerListDao customerDao;
	
	public CustomerListService(CustomerListDao customerDao) {
		this.customerDao = customerDao;
	}
	
	
	public ArrayList<CustomerList> getCustomerList() {
		
		ArrayList<CustomerList> list = new ArrayList<CustomerList>();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			
			list = customerDao.selectCustomerList(conn);
			System.out.println(list + "list 값");
			
			conn.commit();
		}catch (Exception e) {
			System.out.println("service 예외 발생");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
}
