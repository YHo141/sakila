package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sakila.query.StaffQuery;
import sakila.vo.Staff;
import sakila.vo.StaffList;

public class StaffListDao {
	
	public StaffList selectStaffList(Connection conn, StaffList staffList) throws Exception{
		
		StaffList returnStaff = null;
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF);
		stmt.setInt(1, staffList.getStaffId());
		ResultSet rs = stmt.executeQuery();
		
		
		if(rs.next()) {
			
			returnStaff = new StaffList();
			
			returnStaff.setStaffId(rs.getInt("sl.ID"));
			returnStaff.setStaffusername(rs.getString("s.username"));
			returnStaff.setStaffName(rs.getString("sl.name"));
			returnStaff.setStaffphone(rs.getString("sl.phone"));
			returnStaff.setStaffAddress(rs.getString("sl.address"));
			returnStaff.setStaffEmail(rs.getString("s.email"));
			
		}
		
		stmt.close();
		
		return returnStaff;
	}
}
