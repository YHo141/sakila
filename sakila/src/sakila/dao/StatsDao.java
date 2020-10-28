package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.query.statsQuery;
import sakila.vo.Stats;

public class StatsDao {
	//	rs.next()에 값이 들어있으면 true 없으면 false
	public Stats selectDay(Connection conn, Stats stats) throws Exception{
		Stats returnStats = null;
		
		PreparedStatement stmt = conn.prepareStatement(statsQuery.SELECT_DAY);
		stmt.setString(1, stats.getDay());
		
		ResultSet rs = stmt.executeQuery();

		
		if(rs.next()){
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCnt(rs.getLong("cnt"));
		}
		
		return returnStats;
	}

	
	//
	public void insertStates(Connection conn, Stats stats) throws Exception{
		PreparedStatement stmt = conn.prepareStatement(statsQuery.INSERT_STATS);
		stmt.setString(1, stats.getDay());
		
		stmt.executeUpdate();
	}
	//
	public void updateStats(Connection conn, Stats stats) throws Exception{
		PreparedStatement stmt = conn.prepareStatement(statsQuery.UPDATE_STATS);
		stmt.setString(1, stats.getDay());
		
		stmt.executeUpdate();
	}
	
	
	public int selectSumCount(Connection conn) throws Exception{
		int returnStats = 1;
		PreparedStatement stmt = conn.prepareStatement(statsQuery.SELECT_SUM_CNT);
		ResultSet rs = stmt.executeQuery();
		System.out.println(returnStats + ": 정상");
		System.out.println(rs + ": select_sum_cnt 정상");
		
		if(rs.next()) {
			returnStats = rs.getInt("SUM(cnt)");
		}
		return returnStats;
	}
}
