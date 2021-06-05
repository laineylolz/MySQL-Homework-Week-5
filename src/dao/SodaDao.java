package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Soda;

public class SodaDao {
	
	private Connection connection;
	private final String GET_ALL_SODA_QUERY = "select * from soda";
	private final String GET_SODA_BY_ID_QUERY = "select * from soda where id = ?";
	private final String CREATE_NEW_SODA_QUERY = "insert into soda (name, quantity, price) values (?,?,?)";
	private final String DELETE_SODA_BY_ID_QUERY = "delete from soda where id = ?";
	private final String UPDATE_SODA_QUERY = "update soda set name = ?, quantity = ?, price = ? where id = ?";
	
	public SodaDao() {
		connection = DBConnection.getConnection();
	}

	 public List<Soda> getAllSoda() throws SQLException {
	        ResultSet rs = connection.prepareStatement(GET_ALL_SODA_QUERY).executeQuery();
	        List<Soda> sodaList = new ArrayList<>();

	        while (rs.next()) {
	            sodaList.add(populateSoda(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
	        }
	        return sodaList;
	    }
	 
	 public Soda getSodaById(int id) throws SQLException {
		 PreparedStatement ps = connection.prepareStatement(GET_SODA_BY_ID_QUERY);
		 ps.setInt(1, id);
		 ResultSet rs = ps.executeQuery();
		 rs.next();
		 return populateSoda(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
	 }

	private Soda populateSoda(int int1, String string, String string2, double double1) {
		return new Soda(int1, string, string2, double1);
	}
	
	public void createNewSoda(String name, String quantity, double price) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_SODA_QUERY);
		ps.setString(1, name);
		ps.setString(2, quantity);
		ps.setDouble(3, price);
		ps.executeUpdate();
	}
	
	public void deleteSodaById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_SODA_BY_ID_QUERY);
		ps.setInt(1, id);
		
		ps.executeUpdate();
	}
	
	   public void updateSoda(Soda soda) throws SQLException {
	        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SODA_QUERY);

	        preparedStatement.setString(1, soda.getSodaName());
	        preparedStatement.setString(2, soda.getSodaQuantity());
	        preparedStatement.setDouble(3, soda.getSodaPrice());
	        preparedStatement.setInt(4, soda.getSodaId());

	        preparedStatement.executeUpdate();
	}
}
 