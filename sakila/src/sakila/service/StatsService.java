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
	
	
	//	������ �湮�� �� dao�ż��� ȣ�� Stats + �� �湮�� �� dao�ż��� ȣ�� int -> MAP

	public Stats getToday() {
		Calendar today = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String day = formater.format(today.getTime());
		Stats stats = new Stats();
		stats.setDay(day);
		
		System.out.println(today + ": today Ȯ��");
		System.out.println(day + ": day Ȯ��");
		
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
			System.out.println(conn + ": service(conn) Ȯ��");

			
			
			Stats stats = this.getToday();
			System.out.println(stats + ": service(getStats) Ȯ��");
			returnStats = new Stats();
			returnStats.setDay(stats.getDay());
			
			
			
			returnStats = statsDao.selectDay(conn, returnStats);
			int totalCount = statsDao.selectSumCount(conn);
			//System.out.println(returnStats + ": sreturnStats Ȯ��");
			
			System.out.println(returnStats + " : returnStats ����");
			System.out.println(totalCount + " : totalCount ����");
			
			map.put("stats", returnStats);
			map.put("totalCount", totalCount);
			
			conn.commit();
			
		}catch(Exception e) {
			System.out.println("service ���ܹ߻�");
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
