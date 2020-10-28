package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sakila.query.StaffQuery;
import sakila.vo.StaffList;

public class StaffListDao {
	
	public ArrayList<StaffList> selectStaffList(Connection conn) throws Exception{
		
		StaffList returnStaff = null;
		ArrayList<StaffList> list = new ArrayList<StaffList>();
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF);
		
		ResultSet rs = stmt.executeQuery();
		
		
		while(rs.next()) {
			returnStaff = new StaffList();
			
			returnStaff.setStaffusername(rs.getString("s.username"));
			returnStaff.setStaffName(rs.getString("sl.name"));
			returnStaff.setStaffphone(rs.getString("sl.phone"));
			returnStaff.setStaffAddress(rs.getString("sl.address"));
			returnStaff.setStaffEmail(rs.getString("s.email"));
			
			list.add(returnStaff);
		}
		
		stmt.close();
		
		return list;
	}
}