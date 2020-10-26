package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;

import sakila.dao.StaffDao;
import sakila.util.DBUtil;
import sakila.vo.Staff;

public class StaffService {
	
	private StaffDao staffDao;
	
	public Staff getStaffByKey(String staffId, String password) {
		staffDao = new StaffDao();
		Staff returnStaff = null;
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			
			System.out.println(conn + "conn ���� Ȯ��");
			
			Staff staff = new Staff();
			staff.setEmail(staffId);
			staff.setPassword(password);
			
			returnStaff = staffDao.selectStaffByKey(conn, staff);
			
			System.out.println(returnStaff + "returnStaff �� �޾ƿ����� Ȯ��");
			
			
			conn.commit();
			
		}catch (Exception e) {
			System.out.println("service ���� �߻�");
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
		
		return returnStaff;
	}
}
