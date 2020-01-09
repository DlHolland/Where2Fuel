package com.aca.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aca.rest.model.Station;

public class Where2FuelDbDao {
	
	private final static String selectAllStations = 
			"SELECT sta.Name, sta.Address, pri.Price, pri.updateDate " + 
			" FROM station sta " +
			" INNER JOIN price_updates pri ON sta.Address = pri.Address " + 
			" ORDER BY sta.address, pri.price";
	
	private final static String selectStationByCity = 
			"SELECT sta.Name, sta.Address, pri.Price, pri.updateDate" + 
			" FROM station sta " +
			" INNER JOIN price_updates pri ON sta.Address = pri.Address " +
			" WHERE sta.Address LIKE ? " + 
			" ORDER BY sta.address, pri.price";
	
	private final static String selectStationByAddress = 
			"SELECT sta.Name, sta.Address, pri.Price, pri.updateDate " + 
			" FROM station sta " +
			" INNER JOIN price_updates pri ON sta.Address = pri.Address " +
			" WHERE sta.Address = ? " + 
			" GROUP BY UpdateDate";
	
	private final static String selectStationByEmail = 
			"SELECT sta.Name, sta.Address, pri.Price, MAX(pri.UpdateDate) as updateDate, sub.Email " +
			" FROM station sta " +
			" INNER JOIN price_updates pri ON sta.Address = pri.Address " +
			" INNER JOIN subscriptions sub ON sta.Address = sub.Address " +
			" WHERE sub.email = ?";
			

	public List<Station> getAllStations() {

		List<Station> stations = new ArrayList<Station>();
		
		Connection conn = MariaDbUtil.getConnection();
		
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(selectAllStations);
			while(rs.next()) {
				Station station = makeStation(rs);
				stations.add(station);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != conn) {
				try {
					rs.close();
					statement.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
				
		return stations;
	}
	
	public List<Station> getStationByCity(String city) {

		List<Station> stations = new ArrayList<Station>();
		
		Connection conn = MariaDbUtil.getConnection();
		
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			preparedStatement = conn.prepareStatement(selectStationByCity);
			preparedStatement.setString(1, "%" + city +"%");
			rs = preparedStatement.executeQuery();			
			while(rs.next()) {
				Station station = makeStation(rs);
				stations.add(station);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != conn) {
				try {
					rs.close();
					preparedStatement.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
				
		return stations;
	}
	
	public List<Station> getStationByAddress(String address) {

		List<Station> stations = new ArrayList<Station>();
		
		Connection conn = MariaDbUtil.getConnection();
		
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			preparedStatement = conn.prepareStatement(selectStationByAddress);
			preparedStatement.setString(1, address);
			rs = preparedStatement.executeQuery();			
			while(rs.next()) {
				Station station = makeStation(rs);
				stations.add(station);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != conn) {
				try {
					rs.close();
					preparedStatement.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
				
		return stations;
	}
	
	
	
	
	
	
	private Station makeStation(ResultSet rs) throws SQLException {

		Station station = new Station();
		station.setName(rs.getString("Name"));
		station.setAddress(rs.getString("Address"));
		station.setPrice(rs.getDouble("Price"));
		station.setUpdateDate(rs.getDate("UpdateDate"));
		return station;
	}

	
}
