package sakila.dao;

import java.sql.Connection;
import sakila.vo.Stats;

public class StatsDao {
	//	rs.next()�� ���� ��������� true ������ false
	public boolean selectDay(Connection conn, Stats stats) throws Exception{
		boolean result = false;
		/*
		  if(rs.next()){
		  	return true;	//	���� true�̸� update
		  }
		 */
		return false;		//	���� false�̸� insert
	}
	//
	public void insertStates(Connection conn, Stats stats) throws Exception{
		
	}
	//
	public void updateStats(Connection conn) throws Exception{
		
	}
}
