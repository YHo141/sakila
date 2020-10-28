package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sakila.query.CustomerListQuery;
import sakila.vo.CustomerList;

public class CustomerListDao {
	
	public ArrayList<CustomerList> selectCustomerList(Connection conn) throws Exception{
		
		CustomerList returnCustomer = null;
		ArrayList<CustomerList> list = new ArrayList<CustomerList>();
		
		PreparedStatement stmt = conn.prepareStatement(CustomerListQuery.SELECT_CUSTOMER_LIST);
		System.out.println(stmt + "stmt 값 확인");
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			returnCustomer = new CustomerList();
			
			returnCustomer.setCustomerId(rs.getInt("c.ID"));
			returnCustomer.setCustomerName(rs.getString("c.name"));
			returnCustomer.setCustomerPhone(rs.getString("c.phone"));
			returnCustomer.setCustomerNotes(rs.getString("c.notes"));
			
			list.add(returnCustomer);
		}
		
		stmt.close();
		
		return list;
	}
}
