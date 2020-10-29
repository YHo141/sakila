package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import sakila.dao.StaffListDao;
import sakila.util.DBUtil;
import sakila.vo.StaffList;

public class StaffListService {
	private StaffListDao staffListDao;
	
	public StaffListService(StaffListDao staffListDao) {
		this.staffListDao = staffListDao;
	}
	
	public StaffList getStaffList(StaffList staffList){
		StaffList returnStaffList = null;
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			
			returnStaffList = staffListDao.selectStaffList(conn, staffList);
			
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
		
		
		return returnStaffList;
	}
}
