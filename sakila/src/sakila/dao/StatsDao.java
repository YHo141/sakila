package sakila.dao;

import java.sql.Connection;
import sakila.vo.Stats;

public class StatsDao {
	//	rs.next()에 값이 들어있으면 true 없으면 false
	public boolean selectDay(Connection conn, Stats stats) throws Exception{
		boolean result = false;
		/*
		  if(rs.next()){
		  	return true;	//	값이 true이면 update
		  }
		 */
		return false;		//	값이 false이면 insert
	}
	//
	public void insertStates(Connection conn, Stats stats) throws Exception{
		
	}
	//
	public void updateStats(Connection conn) throws Exception{
		
	}
}
