package sakila.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import sakila.dao.StatsDao;
import sakila.util.DBUtil;
import sakila.vo.Stats;

public class StatsService {
	private StatsDao statsDao;
	
	
	//	오늘의 방문자 수 dao매서드 호출 Stats + 총 방문자 수 dao매서드 호출 int -> MAP

	public Stats getToday() {
		Calendar today = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String day = formater.format(today.getTime());
		Stats stats = new Stats();
		stats.setDay(day);
		
		System.out.println(today + ": today 확인");
		System.out.println(day + ": day 확인");
		
		return stats;
	}
	
	
	
	public  Map<String, Object> getStats() {
		Map<String, Object> map = new HashMap<String, Object>();
		statsDao = new StatsDao();
		Stats returnStats = null;
		Connection conn = null;
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			System.out.println(conn + ": service(conn) 확인");

			
			
			Stats stats = this.getToday();
			System.out.println(stats + ": service(getStats) 확인");
			returnStats = new Stats();
			returnStats.setDay(stats.getDay());
			
			
			
			returnStats = statsDao.selectDay(conn, returnStats);
			int totalCount = statsDao.selectSumCount(conn);
			//System.out.println(returnStats + ": sreturnStats 확인");
			
			System.out.println(returnStats + " : returnStats 최종");
			System.out.println(totalCount + " : totalCount 최종");
			
			map.put("stats", returnStats);
			map.put("totalCount", totalCount);
			
			conn.commit();
			
		}catch(Exception e) {
			System.out.println("service 예외발생");
			try {
				
				conn.rollback();
				
			}catch(SQLException e1) {
				
			e1.printStackTrace();
			
			}
			
			e.printStackTrace();
		}finally {
			try {

				conn.close();
				
			}catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		return map;
	}
	

	public void countStats(){
		
		statsDao = new StatsDao();

		Connection conn = null;
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			
			Stats stats = this.getToday();
			
			if(statsDao.selectDay(conn, stats) == null) {
				statsDao.insertStates(conn, stats);
			}else {
				statsDao.updateStats(conn, stats);
			}
			
			conn.commit();
		}catch(Exception e) {
			try {
				
				conn.rollback();
				
			}catch(SQLException e1) {
				
			e1.printStackTrace();
			
			}
			
			e.printStackTrace();
			
		}finally {
			try {

				conn.close();
				
			}catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}
	}
}
